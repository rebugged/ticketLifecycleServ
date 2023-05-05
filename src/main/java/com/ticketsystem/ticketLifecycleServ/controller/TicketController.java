package com.ticketsystem.ticketLifecycleServ.controller;

import com.ticketsystem.ticketLifecycleServ.dto.TicketDTO;
import com.ticketsystem.ticketLifecycleServ.service.TicketService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/{ticket-id}")
    public TicketDTO getBook(@PathVariable long ticketId) {
        return ticketService.findTicketById(ticketId);
    }

    @PostMapping("/create")
    public TicketDTO getBook(@NotNull TicketDTO ticketDTO) {
        return ticketService.createTicket(ticketDTO);
    }

}
