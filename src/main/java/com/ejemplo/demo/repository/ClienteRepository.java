package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Cliente;
import java.util.*;

public class ClienteRepository {
    private final Map<String, Cliente> datos = new HashMap<>();

    public Cliente save(Cliente cliente) {
        datos.put(cliente.getId(), cliente);
        return cliente;
    }

    public Optional<Cliente> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Cliente> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
