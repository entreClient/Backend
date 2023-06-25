package com.upc.trabajo_final.Trabajo.Final.Entreclient.dto;

import com.upc.trabajo_final.Trabajo.Final.security.dto.EmprendedorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalificacionDTO {
    private int id;

    private int puntaje;

    private String comentario;

    private EmprendedorDTO emprendedorDTO;
}
