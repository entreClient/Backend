package com.upc.trabajo_final.Trabajo.Final.Entreclient.dto;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Compra;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePagoDTO {
    private int id;

    private Producto producto;

    private Compra pago;

    private int cantidad;
}
