package com.ticketsystem.ticketLifecycleServ.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Audit {


    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "modified_date")
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;
}
