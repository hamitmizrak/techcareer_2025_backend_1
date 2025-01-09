package com.hamitmizrak.techcareer_2025_backend_1.jwt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

// LOMBOK
@Getter
@Setter
@ToString
public class _2_RegisterRequest  implements Serializable {

    // Serializable
    public static final Long serialVersionUID = 1L;

    // Field
    private String username;
    private String password;
}
