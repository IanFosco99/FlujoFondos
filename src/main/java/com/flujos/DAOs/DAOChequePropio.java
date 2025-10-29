/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.DAOs;

import com.flujos.Entidades.Cheque;
import com.flujos.Entidades.ChequePropio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sol
 */
public class DAOChequePropio {
    
    public ChequePropio obtenerDatos(Long nroCheque, Connection con) {

        Statement st = null;
        ResultSet rs = null;
        ChequePropio chequePropio = new ChequePropio();

        try {
            String consulta = "SELECT * FROM cheque_propio WHERE nro_cheque = " + nroCheque;

            st = con.createStatement();
            rs = st.executeQuery(consulta);

            if (rs.next()) {

                chequePropio.setIdCheque(rs.getLong("id_cheque"));
                chequePropio.setNumCheque(rs.getLong("nro_cheque"));
                chequePropio.setImporteCheque(rs.getBigDecimal("importe_cheque"));
                chequePropio.setObservacionCheque(rs.getString("observacion_cheque"));
                chequePropio.setFechaCobroCheque(rs.getDate("fecha_cobro_cheque"));
                chequePropio.setTitularDestino(rs.getLong("titular_destino"));
                chequePropio.setIdCuentaSalida(rs.getLong("id_cuenta_salida"));
                

            } else {

                chequePropio = null;

            }

        } catch (SQLException ex) {

            chequePropio = null;

        } finally {
            try {

                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }

            } catch (SQLException ex) {
                chequePropio = null;
            }

        }

        return chequePropio;

    }
    
    
    
    public void ingresarChequePropio(ChequePropio chequePropio, Connection conn) throws SQLException {
        String sqlInsert = "INSERT INTO cheque_propio (nro_cheque, importe_cheque, fecha_cobro_cheque, titular_destino, observacion_cheque, id_cuenta_salida ) "
                + " VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sqlInsert);

            ps.setLong(1, chequePropio.getNumCheque());
            ps.setBigDecimal(2, chequePropio.getImporteCheque());
            if (chequePropio.getFechaCobroCheque() != null) {
                java.sql.Date sqlDate = new java.sql.Date(chequePropio.getFechaCobroCheque().getTime());
                ps.setDate(3, sqlDate);

            }

            ps.setString(5, chequePropio.getObservacionCheque());

            if (chequePropio.getTitularDestino() != null) {
                ps.setLong(4, chequePropio.getTitularDestino());

            }
            
            if (chequePropio.getIdCuentaSalida() != null){
                ps.setLong(6, chequePropio.getIdCuentaSalida());
            }
                
        } finally {
            if (ps != null) {
                ps.close();

            }
        }
    }    
    
}


