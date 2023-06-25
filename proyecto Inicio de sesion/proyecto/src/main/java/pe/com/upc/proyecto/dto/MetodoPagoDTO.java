package com.upc.trabajo_final.Trabajo.Final.Entreclient.dto;

import com.upc.trabajo_final.Trabajo.Final.security.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetodoPagoDTO {
    private int id;

    private String nombre;

    private String ultimosNumeros;

    private Cliente cliente;
}
