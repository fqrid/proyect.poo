package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.DetalleFactura;
import com.ejemplo.demo.repository.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalles-factura")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    // Obtener todos los detalles de factura
    @GetMapping
    public List<DetalleFactura> getAllDetallesFactura() {
        return detalleFacturaRepository.findAll();
    }

    // Obtener un detalle de factura por su ID
    @GetMapping("/{id}")
    public Optional<DetalleFactura> getDetalleFacturaById(@PathVariable Long id) {
        return detalleFacturaRepository.findById(id);
    }

    // Crear un nuevo detalle de factura
    @PostMapping
    public DetalleFactura createDetalleFactura(@RequestBody DetalleFactura detalleFactura) {
        return detalleFacturaRepository.save(detalleFactura);
    }

    // Actualizar un detalle de factura
    @PutMapping("/{id}")
    public DetalleFactura updateDetalleFactura(@PathVariable Long id, @RequestBody DetalleFactura detalles) {
        return detalleFacturaRepository.findById(id).map(df -> {
            df.setProducto(detalles.getProducto());
            df.setCantidad(detalles.getCantidad());
            df.setPrecio(detalles.getPrecio());
            return detalleFacturaRepository.save(df);
        }).orElseGet(() -> {
            detalles.setId(id);
            return detalleFacturaRepository.save(detalles);
        });
    }

    // Eliminar un detalle de factura
    @DeleteMapping("/{id}")
    public void deleteDetalleFactura(@PathVariable Long id) {
        detalleFacturaRepository.deleteById(id);
    }
}
