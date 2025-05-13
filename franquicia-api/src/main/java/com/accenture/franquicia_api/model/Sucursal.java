package com.accenture.franquicia_api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sucursal {
    private String id;
    private String nombre;
    private List<Producto> productos;

    // Constructor sin ID (para cuando se crea una nueva sucursal)
    public Sucursal(String nombre, List<Producto> productos) {
        this.id = UUID.randomUUID().toString(); // Generar un ID único al crear
        this.nombre = nombre;
        this.productos = productos;
    }
}
