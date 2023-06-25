package com.upc.trabajo_final.Trabajo.Final.Entreclient.dto;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Categoria;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Emprendimiento;

import java.math.BigDecimal;

public class ProductoDTO {
    private int id;

    private String descripcion;

    private BigDecimal precioUnitario;

    private Categoria categoria;

    private Emprendimiento emprendimiento;
}
