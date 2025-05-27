package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class RolController {

    private RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // Crear un nuevo rol
    public void crearRol(Rol rol) {
        if (rol != null) {
            rolService.crearRol(rol);
            System.out.println(" Rol creado correctamente.");
        } else {
            System.out.println(" El rol no puede ser nulo.");
        }
    }

    // Listar todos los roles
    public void listarRoles() {
        List<Rol> lista = rolService.obtenerRoles();
        if (!lista.isEmpty()) {
            System.out.println(" Lista de roles:");
            for (Rol r : lista) {
                System.out.println(r);
            }
        } else {
            System.out.println("ℹ No hay roles registrados.");
        }
    }

    // Buscar rol por ID
    public void buscarRolPorId(int id) {
        Rol rol = rolService.buscarPorId(id);
        if (rol != null) {
            System.out.println(" Rol encontrado:");
            System.out.println(rol);
        } else {
            System.out.println(" No se encontró ningún rol con ID: " + id);
        }
    }

    // Eliminar rol por ID
    public void eliminarRol(int id) {
        boolean eliminado = rolService.eliminarRol(id);
        if (eliminado) {
            System.out.println(" Rol eliminado correctamente.");
        } else {
            System.out.println(" No se pudo eliminar el rol con ID: " + id);
        }
    }
}
