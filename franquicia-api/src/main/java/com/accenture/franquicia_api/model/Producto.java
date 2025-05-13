package com.accenture.franquicia_api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {
    private String id;
    private String nombre;
    private int stock;

    public Producto(String nombre, int stock) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.stock = stock;
    }
}
