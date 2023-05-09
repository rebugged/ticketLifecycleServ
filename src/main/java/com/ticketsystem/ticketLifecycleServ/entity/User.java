package com.ticketsystem.ticketLifecycleServ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User extends Audit {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name="name", length=100, nullable=false, unique=false)
    private String name;

    @Column(name="email", length=100, nullable=false, unique=false)
    private String email;

    @Column(name="designation", length=50, nullable=true, unique=false)
    private String designation;

}
