package com.upc.trabajo_final.Trabajo.Final.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private int id;

    private String nombre;

    private String apellido;

    private String celular;

    private String email;

    private GestorDTO gestor;
}
