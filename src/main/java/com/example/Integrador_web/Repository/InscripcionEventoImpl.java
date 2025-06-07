package com.example.Integrador_web.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import com.example.Integrador_web.Model.Inscripciones;
import com.example.Integrador_web.Conexion.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InscripcionEventoImpl implements IInscripcionEvento {

    @Override
    public void guardarInscripcion(Inscripciones inscripcion) {
        String query = "INSERT INTO inscripciones_eventos (id_evento, id_usuario, fecha_inscripcion) " +
                "VALUES (?, ?, ?)";
        String fechaActual = LocalDate.now().toString();
        try (Connection con = conexionBD.getConexion();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, inscripcion.getId_evento());
            stmt.setInt(2, inscripcion.getId_usuario());
            stmt.setTimestamp(3, inscripcion.getFecha_inscripcion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Inscripciones> listarInscripcionesPorEvento(int idEvento) {
        List<Inscripciones> lista = new ArrayList<>();
        String query = "SELECT * FROM inscripciones_eventos WHERE id_evento = ?";

        try (Connection con = conexionBD.getConexion();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, idEvento);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Inscripciones ins = new Inscripciones();
                ins.setId_inscripciones(rs.getInt("id_inscripcion"));
                ins.setId_evento(rs.getInt("id_evento"));
                ins.setId_usuario(rs.getInt("id_usuario"));
                ins.setFecha_inscripcion(rs.getTimestamp("fecha_inscripcion"));
                ins.setAsistencia(rs.getBoolean("asistencia"));
                lista.add(ins);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    @Override
    public boolean existeInscripcion(int idUsuario, int idEvento) {
        String query = "SELECT COUNT(*) FROM inscripciones_eventos WHERE id_usuario = ? AND id_evento = ?";
        try (Connection con = conexionBD.getConexion();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idEvento);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
