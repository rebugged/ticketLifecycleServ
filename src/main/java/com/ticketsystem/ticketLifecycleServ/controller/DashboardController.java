package com.ticketsystem.ticketLifecycleServ.controller;

import com.ticketsystem.ticketLifecycleServ.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class DashboardController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String showDashboard(ModelMap model){
        model.put("tickets", ticketService.findAllTickets());
        return "dashboard";
    }


}
