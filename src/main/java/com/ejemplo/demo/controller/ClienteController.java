package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final List<Cliente> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<Cliente> obtenerTodos() {
        return lista;
    }

    @GetMapping("/{id}")
    public Cliente obtenerPorId(@PathVariable Long id) {
        return lista.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        cliente.setId(idCounter++);
        lista.add(cliente);
        return cliente;
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente clienteNuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                clienteNuevo.setId(id);
                lista.set(i, clienteNuevo);
                return clienteNuevo;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        lista.removeIf(c -> c.getId().equals(id));
    }
}
