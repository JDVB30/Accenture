package com.accenture.franquicia_api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Franquicia {
    private String id;
    private String nombre;
    private List<Sucursal> sucursales;

    // Constructor sin ID (para cuando se crea una nueva franquicia)
    public Franquicia(String nombre, List<Sucursal> sucursales) {
        this.id = UUID.randomUUID().toString(); // Generar un ID único al crear
        this.nombre = nombre;
        this.sucursales = sucursales;
    }
}
