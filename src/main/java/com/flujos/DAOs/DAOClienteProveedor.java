/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.DAOs;

import com.flujos.Entidades.ClienteProveedor;
import com.flujos.Utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ian
 */
public class DAOClienteProveedor {

    public void ingresarClienteProveedor(ClienteProveedor cliente, Connection conn) throws SQLException {
        String sqlInsert = "INSERT INTO cliente_proveedores (nom_razon_social, dni_cuit, telefono, email, "
                + "tipo_cliente_proveedor) VALUES (?, ?, ?, ?, ?) ";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sqlInsert);
            ps.setString(1, cliente.getNomRazonSocial());
            ps.setInt(2, cliente.getDniCuit());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getTipoClienteProveedor());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();

            }
        }
    }

    
    
    
    public ClienteProveedor obtenerDatos(Integer dniCuitCuil, Connection con) {

        Statement st = null;
        ResultSet rs = null;
        ClienteProveedor clienteProveedor = new ClienteProveedor();

        try {
            String consulta = "SELECT * FROM cliente_proveedores WHERE dni_cuit = " + dniCuitCuil;

            st = con.createStatement();
            rs = st.executeQuery(consulta);

            if (rs.next()) {

                clienteProveedor.setDniCuit(rs.getInt("dni_cuit"));
                clienteProveedor.setNomRazonSocial(rs.getString("Nom_razon_social"));
                clienteProveedor.setTelefono(rs.getString("telefono"));
                clienteProveedor.setEmail(rs.getString("email"));
                clienteProveedor.setTipoClienteProveedor(rs.getString("tipo_cliente_proveedor"));
                clienteProveedor.setIdClienteProveedor(rs.getLong("id_cliente_proveedor"));
            } else {

                clienteProveedor = null;

            }

        } catch (SQLException ex) {

            clienteProveedor = null;

        } finally {
            try {

                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }

            } catch (SQLException ex) {
                clienteProveedor = null;
            }

        }

        return clienteProveedor;

    }
    
    
    

    public void actualizar(ClienteProveedor clienteProveedor, Connection con) throws SQLException {
        
        PreparedStatement ps = null;

        try {
            String sqlUpdate = "UPDATE cliente_proveedores SET "
                    + "nom_razon_social = ?, "
                    + "dni_cuit = ?, "
                    + "telefono = ?, "
                    + "email = ?, "
                    + "tipo_cliente_proveedor = ? "
                    + "WHERE id_cliente_proveedor = ?";

            ps = con.prepareStatement(sqlUpdate);
            ps.setString(1, clienteProveedor.getNomRazonSocial());
            ps.setInt(2, clienteProveedor.getDniCuit());
            ps.setString(3, clienteProveedor.getTelefono());
            ps.setString(4, clienteProveedor.getEmail());
            ps.setString(5, clienteProveedor.getTipoClienteProveedor());
            ps.setLong(6, clienteProveedor.getIdClienteProveedor());
            ps.executeUpdate();
        } finally{
        
            if(ps != null){
                ps.close();
            }
            
        }

    }
    
    
    
    public void eliminar(Long id, Connection con) throws SQLException{
    
        String sqlEliminar = "DELETE FROM cliente_proveedores WHERE id_cliente_proveedor = ?";
        
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlEliminar);
            ps.setLong(1, id);
            ps.executeUpdate();
        } finally{
            if(ps != null){
                ps.close();
            }
        }
    
    }

}
