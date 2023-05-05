package com.ticketsystem.ticketLifecycleServ.entity;

public enum TicketStatus {
    OPEN("OPEN"),
    WAITING("WAITING"),
    IN_PROGRESS("IN_PROGRESS"),
    DEFERRED("DEFERRED"),
    DUPLICATE("DUPLICATE"),
    REJECT("REJECT"),
    CLOSED("CLOSED");

    public final String status;

    private TicketStatus(String status) {
        this.status = status;
    }
}
