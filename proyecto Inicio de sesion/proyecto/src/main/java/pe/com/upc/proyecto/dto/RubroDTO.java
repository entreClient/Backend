package com.upc.trabajo_final.Trabajo.Final.Entreclient.dto;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Emprendimiento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RubroDTO {
    private int id;

    private String nombre;

    private List<Emprendimiento> emprendimientos;
}
