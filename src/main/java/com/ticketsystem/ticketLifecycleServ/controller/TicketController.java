package com.ticketsystem.ticketLifecycleServ.controller;

import com.ticketsystem.ticketLifecycleServ.dto.TicketDTO;
import com.ticketsystem.ticketLifecycleServ.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@Controller
@SessionAttributes("username")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value="ticket/{ticketId}", method = RequestMethod.GET)
    public TicketDTO getTicket(@PathVariable long ticketId) {
        return ticketService.findTicketById(ticketId);
    }

    @RequestMapping(value="ticket/show-ticket/{ticketId}", method = RequestMethod.GET)
    public String showTicket(ModelMap model, @PathVariable long ticketId) {
        TicketDTO ticketDTO = ticketService.findTicketById(ticketId);
        model.put("ticket", ticketDTO);
        return "ticket";
    }

    @RequestMapping(value="ticket/edit-ticket/{ticketId}", method = RequestMethod.GET)
    public String editTicket(ModelMap model, @PathVariable long ticketId) {
        TicketDTO ticketDTO = ticketService.findTicketById(ticketId);
        model.put("ticket", ticketDTO);
        return "ticket-edit";
    }

    @RequestMapping(value="ticket/create", method = RequestMethod.POST)
    public TicketDTO createTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.createTicket(ticketDTO);
    }

    @RequestMapping(value = "ticket", method = RequestMethod.POST)
    public String createNewTicket(ModelMap model, @RequestParam String ticketHeading, @RequestParam String ticketDescription, @RequestParam String assignedTo) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setTicketHeading(ticketHeading);
        ticketDTO.setTicketDescription(ticketDescription);
        ticketDTO.setAssignedTo(assignedTo);
        TicketDTO ticketDTONew = ticketService.createTicket(ticketDTO);
        model.put("ticket", ticketDTONew);
        return "ticket";
    }


    @RequestMapping(value = "ticket-edit", method = RequestMethod.POST)
    public String editTicket(ModelMap model,
                             @RequestParam String ticketHeading,
                             @RequestParam String ticketDescription,
                             @RequestParam String assignedTo,
                             @RequestParam String ticketStatus) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setTicketHeading(ticketHeading);
        ticketDTO.setTicketDescription(ticketDescription);
        ticketDTO.setAssignedTo(assignedTo);
        ticketDTO.setTicketStatus(ticketStatus);
        TicketDTO ticketDTONew = ticketService.createTicket(ticketDTO);
        model.put("ticket", ticketDTONew);
        return "ticket";
    }

    @RequestMapping(value = "ticket", method = RequestMethod.GET)
    public String createNewTicketView(HttpServletRequest request) {
        return "ticket-create";
    }

}
