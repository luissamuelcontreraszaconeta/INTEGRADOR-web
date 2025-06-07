package com.example.Integrador_web.Controller;

import com.example.Integrador_web.Model.Publicaciones;
import com.example.Integrador_web.Model.Usuario;
import com.example.Integrador_web.Service.PublicacionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;@Controller
public class RespuestaController {

    @Autowired
    private PublicacionService publicacionService;

    @PostMapping("/foro/{id_tema}/responder")
    public String responderPublicacion(@PathVariable("id_tema") int id_tema,
                                       @ModelAttribute("nuevaRespuesta") Publicaciones publicacion,
                                       HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/Ecogreen/login";
        }

        publicacion.setId_tema(id_tema);
        publicacion.setId_usuario(usuario.getIdUsuario());
        publicacionService.publicarRespuesta(publicacion);

        return "redirect:/Ecogreen/foro";
    }
}


