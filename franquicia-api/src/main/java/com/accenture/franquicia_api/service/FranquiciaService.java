package com.accenture.franquicia_api.service;

import com.accenture.franquicia_api.dto.ProductoConSucursalDTO;
import com.accenture.franquicia_api.model.Franquicia;
import com.accenture.franquicia_api.model.Producto;
import com.accenture.franquicia_api.model.Sucursal;

import java.util.List;

public interface FranquiciaService {
    Franquicia guardarFranquicia(Franquicia franquicia);
    Sucursal agregarSucursal(String franquiciaId, Sucursal nuevaSucursal);
    Producto agregarProducto(String franquiciaId, String sucursalId, Producto nuevoProducto);
    boolean eliminarProducto(String franquiciaId, String sucursalId, String productoId); // Usamos ID
    Producto modificarStockProducto(String franquiciaId, String sucursalId, String productoId, int nuevoStock); // Usamos ID
    Sucursal obtenerSucursalPorId(String franquiciaId, String sucursalId);
    Producto obtenerProductoPorId(String franquiciaId, String sucursalId, String productoId); // Nuevo método
    List<ProductoConSucursalDTO> obtenerProductoConMayorStockPorSucursal(String franquiciaId);
    Franquicia actualizarNombreFranquicia(String franquiciaId, String nuevoNombre); // Punto extra
    Sucursal actualizarNombreSucursal(String franquiciaId, String sucursalId, String nuevoNombre); // Punto extra
    Producto actualizarNombreProducto(String franquiciaId, String sucursalId, String productoId, String nuevoNombre); // Punto extra

}
