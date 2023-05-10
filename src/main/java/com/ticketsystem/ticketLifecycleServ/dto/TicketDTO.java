package com.ticketsystem.ticketLifecycleServ.dto;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

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

    @Size(max = 50)
    private String createdBy;

    @NotEmpty
    @Size(max = 50)
    private String assignedTo;

    @Size(max = 50)
    private String ticketStatus;

    private Date createdDate;

    private Date modifiedDate;

    private String modifiedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDTO ticketDTO = (TicketDTO) o;
        return ticketId.equals(ticketDTO.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId);
    }

}
