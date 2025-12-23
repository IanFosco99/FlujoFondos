/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.flujos.Formularios;

import com.flujos.DAOs.DAOCheque;
import com.flujos.DAOs.DAOChequeTercero;
import com.flujos.DAOs.DAOCuenta;
import com.flujos.Entidades.ClienteProveedor;
import com.flujos.Entidades.Cuenta;
import com.flujos.Utilidades.Conexion;
import com.flujos.Utilidades.Utilidades;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author monse
 */
public class FrmConfirmacionSalidaChequeTercero extends javax.swing.JFrame {

    private Conexion con;
    DefaultComboBoxModel<String> modeloCuentaSalida = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> modeloTitularDestino = new DefaultComboBoxModel<>();

    private DAOCheque daoCheque;
    private DAOChequeTercero daoChequeTercero;
    private DAOCuenta daoCuenta;
    private String fecha_mov;
    private int id_movimiento;
    private int id_cuenta;
    private double importe;
    private String observaciones_mov;
    private int id_cheque_tercero;
    private int id_cheque;

    /**
     * Creates new form FrmConfirmacionSalidaChequeTercero
     */
    public FrmConfirmacionSalidaChequeTercero() {
        initComponents();
        comboCuentaSalida.setModel(modeloCuentaSalida);
        comboTitularDestino.setModel(modeloTitularDestino);
        inicializar();
    }

    private void inicializar() {
        try {
            con = new Conexion();

            con = new Conexion();
            daoCheque = new DAOCheque();
            daoCuenta = new DAOCuenta();
            daoChequeTercero = new DAOChequeTercero();

            TxtIdChequeTercero.setVisible(false);
            TxtIdCuenta.setVisible(false);
            TxtIdTitular.setVisible(false);

            daoCheque.llenarComboClienteProveedorDestino(modeloTitularDestino, con.getConexion());
            daoCuenta.llenarComboCuenta(modeloCuentaSalida, con.getConexion());
            comboCuentaSalida.setSelectedIndex(0);
            comboTitularDestino.setSelectedIndex(0);

            btnConfirmar.setEnabled(true);
            btnSalir.setEnabled(true);

            if (TxtIdChequeTercero.getText().trim().isEmpty()) {
                return;
            }

            long idCheque = Long.parseLong(TxtIdChequeTercero.getText());
            
            txtImporteCheque.setEditable(false);
            txtNroCheque.setEditable(false);
            txtObservacionCheque.setEditable(false);

            try {
                DatosCheque datosCheque = obtenerDatosCheque(con.getConexion(), idCheque);

                if (datosCheque != null) {
                    txtNroCheque.setText(String.valueOf(datosCheque.nro_Cheque));
                    txtImporteCheque.setText(String.valueOf(datosCheque.importe));
                    txtObservacionCheque.setText(datosCheque.observacion);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar datos del cheque");
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrmConfirmacionSalidaChequeTercero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private long obtenerIdMovimiento(Connection cn, long idCuentaSalida) throws SQLException {

        String q = """
            SELECT movimiento.id_movimiento
            FROM movimiento 
            JOIN cuentas ON cuentas.id_movimiento = movimiento.id_movimiento
            WHERE cuentas.id_cuenta = ?
        """;

        try (PreparedStatement ps = cn.prepareStatement(q)) {

            ps.setLong(1, idCuentaSalida);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong(1);
                } else {
                    throw new SQLException("No se encontró id_movimiento para la cuenta " + idCuentaSalida);
                }
            }
        }
    }

    private DatosCheque obtenerDatosCheque(Connection con, Long idCheque) throws SQLException {

        System.out.println(">>> obtenerDatosCheque idCheque = " + idCheque);

        String q = """
            SELECT id_cuenta_entrada, nro_cheque,importe_cheque, observacion_cheque
            FROM cheque_tercero
            WHERE id_cheque = ?
    """;

        try (PreparedStatement ps = con.prepareStatement(q)) {
            ps.setLong(1, idCheque);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new DatosCheque(
                            rs.getLong("id_cuenta_entrada"),
                            rs.getLong("nro_cheque"),
                            rs.getBigDecimal("importe_cheque"),
                            rs.getString("observacion_cheque")
                    );
                } else {
                    throw new SQLException("No se encontró el cheque con ID=" + idCheque);
                }
            }
        }
    }

    class DatosCheque {

        long idCuenta;
        long nro_Cheque;
        BigDecimal importe;
        String observacion;

        DatosCheque(long idCuenta, long nro_cheque, BigDecimal importe, String observacion) {
            this.idCuenta = idCuenta;
            this.nro_Cheque = nro_cheque;
            this.importe = importe;
            this.observacion = observacion;
        }

        public String getObservacion() {
            return observacion;
        }
    }

    public FrmConfirmacionSalidaChequeTercero(String id) {
        initComponents();
        comboCuentaSalida.setModel(modeloCuentaSalida);
        comboTitularDestino.setModel(modeloTitularDestino);
        // Seteás el ID en el txtId DESTINO
        TxtIdChequeTercero.setText(id);
        inicializar();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TxtIdChequeTercero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboCuentaSalida = new javax.swing.JComboBox<>();
        TxtIdCuenta = new javax.swing.JTextField();
        TxtIdTitular = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboTitularDestino = new javax.swing.JComboBox<>();
        btnConfirmar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtNroCheque = new javax.swing.JTextField();
        txtImporteCheque = new javax.swing.JTextField();
        txtObservacionCheque = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONFIRMACION SALIDA CHEQUE TERCCEROS");

        jLabel1.setText("Cuenta Salida:");

        comboCuentaSalida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCuentaSalidaItemStateChanged(evt);
            }
        });

        jLabel2.setText("Titular Destino:");

        comboTitularDestino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTitularDestinoItemStateChanged(evt);
            }
        });

        btnConfirmar.setText("CONFIRMAR");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero de cheque:");

        jLabel4.setText("Importe de cheque:");

        jLabel5.setText("Observacion de cheque:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(171, 171, 171)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(TxtIdChequeTercero, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(1, 1, 1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboCuentaSalida, 0, 173, Short.MAX_VALUE)
                                    .addComponent(txtImporteCheque, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboTitularDestino, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtObservacionCheque, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNroCheque, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(114, 114, 114)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtIdTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(TxtIdCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImporteCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObservacionCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCuentaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtIdChequeTercero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtIdTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTitularDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnSalir))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCuentaSalidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCuentaSalidaItemStateChanged

        TxtIdCuenta.setText("");
        try {
            String cuentaSalida = comboCuentaSalida.getSelectedItem() != null ? comboCuentaSalida.getSelectedItem().toString() : null;
            if (cuentaSalida == null || cuentaSalida.equals("--")) {
                TxtIdCuenta.setText("");
            } else {
                Cuenta cuentaEntradaSeleccionado = daoCuenta.obtenerDatos(cuentaSalida, con.getConexion());
                if (cuentaEntradaSeleccionado != null) {
                    TxtIdCuenta.setText(String.valueOf(cuentaEntradaSeleccionado.getIdCuenta()));
                } else {
                    TxtIdCuenta.setText("");
                }
            }

        } catch (Exception e) {
            Utilidades.msg(null, "Se produjo un error en la seleccion del combo cuenta salida, ingrese nuevamente");
            this.dispose();
        }

    }//GEN-LAST:event_comboCuentaSalidaItemStateChanged

    private void comboTitularDestinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTitularDestinoItemStateChanged

        TxtIdTitular.setText("");
        try {
            String clienteProveedor = comboTitularDestino.getSelectedItem() != null ? comboTitularDestino.getSelectedItem().toString() : null;
            if (clienteProveedor == null || clienteProveedor.equals("--")) {
                TxtIdTitular.setText("");
            } else {
                ClienteProveedor clienteProveedorSeleccionado = daoCheque.obtenerDatosClienteProveedor(clienteProveedor, con.getConexion());
                if (clienteProveedorSeleccionado != null) {
                    TxtIdTitular.setText(String.valueOf(clienteProveedorSeleccionado.getIdClienteProveedor()));
                } else {
                    TxtIdTitular.setText("");
                }
            }

        } catch (Exception e) {
            Utilidades.msg(null, "Se produjo un error en la seleccion del combo Titular Destino Cheque, ingrese nuevamente");
            this.dispose();
        }

    }//GEN-LAST:event_comboTitularDestinoItemStateChanged

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        try {
            con.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al salir de la ventana, intente de nuevo.");
            this.dispose();
        }

        this.dispose();

    }//GEN-LAST:event_btnSalirActionPerformed


    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (TxtIdChequeTercero.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cheque.");
            return;
        }

// PARSEAMOS UNA VEZ
        long idCheque;
        try {
            idCheque = Long.parseLong(TxtIdChequeTercero.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
            return;
        }

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();

            // -------- UPDATE --------
            String sql = """
                 UPDATE cheque_tercero
                 SET 
                     fecha_entrega_cheque = CURDATE(),
                     id_cuenta_salida = ?,
                     titular_destino = ?,
                     estado_cheque = 1
                 WHERE id_cheque = ?
                 """;

            PreparedStatement ps = con.prepareStatement(sql);

            long idCuentaSalida = Long.parseLong(TxtIdCuenta.getText());
            long idTitular = Long.parseLong(TxtIdTitular.getText());

            ps.setLong(1, idCuentaSalida);
            ps.setLong(2, idTitular);
            ps.setLong(3, idCheque);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                // ----------- OBTENER DATOS DEL CHEQUE -----------
                DatosCheque datos = obtenerDatosCheque(con, idCheque);

                long idCuentaEntrada = datos.idCuenta;
                BigDecimal importe = datos.importe;
                String observacion = datos.observacion;

                long idMovimiento = obtenerIdMovimiento(con, idCuentaSalida);

                // -------- INSERT (ENTRADA) --------
                String insertQuery = """
                             INSERT INTO flujos_mov 
                             (fecha_mov, id_movimiento, id_cuenta, importe, observaciones_mov, id_cheque, id_cheque_tercero)
                             VALUES (CURRENT_DATE, ?, ?, ?, ?, ?, ?)
                             """;

                PreparedStatement psInsert = con.prepareStatement(insertQuery);
                psInsert.setLong(1, idMovimiento);
                psInsert.setLong(2, idCuentaEntrada);
                psInsert.setBigDecimal(3, importe);
                psInsert.setString(4, observacion);
                psInsert.setLong(5, 0);
                psInsert.setLong(6, idCheque);
                psInsert.executeUpdate();

                // -------- INSERT EN NEGATIVO (SALIDA) --------
                PreparedStatement psInsertNegative = con.prepareStatement(insertQuery);
                psInsertNegative.setLong(1, idMovimiento);
                psInsertNegative.setLong(2, idCuentaSalida);
                psInsertNegative.setBigDecimal(3, importe.multiply(new BigDecimal(-1)));
                psInsertNegative.setString(4, observacion);
                psInsertNegative.setLong(5, 0);
                psInsertNegative.setLong(6, idCheque);
                psInsertNegative.executeUpdate();

                JOptionPane.showMessageDialog(this, "Cheque confirmado correctamente.");
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "No se pudo confirmar (ya enviado o ID inválido).");

                // También cerramos todo en caso de error para refrescar el flujo
                if (this.getOwner() != null) {
                    this.getOwner().dispose();
                }
                this.dispose();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmConfirmacionSalidaChequeTercero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConfirmacionSalidaChequeTercero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConfirmacionSalidaChequeTercero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConfirmacionSalidaChequeTercero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmConfirmacionSalidaChequeTercero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtIdChequeTercero;
    private javax.swing.JTextField TxtIdCuenta;
    private javax.swing.JTextField TxtIdTitular;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboCuentaSalida;
    private javax.swing.JComboBox<String> comboTitularDestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtImporteCheque;
    private javax.swing.JTextField txtNroCheque;
    private javax.swing.JTextField txtObservacionCheque;
    // End of variables declaration//GEN-END:variables
}
