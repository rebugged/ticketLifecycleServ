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
@Table(name="role")
public class Role {

    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;
}
