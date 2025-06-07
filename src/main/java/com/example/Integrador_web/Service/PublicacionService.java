package com.example.Integrador_web.Service;

import com.example.Integrador_web.Model.Publicaciones;
import com.example.Integrador_web.Repository.IPublicacionForo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionService {

    @Autowired
    private IPublicacionForo repo;

    public List<Publicaciones> obtenerPublicacionesPorTema(int id_tema) {
        return repo.listarPorTema(id_tema);
    }

    public boolean publicarRespuesta(Publicaciones publicacion) {
        return repo.guardar(publicacion);
    }
}
