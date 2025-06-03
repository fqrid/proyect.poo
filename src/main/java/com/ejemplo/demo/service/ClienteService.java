package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Cliente;
import com.ejemplo.demo.repository.ClienteRepository;

import java.util.List;

public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente crear(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente actualizar(String id, Cliente nuevo) {
        Cliente existente = obtener(id);
        existente.setNombre(nuevo.getNombre());
        existente.setCorreo(nuevo.getCorreo());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}