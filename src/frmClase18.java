
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @
 */
public class frmClase18 extends javax.swing.JDialog {

    /**
     * Creates new form frmClase07b
     */
    // Declaro variable de Conexion
    clsConnection oConn = new clsConnection();
    
    // Variable para las funciones propias
    clsFunciones  oFunc = new clsFunciones();
    
    
    
    public frmClase18(java.awt.Frame parent, boolean modal) 
    {
        // Código de Inicialización
        super(parent, modal);
        initComponents();
        
        //Centro la Forma   
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        pnlDetalle = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblMedida = new javax.swing.JLabel();
        lblInicial = new javax.swing.JLabel();
        lblEntradas = new javax.swing.JLabel();
        lblSalidas = new javax.swing.JLabel();
        lblActual = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        txtLocalidad = new javax.swing.JTextField();
        txtCodigoCliente = new javax.swing.JTextField();
        txtCodCteCte = new javax.swing.JTextField();
        txtCodPostal = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        txtCodigo.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtCodigo.setMaximumSize(new java.awt.Dimension(170, 25));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");

        pnlDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12))); // NOI18N

        lblCodigo.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblCodigo.setText("Código:");

        lblNombre.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblNombre.setText("Nombre:");

        lblDescripcion.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblDescripcion.setText("Apellido:");

        lblMedida.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblMedida.setText("Domicilio:");

        lblInicial.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblInicial.setText("Localidad:");

        lblEntradas.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblEntradas.setText("Cod. Postal:");

        lblSalidas.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblSalidas.setText("Telefono:");

        lblActual.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblActual.setText("Cod. Cte. Cte:");

        txtNombre.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtNombre.setMaximumSize(new java.awt.Dimension(170, 25));
        txtNombre.setPreferredSize(new java.awt.Dimension(170, 21));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtDomicilio.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtDomicilio.setMaximumSize(new java.awt.Dimension(170, 21));
        txtDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomicilioActionPerformed(evt);
            }
        });

        txtLocalidad.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtLocalidad.setMaximumSize(new java.awt.Dimension(170, 21));
        txtLocalidad.setPreferredSize(new java.awt.Dimension(170, 21));

        txtCodigoCliente.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtCodigoCliente.setMaximumSize(new java.awt.Dimension(170, 21));
        txtCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoClienteActionPerformed(evt);
            }
        });

        txtCodCteCte.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtCodCteCte.setMaximumSize(new java.awt.Dimension(170, 21));
        txtCodCteCte.setPreferredSize(new java.awt.Dimension(170, 21));

        txtCodPostal.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtCodPostal.setMaximumSize(new java.awt.Dimension(170, 21));
        txtCodPostal.setPreferredSize(new java.awt.Dimension(170, 21));

        txtApellido.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtApellido.setMaximumSize(new java.awt.Dimension(170, 25));
        txtApellido.setPreferredSize(new java.awt.Dimension(170, 21));
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtTelefono.setMaximumSize(new java.awt.Dimension(170, 21));
        txtTelefono.setPreferredSize(new java.awt.Dimension(170, 21));

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSalidas)
                    .addComponent(lblEntradas)
                    .addComponent(lblMedida)
                    .addComponent(lblDescripcion)
                    .addComponent(lblNombre)
                    .addComponent(lblCodigo)
                    .addComponent(lblInicial)
                    .addComponent(lblActual))
                .addGap(18, 65, Short.MAX_VALUE)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodCteCte, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDomicilio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodPostal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMedida))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicial)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEntradas))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalidas))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblActual)
                    .addComponent(txtCodCteCte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAceptar.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   
    
    public boolean fnBoolClienteExiste(boolean bDisplay)
    {
        // Para devolver el resultado
        boolean bResultado=false;
        
        // Para el Query
        String sQuery;
        
        // Prepara el Query
        sQuery  = "Select * from 12tblclientes Where intClienteCodigo='"+txtCodigoCliente.getText()+"'";
        
        //Ejecuta el Query
        oConn.FnBoolQueryExecute(sQuery);
        
        // Capturo el Error
        try {
            // Verifico que haya habido resultados
            if (oConn.setResult.next())
            {
        
                // Verifica si debe desplegar
                if (bDisplay)
                {
                    // Obtengo los datos
                    txtCodigoCliente.setText(oConn.setResult.getString("intClienteCodigo"));
                    txtNombre.setText(oConn.setResult.getString("strClienteNombre"));
                    txtApellido.setText(oConn.setResult.getString("strClienteApellido"));
                    txtDomicilio.setText(oConn.setResult.getString("strClienteDomicilio"));
                    txtLocalidad.setText(oConn.setResult.getString("strClienteLocalidad"));
                    txtTelefono.setText(oConn.setResult.getString("strClienteTelefono"));
                    txtCodPostal.setText(oConn.setResult.getString("strCodigoPostal"));
                    txtCodCteCte.setText(oConn.setResult.getString("intCodigoCuentaCorriente"));

                }
                // Resultado
                bResultado = true;

            }
            
            // Cierro los Resultados
            oConn.setResult.close();
                
        } catch (SQLException ex) {
            oFunc.SubSistemaMensaje("Cliente Existente:"+ex.getMessage().toString());
        }
        
        
        
        // Retorna el Resultado
        return bResultado;
        
    }
    
    // Procedimiento para insertar el producto
    private void sbInsertaCliente()
    {
        String sQuery;
        
        // Prepara el Query para Insertar
        sQuery = "insert into 12tblclientes values (";
        sQuery += ""+txtCodigoCliente.getText().toString()+",";
        sQuery += "'"+txtNombre.getText().toString()+"',";
        sQuery += "'"+txtApellido.getText().toString()+"',";
        sQuery += "'"+txtDomicilio.getText().toString()+"',";
        sQuery += "'"+txtLocalidad.getText().toString()+"',";
        sQuery += "'"+txtCodPostal.getText().toString()+"',";
        sQuery += "'"+txtTelefono.getText().toString()+"',";
        sQuery += txtCodCteCte.getText().toString()+")";
        
        // Para ver el Query
        //oFunc.SubSistemaMensaje(sQuery);
                
                
                        
        // Ejecuta la Insercion
        if (oConn.FnBoolQueryExecuteUpdate(sQuery))
            oFunc.SubSistemaMensaje("La Inserción se ha realizado con éxito");
        
        // Cierra la Forma
        this.dispose();
        
    }
    
    private void sbModificaCliente()
    {
        
        // Variable para el Query
        String sQuery;
               
        // Prepara el Query para Insertar
        sQuery = " Update 12tblclientes Set ";
        sQuery += " intClienteCodigo="+txtCodigoCliente.getText().toString()+",";
        sQuery += " strClienteNombre='"+txtNombre.getText().toString()+"',";
        sQuery += " strClienteApellido='"+txtApellido.getText()+"',";
        sQuery += " strClienteDomicilio='"+txtDomicilio.getText()+"',";
        sQuery += " strClienteLocalidad='"+txtLocalidad.getText()+"',";
        sQuery += " strClienteTelefono='"+txtTelefono.getText()+"',";
        sQuery += " intCodigoCuentaCorriente='"+txtCodCteCte.getText()+"',";
        sQuery += " strCodigoPostal='"+txtCodPostal.getText()+"' ";
        sQuery += " Where intClienteCodigo="+txtCodigoCliente.getText();
        
        // Para ver el Query
        //oFunc.SubSistemaMensaje(sQuery);
                        
        // Ejecuta la Insercion
        if (oConn.FnBoolQueryExecuteUpdate(sQuery))
            oFunc.SubSistemaMensaje("La Modificación se ha realizado con éxito");
        
        // Cierra la Forma
        this.dispose();
        
    }
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
         if (FnBoolValidaDatos()) {
        if (this.getTitle().toString().lastIndexOf("Insertar")>=0)
        {
            if (fnBoolClienteExiste(true))
                oFunc.SubSistemaMensaje("El Código de Cliente ya existe");
            else
                   sbInsertaCliente();
        }
        else
            if (! fnBoolClienteExiste(false))
                oFunc.SubSistemaMensaje("El Código de Cliente NO existe");
            else
                   sbModificaCliente();
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoClienteActionPerformed

    private void txtDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void sbCargaCtaCte(String codigo)
    {
        // Variable para el Query
        String sQuery;
        
        // Prepara el Query
        sQuery ="Select intCtaCteCodigo from 13tbldetallectacte";
        
        if (oConn.FnBoolQueryExecute(sQuery))
        {
            try 
            {
                // Verifica resultados
                 while (oConn.setResult.next())
                 {                     
                     // Obtiene los datos de la Consulta
                     
                 }
                 
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
        
        // Desselecciona
        //cboMedida.setSelectedIndex(-1);
    }
    

    
    
      private boolean FnBoolValidaDatos() {

        // Variable para el Mensaje
        String sMensaje = "";
        
        // Valida el Usuario
        if (txtCodigoCliente.getText().length() == 0) {
            // Añade el Usuario al Mensaje
            sMensaje = "Codigo";

            // Coloca el Foco en el Objeto
            txtCodigoCliente.requestFocus();
        }

        // Valida el Password
        if (txtNombre.getText().length() == 0) {
            // Valida si no falló con el usuario para mandar el foco
            if (sMensaje.length() == 0) // Mando el Foco al Password si no ha fallado algun dato previo
            {
                txtNombre.requestFocus();
            }

            // Añade el Usuario al Mensaje
            sMensaje = sMensaje + "\n" + "Nombre";

        }

                // Valida el Password
        if (txtApellido.getText().length() == 0) {
            // Valida si no falló con el usuario para mandar el foco
            if (sMensaje.length() == 0) // Mando el Foco al Password si no ha fallado algun dato previo
            {
                txtApellido.requestFocus();
            }

            // Añade el Usuario al Mensaje
            sMensaje = sMensaje + "\n" + "Apellido";

        }
        
                // Valida el Password
        if (txtDomicilio.getText().length() == 0) {
            // Valida si no falló con el usuario para mandar el foco
            if (sMensaje.length() == 0) // Mando el Foco al Password si no ha fallado algun dato previo
            {
                txtDomicilio.requestFocus();
            }

            // Añade el Usuario al Mensaje
            sMensaje = sMensaje + "\n" + "Domicilio";

        }
        
                // Valida el Password
        if (txtLocalidad.getText().length() == 0) {
            // Valida si no falló con el usuario para mandar el foco
            if (sMensaje.length() == 0) // Mando el Foco al Password si no ha fallado algun dato previo
            {
                txtLocalidad.requestFocus();
            }

            // Añade el Usuario al Mensaje
            sMensaje = sMensaje + "\n" + "Localidad";

        }
        
                // Valida el Password
        if (txtTelefono.getText().length() == 0) {
            // Valida si no falló con el usuario para mandar el foco
            if (sMensaje.length() == 0) // Mando el Foco al Password si no ha fallado algun dato previo
            {
                txtTelefono.requestFocus();
            }

            // Añade el Usuario al Mensaje
            sMensaje = sMensaje + "\n" + "Telefono";

        }
        
                // Valida el Password
        if (txtCodCteCte.getText().length() == 0) {
            // Valida si no falló con el usuario para mandar el foco
            if (sMensaje.length() == 0) // Mando el Foco al Password si no ha fallado algun dato previo
            {
                txtCodCteCte.requestFocus();
            }

            // Añade el Usuario al Mensaje
            sMensaje = sMensaje + "\n" + "Cod Cte Cte";

        }
        
                // Valida el Password
        if (txtCodPostal.getText().length() == 0) {
            // Valida si no falló con el usuario para mandar el foco
            if (sMensaje.length() == 0) // Mando el Foco al Password si no ha fallado algun dato previo
            {
                txtCodPostal.requestFocus();
            }

            // Añade el Usuario al Mensaje
            sMensaje = sMensaje + "\n" + "Cod Postal";

        }
        

        // Verifica si hay que desplegar el Mensaje
        if (sMensaje.length() > 0) {
            //Prepara el Mensaje
            sMensaje = "Debe ingresar los siguiente datos:\n" + sMensaje;
            JOptionPane.showMessageDialog(null, sMensaje);

            // Devuelve falso
            return false;
        } else {
            // Retorna Correcto
            return true;
        }

    }

    
    
    
    
    // Setter para asiganar código
    public void setCodigo(String sCodigo)
    {
        // Coloco el Código
        txtCodigoCliente.setText(sCodigo);
    }
    
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
            java.util.logging.Logger.getLogger(frmClase07b.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClase07b.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClase07b.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClase07b.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmClase07b dialog = new frmClase07b(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblActual;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEntradas;
    private javax.swing.JLabel lblInicial;
    private javax.swing.JLabel lblMedida;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSalidas;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodCteCte;
    private javax.swing.JTextField txtCodPostal;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
