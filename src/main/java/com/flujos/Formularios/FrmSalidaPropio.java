/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.flujos.Formularios;

import com.flujos.Utilidades.Conexion;
import com.flujos.Utilidades.Utilidades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author monse
 */
public class FrmSalidaPropio extends javax.swing.JFrame {

        private Conexion con;
        private DefaultTableModel modelTblSalidasChequePropio;
    
    /**
     * Creates new form FrmSalidaPropio
     */
    public FrmSalidaPropio() {
        initComponents();
        crearModeloTabla();
        inicializar();
    }
    
    private void crearModeloTabla (){   
        modelTblSalidasChequePropio = (new DefaultTableModel (){
        
        @Override
        public boolean isCellEditable (int rowIndex, int colIndex ){
            return false;
        }
    });
 }

    private void limpiarTabla () {
        for (int i = 0; i < TblSalidasChequePropio.getRowCount (); i++){
            modelTblSalidasChequePropio.removeRow (i);
            i-= 1;
        }
 }

    
    private void inicializar (){
        con = new Conexion();
        TblSalidasChequePropio.setModel(modelTblSalidasChequePropio);
        TblSalidasChequePropio.getTableHeader().setReorderingAllowed(false);
        cargarDatos(con.getConexion());
        TxtIdChequePropio.setText("");
        TxtIdChequePropio.setVisible(false);
    }
    
    private void cargarDatos (Connection con){
        modelTblSalidasChequePropio.setRowCount(0);
        modelTblSalidasChequePropio.setColumnCount(0);
        
String query = """
            SELECT
                ch.nro_cheque AS Cheque,
                ch.importe_cheque AS Importe,
                ch.fecha_cobro_cheque AS Fecha,
                ch.observacion_cheque AS Observacion,
                ti.nom_razon_social AS Destino,
                cu.nom_concepto AS Cuenta,
                ch.id_cheque AS ID
                FROM cheque_propio ch
                JOIN cliente_proveedores ti ON
                ti.id_cliente_proveedor = ch.titular_destino
                JOIN cuentas cu ON ch.id_cuenta_salida = cu.id_cuenta 
                WHERE ch.estado_cheque = 0
                ORDER BY ch.nro_cheque DESC;               
               """;

    try (
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query)) {

        ResultSetMetaData meta = rs.getMetaData();
    int columnas = meta.getColumnCount();

        // Configurar nombres de columnas
    for (int i = 1; i <= columnas; i++) {
        modelTblSalidasChequePropio.addColumn(meta.getColumnLabel(i));
    }

        // Cargar filas
    while (rs.next()) {
        Object[] fila = new Object[columnas];
        
    for (int i = 0; i < columnas; i++) {
        fila[i] = rs.getObject(i + 1);
    }
        modelTblSalidasChequePropio.addRow(fila);
    }

    }catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,
            "Error al cargar datos:\n, ingrese nuevamente");
        this.dispose();

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


    private DatosCheque obtenerDatosCheque(Connection cn, int idCheque) throws SQLException {

        String q = """
            SELECT id_cuenta_salida, importe_cheque
            FROM cheque_propio
            WHERE id_cheque = ?
        """;

        try (PreparedStatement ps = cn.prepareStatement(q)) {

            ps.setInt(1, idCheque);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new DatosCheque(
                        rs.getLong("id_cuenta_salida"),
                        rs.getDouble("importe_cheque")
                    );
                } else {
                    throw new SQLException("No se encontró el cheque con ID=" + idCheque);
                }
            }
        }
    }

    class DatosCheque {
        long idCuenta;
        double importe;
        DatosCheque(long idCuenta, double importe) {
            this.idCuenta = idCuenta;
            this.importe = importe;
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TblSalidasChequePropio = new javax.swing.JTable();
        BtnSalir = new javax.swing.JButton();
        BtnConfimar = new javax.swing.JButton();
        TxtIdChequePropio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SALIDA DE CHEQUE PROPIO");

        TblSalidasChequePropio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblSalidasChequePropio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblSalidasChequePropioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TblSalidasChequePropio);

        BtnSalir.setText("SALIR");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        BtnConfimar.setText("Confirmar");
        BtnConfimar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfimarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(TxtIdChequePropio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnConfimar)
                        .addGap(234, 234, 234)
                        .addComponent(BtnSalir)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSalir)
                    .addComponent(BtnConfimar)
                    .addComponent(TxtIdChequePropio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
    try {
          con.cerrarConexion();
          
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al salir de la ventana, intente de nuevo.");
        this.dispose();
        
    }    
    this.dispose(); 
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void TblSalidasChequePropioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblSalidasChequePropioMousePressed
    
        TxtIdChequePropio.setText(" ");
        seleccionarResultado();          
            
    }//GEN-LAST:event_TblSalidasChequePropioMousePressed

    private void BtnConfimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfimarActionPerformed

        if (TxtIdChequePropio.getText().equals("")) {
        Utilidades.msg(null, "OCURRIO UN ERROR! Seleccione nuevamente el cheque a confirmar");
        TxtIdChequePropio.requestFocus();
        return;
        }

            try {
                confirmarSalida();
            } catch (SQLException ex) {
                Logger.getLogger(FrmSalidaPropio.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_BtnConfimarActionPerformed

     private void seleccionarResultado() {
        
        if (TblSalidasChequePropio.getSelectedRow() != -1) {
            TxtIdChequePropio.setText(TblSalidasChequePropio.getValueAt(TblSalidasChequePropio.getSelectedRow(), 6).toString());
        }
        
       
        
        
       //DTOSalidaCheque = new dtoSalidaCheque
    }
     
    private void confirmarSalida() throws SQLException {

    Connection cn = con.getConexion();

    String updateQuery = """
        UPDATE cheque_propio
        SET fecha_entrega_cheque = CURRENT_DATE, estado_cheque = 1
        WHERE id_cheque = ?
    """;

    String insertQuery = """
        INSERT INTO flujos_mov (fecha_mov, id_movimiento, id_cuenta, importe, observaciones_mov, id_cheque)
        VALUES (CURRENT_DATE, ?, ?, ?, ?, ?)
    """;

    try {
        cn.setAutoCommit(false);

        int idCheque = Integer.parseInt(TxtIdChequePropio.getText().trim());

        // ----------------------------------------
        // 1) UPDATE del cheque
        // ----------------------------------------
        try (PreparedStatement ps = cn.prepareStatement(updateQuery)) {
            ps.setInt(1, idCheque);
            int actualizado = ps.executeUpdate();

            if (actualizado <= 0) {
                Utilidades.msg(null, "ERROR AL ACTUALIZAR CHEQUE.");
                cn.rollback();
                return;
            }
        }

        // ----------------------------------------
        // 2) Obtener datos del cheque (ID cuenta + importe)
        // ----------------------------------------
        DatosCheque datos = obtenerDatosCheque(cn, idCheque);

        long idCuenta = datos.idCuenta;
        double importe = datos.importe;

        // ----------------------------------------
        // 3) Obtener id_movimiento según tu consulta
        // ----------------------------------------
        long idMovimiento = obtenerIdMovimiento(cn, idCuenta);

        // ----------------------------------------
        // 4) INSERT en flujos_mov
        // ----------------------------------------
        try (PreparedStatement ps = cn.prepareStatement(insertQuery)) {

            ps.setLong(1, idMovimiento);
            ps.setLong(2, idCuenta);
            ps.setDouble(3, importe * (-1));
            ps.setString(4, "Salida de cheque propio");
            ps.setLong(5, idCheque);

            ps.executeUpdate();
        }

        cn.commit();

        Utilidades.msg(null, "Salida registrada y movimiento creado correctamente.");
        cargarDatos(con.getConexion());

    } catch (Exception e) {
        cn.rollback();
        throw e;
    } finally {
        cn.setAutoCommit(true);
    }
}
   
     
    
     
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
            java.util.logging.Logger.getLogger(FrmSalidaPropio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSalidaPropio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSalidaPropio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSalidaPropio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSalidaPropio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConfimar;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JTable TblSalidasChequePropio;
    private javax.swing.JTextField TxtIdChequePropio;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
