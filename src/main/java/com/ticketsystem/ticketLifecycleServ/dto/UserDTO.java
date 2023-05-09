package com.ticketsystem.ticketLifecycleServ.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String userId;

    @NotEmpty
    @Size(max = 100)
    private String name;

    @NotEmpty
    @Size(max = 100)
    @Email
    private String email;

    @Size(max = 50)
    private String designation;
}
