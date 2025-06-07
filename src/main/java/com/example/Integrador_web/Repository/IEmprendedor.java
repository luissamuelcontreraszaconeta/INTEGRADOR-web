package com.example.Integrador_web.Repository;

import com.example.Integrador_web.Model.Usuario;

public interface IEmprendedor {
    Usuario validarCliente(String email, String contrasena);

}
