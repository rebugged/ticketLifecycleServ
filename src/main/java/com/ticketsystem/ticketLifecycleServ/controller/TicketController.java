package com.ticketsystem.ticketLifecycleServ.controller;

import com.ticketsystem.ticketLifecycleServ.dto.TicketDTO;
import com.ticketsystem.ticketLifecycleServ.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/{ticketId}")
    public TicketDTO getTicket(@PathVariable long ticketId) {
        return ticketService.findTicketById(ticketId);
    }

    @PostMapping("/create")
    public TicketDTO createTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.createTicket(ticketDTO);
    }

}
