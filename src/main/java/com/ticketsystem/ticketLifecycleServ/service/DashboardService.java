package com.ticketsystem.ticketLifecycleServ.service;

import com.ticketsystem.ticketLifecycleServ.dto.TicketDTO;
import com.ticketsystem.ticketLifecycleServ.entity.Ticket;
import com.ticketsystem.ticketLifecycleServ.repository.TicketRepository;
import com.ticketsystem.ticketLifecycleServ.repository.UserRepository;
import com.ticketsystem.ticketLifecycleServ.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<TicketDTO> getDashboardDetails(String userName) {

        List<String> roles = fetchRoles(userName);

        System.out.println(Arrays.toString(roles.toArray()));

        if(!CollectionUtils.isEmpty(roles)) {
            if(roles.contains("admin")) {
                List<Ticket> ticketList1 = this.ticketRepository.findAll();

                List<TicketDTO> ticketDTOList1 = ticketList1.stream().map(ticket -> {
                    TicketDTO ticketDTO = new TicketDTO();
                    ticketDTO.setTicketId(ticket.getTicketId());
                    ticketDTO.setTicketStatus(ticket.getTicketStatus().status);
                    ticketDTO.setTicketHeading(ticket.getTicketHeading());
                    ticketDTO.setTicketDescription(ticket.getTicketDescription());
                    ticketDTO.setCreatedBy(ticket.getCreatedBy());
                    ticketDTO.setAssignedTo(ticket.getAssignedTo());
                    ticketDTO.setModifiedDate(ticket.getModifiedDate());
                    ticketDTO.setCreatedDate(ticket.getCreatedDate());
                    ticketDTO.setModifiedBy(ticket.getModifiedBy());
                    return ticketDTO;
                }).collect(Collectors.toList());

                return ticketDTOList1;
            } else {

                List<Ticket> ticketList1 = this.ticketRepository.findAllTicketsByAssignedTo(userName);
                List<Ticket> ticketList2 = this.ticketRepository.findAllTicketsByCreatedBy(userName);

                List<TicketDTO> ticketDTOList1 = ticketList1.stream().map(ticket -> {
                    TicketDTO ticketDTO = new TicketDTO();
                    ticketDTO.setTicketId(ticket.getTicketId());
                    ticketDTO.setTicketStatus(ticket.getTicketStatus().status);
                    ticketDTO.setTicketHeading(ticket.getTicketHeading());
                    ticketDTO.setTicketDescription(ticket.getTicketDescription());
                    ticketDTO.setCreatedBy(ticket.getCreatedBy());
                    ticketDTO.setAssignedTo(ticket.getAssignedTo());
                    ticketDTO.setModifiedDate(ticket.getModifiedDate());
                    ticketDTO.setCreatedDate(ticket.getCreatedDate());
                    ticketDTO.setModifiedBy(ticket.getModifiedBy());
                    return ticketDTO;
                }).collect(Collectors.toList());


                List<TicketDTO> ticketDTOList2 = ticketList2.stream().map(ticket -> {
                    TicketDTO ticketDTO = new TicketDTO();
                    ticketDTO.setTicketId(ticket.getTicketId());
                    ticketDTO.setTicketStatus(ticket.getTicketStatus().status);
                    ticketDTO.setTicketHeading(ticket.getTicketHeading());
                    ticketDTO.setTicketDescription(ticket.getTicketDescription());
                    ticketDTO.setCreatedBy(ticket.getCreatedBy());
                    ticketDTO.setAssignedTo(ticket.getAssignedTo());
                    ticketDTO.setModifiedDate(ticket.getModifiedDate());
                    ticketDTO.setCreatedDate(ticket.getCreatedDate());
                    ticketDTO.setModifiedBy(ticket.getModifiedBy());
                    return ticketDTO;
                }).collect(Collectors.toList());

                ticketDTOList1.addAll(ticketDTOList2);
                return dedup(ticketDTOList1);
            }
        } else {
            return null;
        }
    }

    private List<String> fetchRoles(String username) {
        return userRoleRepository.getRolesOfUser(username);
    }


    private List<TicketDTO> dedup(List<TicketDTO> ticketDTOList) {
        HashSet<TicketDTO> ticketDTOHashSet = new HashSet<>(ticketDTOList);
        return ticketDTOHashSet.stream().collect(Collectors.toList());
    }

}
