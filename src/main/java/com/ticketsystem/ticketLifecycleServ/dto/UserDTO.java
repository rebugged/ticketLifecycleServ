package com.ticketsystem.ticketLifecycleServ.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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
