package com.example.Integrador_web.Repository;

import com.example.Integrador_web.Model.Emprendedores;
import com.example.Integrador_web.Model.Usuario;

public interface IEmprendedor {
    Emprendedores validarCliente(String ruc, String contrasena);
    void registrarEmpresa(Emprendedores emprendedores);


}
