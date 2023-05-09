package com.ticketsystem.ticketLifecycleServ.controller;

import com.ticketsystem.ticketLifecycleServ.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("username")
public class DashboardController {

    @Autowired
    private DashboardService ticketService;

    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String showDashboard(ModelMap model, HttpServletRequest request){
        String user = (String)request.getSession().getAttribute("username");
        System.out.println("in contoller - "+user);
        model.put("tickets", ticketService.getDashboardDetails(user));
        return "dashboard";
    }

}
