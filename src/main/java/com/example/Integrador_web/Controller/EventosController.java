package com.example.Integrador_web.Controller;

import com.example.Integrador_web.Model.Inscripciones;
import com.example.Integrador_web.Model.Usuario;
import com.example.Integrador_web.Service.InscripcionesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Integrador_web.Model.Eventos;
import com.example.Integrador_web.Service.EventosService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/Ecogreen")
public class EventosController {

    @Autowired
    private EventosService eventosService;
    @Autowired
    private InscripcionesService inscripcionService;


    @GetMapping("/voluntariado")
    public String mostrarEventos(Model model, HttpSession session) {
        List<Eventos> listaEventos = eventosService.listareventos();
        model.addAttribute("eventos", listaEventos);

        // Obtener el usuario logueado desde la sesión
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        // Crear un mapa para saber si el usuario está inscrito en cada evento
        Map<Integer, Boolean> eventosInscritos = new HashMap<>();

        if (usuario != null) {
            for (Eventos evento : listaEventos) {
                boolean inscrito = inscripcionService.estaInscrito(usuario.getIdUsuario(), evento.getId_evento());
                eventosInscritos.put(evento.getId_evento(), inscrito);
            }
        }

        // Enviar el mapa al HTML
//        model.addAttribute("eventosInscritos", eventosInscritos);
        model.addAttribute("eventosInscritos", new HashMap<Integer, Boolean>());


        return "voluntariados"; // Tu vista HTML
    }

//    @PostMapping("/eventos/{id}/inscribirse")
//    public String inscribirseEvento(@PathVariable("id") int idEvento, HttpSession session) {
//        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
//
//        if (usuario != null) {
//            boolean yaInscrito = inscripcionService.estaInscrito(usuario.getIdUsuario(), idEvento);
//
//            if (!yaInscrito) {
//                Inscripciones nuevaInscripcion = new Inscripciones();
//                nuevaInscripcion.setId_evento(idEvento);
//                nuevaInscripcion.setId_usuario(usuario.getIdUsuario());
//
//
//                inscripcionService.guardar(nuevaInscripcion);
//            }
//        }
//
//        // Redirigir a la misma página para refrescar los datos
//        return "redirect:/Ecogreen/voluntariado";
//    }


}

