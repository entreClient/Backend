package com.upc.trabajo_final.Trabajo.Final.Entreclient.dto;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Rubro;
import com.upc.trabajo_final.Trabajo.Final.security.model.Emprendedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmprendimientoDTO {
    private int id;

    private String nombre;

    private String descripcion;

    private Rubro rubro;

    private Emprendedor emprendedor;
}
