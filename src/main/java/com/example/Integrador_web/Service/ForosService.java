package com.example.Integrador_web.Service;

import com.example.Integrador_web.Model.Foros;
import com.example.Integrador_web.Repository.IEventos;
import com.example.Integrador_web.Repository.IForos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForosService {
    @Autowired
    private IForos iforos;



    public List<Foros> listarforo() {
        return iforos.listarforo();
    }

}
