/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.DAOs;

import com.flujos.Entidades.ChequeTerceros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author monse
 */
public class DAOChequeTercero {

    //INSERTAR CHEQUE DE TERCERO
    public void agregarChequeTercero(ChequeTerceros chequeTerceros, Connection con) throws SQLException {

        String sql = "INSERT INTO cheque_tercero (nro_cheque, id_titular, importe, fecha_cobro, observacion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, chequeTerceros.getNroCheque());
            ps.setLong(2, chequeTerceros.getTitularCheque());
            ps.setBigDecimal(3, chequeTerceros.getImporteCheque());
            ps.setDate(4, new java.sql.Date(chequeTerceros.getFechaCobroCheque().getTime()));
            ps.setString(5, chequeTerceros.getObservacionCheque());
            ps.executeUpdate();
        }
    }

    //MODIFICAR 
    public void modificarChequeTercero(ChequeTerceros chequeTerceros, Connection con) throws SQLException {
        String sql = "UPDATE cheque_tercero SET  id_titular = ?, importe_cheque = ?, fecha_cobro_cheque = ?, observacion_cheque, nro_cheque = ? WHERE id_cheque = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, chequeTerceros.getTitularCheque());
            ps.setBigDecimal(2, chequeTerceros.getImporteCheque());
            ps.setDate(3, new java.sql.Date(chequeTerceros.getFechaCobroCheque().getTime()));
            ps.setString(4, chequeTerceros.getObservacionCheque());
            ps.setLong(5, chequeTerceros.getNroCheque());
            ps.setLong(6, chequeTerceros.getIdCheque());

            
            ps.executeUpdate();
        }
    }

    //ELIMINAR
    public void eliminarChequeTercero(long numeroCheque, Connection con) throws SQLException {

        String sql = "DELETE FROM cheque_tercero WHERE nro_cheque";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, numeroCheque);
            ps.executeUpdate();
        }
    }

    //OBTENER CHEQUE POR NUMERO
    public ChequeTerceros obtenerChequePorNumero(long numero, Connection con) throws SQLException {
        String sql = "SELECT * FROM cheque_tercero WHERE nro_cheque = ?";
        ChequeTerceros chequeTerceros = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, numero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                chequeTerceros = new ChequeTerceros();
                chequeTerceros.setNroCheque(rs.getLong("nro_cheque"));
                chequeTerceros.setTitularCheque(rs.getLong("id_titular"));
                chequeTerceros.setImporteCheque(rs.getBigDecimal("importe"));
                chequeTerceros.setFechaCobroCheque(rs.getDate("fecha_cobro"));
                chequeTerceros.setObservacionCheque(rs.getString("observacion"));
            }
            rs.close();

        }
        return chequeTerceros;
    }
    
    
    public boolean existeCheque(long numero, Connection con) throws SQLException{
    
        String sql = "SELECT 1 FROM cheque_tercero WHERE nro_cheque = ?";
        
        try(PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, numero);
            ResultSet rs = ps.executeQuery();
            boolean existe = rs.next();
            rs.close();
            return existe;
        }  
    }
}

