package com.proyectodam.biblioteca.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyectodam.biblioteca.dto.Padecimiento;

public class PadecimientoDAO {
    
    // Crear un nuevo Padecimiento burno
    public boolean agregarPadecimiento(Padecimiento padecimiento) {
        String sql = "INSERT INTO padecimientos (nombre_padecimiento, descripcion, gravedad) VALUES (?, ?, ?)"; //INSERT INTO persona (nombre) VALUES (?)
        try (Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, padecimiento.getNombre());
            pstmt.setString(2, padecimiento.getDescripcion());
            pstmt.setString(3, padecimiento.getGravedad());
            int affectedRows = pstmt.executeUpdate();
            
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    

    public List<Padecimiento> obtenerTodosPadecimientos(){
        String sql = "select * from padecimientos";
        try (Connection conn = Conexion.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();) {
            List<Padecimiento> padecimiento = new ArrayList<>();
            while (rs.next()) {
                padecimiento.add(new Padecimiento(rs.getInt("id_padecimiento"),rs.getString("nombre_padecimiento"), rs.getString("descripcion"), rs.getString("gravedad")));
            }
            return padecimiento;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        public boolean eliminarPadecimiento(Padecimiento padecimiento) {
            String sql = "DELETE FROM padecimientos WHERE nombre_padecimiento = ?";
            try (Connection connection = Conexion.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, padecimiento.getNombre());
                int rowsDeleted = statement.executeUpdate();
                return rowsDeleted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean actualizarPadecimiento(Padecimiento padecimiento) {
            String sql = "UPDATE padecimientos SET nombre_padecimiento = ?, descripcion = ?, gravedad = ? WHERE id_padecimiento = ?";
            try (Connection connection = Conexion.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, padecimiento.getNombre());
                statement.setString(2, padecimiento.getDescripcion());
                statement.setString(3, padecimiento.getGravedad());
                statement.setInt(4, padecimiento.getId_padecimiento());
                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
}

