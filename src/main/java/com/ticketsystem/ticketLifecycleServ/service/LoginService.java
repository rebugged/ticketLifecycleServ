package com.ticketsystem.ticketLifecycleServ.service;

import com.ticketsystem.ticketLifecycleServ.entity.User;
import com.ticketsystem.ticketLifecycleServ.repository.UserRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String username, String password) {
        User user = this.userRepository.findById(username).get();
        if(ObjectUtils.isNotEmpty(user)) {
            return password.equalsIgnoreCase("admin");
        } else {
            return false;
        }
    }
}
