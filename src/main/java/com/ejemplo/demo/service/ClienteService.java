package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Cliente;
import com.ejemplo.demo.repository.ClienteRepository;
import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    private void validar(Cliente cliente) {
        if (cliente == null) {
            throw new BadParameterException("Cliente no puede ser null");
        }
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new BadParameterException("Nombre requerido");
        }
        if (cliente.getCorreo() == null || cliente.getCorreo().isEmpty()) {
            throw new BadParameterException("Correo requerido");
        }
    }

    public void crear(Cliente cliente) {
        validar(cliente);
        repository.guardar(cliente);
    }

    public void eliminar(String id) {
        Cliente eliminado = repository.eliminar(Integer.parseInt(id));
        if (eliminado == null) {
            throw new NotFoundException("Cliente no encontrado");
        }
    }

    public void actualizar(String id, Cliente nuevo) {
        validar(nuevo);
        Cliente actualizado = repository.actualizar(Integer.parseInt(id), nuevo);
        if (actualizado == null) {
            throw new NotFoundException("Cliente no encontrado");
        }
    }

    public Cliente obtener(String id) {
        Cliente cliente = repository.obtener(Integer.parseInt(id));
        if (cliente == null) {
            throw new NotFoundException("Cliente no encontrado");
        }
        return cliente;
    }

    public List<Cliente> listar() {
        return repository.obtenerTodos();
    }
}