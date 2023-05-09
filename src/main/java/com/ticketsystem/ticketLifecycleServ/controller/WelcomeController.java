package com.ticketsystem.ticketLifecycleServ.controller;

import com.ticketsystem.ticketLifecycleServ.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class WelcomeController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "welcome";
    }

    @RequestMapping(value="/welcome", method = RequestMethod.POST)
    public String doLoginAndShowDashboard(ModelMap model, @RequestParam String username, @RequestParam String password) {

        boolean isValidUser = loginService.validateUser(username, password);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "welcome";
        }

        model.put("username", username);
        model.put("password", password);

        return "dashboard";
    }

}
