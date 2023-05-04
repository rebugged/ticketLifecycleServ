package com.ticketsystem.ticketLifecycleServ.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TicketDTO {

    private Long ticketId;

    @NotEmpty
    @Size(max = 100, message = "max 100 characters for heading")
    private String ticketHeading;

    @Size(max = 500, message = "max 500 characters for description")
    private String ticketDescription;

    @NotEmpty
    @Size(max = 50)
    private String createdBy;

    @NotEmpty
    @Size(max = 50)
    private String assignedTo;

    @NotEmpty
    @Size(max = 50)
    private String ticketStatus;
}
