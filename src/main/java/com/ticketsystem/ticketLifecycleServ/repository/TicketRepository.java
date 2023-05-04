package com.ticketsystem.ticketLifecycleServ.repository;

import com.ticketsystem.ticketLifecycleServ.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
