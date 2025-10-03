/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.Utilidades;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Ian
 */
public class Utilidades {

    public static void msg(JButton boton, String cadena) {
        JOptionPane.showMessageDialog(boton, cadena);
    }

    public static boolean existe(Connection conn, String consulta) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    public static boolean isNunInt(String cadena){
        try{
            Integer.valueOf(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
    
    public static boolean isValidBigDecimal(String cadena) {
    try {
        new BigDecimal(cadena);  // Trata de convertir la cadena a BigDecimal
        return true;
    } catch (NumberFormatException nfe) {
        return false;  // Si ocurre una excepción, la cadena no es válida
    }
}

}
