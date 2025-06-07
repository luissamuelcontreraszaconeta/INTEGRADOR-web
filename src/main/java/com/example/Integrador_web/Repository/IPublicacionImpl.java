package com.example.Integrador_web.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.Integrador_web.Model.Publicaciones;
import com.example.Integrador_web.Conexion.conexionBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IPublicacionImpl implements IPublicacionForo{
    @Override
    public List<Publicaciones> listarPorTema(int id_tema) {
        List<Publicaciones> lista = new ArrayList<>();
        String sql = "SELECT p.*, u.nombre_usuario FROM publicaciones_foro p " +
                "JOIN usuarios u ON p.id_usuario = u.id_usuario " +
                "WHERE p.id_tema = ?";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id_tema);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Publicaciones pub = new Publicaciones();
                    pub.setId_publicacion(rs.getInt("id_publicacion"));
                    pub.setId_tema(rs.getInt("id_tema"));
                    pub.setId_usuario(rs.getInt("id_usuario"));
                    pub.setContenido(rs.getString("contenido"));
                    pub.setNombreUsuario(rs.getString("nombre_usuario"));
                    lista.add(pub);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    @Override
    public boolean guardar(Publicaciones publicacion) {
        String sql = "INSERT INTO publicaciones_foro (id_tema, id_usuario, contenido) VALUES (?, ?, ?)";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, publicacion.getId_tema());
            ps.setInt(2, publicacion.getId_usuario());
            ps.setString(3, publicacion.getContenido());


            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
