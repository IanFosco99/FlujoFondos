/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.DAOs;

import com.flujos.Entidades.FlujosMov;
import com.flujos.Entidades.Movimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;



/**
 *
 * @author Ian
 */
public class DAOFlujosMov {
    


public void llenarComboMovimiento(DefaultComboBoxModel<String> modeloComboMovimiento, Connection con) throws SQLException {
        String consulta = "SELECT desc_movimiento FROM movimiento";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(consulta);

            modeloComboMovimiento.removeAllElements();
            modeloComboMovimiento.addElement("--");

            while (rs.next()) {
                String movimiento = rs.getString("desc_movimiento");
                modeloComboMovimiento.addElement(movimiento);

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }
}

    public Movimiento obtenerDatosMovimieto(String movi, Connection con) {
        Movimiento movimiento = new Movimiento();
        String consulta = "SELECT id_movimiento FROM movimiento WHERE desc_movimiento = '" + movi + "'";
        Statement st = null;
        ResultSet rs = null;
    
        try {
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs.next()) {
                movimiento.setIdMovimiento(rs.getLong("id_movimiento"));
            } else {
                movimiento = null;
            }
        } catch (Exception e) {
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

    public void ingresarFlujomov(FlujosMov flujoMov, Connection con) throws SQLException {
        String sqlInsert = "INSERT INTO flujos_mov (fecha_mov,id_movimiento,id_cuenta,importe,observaciones_mov,id_cheque) "
                + "VALUES (?,?,?,?,?,?)";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlInsert);
            if (flujoMov.getFechaMovimiento()!= null) {
                java.sql.Date sqlDate = new java.sql.Date(flujoMov.getFechaMovimiento().getTime());
                ps.setDate(1, sqlDate);

            } else {
                ps.setNull(1, java.sql.Types.DATE);

            }            
            
            
            ps.setLong(2, flujoMov.getIdMovimiento());
            ps.setLong(3, flujoMov.getIdCuenta());
            ps.setBigDecimal(4, flujoMov.getImporte());
            ps.setString(5, flujoMov.getObservacionesMovimiento());
            if (flujoMov.getIdCheque() != null){
                ps.setLong(6, flujoMov.getIdCheque());
            }else{
                ps.setLong(6,0);
            }
            
            ps.executeUpdate();

        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    public void eliminarFlujoMov(Long idFlujoMov, Connection con) throws SQLException {
        
        String consultaElim = " DELETE FROM flujos_mov WHERE id_flujo_mov = ? ";

        PreparedStatement psElim = null;
        
        try {
            
            psElim = con.prepareStatement(consultaElim);
            
            psElim.setLong(1, idFlujoMov);
                        
            psElim.executeUpdate();
            
        } finally {
            
            if (psElim != null) {
               
                psElim.close();
               
            }
            
        }
        
    }
    
}