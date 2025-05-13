package com.accenture.franquicia_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductoConSucursalDTO {
    private String nombreProducto;
    private int stock;
    private String nombreSucursal;
    private String idSucursal;
}
