package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> obtenerTodos() {
        return repository.findAll();
    }

    public Pedido obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pedido crear(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido actualizar(Long id, Pedido pedido) {
        if (repository.existsById(id)) {
            pedido.setId(id);
            return repository.save(pedido);
        }
        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
