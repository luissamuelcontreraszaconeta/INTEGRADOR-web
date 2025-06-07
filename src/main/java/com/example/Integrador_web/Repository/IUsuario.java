package com.example.Integrador_web.Repository;

import java.util.List;
import com.example.Integrador_web.Model.Usuario;

public interface IUsuario
{
    Usuario validarCliente(String email, String contrasena);


}
