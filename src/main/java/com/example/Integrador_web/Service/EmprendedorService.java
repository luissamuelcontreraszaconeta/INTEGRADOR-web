package com.example.Integrador_web.Service;

import com.example.Integrador_web.Model.Emprendedores;
import com.example.Integrador_web.Model.Usuario;
import com.example.Integrador_web.Repository.IEmprendedor;
import com.example.Integrador_web.Repository.IUsuario;
import org.springframework.stereotype.Service;

@Service

public class EmprendedorService {

    private IEmprendedor emprededorRepository;

    public EmprendedorService(IEmprendedor emprededorRepository) {
        this.emprededorRepository = emprededorRepository;
    }

    public Emprendedores validarCliente(String ruc, String contrasena) {
        return emprededorRepository.validarCliente( ruc,contrasena);
    }
    // ✅ Método para registrar un nuevo usuario
    public void registrarEmpresa(Emprendedores emprendedores) {
        emprededorRepository.registrarEmpresa(emprendedores);
    }
}
