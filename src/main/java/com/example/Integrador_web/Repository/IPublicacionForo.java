package com.example.Integrador_web.Repository;

import com.example.Integrador_web.Model.Publicaciones;

import java.util.List;

public interface IPublicacionForo {
    List<Publicaciones> listarPorTema(int id_tema);
    boolean guardar(Publicaciones publicacion);
}
