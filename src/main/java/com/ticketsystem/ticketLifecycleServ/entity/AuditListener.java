package com.ticketsystem.ticketLifecycleServ.entity;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class AuditListener {

    @PreUpdate
    private void beforeAnyUpdate(Object object) {
        String userName = fetchUserName();

        if(object instanceof Ticket) {
            ((Ticket) object).setModifiedDate(new Date());
            ((Ticket) object).setModifiedBy(userName);
        }

        if(object instanceof User) {
            ((User) object).setModifiedDate(new Date());
            ((User) object).setModifiedBy(userName);
        }
    }

    @PrePersist
    private void beforeAnyCreation(Object object) {
        String userName = fetchUserName();

        if(object instanceof Ticket) {
            ((Ticket) object).setCreatedDate(new Date());
            ((Ticket) object).setCreatedBy(userName);
            ((Ticket) object).setModifiedDate(new Date());
            ((Ticket) object).setModifiedBy(userName);
        }

        if(object instanceof User) {
            ((User) object).setCreatedDate(new Date());
            ((User) object).setCreatedBy(userName);
            ((User) object).setModifiedDate(new Date());
            ((User) object).setModifiedBy(userName);
        }
    }

    private String fetchUserName() {
        String userName = null;
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();

        userName = (String)request.getHeader("USER_NAME");
        if(StringUtils.isEmpty(userName)) {
            userName = (String)request.getSession().getAttribute("username");
        }
        return userName;
    }

}
