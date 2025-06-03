package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Cliente;
import com.ejemplo.demo.repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private void validarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new BadParameterException("Cliente no puede estar vacío");
        }
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new BadParameterException("El nombre del cliente no puede estar vacío");
        }
        if (cliente.getCorreo() == null || cliente.getCorreo().isEmpty()) {
            throw new BadParameterException("El correo del cliente no puede estar vacío");
        }
    }

    public void guardarCliente(Cliente cliente) {
        this.validarCliente(cliente);
        this.clienteRepository.agregarCliente(cliente);
    }

    public void eliminarCliente(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el cliente");
        }
        Cliente cliente = this.clienteRepository.eliminarCliente(Integer.parseInt(id));
        if (cliente == null) {
            throw new NotFoundException("No existe el cliente");
        }
    }

    public void actualizarCliente(String id, Cliente clienteActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el cliente");
        }
        this.validarCliente(clienteActualizar);
        Cliente cliente = this.clienteRepository.actualizarCliente(Integer.parseInt(id), clienteActualizar);
        if (cliente == null) {
            throw new NotFoundException("No existe el cliente");
        }
    }

    public Cliente obtenerCliente(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el cliente");
        }

        return this.clienteRepository.obtenerCliente(Integer.parseInt(id));
    }

    public List<Cliente> obtenerClientes() {
        return this.clienteRepository.obtenerClientes();
    }
}
