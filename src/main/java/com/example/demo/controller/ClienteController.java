package com.example.demo.controller;

import com.example.demo.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private List<Cliente> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<Cliente> obtenerTodos() {
        return lista;
    }

    @GetMapping("/<built-in function id>")
    public Cliente obtenerPorId(@PathVariable Long id) {
        Optional<Cliente> resultado = lista.stream().filter(m -> m.getId().equals(id)).findFirst();
        return resultado.orElse(null);
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente modelo) {
        modelo.setId(idCounter++);
        lista.add(modelo);
        return modelo;
    }

    @PutMapping("/<built-in function id>")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente nuevoModelo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                nuevoModelo.setId(id);
                lista.set(i, nuevoModelo);
                return nuevoModelo;
            }
        }
        return null;
    }

    @DeleteMapping("/<built-in function id>")
    public void eliminar(@PathVariable Long id) {
        lista.removeIf(m -> m.getId().equals(id));
    }
}
