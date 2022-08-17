
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/*

 */
public class frmClase05 extends javax.swing.JDialog {

    // Declaro variable de Conexion
    clsConnection oConn = new clsConnection();
    
    // Declaro variable 
    String strCveActual;
    
    /** Creates new form frmClase05 */
    public frmClase05(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        // Centra la Forma
        this.setLocationRelativeTo(null);
        
            
        // Carga el ListBox con los procesos
        SubProcesosCarga();
        
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProcesos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProcesos = new javax.swing.JList();
        txtNom = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        butGrabar = new javax.swing.JButton();
        txtIde = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema-Procesos");

        pnlProcesos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Procesos del Sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12))); // NOI18N
        pnlProcesos.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        pnlProcesos.setName("pnlProcesos"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        lstProcesos.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lstProcesos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstProcesos.setName("lstProcesos"); // NOI18N
        lstProcesos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstProcesosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lstProcesosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(lstProcesos);

        txtNom.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtNom.setName("txtNom"); // NOI18N
        txtNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomKeyPressed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setName("btnAgregar"); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        butGrabar.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        butGrabar.setText("Grabar");
        butGrabar.setName("butGrabar"); // NOI18N
        butGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butGrabarActionPerformed(evt);
            }
        });

        txtIde.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtIde.setName("txtIde"); // NOI18N
        txtIde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdeKeyPressed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setName("btnLimpiar"); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProcesosLayout = new javax.swing.GroupLayout(pnlProcesos);
        pnlProcesos.setLayout(pnlProcesosLayout);
        pnlProcesosLayout.setHorizontalGroup(
            pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProcesosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addGroup(pnlProcesosLayout.createSequentialGroup()
                        .addGroup(pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIde, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(butGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlProcesosLayout.createSequentialGroup()
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                .addComponent(btnAgregar))
                            .addComponent(txtNom, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlProcesosLayout.setVerticalGroup(
            pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProcesosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(butGrabar)
                    .addComponent(btnLimpiar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnlProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlProcesos.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lstProcesosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstProcesosMouseClicked
// TODO add your handling code here:
    
    // Variable para obtener el indice seleccionado
    int iSeleccionado;
    
    // Obtiene el Elemento Seleccionado
    iSeleccionado=lstProcesos.getSelectedIndex();
    
    // Verifica si realmente seleccionó
    if (iSeleccionado>=0)
    {
        // Coloca el dato seleccionado en los text box
        txtIde.setText(lstProcesos.getSelectedValue().toString().substring(0,10));
        txtNom.setText(lstProcesos.getSelectedValue().toString().substring(11));
        
        // Guarda Clave Actual
        strCveActual=txtIde.getText();
    }
}//GEN-LAST:event_lstProcesosMouseClicked

private void lstProcesosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstProcesosMousePressed
// TODO add your handling code here:
    
    // Declaro variable para obtener el seleccionado
    int iSeleccionado;
    String strIde;
    String strNom;
    String strSqlStmt;
    
    // Pregunto en el Parametro
    if (evt.getClickCount()==2)
    {
         
         // Obtiene el Elemento Seleccionado
         iSeleccionado=lstProcesos.getSelectedIndex();
         if (iSeleccionado>=0)
         {
            // Coloca el dato seleccionado en los text box
            strIde=lstProcesos.getSelectedValue().toString().substring(0,10);
            strNom=lstProcesos.getSelectedValue().toString().substring(11);

            // Prepara el Query para elimianr
            strSqlStmt =  " Delete From 02tblProcesos ";
            strSqlStmt += " Where strProcesoIde='"+strIde+"' ";
            strSqlStmt += " And   strProcesoNom='"+strNom+"' ";
            
            
            // Ejecuta el Update
            oConn.FnBoolQueryExecuteUpdate(strSqlStmt);
            
            //Carga los Procesos
            SubProcesosCarga();
            
         }
         
    }
}//GEN-LAST:event_lstProcesosMousePressed

private void txtIdeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdeKeyPressed
// TODO add your handling code here:
    // Valido la Longitud a 10
    if (txtIde.getText().length()>9)
    {
        // Lo consume
        evt.consume();
        
        // Reestringe a 10
        txtIde.setText(txtIde.getText().substring(0, 9));
    }
    
}//GEN-LAST:event_txtIdeKeyPressed

private void txtNomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomKeyPressed
// TODO add your handling code here:
    if (txtNom.getText().length()>29)
    {
        // Lo consume
        evt.consume();
        
        // Reestringe a 10
        txtNom.setText(txtNom.getText().substring(0, 29));
    }
}//GEN-LAST:event_txtNomKeyPressed

private void butGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butGrabarActionPerformed

    // TODO add your handling code here:
    String strSqlStmt;
    
    
    // Valida los datos correctos
    if (FnBoolValidaDatos())
    {
        // Prepara el Query
        strSqlStmt  = " Update 02tblProcesos ";
        strSqlStmt += " Set strProcesoIde='"+txtIde.getText()+"', ";
        strSqlStmt += "     strProcesoNom='"+txtNom.getText()+"' ";
        strSqlStmt += " Where strProcesoIde='"+strCveActual+"' ";

        // Ejecuta el Query
        oConn.FnBoolQueryExecuteUpdate(strSqlStmt);

        // Carga los Procesos de Nueva Cuenta
        SubProcesosCarga();
    
    }
}//GEN-LAST:event_butGrabarActionPerformed

private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
// TODO add your handling code here:
    txtIde.setText("");
    txtNom.setText("");
}//GEN-LAST:event_btnLimpiarActionPerformed

private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

    // TODO add your handling code here:
    String strSqlStmt;
    
    if (FnBoolValidaDatos())
    {
        // Prepara el Query
        strSqlStmt  = " Insert into 02tblProcesos (strProcesoIde,strProcesoNom) ";
        strSqlStmt += " Values ('"+txtIde.getText()+"','"+txtNom.getText()+"')";

        // Ejecuta el Query
        oConn.FnBoolQueryExecuteUpdate(strSqlStmt);

        // Carga los Procesos de Nueva Cuenta
        SubProcesosCarga();
    }
    
}//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(frmClase05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClase05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClase05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClase05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmClase05 dialog = new frmClase05(new javax.swing.JFrame(), true);
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
   
    // Carga los Procesos existentes a la lista
    private void SubProcesosCarga()
    {
        // Para instrucción sql
        String sqlStmt;
        String sIdeProceso;
        String sNomProceso;
        
        // Variable para agregar elementos a la lista
        DefaultListModel itemLista;
        itemLista = new DefaultListModel();
        
        // Limpia el Control
        lstProcesos.removeAll();
        
         // Prepara Variable para realizar el Query
        sqlStmt = "Select * from 02tblprocesos";
        
        if (oConn.FnBoolQueryExecute(sqlStmt))
        {
            try 
            {
                // Verifica resultados
                 while (oConn.setResult.next())
                 {
                     
                     // Obtiene los datos de la Consulta
                     sIdeProceso = oConn.setResult.getString ("strProcesoIde");
                     sNomProceso = oConn.setResult.getString ("strProcesoNom");
                     
                     // agrega el dato a la lista
                     itemLista.addElement(sIdeProceso+"-"+sNomProceso);
                     
                 }
                 
                 // Agrega el Dato a la lista
                 lstProcesos.setModel(itemLista);
                
             
                 // Cierra Resultados
                 oConn.setResult.close();
            } 
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(rootPane,ex);
                Logger.getLogger(frmClase05.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    // Valida que los datos sean capturador
    boolean FnBoolValidaDatos()
    {
        // Variable para el Mensaje
        String strMensaje="";
        
        // Valida el Ide
        if (txtIde.getText().length()==0 || txtIde.getText().length()!=10)
        {
           strMensaje = "El Ide debe ser de 10 Caracteres:";
           txtIde.requestFocus();
        }
        
        // Valida el Nombre
        if (txtNom.getText().length()==0)
        {
           if (strMensaje.length()==0)
              txtNom.requestFocus();
           strMensaje = strMensaje + "\n"+"El Proceso debe ser de mas de 0 Caracteres:";
          
        }
                
        // Valida si faltaron datos
        if (strMensaje.length()>0)
        {
            // Construye el Mensaje
            strMensaje ="Debe Capturar los siguientes datos:\n"+strMensaje;
            
            // Muestra el Mensaje
            JOptionPane.showMessageDialog(this, strMensaje);
            
            // Retorna
            return false;
            
        }
        else
            
            return true;
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton butGrabar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstProcesos;
    private javax.swing.JPanel pnlProcesos;
    private javax.swing.JTextField txtIde;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}