package com.ticketsystem.ticketLifecycleServ.service;

import com.ticketsystem.ticketLifecycleServ.dto.TicketDTO;
import com.ticketsystem.ticketLifecycleServ.entity.Ticket;
import com.ticketsystem.ticketLifecycleServ.entity.TicketStatus;
import com.ticketsystem.ticketLifecycleServ.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        ticketDTO.setModifiedDate(ticket.getModifiedDate());
        ticketDTO.setCreatedDate(ticket.getCreatedDate());
        ticketDTO.setModifiedBy(ticket.getModifiedBy());

        return ticketDTO;
    }

    public List<TicketDTO> findAllTickets() {
        List<Ticket> ticketList = this.ticketRepository.findAll();

        List<TicketDTO> ticketDTOList = ticketList.stream().map(ticket -> {
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

        return ticketDTOList;
    }

    public TicketDTO createTicket(TicketDTO newTicketDTO) {
        System.out.println("Create ticket - " + newTicketDTO);
        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.OPEN);
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
        newSavedTicketDTO.setModifiedDate(savedTicket.getModifiedDate());
        newSavedTicketDTO.setCreatedDate(savedTicket.getCreatedDate());
        newSavedTicketDTO.setModifiedBy(savedTicket.getModifiedBy());

        return newSavedTicketDTO;

    }

    public static void main(String ... args) {
        TicketStatus status = TicketStatus.valueOf("OPEN");
        System.out.println(status.name());
    }


}
