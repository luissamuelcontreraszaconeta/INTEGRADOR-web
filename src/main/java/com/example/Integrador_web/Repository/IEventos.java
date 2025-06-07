package com.example.Integrador_web.Repository;


import java.util.List;
import com.example.Integrador_web.Model.Eventos;


public interface IEventos {

    List<Eventos> ListarEvento();

    void guardar(Eventos eventos);

}
