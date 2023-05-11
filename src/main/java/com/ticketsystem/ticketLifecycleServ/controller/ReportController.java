package com.ticketsystem.ticketLifecycleServ.controller;

import com.ticketsystem.ticketLifecycleServ.dto.TicketDTO;
import com.ticketsystem.ticketLifecycleServ.service.DashboardService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@SessionAttributes("username")
public class ReportController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping(value="/downloadTemplate")
    public ResponseEntity<ByteArrayResource> downloadTemplate(HttpServletRequest request) throws Exception {
        String user = (String)request.getSession().getAttribute("username");
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Ticket Report");
            XSSFRow row;

            List<TicketDTO> ticketDTOList = dashboardService.getDashboardDetails(user);
            Map<Long, TicketDTO> ticketData =
                    ticketDTOList.stream().collect(Collectors.toMap(TicketDTO::getTicketId, Function.identity()));

            Set<Long> keyid = ticketData.keySet();

            CellStyle style = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);

            int rowid = 1;
            XSSFRow heading = spreadsheet.createRow(0);
            Cell headingcell1 = heading.createCell(0);
            headingcell1.setCellValue("Ticket ID");
            headingcell1.setCellStyle(style);

            Cell headingcell2 = heading.createCell(1);
            headingcell2.setCellValue("Ticket Heading");
            headingcell2.setCellStyle(style);

            Cell headingcell3 = heading.createCell(2);
            headingcell3.setCellValue("Ticket Description");
            headingcell3.setCellStyle(style);

            Cell headingcell4 = heading.createCell(3);
            headingcell4.setCellValue("Ticket Status");
            headingcell4.setCellStyle(style);

            Cell headingcell5 = heading.createCell(4);
            headingcell5.setCellValue("Ticket Assigned To");
            headingcell5.setCellStyle(style);

            Cell headingcell6 = heading.createCell(5);
            headingcell6.setCellValue("Ticket Created By");
            headingcell6.setCellStyle(style);

            for (Long key : keyid) {
                row = spreadsheet.createRow(rowid++);
                TicketDTO ticketDTO = ticketData.get(key);
                int cellid = 0;


                Cell cell1 = row.createCell(cellid++);
                cell1.setCellValue(ticketDTO.getTicketId());

                Cell cell2 = row.createCell(cellid++);
                cell2.setCellValue(ticketDTO.getTicketHeading());

                Cell cell3 = row.createCell(cellid++);
                cell3.setCellValue(ticketDTO.getTicketDescription());

                Cell cell4 = row.createCell(cellid++);
                cell4.setCellValue(ticketDTO.getTicketStatus());

                Cell cell5 = row.createCell(cellid++);
                cell5.setCellValue(ticketDTO.getAssignedTo());

                Cell cell6 = row.createCell(cellid++);
                cell6.setCellValue(ticketDTO.getCreatedBy());
            }

            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "force-download"));
            header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=TicketReport.xlsx");
            workbook.write(stream);
            workbook.close();
            return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
