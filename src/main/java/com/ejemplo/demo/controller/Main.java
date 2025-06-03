package com.ejemplo.demo.controller;

import io.javalin.Javalin;

import com.ejemplo.demo.repository.*;
import com.ejemplo.demo.service.*;

public class Main {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.plugins.enableCors(cors -> cors.add(it -> {
                it.anyHost();
            }));
        }).start(7000);

        // Repositorios
        ClienteRepository clienteRepo = new ClienteRepository();
        ProductoRepository productoRepo = new ProductoRepository();
        CategoriaRepository categoriaRepo = new CategoriaRepository();
        CategoriaSecundariaRepository categoriaSecundariaRepo = new CategoriaSecundariaRepository();
        CarritoCompraRepository carritoRepo = new CarritoCompraRepository();
        ItemCarritoRepository itemCarritoRepo = new ItemCarritoRepository();
        ComentarioRepository comentarioRepo = new ComentarioRepository();
        DescuentoRepository descuentoRepo = new DescuentoRepository();
        DireccionRepository direccionRepo = new DireccionRepository();
        DetalleFacturaRepository detalleFacturaRepo = new DetalleFacturaRepository();
        DetallePedidoRepository detallePedidoRepo = new DetallePedidoRepository();
        FacturaRepository facturaRepo = new FacturaRepository();
        MetodoPagoRepository metodoPagoRepo = new MetodoPagoRepository();
        NotificacionRepository notificacionRepo = new NotificacionRepository();
        PagoRepository pagoRepo = new PagoRepository();
        PedidoRepository pedidoRepo = new PedidoRepository();
        ResenaRepository resenaRepo = new ResenaRepository();
        RolRepository rolRepo = new RolRepository();
        UsuarioRepository usuarioRepo = new UsuarioRepository();

        // Servicios
        ClienteService clienteService = new ClienteService(clienteRepo);
        ProductoService productoService = new ProductoService(productoRepo);
        CategoriaService categoriaService = new CategoriaService(categoriaRepo);
        CategoriaSecundariaService categoriaSecundariaService = new CategoriaSecundariaService(categoriaSecundariaRepo);
        CarritoCompraService carritoService = new CarritoCompraService(carritoRepo);
        ItemCarritoService itemCarritoService = new ItemCarritoService(itemCarritoRepo);
        ComentarioService comentarioService = new ComentarioService(comentarioRepo);
        DescuentoService descuentoService = new DescuentoService(descuentoRepo);
        DireccionService direccionService = new DireccionService(direccionRepo);
        DetalleFacturaService detalleFacturaService = new DetalleFacturaService(detalleFacturaRepo);
        DetallePedidoService detallePedidoService = new DetallePedidoService(detallePedidoRepo);
        FacturaService facturaService = new FacturaService(facturaRepo);
        MetodoPagoService metodoPagoService = new MetodoPagoService(metodoPagoRepo);
        NotificacionService notificacionService = new NotificacionService(notificacionRepo);
        PagoService pagoService = new PagoService(pagoRepo);
        PedidoService pedidoService = new PedidoService(pedidoRepo);
        ResenaService resenaService = new ResenaService(resenaRepo);
        RolService rolService = new RolService(rolRepo);
        UsuarioService usuarioService = new UsuarioService(usuarioRepo);

        // Controladores
        new ClienteController(clienteService).configurarRutas(app);
        new ProductoController(productoService).configurarRutas(app);
        new CategoriaController(categoriaService).configurarRutas(app);
        new CategoriaSecundariaController(categoriaSecundariaService).configurarRutas(app);
        new CarritoCompraController(carritoService).configurarRutas(app);
        new ItemCarritoController(itemCarritoService).configurarRutas(app);
        new ComentarioController(comentarioService).configurarRutas(app);
        new DescuentoController(descuentoService).configurarRutas(app);
        new DireccionController(direccionService).configurarRutas(app);
        new DetalleFacturaController(detalleFacturaService).configurarRutas(app);
        new DetallePedidoController(detallePedidoService).configurarRutas(app);
        new FacturaController(facturaService).configurarRutas(app);
        new MetodoPagoController(metodoPagoService).configurarRutas(app);
        new NotificacionController(notificacionService).configurarRutas(app);
        new PagoController(pagoService).configurarRutas(app);
        new PedidoController(pedidoService).configurarRutas(app);
        new ResenaController(resenaService).configurarRutas(app);
        new RolController(rolService).configurarRutas(app);
        new UsuarioController(usuarioService).configurarRutas(app);

        // Ruta raíz
        new InicioController().configurarRutas(app);
    }
}
