package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Producto crear(Producto producto) {
        return repository.save(producto);
    }

    public Producto actualizar(Long id, Producto producto) {
        if (repository.existsById(id)) {
            producto.setId(id);
            return repository.save(producto);
        }
        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
