package com.proyectodam.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.proyectodam.biblioteca.dto.Asistente;

public class AsistenteDAO {

    // Crear un nuevo Asistente
    public boolean insertarAsistente(Asistente asistente) {
        String sql = "INSERT INTO asistentes (nombre, especialidad, telefono, direccion, email) VALUES ( ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, asistente.getNombre());
            pstmt.setString(2, asistente.getEspecialidad());
            pstmt.setString(3, asistente.getTelefono());
            pstmt.setString(4, asistente.getDireccion());
            pstmt.setString(5, asistente.getEmail());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }   

    public boolean actualizarAsistente(String antiguoNombre, String nuevoNombre, String nuevaEspecialidad, String nuevoTelefono, String nuevaDireccion, String nuevoEmail) {
        String sql = "UPDATE asistentes SET nombre = ?, especialidad = ?, telefono = ?, direccion = ?, email = ? WHERE nombre = ?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevaEspecialidad);
            pstmt.setString(3, nuevoTelefono);
            pstmt.setString(4, nuevaDireccion);
            pstmt.setString(5, nuevoEmail);
            pstmt.setString(6, antiguoNombre);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarAsistente(Asistente asistente) {
        String sql = "DELETE FROM asistentes WHERE nombre = ?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, asistente.getNombre());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

        public List<Asistente> obtenerTodosAsistentes() {
            String sql = "select * from asistentes";
            try (Connection conn = Conexion.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();) {
                List<Asistente> asistentes = new ArrayList<>();
                while (rs.next()) {
                    asistentes.add(new Asistente(rs.getInt("id_Asistente"), rs.getString("nombre"),
                            rs.getString("especialidad"), rs.getString("telefono"), rs.getString("direccion"),
                            rs.getString("email")));
                }
                return asistentes;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

         public String obtenerNombreYTelefonoAsistente(String nombre) {
        String sql = "SELECT nombre, telefono FROM Asistentes";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombreAsistente = rs.getString("nombre");
                    String telefonoAsistente = rs.getString("telefono");
                    return "Nombre: " + nombreAsistente + ", Teléfono: " + telefonoAsistente;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}