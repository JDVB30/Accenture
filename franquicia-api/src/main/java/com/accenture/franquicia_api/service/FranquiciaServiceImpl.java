package com.accenture.franquicia_api.service;

import com.accenture.franquicia_api.dto.ProductoConSucursalDTO;
import com.accenture.franquicia_api.model.Franquicia;
import com.accenture.franquicia_api.model.Producto;
import com.accenture.franquicia_api.model.Sucursal;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FranquiciaServiceImpl implements FranquiciaService {

    private final Map<String, Franquicia> franquicias = new HashMap<>();
    private int nextFranquiciaId = 1;

    @Override
    public Franquicia guardarFranquicia(Franquicia franquicia) {
        String id = String.valueOf(nextFranquiciaId++);
        Franquicia nuevaFranquicia = new Franquicia(franquicia.getNombre(), new ArrayList<>());
        franquicias.put(id, nuevaFranquicia);
        return nuevaFranquicia;
    }

    @Override
    public Sucursal agregarSucursal(String franquiciaId, Sucursal nuevaSucursal) {
        Franquicia franquicia = franquicias.get(franquiciaId);
        if (franquicia != null) {
            if (franquicia.getSucursales() == null) {
                franquicia.setSucursales(new ArrayList<>());
            }
            Sucursal sucursalConId = new Sucursal(nuevaSucursal.getNombre(), new ArrayList<>());
            franquicia.getSucursales().add(sucursalConId);
            return sucursalConId;
        }
        return null;
    }

    @Override
    public Producto agregarProducto(String franquiciaId, String sucursalId, Producto nuevoProducto) {
        Sucursal sucursal = obtenerSucursalPorId(franquiciaId, sucursalId);
        if (sucursal != null) {
            if (sucursal.getProductos() == null) {
                sucursal.setProductos(new ArrayList<>());
            }
            Producto productoConId = new Producto(nuevoProducto.getNombre(), nuevoProducto.getStock());
            sucursal.getProductos().add(productoConId);
            return productoConId;
        }
        return null;
    }

    @Override
    public boolean eliminarProducto(String franquiciaId, String sucursalId, String productoId) {
        Sucursal sucursal = obtenerSucursalPorId(franquiciaId, sucursalId);
        if (sucursal != null && sucursal.getProductos() != null) {
            Iterator<Producto> iterator = sucursal.getProductos().iterator();
            while (iterator.hasNext()) {
                Producto producto = iterator.next();
                if (producto.getId().equals(productoId)) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Producto modificarStockProducto(String franquiciaId, String sucursalId, String productoId, int nuevoStock) {
        Producto producto = obtenerProductoPorId(franquiciaId, sucursalId, productoId);
        if (producto != null) {
            producto.setStock(nuevoStock);
            return producto;
        }
        return null;
    }

    @Override
    public Sucursal obtenerSucursalPorId(String franquiciaId, String sucursalId) {
        Franquicia franquicia = franquicias.get(franquiciaId);
        if (franquicia != null && franquicia.getSucursales() != null) {
            for (Sucursal sucursal : franquicia.getSucursales()) {
                if (sucursal.getId().equals(sucursalId)) {
                    return sucursal;
                }
            }
        }
        return null;
    }

    @Override
    public Producto obtenerProductoPorId(String franquiciaId, String sucursalId, String productoId) {
        Sucursal sucursal = obtenerSucursalPorId(franquiciaId, sucursalId);
        if (sucursal != null && sucursal.getProductos() != null) {
            for (Producto producto : sucursal.getProductos()) {
                if (producto.getId().equals(productoId)) {
                    return producto;
                }
            }
        }
        return null;
    }

    @Override
    public List<ProductoConSucursalDTO> obtenerProductoConMayorStockPorSucursal(String franquiciaId) {
        Franquicia franquicia = franquicias.get(franquiciaId);
        if (franquicia != null && franquicia.getSucursales() != null) {
            List<ProductoConSucursalDTO> resultados = new ArrayList<>();
            for (Sucursal sucursal : franquicia.getSucursales()) {
                Producto productoConMayorStock = null;
                int maxStock = -1;
                if (sucursal.getProductos() != null && !sucursal.getProductos().isEmpty()) {
                    for (Producto producto : sucursal.getProductos()) {
                        if (producto.getStock() > maxStock) {
                            maxStock = producto.getStock();
                            productoConMayorStock = producto;
                        }
                    }
                    if (productoConMayorStock != null) {
                        resultados.add(new ProductoConSucursalDTO(
                                productoConMayorStock.getNombre(),
                                productoConMayorStock.getStock(),
                                sucursal.getNombre(),
                                sucursal.getId() // Incluimos el ID de la sucursal
                        ));
                    }
                }
            }
            return resultados;
        }
        return null;
    }

    @Override
    public Franquicia actualizarNombreFranquicia(String franquiciaId, String nuevoNombre) {
        Franquicia franquicia = franquicias.get(franquiciaId);
        if (franquicia != null) {
            franquicia.setNombre(nuevoNombre);
            return franquicia;
        }
        return null;
    }

    @Override
    public Sucursal actualizarNombreSucursal(String franquiciaId, String sucursalId, String nuevoNombre) {
        Sucursal sucursal = obtenerSucursalPorId(franquiciaId, sucursalId);
        if (sucursal != null) {
            sucursal.setNombre(nuevoNombre);
            return sucursal;
        }
        return null;
    }

    @Override
    public Producto actualizarNombreProducto(String franquiciaId, String sucursalId, String productoId, String nuevoNombre) {
        Producto producto = obtenerProductoPorId(franquiciaId, sucursalId, productoId);
        if (producto != null) {
            producto.setNombre(nuevoNombre);
            return producto;
        }
        return null;
    }
}
