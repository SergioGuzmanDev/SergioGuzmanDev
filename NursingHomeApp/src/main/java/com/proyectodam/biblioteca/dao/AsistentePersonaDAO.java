package com.proyectodam.biblioteca.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.proyectodam.biblioteca.dto.AsistentePersona;


public class AsistentePersonaDAO {
    // Insertar una relación Asistente-Persona en la base de datos
    public boolean insertarAsistentePersona(AsistentePersona AsistentePersona) { 
        String sql = "INSERT INTO asistentes_personas (id_asistente, id_persona) VALUES (?, ?)";  
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, AsistentePersona.getAsistenteId());
            pstmt.setInt(2, AsistentePersona.getPersonaId()); 
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
    
    }
    }
   
   
    }
  

