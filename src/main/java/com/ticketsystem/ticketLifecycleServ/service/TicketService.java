package com.ticketsystem.ticketLifecycleServ.service;

import com.ticketsystem.ticketLifecycleServ.dto.TicketDTO;
import com.ticketsystem.ticketLifecycleServ.entity.Ticket;
import com.ticketsystem.ticketLifecycleServ.entity.TicketStatus;
import com.ticketsystem.ticketLifecycleServ.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketDTO findTicketById(long ticketId) {
        Ticket ticket = this.ticketRepository.findById(ticketId).get();

        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setTicketId(ticket.getTicketId());
        ticketDTO.setTicketStatus(ticket.getTicketStatus().status);
        ticketDTO.setTicketHeading(ticket.getTicketHeading());
        ticketDTO.setTicketDescription(ticket.getTicketDescription());
        ticketDTO.setCreatedBy(ticket.getCreatedBy());
        ticketDTO.setAssignedTo(ticket.getAssignedTo());

        return ticketDTO;
    }

    public TicketDTO createTicket(TicketDTO newTicketDTO) {
        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.valueOf(newTicketDTO.getTicketStatus()));
        ticket.setTicketHeading(newTicketDTO.getTicketHeading());
        ticket.setTicketDescription(newTicketDTO.getTicketDescription());
        ticket.setAssignedTo(newTicketDTO.getAssignedTo());

        Ticket savedTicket = this.ticketRepository.save(ticket);

        TicketDTO newSavedTicketDTO = new TicketDTO();
        newSavedTicketDTO.setTicketId(savedTicket.getTicketId());
        newSavedTicketDTO.setTicketStatus(savedTicket.getTicketStatus().status);
        newSavedTicketDTO.setTicketHeading(savedTicket.getTicketHeading());
        newSavedTicketDTO.setTicketDescription(savedTicket.getTicketDescription());
        newSavedTicketDTO.setCreatedBy(savedTicket.getCreatedBy());
        newSavedTicketDTO.setAssignedTo(savedTicket.getAssignedTo());

        return newSavedTicketDTO;

    }


}
