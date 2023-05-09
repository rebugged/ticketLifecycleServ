package com.ticketsystem.ticketLifecycleServ.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ticket")
@EntityListeners(AuditListener.class)
public class Ticket extends Audit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name="ticket_heading", length=100, nullable=false, unique=false)
    private String ticketHeading;

    @Column(name="ticket_description", length=500, nullable=true, unique=false)
    private String ticketDescription;

    @Column(name="assigned_to", length=50, nullable=false, unique=false)
    private String assignedTo;

    @Enumerated(EnumType.STRING)
    @Column(name="ticket_status", length=50, nullable=false, unique=false)
    private TicketStatus ticketStatus;

}
