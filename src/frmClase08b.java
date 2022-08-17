

import com.mysql.jdbc.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @
 */
public class frmClase08b extends javax.swing.JDialog {

    /**
     * Creates new form frmClase08b
     */
    
    clsFunciones  oFunc = new clsFunciones();
    clsConnection oConn = new clsConnection();
    
    public frmClase08b(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Centro la Forma   
        this.setLocationRelativeTo(null);        
        
        // deshabilita resize
        this.setResizable(false);
        
        //Ejecuta la Consulta
        sbConsultaExecute();
        
    }
    
    // Ejecuta la Consulta
    private void sbConsultaExecute()
    {       
        // Declaro una variable para las columnas
        int iColumnas=0;
        
        // Declaro un modelo de datos
        DefaultTableModel modelo = new DefaultTableModel();
        java.sql.ResultSetMetaData mdConsulta=null;
        Object [] oFila=null;
        
        // Ejecuto el Query definido en la variable
        if (oConn.FnBoolQueryExecute(clsConnection.sQuery))
        {
            // Captura el Error de Sql
            try 
            {
                // Prepara variable para obtener Meta Datos de la Consulta
                mdConsulta = oConn.setResult.getMetaData();
                
                // Obtiene el Numero de Columnas de la Consulta
                iColumnas = mdConsulta.getColumnCount();
                
                // Prepara los datos vacios iniciales
                oFila = new Object[iColumnas];
                                        
                // Ciclo para agregar las columnas                
                for ( int i = 1; i <= iColumnas; i++ ) 
                {
                    // Agrega la Columna al Modelo
                    modelo.addColumn(mdConsulta.getColumnLabel( i ));
                    //if ( i > 1 )
                    //    System.out.print( ", " );
                    //System.out.print( mdConsulta.getColumnLabel( i ) ); // Mostrar nombres de campos
                }
                
                // Coloca el Modelo en la Tabla
                tblConsulta.setModel(modelo);
        
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(frmClase08b.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try 
            {
                 // Obtener los datos de la consulta
                 DefaultTableModel tblDatos = (DefaultTableModel) tblConsulta.getModel();
                 
                // Verifica resultados
                while (oConn.setResult.next())
                {
                    // Ciclo para agregar las columnas                
                    for ( int i = 1; i <= iColumnas; i++ ) 
                    {
                        // Agrega la Columna al Modelo
                       oFila[i-1]=oConn.setResult.getString(i);                        
                    }
                    // Agrega los datos a la tabla
                    tblDatos.addRow(oFila);
                     
                }
                 
                  // Coloca el Modelo de Nueva Cuenta
                  tblConsulta.setModel(tblDatos);
                
             
                 // Cierra Resultados
                 oConn.setResult.close();
            } 
            catch (SQLException ex) 
            {
                //JOptionPane.showMessageDialorootPane,ex);
                oFunc.SubSistemaMensaje(ex.toString());
                Logger.getLogger(frmClase05.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    // Busca dato en la tabla
    private void sbProductoBuscaDato()
    {
        // Variables para Fila y Columns
        int fil, col;
        
        //boolean bEncontro=false;
        String sDato;
        
        // Para contar cuantos encontro
        int iEncontrados=0;
        
        // Pasa a mayúsculas
        sDato = txtBuscar.getText().toUpperCase();
        
        //Limpia selección de la tabla
        tblConsulta.clearSelection();

        for(fil = 0; fil < tblConsulta.getRowCount();fil++)
        {
            for(col = 0; col < tblConsulta.getColumnCount(); col++)
            {              
                 //Obtiene dato contenido en una celda de la tabla
                 String value = (String)tblConsulta.getValueAt(fil, col);
                 
                 // lo pasa a Mayúsculas
                 value = value.toUpperCase();
                                  
                 //if(value.equals(sDato))
                 if(value.lastIndexOf(sDato)>=0)
                 {     
                       //Selecciona celda si el texto es encontrado     
                       //tblProductos.changeSelection(col, col, bEncontro, bEncontro);
                       
                       tblConsulta.changeSelection(fil, col, true, false);
                       iEncontrados++;
                      
                 }
             }
           
        }
        
        // Coloca el número de incidencias encontradas
        lblEncontradosView.setText(String.valueOf(iEncontrados));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConsulta = new javax.swing.JPanel();
        lblTexto = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        lblEncontrados = new javax.swing.JLabel();
        lblEncontradosView = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTexto.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblTexto.setText("Texto:");

        txtBuscar.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblConsulta.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblConsulta);

        lblEncontrados.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblEncontrados.setText("Encontrados:");

        lblEncontradosView.setBackground(new java.awt.Color(255, 255, 255));
        lblEncontradosView.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblEncontradosView.setForeground(new java.awt.Color(51, 51, 255));
        lblEncontradosView.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEncontradosView.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnlConsultaLayout = new javax.swing.GroupLayout(pnlConsulta);
        pnlConsulta.setLayout(pnlConsultaLayout);
        pnlConsultaLayout.setHorizontalGroup(
            pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultaLayout.createSequentialGroup()
                        .addComponent(lblEncontrados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEncontradosView, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlConsultaLayout.createSequentialGroup()
                        .addComponent(lblTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        pnlConsultaLayout.setVerticalGroup(
            pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultaLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTexto)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEncontrados, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEncontradosView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnCancelar.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        // Valida que esté seleccionado  un dato
        if (tblConsulta.getSelectedRow()>=0)
        {
            // Variable para el modelo de la tabla
             DefaultTableModel tblDatos = (DefaultTableModel) tblConsulta.getModel();
            
            // Obtengo el Codigo de la celda
            clsGlobales.sConsultaDato = tblDatos.getValueAt(tblConsulta.getSelectedRow(),0).toString();
            
            // Libera la Forma
            this.dispose();
        }
        else
            oFunc.SubSistemaMensaje("Seleccione un Registro");
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        sbProductoBuscaDato();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:        
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmClase08b.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClase08b.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClase08b.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClase08b.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmClase08b dialog = new frmClase08b(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEncontrados;
    private javax.swing.JLabel lblEncontradosView;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JPanel pnlConsulta;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
