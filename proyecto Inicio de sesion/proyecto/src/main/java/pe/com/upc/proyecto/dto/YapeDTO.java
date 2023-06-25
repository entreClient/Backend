package com.upc.trabajo_final.Trabajo.Final.Entreclient.dto;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YapeDTO {
    private int id;
    private String numeroCelular;

    private String titular;
    private String numeroDNI;

    private String type;
    private MetodoPago metodoPago;
}
