package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Factura;
import com.ejemplo.demo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    // Obtener todas las facturas
    @GetMapping
    public ResponseEntity<List<Factura>> obtenerTodasLasFacturas() {
        List<Factura> facturas = facturaService.obtenerTodas();
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    // Obtener una factura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id) {
        Factura factura = facturaService.obtenerPorId(id);
        return factura != null
                ? new ResponseEntity<>(factura, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Crear una nueva factura
    @PostMapping
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        Factura nuevaFactura = facturaService.guardar(factura);
        return new ResponseEntity<>(nuevaFactura, HttpStatus.CREATED);
    }

    // Actualizar una factura existente
    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizarFactura(
            @PathVariable Long id,
            @RequestBody Factura factura) {

        Factura facturaExistente = facturaService.obtenerPorId(id);
        if (facturaExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Actualizar los campos
        facturaExistente.setFecha(factura.getFecha());
        facturaExistente.setTotal(factura.getTotal());

        Factura facturaActualizada = facturaService.guardar(facturaExistente);
        return new ResponseEntity<>(facturaActualizada, HttpStatus.OK);
    }

    // Eliminar una factura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Long id) {
        if (facturaService.obtenerPorId(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        facturaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}