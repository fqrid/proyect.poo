package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Carrito;
import com.ejemplo.demo.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoRepository carritoRepository;

    // Obtener todos los carritos
    @GetMapping
    public List<Carrito> getAllCarritos() {
        return carritoRepository.findAll();
    }

    // Obtener un carrito por ID
    @GetMapping("/{id}")
    public Optional<Carrito> getCarritoById(@PathVariable Long id) {
        return carritoRepository.findById(id);
    }

    // Crear un nuevo carrito
    @PostMapping
    public Carrito createCarrito(@RequestBody Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    // Actualizar un carrito existente
    @PutMapping("/{id}")
    public Carrito updateCarrito(@PathVariable Long id, @RequestBody Carrito carritoDetails) {
        return carritoRepository.findById(id).map(carrito -> {
            carrito.setUsuario(carritoDetails.getUsuario());
            carrito.setProductos(carritoDetails.getProductos());
            return carritoRepository.save(carrito);
        }).orElseGet(() -> {
            carritoDetails.setId(id);
            return carritoRepository.save(carritoDetails);
        });
    }

    // Eliminar un carrito
    @DeleteMapping("/{id}")
    public void deleteCarrito(@PathVariable Long id) {
        carritoRepository.deleteById(id);
    }
}
