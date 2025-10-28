/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.DAOs;

import com.flujos.Entidades.Cheque;
import com.flujos.Entidades.ChequePropio;
import java.sql.Connection;
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
    
    
}


