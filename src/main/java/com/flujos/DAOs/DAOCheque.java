/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.DAOs;

import com.flujos.Entidades.Cheque;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author monse
 */
public class DAOCheque {
    
    
    public void ingresarCheque(Cheque cheque, Connection conn) throws SQLException {
        String sqlInsert = "INSERT INTO cheque(nro_cheque, importe_cheque, fecha_cobro_cheque, tipo_cheque, estado_cheque, observacion_cheque, fecha_entrega_cheque, titular_cheque, titular_destino, uso_cheque) "
        + " VALUES (?, ?, ?, ?, ?,?,?,?,?,?)";
        
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sqlInsert);
            
            ps.setInt(1, cheque.getNumCheque());
            ps.setBigDecimal(2, cheque.getImporteCheque());
            ps.setDate(3, (Date) cheque.getFechaCobroCheque());
            ps.setString(4, cheque.getTipoCheque());
            ps.setInt(5, cheque.getEstadoCheque());
            ps.setString(6, cheque.getObservacionCheque());
            ps.setDate(7, (Date) cheque.getFechaEntregaCheque());
            ps.setLong(8, cheque.getTitularCheque());
            ps.setLong(9, cheque.getTitularDestino());
            ps.setString(10, cheque.getUsoCheque());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();

            }
        }
    }
    
    
    
    public Cheque obtenerDatos(Integer nroCheque, Connection con) {

        Statement st = null;
        ResultSet rs = null;
        Cheque cheque = new Cheque();

        try {
            String consulta = "SELECT * FROM cheque WHERE nro_cheque = " + nroCheque;

            st = con.createStatement();
            rs = st.executeQuery(consulta);

            if (rs.next()) {

                cheque.setNumCheque(rs.getInt("nro_cheque"));
                cheque.setImporteCheque(rs.getBigDecimal("importe_cheque"));
                cheque.setTipoCheque(rs.getString("tipo_cheque"));
                cheque.setEstadoCheque(rs.getInt("estado_cheque"));
                cheque.setObservacionCheque(rs.getString("observacion_cheque"));
                cheque.setFechaEntregaCheque(rs.getDate("fecha_entrega_cheque"));
                cheque.setTitularCheque(rs.getLong("titular_cheque"));
                cheque.setTitularDestino(rs.getLong("titular_destino"));
                cheque.setUsoCheque(rs.getString("uso_cheque"));
                cheque.setIdCheque(rs.getLong("id_cheque"));


            } else {

                cheque = null;

            }

        } catch (SQLException ex) {

            cheque = null;

        } finally {
            try {

                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }

            } catch (SQLException ex) {
                cheque = null;
            }

        }

        return cheque;

    }
    
    
    
    public void actualizar(Cheque cheque, Connection con) throws SQLException {
        
        PreparedStatement ps = null;

        try {
            String sqlUpdate = "UPDATE cheque SET "
                    + "nro_cheque = ?, "
                    + "importe_cheque = ?, "
                    + "fecha_cobro_cheque = ?, "
                    + "tipo_cheque = ?, "
                    + "estado_cheque = ? "
                    + "observacion_cheque = ?"
                    +"fecha_entrega_cheque = ?"
                    +"titular_cheque = ?"
                    +"titular_destino = ?"
                    +"uso_cheque = ?"
                    + "WHERE id_cheque = ?";

            ps = con.prepareStatement(sqlUpdate);
            ps.setInt(1, cheque.getNumCheque());
            ps.setBigDecimal(2, cheque.getImporteCheque());
            ps.setDate(3, (Date) cheque.getFechaCobroCheque());
            ps.setString(4, cheque.getTipoCheque());
            ps.setInt(5, cheque.getEstadoCheque());
            ps.setString(6, cheque.getObservacionCheque());
            ps.setDate(7, (Date) cheque.getFechaEntregaCheque());
            ps.setLong(8, cheque.getTitularCheque());
            ps.setLong(9, cheque.getTitularDestino());
            ps.setString(10, cheque.getUsoCheque());
            ps.executeUpdate();
        } finally{
        
            if(ps != null){
                ps.close();
            }
            
        }

    }

    
}
