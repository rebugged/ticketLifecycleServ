package com.ticketsystem.ticketLifecycleServ.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

@Component
public class AuditListener {

    @PreUpdate
    private void beforeAnyUpdate(Object object) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();
        String user_name = (String)request.getHeader("USER_NAME");

        if(object instanceof Ticket) {
            ((Ticket) object).setModifiedDate(new Date());
            ((Ticket) object).setModifiedBy(user_name);
        }

        if(object instanceof User) {
            ((User) object).setModifiedDate(new Date());
            ((User) object).setModifiedBy(user_name);
        }
    }

    @PrePersist
    private void beforeAnyCreation(Object object) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();
        String user_name = (String)request.getHeader("USER_NAME");

        if(object instanceof Ticket) {
            ((Ticket) object).setCreatedDate(new Date());
            ((Ticket) object).setCreatedBy(user_name);
        }

        if(object instanceof User) {
            ((User) object).setCreatedDate(new Date());
            ((User) object).setCreatedBy(user_name);
        }
    }

}
