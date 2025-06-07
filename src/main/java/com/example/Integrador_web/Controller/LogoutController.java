package com.example.Integrador_web.Controller;
// src/main/java/tu/paquete/LogoutController.java

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping("/Ecogreen/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate(); // Cierra sesión completamente
        return "redirect:/Ecogreen/login"; // Puedes redirigir al login o al index
    }
}
