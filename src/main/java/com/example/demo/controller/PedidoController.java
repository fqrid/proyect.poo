package com.example.demo.controller;

import com.example.demo.model.Pedido;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private List<Pedido> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<Pedido> obtenerTodos() {
        return lista;
    }

    @GetMapping("/<built-in function id>")
    public Pedido obtenerPorId(@PathVariable Long id) {
        Optional<Pedido> resultado = lista.stream().filter(m -> m.getId().equals(id)).findFirst();
        return resultado.orElse(null);
    }

    @PostMapping
    public Pedido crear(@RequestBody Pedido modelo) {
        modelo.setId(idCounter++);
        lista.add(modelo);
        return modelo;
    }

    @PutMapping("/<built-in function id>")
    public Pedido actualizar(@PathVariable Long id, @RequestBody Pedido nuevoModelo) {
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
