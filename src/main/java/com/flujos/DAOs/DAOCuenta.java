/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.DAOs;

import com.flujos.Entidades.Cuenta;
import com.flujos.Entidades.Movimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Ian
 */
public class DAOCuenta {

    public void actualizar(Cuenta cuenta, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void eliminar(Long valueOf, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Cuenta obtenerDatos(String dato, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void llenarComboCuenta(DefaultComboBoxModel<String> modeloComboMovimiento, Connection con) throws SQLException {
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

    public void ingresarCuenta(Cuenta cuenta, Connection con) throws SQLException {
        String sqlInsert = "INSERT INTO cuentas (cod_concepto,nom_concepto,clas_concepto,id_movimiento,ingreso) "
                + "VALUES (?,?,?,?,?)";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, cuenta.getCodConcepto());
            ps.setString(2, cuenta.getNombreConcepto());
            ps.setString(3, cuenta.getClaseConcepto());
            ps.setLong(4, cuenta.getIdMovimiento());
            ps.setString(5, cuenta.getIngreso());
            ps.executeUpdate();

        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    public Movimiento obtenerDatosMovimieto(String movimiento, Connection con) {
        Movimiento mov = new Movimiento();
        String consulta = "SELECT id_movimiento FROM movimiento WHERE desc_movimiento = '" + movimiento + "'";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs.next()) {
                mov.setIdMovimiento(rs.getLong("id_movimiento"));
            } else {
                mov = null;
            }
        } catch (Exception e) {
            mov = null;
        } finally {
            try {

                if (rs != null) {
                    rs.close();
                }
                if (st != null) {

                    st.close();
                }
            } catch (SQLException ex) {
                mov = null;
            }
        }
        return mov;

    }


    public String obtenerCuenta(Long idCuenta, Connection con) {
            String conceptoCuenta = null;
            String consulta = "SELECT nom_concepto FROM cuentas WHERE id_cuenta = " + idCuenta + "";
            Statement st = null;
            ResultSet rs = null;
            try {
                st = con.createStatement();
                rs = st.executeQuery(consulta);
                if (rs.next()) {
                    conceptoCuenta = rs.getString("nom_concepto");
                }
            } catch (SQLException e) {
                conceptoCuenta = null;
            } finally {
                try {

                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {

                        st.close();
                    }
                } catch (SQLException ex) {
                    conceptoCuenta = null;
                }
            }
            return conceptoCuenta;

        }
    
    
        public void llenarComboCuentaSalida(DefaultComboBoxModel<String> modeloCuentaSalida, Connection con) throws SQLException {
        String consulta = "SELECT nom_concepto FROM cuenta";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(consulta);

            modeloCuentaSalida.removeAllElements();
            modeloCuentaSalida.addElement("--");

            while (rs.next()) {
                String cuenta = rs.getString("nom_concepto");
                modeloCuentaSalida.addElement(cuenta);

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
    
    
    
}

