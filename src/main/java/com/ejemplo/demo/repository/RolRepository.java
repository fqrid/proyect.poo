package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Rol;
import java.util.*;

public class RolRepository {
    private final Map<String, Rol> datos = new HashMap<>();

    public Rol save(Rol rol) {
        datos.put(rol.getId(), rol);
        return rol;
    }

    public Optional<Rol> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Rol> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
