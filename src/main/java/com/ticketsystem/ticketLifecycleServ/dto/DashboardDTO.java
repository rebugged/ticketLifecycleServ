package com.ticketsystem.ticketLifecycleServ.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DashboardDTO {

    private Long ticketId;

    private String ticketHeading;

    private String ticketCreated;

    private String lastUpdateDate;

    private String creationDate;

    private String createdBy;

    private String assignedTo;

}
