package com.example.Integrador_web.Repository;

import com.example.Integrador_web.Conexion.conexionBD;
import com.example.Integrador_web.Model.Eventos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.Integrador_web.Model.Foros;
import org.springframework.stereotype.Repository;

@Repository
public class IForosImpl implements IForos{
    @Override
    public List<Foros> listarforo() {
        List<Foros> foro = new ArrayList<>();
        String query = "SELECT * FROM temas_foro";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Foros carga = new Foros();
                carga.setId_tema(rs.getInt("id_tema"));
                carga.setNombre(rs.getString("nombre"));
                carga.setDescipcion(rs.getString("descripcion"));
                foro.add(carga);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foro;
    }
}
