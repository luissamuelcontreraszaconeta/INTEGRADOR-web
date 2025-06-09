package com.example.Integrador_web.Repository;

import com.example.Integrador_web.Conexion.conexionBD;
import com.example.Integrador_web.Model.Emprendedores;
import com.example.Integrador_web.Model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository

public class IEmprendedorImpl implements IEmprendedor {

    private final BCryptPasswordEncoder passwordEncoder;

    // Inyectar BCryptPasswordEncoder
    public IEmprendedorImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Emprendedores validarCliente(String ruc, String contrasena) {
        Emprendedores emprendedores = null;
        String query = "SELECT * FROM empresas WHERE ruc = ? AND contraseña = ?";



        try (Connection con = conexionBD.getConexion();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, ruc);
            stmt.setString(2, contrasena);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    emprendedores = new Emprendedores(
                            rs.getInt("id_empresa"),
                            rs.getString("nombre_empresa"),
                            rs.getString("telefono"),
                            rs.getString("descripcion"),
                            rs.getString("sitio_web"),
                            rs.getString("ruc"),
                            rs.getString("contraseña")

                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprendedores;
    }
    @Override
    public void registrarEmpresa(Emprendedores emprendedores) {
        String sql = "INSERT INTO empresas (nombre_empresa, telefono, ruc, contraseña) VALUES (?, ?, ?, ?)";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, emprendedores.getNombre_empresa());
            stmt.setString(2, emprendedores.getTelefono());
            stmt.setString(3, emprendedores.getRuc()); // ⚠️ Cifra si es posible
            stmt.setString(4, emprendedores.getContraseña());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
