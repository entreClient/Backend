package com.upc.trabajo_final.Trabajo.Final.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GestorDTO {
    private int id;

    private String username;

    private String password;

    private String rol;
}
