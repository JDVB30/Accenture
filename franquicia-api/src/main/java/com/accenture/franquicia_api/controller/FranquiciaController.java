package com.accenture.franquicia_api.controller;


import com.accenture.franquicia_api.dto.ProductoConSucursalDTO;
import com.accenture.franquicia_api.model.Franquicia;
import com.accenture.franquicia_api.model.Producto;
import com.accenture.franquicia_api.model.Sucursal;
import com.accenture.franquicia_api.service.FranquiciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    public FranquiciaController(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @PostMapping
    public ResponseEntity<Franquicia> agregarFranquicia(@RequestBody Franquicia franquicia) {
        Franquicia nuevaFranquicia = franquiciaService.guardarFranquicia(franquicia);
        return new ResponseEntity<>(nuevaFranquicia, HttpStatus.CREATED);
    }

    @PostMapping("/{franquiciaId}/sucursales")
    public ResponseEntity<Sucursal> agregarSucursal(
            @PathVariable String franquiciaId,
            @RequestBody Sucursal nuevaSucursal) {
        Sucursal sucursalAgregada = franquiciaService.agregarSucursal(franquiciaId, nuevaSucursal);
        if (sucursalAgregada != null) {
            return new ResponseEntity<>(sucursalAgregada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{franquiciaId}/sucursales/{sucursalId}/productos")
    public ResponseEntity<Producto> agregarProducto(
            @PathVariable String franquiciaId,
            @PathVariable String sucursalId,
            @RequestBody Producto nuevoProducto) {
        Producto productoAgregado = franquiciaService.agregarProducto(franquiciaId, sucursalId, nuevoProducto);
        if (productoAgregado != null) {
            return new ResponseEntity<>(productoAgregado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}")
    public ResponseEntity<Void> eliminarProducto(
            @PathVariable String franquiciaId,
            @PathVariable String sucursalId,
            @PathVariable String productoId) {
        boolean eliminado = franquiciaService.eliminarProducto(franquiciaId, sucursalId, productoId);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}/stock")
    public ResponseEntity<Producto> modificarStockProducto(
            @PathVariable String franquiciaId,
            @PathVariable String sucursalId,
            @PathVariable String productoId,
            @RequestBody int nuevoStock) {
        Producto productoActualizado = franquiciaService.modificarStockProducto(franquiciaId, sucursalId, productoId, nuevoStock);
        if (productoActualizado != null) {
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{franquiciaId}/productos-con-mayor-stock")
    public ResponseEntity<List<ProductoConSucursalDTO>> obtenerProductoConMayorStockPorSucursal(
            @PathVariable String franquiciaId) {
        List<ProductoConSucursalDTO> productosConMayorStock = franquiciaService.obtenerProductoConMayorStockPorSucursal(franquiciaId);
        if (productosConMayorStock != null) {
            return new ResponseEntity<>(productosConMayorStock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{franquiciaId}")
    public ResponseEntity<Franquicia> actualizarNombreFranquicia(
            @PathVariable String franquiciaId,
            @RequestBody String nuevoNombre) {
        Franquicia franquiciaActualizada = franquiciaService.actualizarNombreFranquicia(franquiciaId, nuevoNombre);
        if (franquiciaActualizada != null) {
            return new ResponseEntity<>(franquiciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{franquiciaId}/sucursales/{sucursalId}")
    public ResponseEntity<Sucursal> actualizarNombreSucursal(
            @PathVariable String franquiciaId,
            @PathVariable String sucursalId,
            @RequestBody String nuevoNombre) {
        Sucursal sucursalActualizada = franquiciaService.actualizarNombreSucursal(franquiciaId, sucursalId, nuevoNombre);
        if (sucursalActualizada != null) {
            return new ResponseEntity<>(sucursalActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}/nombre")
    public ResponseEntity<Producto> actualizarNombreProducto(
            @PathVariable String franquiciaId,
            @PathVariable String sucursalId,
            @PathVariable String productoId,
            @RequestBody String nuevoNombre) {
        Producto productoActualizado = franquiciaService.actualizarNombreProducto(franquiciaId, sucursalId, productoId, nuevoNombre);
        if (productoActualizado != null) {
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
