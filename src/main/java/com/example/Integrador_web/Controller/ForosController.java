package com.example.Integrador_web.Controller;

import com.example.Integrador_web.Model.Eventos;
import com.example.Integrador_web.Model.Foros;
import com.example.Integrador_web.Model.Publicaciones;
import com.example.Integrador_web.Model.Usuario;
import com.example.Integrador_web.Service.EventosService;
import com.example.Integrador_web.Service.ForosService;
import com.example.Integrador_web.Service.PublicacionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Ecogreen")
public class ForosController {

    @Autowired
    private ForosService forosService;

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping("/foro")
    public String mostrarForo(Model model, HttpSession session) {
        List<Foros> listaForos = forosService.listarforo();
        Map<Integer, List<Publicaciones>> respuestasPorForo = new HashMap<>();

        for (Foros foro : listaForos) {
            List<Publicaciones> respuestas = publicacionService.obtenerPublicacionesPorTema(foro.getId_tema());
            respuestasPorForo.put(foro.getId_tema(), respuestas);
        }

        model.addAttribute("foros", listaForos);
        model.addAttribute("respuestasPorForo", respuestasPorForo);
        model.addAttribute("nuevaRespuesta", new Publicaciones());

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.addAttribute("usuarioLogueado", usuario);

        return "foro";
    }


}
