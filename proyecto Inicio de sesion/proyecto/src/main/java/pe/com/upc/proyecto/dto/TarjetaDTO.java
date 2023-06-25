package com.upc.trabajo_final.Trabajo.Final.Entreclient.dto;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaDTO {
    private int id;
    private LocalDate fechaVencimiento;
    private String cvv;

    private String type;
    private String nombreTarjeta;
    private MetodoPago metodoPago;
}
