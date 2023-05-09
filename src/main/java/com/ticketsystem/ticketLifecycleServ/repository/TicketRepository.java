package com.ticketsystem.ticketLifecycleServ.repository;

import com.ticketsystem.ticketLifecycleServ.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllTicketsByAssignedTo(String assignedTo);

    List<Ticket> findAllTicketsByCreatedBy(String createdBy);
}
