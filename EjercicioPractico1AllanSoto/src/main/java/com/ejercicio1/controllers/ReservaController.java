package com.ejercicio1.controllers;

import com.ejercicio1.domain.Reserva;
import com.ejercicio1.service.ReservaService;
import com.ejercicio1.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var reservas = reservaService.getReservas();
        var servicios = servicioService.getServicios(false);
        model.addAttribute("reservas", reservas);
        model.addAttribute("totalReservas", reservas.size());
        model.addAttribute("servicios", servicios);
        return "/reserva/lista_reservas";
    }

    @PostMapping("/guardar")
    public String guardar(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/eliminar/{idReserva}")
    public String eliminar(Reserva reserva) {
        reservaService.delete(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/modificar/{idReserva}")
    public String modificar(Reserva reserva, Model model) {
        reserva = reservaService.getReserva(reserva);
        var servicios = servicioService.getServicios(false);
        model.addAttribute("reserva", reserva);
        model.addAttribute("servicios", servicios);
        return "/reserva/edita_reserva";
    }
}
