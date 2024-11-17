package com.proyectodam.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.proyectodam.biblioteca.dto.Persona;

public class PersonaDAO {
    // Obtener una persona por su ID
    // Crear un nuevo Usuario
    public boolean insertarPersona(Persona persona) {
        String sql = "INSERT INTO personas (nombre, direccion, telefono, email, dni, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, persona.getNombre());
            pstmt.setString(2, persona.getDireccion());
            pstmt.setString(3, persona.getTelefono());
            pstmt.setString(4, persona.getEmail());
            pstmt.setString(5, persona.getDni());
            pstmt.setString(6, persona.getfecha_nacimiento());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Persona> obtenerTodasPersonas() {
        String sql = "select * from personas";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();) {
            List<Persona> persona = new ArrayList<>();
            while (rs.next()) {
                persona.add(new Persona(rs.getInt("id_persona"), rs.getString("nombre"), rs.getString("direccion"),
                        rs.getString("telefono"), rs.getString("email"), rs.getString("dni"),
                        rs.getString("fecha_nacimiento")));
            }
            return persona;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String obtenerNombreYTelefonoPersona(String nombre) {
        String sql = "SELECT nombre, telefono FROM personas";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombrePersona = rs.getString("nombre");
                    String telefonoPersona = rs.getString("telefono");
                    return "Nombre: " + nombrePersona + ", Teléfono: " + telefonoPersona;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean actualizarPersona(String antiguoNombre, String nuevoNombre, String nuevaDireccion, String nuevoTelefono, String nuevoEmail) {
        StringBuilder sql = new StringBuilder("UPDATE personas SET ");
        boolean hasPrevious = false;

        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            sql.append("nombre = ?");
            hasPrevious = true;
        }

        if (nuevaDireccion != null && !nuevaDireccion.isEmpty()) {
            if (hasPrevious) {
                sql.append(", ");
            }
            sql.append("direccion = ?");
            hasPrevious = true;
        }

        if (nuevoTelefono != null && !nuevoTelefono.isEmpty()) {
            if (hasPrevious) {
                sql.append(", ");
            }
            sql.append("telefono = ?");
            hasPrevious = true;
        }

        if (nuevoEmail != null && !nuevoEmail.isEmpty()) {
            if (hasPrevious) {
                sql.append(", ");
            }
            sql.append("email = ?");
        }

        sql.append(" WHERE nombre = ?");

        try (Connection connection = Conexion.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql.toString())) {

            int parameterIndex = 1;

            if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                statement.setString(parameterIndex++, nuevoNombre);
            }

            if (nuevaDireccion != null && !nuevaDireccion.isEmpty()) {
                statement.setString(parameterIndex++, nuevaDireccion);
            }

            if (nuevoTelefono != null && !nuevoTelefono.isEmpty()) {
                statement.setString(parameterIndex++, nuevoTelefono);
            }

            if (nuevoEmail != null && !nuevoEmail.isEmpty()) {
                statement.setString(parameterIndex++, nuevoEmail);
            }

            statement.setString(parameterIndex, antiguoNombre);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarPersonaPorDNI(Persona persona) {
        String sql = "DELETE FROM personas WHERE dni = ?";
        try (Connection connection = Conexion.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, persona.getDni()); // Extract dni from Persona object
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Persona obtenerPersonaPorID(int id) {
        String sql = "SELECT * FROM personas WHERE persona_id = ?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Persona(rs.getInt("persona_id"), rs.getString("nombre"), rs.getString("direccion"),
                            rs.getString("telefono"), rs.getString("email"), rs.getString("dni"),
                            rs.getString("fecha_nacimiento"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
