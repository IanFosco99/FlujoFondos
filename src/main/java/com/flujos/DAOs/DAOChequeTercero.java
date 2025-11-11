package com.flujos.DAOs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.flujos.Entidades.ChequeTerceros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author monse
 */

public class DAOChequeTercero {

    //INSERTAR CHEQUE DE TERCERO
    public void agregarChequeTercero(ChequeTerceros chequeTerceros, Connection conn) throws SQLException {

        String sqlInsert = "INSERT INTO cheque_tercero (nro_cheque, importe_cheque, fecha_cobro_cheque, titular_cheque, observacion_cheque, id_cuenta_entrada ) "
                + " VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sqlInsert);
            ps.setLong(1, chequeTerceros.getNroCheque());
            ps.setBigDecimal(2, chequeTerceros.getImporteCheque());

            if (chequeTerceros.getFechaCobroCheque() != null) {
                java.sql.Date sqlDate = new java.sql.Date(chequeTerceros.getFechaCobroCheque().getTime());
                ps.setDate(3, sqlDate);

            }

            if (chequeTerceros.getTitularCheque()!= null) {
                ps.setLong(4, chequeTerceros.getTitularCheque());
            }
            
            ps.setString(5, chequeTerceros.getObservacionCheque());
            
            if (chequeTerceros.getIdCuentaEntrada()!= null){
                ps.setLong(6, chequeTerceros.getIdCuentaEntrada());
            }
                
            ps.executeUpdate();

            
        } finally {
            if (ps != null) {
                ps.close();

            }
        }
    }

    //MODIFICAR 
    public void modificarChequeTercero(ChequeTerceros chequeTerceros, Connection con) throws SQLException {
        String sql = "UPDATE cheque_tercero SET  titular_cheque = ?, importe_cheque = ?, fecha_cobro_cheque = ?, observacion_cheque, nro_cheque = ?, id_cuenta_entrada WHERE id_cheque = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, chequeTerceros.getTitularCheque());
            ps.setBigDecimal(2, chequeTerceros.getImporteCheque());
            ps.setDate(3, new java.sql.Date(chequeTerceros.getFechaCobroCheque().getTime()));
            ps.setString(4, chequeTerceros.getObservacionCheque());
            ps.setLong(5, chequeTerceros.getNroCheque());
            ps.setLong(6, chequeTerceros.getIdCuentaEntrada());
            ps.setLong(7, chequeTerceros.getIdCheque());

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

    public boolean existeCheque(long numero, Connection con) throws SQLException {

        String sql = "SELECT 1 FROM cheque_tercero WHERE nro_cheque = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, numero);
            ResultSet rs = ps.executeQuery();
            boolean existe = rs.next();
            rs.close();
            return existe;
        }
    }

    public ChequeTerceros obtenerDatos(Long nroCheque, Connection con) {

        Statement st = null;
        ResultSet rs = null;
        ChequeTerceros chequeTerceros = new ChequeTerceros();

        try {
            String consulta = "SELECT * FROM cheque_tercero WHERE nro_cheque = " + nroCheque;

            st = con.createStatement();
            rs = st.executeQuery(consulta);

            if (rs.next()) {

                chequeTerceros = new ChequeTerceros();
                chequeTerceros.setNroCheque(rs.getLong("nro_cheque"));
                chequeTerceros.setTitularCheque(rs.getLong("id_titular"));
                chequeTerceros.setImporteCheque(rs.getBigDecimal("importe"));
                chequeTerceros.setFechaCobroCheque(rs.getDate("fecha_cobro"));
                chequeTerceros.setObservacionCheque(rs.getString("observacion"));
                chequeTerceros.setIdCuentaEntrada(rs.getLong("id_cuenta_entrada"));
                
            } else {
                chequeTerceros = null;
            }

        } catch (SQLException ex) {
            chequeTerceros = null;

        } finally {
            try {

                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }

            } catch (SQLException ex) {
                chequeTerceros = null;
            }
        }
        return chequeTerceros;
    }
}