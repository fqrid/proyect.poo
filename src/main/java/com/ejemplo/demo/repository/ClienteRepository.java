package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Cliente;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ClienteRepository {
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarCliente(Cliente cliente) {
        cliente.setId(this.autoId.getAndIncrement());
        this.clientes.add(cliente);
    }

    public Cliente eliminarCliente(int id) {
        Cliente cliente = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                cliente = clientes.remove(i);
                break;
            }
        }
        return cliente;
    }

    public Cliente actualizarCliente(int id, Cliente clienteActualizado) {
        Cliente cliente = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.set(i, clienteActualizado);
                cliente = clienteActualizado;
                break;
            }
        }
        return cliente;
    }

    public Cliente obtenerCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public ArrayList<Cliente> obtenerClientes() {
        return this.clientes;
    }
}
