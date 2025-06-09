package com.example.Integrador_web.Repository;

import java.util.List;
import com.example.Integrador_web.Model.Usuario;

public interface IUsuario
{
    Usuario validarCliente(String dni, String contrasena);
    void registrarUsuario(Usuario usuario);

}
