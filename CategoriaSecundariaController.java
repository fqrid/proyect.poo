package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;;

public class CategoriaSecundariaController {

    private CategoriaSecundariaService categoriaService;

    public CategoriaSecundariaController(CategoriaSecundariaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Crear una nueva categoría secundaria
    public void crearCategoria(CategoriaSecundaria categoria) {
        if (categoria != null) {
            categoriaService.crearCategoria(categoria);
            System.out.println(" Categoría secundaria creada correctamente.");
        } else {
            System.out.println(" La categoría secundaria no puede ser nula.");
        }
    }

    // Listar todas las categorías secundarias
    public void listarCategorias() {
        List<CategoriaSecundaria> lista = categoriaService.obtenerCategorias();
        if (!lista.isEmpty()) {
            System.out.println(" Categorías secundarias registradas:");
            for (CategoriaSecundaria c : lista) {
                System.out.println(c);
            }
        } else {
            System.out.println("ℹ No hay categorías secundarias registradas.");
        }
    }

    // Buscar una categoría por ID
    public void buscarCategoriaPorId(int id) {
        CategoriaSecundaria categoria = categoriaService.buscarPorId(id);
        if (categoria != null) {
            System.out.println(" Categoría secundaria encontrada:");
            System.out.println(categoria);
        } else {
            System.out.println(" No se encontró ninguna categoría secundaria con ID: " + id);
        }
    }

    // Eliminar una categoría secundaria
    public void eliminarCategoria(int id) {
        boolean eliminado = categoriaService.eliminarCategoria(id);
        if (eliminado) {
            System.out.println(" Categoría secundaria eliminada correctamente.");
        } else {
            System.out.println(" No se pudo eliminar la categoría secundaria con ID: " + id);
        }
    }
}
