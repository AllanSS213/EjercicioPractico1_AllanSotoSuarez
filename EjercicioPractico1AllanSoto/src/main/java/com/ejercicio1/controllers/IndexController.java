package com.ejercicio1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("titulo", "Salón de Belleza");
        return "index";
    }
}
