package com.example.Integrador_web.Controller;
// src/main/java/tu/paquete/GlobalControllerAdvice.java

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.Integrador_web.Model.Usuario;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void agregarUsuarioALasVistas(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.addAttribute("usuarioLogueado", usuario);
    }
}

