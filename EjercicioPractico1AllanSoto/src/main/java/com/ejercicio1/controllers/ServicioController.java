package com.ejercicio1.controllers;

import com.ejercicio1.domain.Servicio;
import com.ejercicio1.service.CategoriaService;
import com.ejercicio1.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var servicios = servicioService.getServicios(false);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("servicios", servicios);
        model.addAttribute("totalServicios", servicios.size());
        model.addAttribute("categorias", categorias);
        return "/servicio/lista_servicios";
    }

    @GetMapping("/nuevo")
    public String servicioNuevo(Servicio servicio) {
        return "/servicio/edita_servicio";
    }

    @PostMapping("/guardar")
    public String servicioGuardar(Servicio servicio) {
        servicioService.save(servicio);
        return "redirect:/servicio/listado";
    }

    @GetMapping("/eliminar/{idServicio}")
    public String servicioEliminar(Servicio servicio) {
        servicioService.delete(servicio);
        return "redirect:/servicio/listado";
    }

    @GetMapping("/modificar/{idServicio}")
    public String servicioModificar(Servicio servicio, Model model) {
        servicio = servicioService.getServicio(servicio);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("servicio", servicio);
        model.addAttribute("categorias", categorias);
        return "/servicio/edita_servicio";
    }
}
