package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.MetodoPago;
import com.ejemplo.demo.repository.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metodos-pago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    // Obtener todos los métodos de pago
    @GetMapping
    public List<MetodoPago> getAllMetodosPago() {
        return metodoPagoRepository.findAll();
    }

    // Obtener un método de pago por ID
    @GetMapping("/{id}")
    public Optional<MetodoPago> getMetodoPagoById(@PathVariable Long id) {
        return metodoPagoRepository.findById(id);
    }

    // Crear un nuevo método de pago
    @PostMapping
    public MetodoPago createMetodoPago(@RequestBody MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    // Actualizar un método de pago existente
    @PutMapping("/{id}")
    public MetodoPago updateMetodoPago(@PathVariable Long id, @RequestBody MetodoPago detalles) {
        return metodoPagoRepository.findById(id).map(m -> {
            m.setTipo(detalles.getTipo());
            m.setDetalle(detalles.getDetalle());
            return metodoPagoRepository.save(m);
        }).orElseGet(() -> {
            detalles.setId(id);
            return metodoPagoRepository.save(detalles);
        });
    }

    // Eliminar un método de pago
    @DeleteMapping("/{id}")
    public void deleteMetodoPago(@PathVariable Long id) {
        metodoPagoRepository.deleteById(id);
    }
}
