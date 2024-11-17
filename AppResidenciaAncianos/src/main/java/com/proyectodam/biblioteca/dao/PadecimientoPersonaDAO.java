package com.proyectodam.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.proyectodam.biblioteca.dto.PadecimientoPersona;



public class PadecimientoPersonaDAO {
    // Insertar una relación Padecoimiento - Persona en la base de datos
    public boolean insertarPadecimientoPersona(PadecimientoPersona padecimientoPersona) { 
        String sql = "INSERT INTO padecimientos_personas (id_padecimiento, id_persona) VALUES (?, ?)";  
        try (Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, padecimientoPersona.getId_padecimiento()); 
            pstmt.setInt(2, padecimientoPersona.getId_persona());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

