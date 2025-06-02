package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Descuento;
import com.ejemplo.demo.repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/descuentos")
public class DescuentoController {

    @Autowired
    private DescuentoRepository descuentoRepository;

    // Obtener todos los descuentos
    @GetMapping
    public List<Descuento> getAllDescuentos() {
        return descuentoRepository.findAll();
    }

    // Obtener un descuento por ID
    @GetMapping("/{id}")
    public Optional<Descuento> getDescuentoById(@PathVariable Long id) {
        return descuentoRepository.findById(id);
    }

    // Crear un nuevo descuento
    @PostMapping
    public Descuento createDescuento(@RequestBody Descuento descuento) {
        return descuentoRepository.save(descuento);
    }

    // Actualizar un descuento existente
    @PutMapping("/{id}")
    public Descuento updateDescuento(@PathVariable Long id, @RequestBody Descuento detalles) {
        return descuentoRepository.findById(id).map(d -> {
            d.setPorcentaje(detalles.getPorcentaje());
            d.setFechaInicio(detalles.getFechaInicio());
            d.setFechaFin(detalles.getFechaFin());
            return descuentoRepository.save(d);
        }).orElseGet(() -> {
            detalles.setId(id);
            return descuentoRepository.save(detalles);
        });
    }

    // Eliminar un descuento
    @DeleteMapping("/{id}")
    public void deleteDescuento(@PathVariable Long id) {
        descuentoRepository.deleteById(id);
    }
}
