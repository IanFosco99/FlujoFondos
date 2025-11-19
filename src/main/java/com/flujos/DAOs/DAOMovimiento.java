/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.DAOs;

import com.flujos.Entidades.Movimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sol
 */
public class DAOMovimiento {
    
    public void ingresarMovimiento(Movimiento movimiento, Connection conn) throws SQLException {
        String sqlInsert = "INSERT INTO movimiento (desc_movimiento) VALUES (?) ";
        try (PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
            ps.setString(1, movimiento.getDescripcionMovimiento());
            ps.executeUpdate();
        }    
    }
    
    public String obtenerDescripcionMovimiento(Long idMovimiento, Connection con) {
    String descripcion = null;

    String sql = "SELECT desc_movimiento FROM movimiento WHERE id_movimiento = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setLong(1, idMovimiento);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            descripcion = rs.getString("desc_movimiento");
        }

        rs.close();
    } catch (SQLException e) {
        descripcion = null;
    }

    return descripcion;
}
public Movimiento obtenerDatosMovimiento(String descripcion, Connection con) {

    Movimiento movimiento = null;

    String sql = "SELECT * FROM movimiento WHERE desc_movimiento = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, descripcion);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            movimiento = new Movimiento();
            movimiento.setIdMovimiento(rs.getLong("id_movimiento"));
            movimiento.setDescripcionMovimiento(rs.getString("desc_movimiento"));
        }

        rs.close();
    } catch (SQLException e) {
        movimiento = null;
    }

    return movimiento;
}

    public Movimiento obtenerDatos(String descripcion, Connection con) {

        Statement st = null;
        ResultSet rs = null;
        Movimiento movimiento = new Movimiento();

        try {
            String consulta = "SELECT * FROM movimiento WHERE desc_movimiento LIKE '%"+descripcion+"%'";

            st = con.createStatement();
            rs = st.executeQuery(consulta);

            if (rs.next()) {
                movimiento.setIdMovimiento(rs.getLong("id_movimiento"));
                movimiento.setDescripcionMovimiento(rs.getString("desc_movimiento"));
            } else {

                movimiento = null;
            }

        } catch (SQLException ex) {

            movimiento = null;

        } finally {
            try {

                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }

            } catch (SQLException ex) {
                movimiento = null;
            }
        }

        return movimiento;
    }
    

    public void actualizar(Movimiento movimiento, Connection con) throws SQLException {
        
        PreparedStatement ps = null;

        try {
            String sqlUpdate = "UPDATE movimiento SET desc_movimiento = ?"
                    + " WHERE id_movimiento = ? ";

            ps = con.prepareStatement(sqlUpdate);
            ps.setString(1, movimiento.getDescripcionMovimiento());
            ps.setLong(2, movimiento.getIdMovimiento());
            ps.executeUpdate();
        } finally{
        
            if(ps != null){
                ps.close();
            }           
        }
    }
    
    public void eliminar(Long id, Connection con) throws SQLException{
    
        String sqlEliminar = "DELETE FROM movimiento WHERE id_movimiento = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sqlEliminar)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }   
    }

    public Movimiento obtenerDatosMovimieto(String movimiento, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
