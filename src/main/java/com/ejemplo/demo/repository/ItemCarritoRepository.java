package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.ItemCarrito;
import java.util.*;

/**
 * Repositorio en memoria para ItemCarrito, usando String como ID.
 * Internamente genera IDs secuenciales (1, 2, 3, …) convertidos a String.
 */
public class ItemCarritoRepository {
    // Mapa de id:String  →  ItemCarrito
    private final Map<String, ItemCarrito> data = new HashMap<>();
    private long currentId = 1;

    /**
     * Guarda un nuevo ItemCarrito o actualiza uno existente.
     * Si item.getId() == null, se genera un nuevo IDString.
     * En caso contrario, se overwrite del item existente.
     */
    public ItemCarrito save(ItemCarrito item) {
        if (item.getId() == null) {
            // Generar nuevo ID como String
            item.setId(String.valueOf(currentId++));
        }
        data.put(item.getId(), item);
        return item;
    }

    /**
     * Busca por ID (String). Retorna Optional<ItemCarrito>.
     */
    public Optional<ItemCarrito> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }

    /**
     * Devuelve todos los items en forma de lista.
     */
    public List<ItemCarrito> findAll() {
        return new ArrayList<>(data.values());
    }

    /**
     * Elimina el item con ese ID. Si no existe, no hace nada.
     */
    public void deleteById(String id) {
        data.remove(id);
    }
}
