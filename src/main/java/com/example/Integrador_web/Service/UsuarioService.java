package com.example.Integrador_web.Service;
import com.example.Integrador_web.Model.Usuario;
import com.example.Integrador_web.Repository.IUsuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private IUsuario usuarioRepository;

    public UsuarioService(IUsuario usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario validarCliente(String correo, String contrasena) {
        return usuarioRepository.validarCliente( correo,contrasena);
    }
}
