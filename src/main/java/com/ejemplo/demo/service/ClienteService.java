package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Cliente;
import com.ejemplo.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> obtenerTodos() {
        return repository.findAll();
    }

    public Cliente obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cliente crear(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente cliente) {
        if (repository.existsById(id)) {
            cliente.setId(id);
            return repository.save(cliente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
