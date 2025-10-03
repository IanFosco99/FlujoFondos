/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ian
 */
public class Conexion {
    
    private Connection conn;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String db = "jdbc:mysql://localhost/flujo_fondos";
            conn = DriverManager.getConnection(db,"root","");
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la Base de Datos, intente nuevamente");
            System.exit(0);
            
        }
        
    }
    
    public Connection getConexion(){
        return conn;
        
    }
    
    public Connection cerrarConexion() throws SQLException{
        conn.close();
        conn = null;
        return conn;       
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
