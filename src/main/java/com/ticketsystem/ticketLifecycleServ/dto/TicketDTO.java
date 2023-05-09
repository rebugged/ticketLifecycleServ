package com.ticketsystem.ticketLifecycleServ.dto;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    private Date createdDate;

    private Date modifiedDate;

    private String modifiedBy;
}
