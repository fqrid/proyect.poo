package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void guardar(Cliente cliente) {
        cliente.setId(autoId.getAndIncrement());
        clientes.add(cliente);
    }

    public Cliente eliminar(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id)) {
                return clientes.remove(i);
            }
        }
        return null;
    }

    public Cliente actualizar(int id, Cliente clienteActualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id)) {
                clienteActualizado.setId(id); // aseguramos que conserve el ID original
                clientes.set(i, clienteActualizado);
                return clienteActualizado;
            }
        }
        return null;
    }

    public Cliente obtener(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> obtenerTodos() {
        return new ArrayList<>(clientes);
    }
}
