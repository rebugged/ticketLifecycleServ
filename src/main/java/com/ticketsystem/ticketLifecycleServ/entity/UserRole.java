package com.ticketsystem.ticketLifecycleServ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(name = "user_role_id")
    private Long userRoleId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private Long roleId;

    @Transient
    private String roleName;

}
