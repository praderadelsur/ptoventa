
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class frmClase04 extends javax.swing.JFrame {

    // Declaro variable de Conexion
    clsConnection oConn = new clsConnection();
    clsGlobales oGlobal = new clsGlobales();

    /**
     * Creates new form Clase02
     */
    public frmClase04() {

        // Intento Conexion        
        if (!oConn.FnBoolConnectionOpen("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "root", "portal01")) //if (! oConn.FnBoolConnectionOpen("com.mysql.jdbc.Driver", "jdbc:mysql://localhost", "root", ""))
        {

            // Mensaje de que no logrola conexion
            JOptionPane.showMessageDialog(null, "No se logro la conexion al Host");

            // Finaliza la Aplicación
            System.exit(0);

        } else {
            // Inicializa Componentes
            initComponents();

            //Centro la Forma   
            this.setLocationRelativeTo(null);
            this.setTitle("Iniciar Sesión");
            this.setResizable(false);

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

        pnlSession = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txpPassword = new javax.swing.JPasswordField();
        lblName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblNameView = new javax.swing.JLabel();
        lblRoleView = new javax.swing.JLabel();
        butAccept = new javax.swing.JButton();
        butCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setName(""); // NOI18N

        pnlSession.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlSession.setName(""); // NOI18N

        lblUser.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        lblUser.setText("Usuario:");
        lblUser.setName(""); // NOI18N

        lblPassword.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        lblPassword.setText("Contraseña:");
        lblPassword.setName("lblPassword"); // NOI18N

        txtUser.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        txtUser.setName("txtUser"); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txpPassword.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        txpPassword.setName("txpPassword"); // NOI18N
        txpPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txpPasswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txpPasswordKeyTyped(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        lblName.setText("Nombre:");
        lblName.setName("lblName"); // NOI18N

        lblRole.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        lblRole.setText("Rol:");
        lblRole.setName("lblRole"); // NOI18N

        lblNameView.setBackground(new java.awt.Color(255, 255, 255));
        lblNameView.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        lblNameView.setForeground(new java.awt.Color(51, 51, 255));
        lblNameView.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblNameView.setName("lblNameView"); // NOI18N

        lblRoleView.setBackground(new java.awt.Color(255, 255, 255));
        lblRoleView.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        lblRoleView.setForeground(new java.awt.Color(51, 51, 255));
        lblRoleView.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRoleView.setName("lblRoleView"); // NOI18N

        javax.swing.GroupLayout pnlSessionLayout = new javax.swing.GroupLayout(pnlSession);
        pnlSession.setLayout(pnlSessionLayout);
        pnlSessionLayout.setHorizontalGroup(
            pnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSessionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPassword)
                    .addComponent(lblName)
                    .addComponent(lblUser)
                    .addComponent(lblRole))
                .addGap(43, 43, 43)
                .addGroup(pnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txpPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(lblNameView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRoleView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSessionLayout.setVerticalGroup(
            pnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSessionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPassword)
                    .addComponent(txpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblNameView, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(pnlSessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRoleView, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblUser.getAccessibleContext().setAccessibleName("");
        lblPassword.getAccessibleContext().setAccessibleName("lblPassword");
        txtUser.getAccessibleContext().setAccessibleName("txtUser");

        butAccept.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        butAccept.setText("Aceptar");
        butAccept.setName("butAccept"); // NOI18N
        butAccept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAcceptMouseClicked(evt);
            }
        });
        butAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAcceptActionPerformed(evt);
            }
        });

        butCancel.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        butCancel.setText("Cancelar");
        butCancel.setName("butCancel"); // NOI18N
        butCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butCancelMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo2.png"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(butAccept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butCancel)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butAccept)
                    .addComponent(butCancel))
                .addGap(17, 17, 17))
        );

        pnlSession.getAccessibleContext().setAccessibleDescription("Sesion");
        butAccept.getAccessibleContext().setAccessibleName("butAceptar");
        butCancel.getAccessibleContext().setAccessibleName("butCancelar");

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butCancelMouseClicked
        // TODO add your handling code here:                
        // Libera la forma            
        this.dispose();
    }//GEN-LAST:event_butCancelMouseClicked

    private void butAcceptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAcceptMouseClicked
        // TODO add your handling code here:      

        // Declaro variable para Sentencia
        String sqlStmt;

        // Verifico que esté intentando ingresar
        if (butAccept.getText().equals("Aceptar")) {
            // Valida que datos correctos

            if (FnBoolValidaDatos()) {
                // Prepara Variable para realizar el Query
                sqlStmt = "Select * from 01tblusers";
                sqlStmt += " Where strUserIde='" + txtUser.getText() + "'";
                sqlStmt += " And   strUserPass='" + String.valueOf(txpPassword.getPassword()) + "'";

                // Capturo el Error
                try {
                    // Ejecuto la Consulta
                    if (oConn.FnBoolQueryExecute(sqlStmt)) {

                        // Verifico que haya habido resultados
                        if (oConn.setResult.next()) {
                            //oConn.setResult.first();
                            //System.out.println ("Col 1:"+oConn.setResult.getString (1)); 
                            lblNameView.setText(oConn.setResult.getString("strUserName"));
                            lblRoleView.setText(oConn.setResult.getString("strRoleName"));
                            clsGlobales.sRole = oConn.setResult.getString("strRoleName");

                            //Cambio el Texto del Boton
                            butAccept.setText("Iniciar");

                            // Coloco en variable global el usuario del sustema
                            clsGlobales.sSystemUser = txtUser.getText();

                            //Deshabilito Cancelar
                            butCancel.setEnabled(false);
                        } else {
                            lblNameView.setText("Usuario y Contraseña Incorrecta");
                            lblRoleView.setText("Intente nuevamente ...");
                        }

                        // Cierra la Consulta
                        oConn.setResult.close();
                    }

                } catch (RuntimeException e) {
                    // Mensaje de que no logrola conexion
                    JOptionPane.showMessageDialog(null, "Este Mensaje" + e);

                } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
                    // Mensaje de que no logrola conexion
                    JOptionPane.showMessageDialog(null, "Este Mensaje" + e);

                } catch (SQLException ex) {
                    Logger.getLogger(frmClase03.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else {

            this.dispose();
            // Declaro una variable de la Nueva Forma
            frmClase04b frmPrincipal = new frmClase04b();

            // Hago visible la forma
            frmPrincipal.setVisible(true);

            /*Component[] components;       
            components = frmPrincipal.getComponents();  
            System.out.println("components.length " + components.length );  
            for (int i = 0; i < components.length; i++) 
            {  
                 System.out.println("view components[i] " + components[i]);  
                 components[i].setEnabled(false);  
            }  
             */
            if (oGlobal.fnBoolBitacoraActiva()) {
                oGlobal.sbGrabaBitacora(clsGlobales.sSystemUser, "Ingreso al Sistema");
            }

        }
    }//GEN-LAST:event_butAcceptMouseClicked

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void butAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAcceptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butAcceptActionPerformed

    private void txpPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txpPasswordKeyPressed
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (vChar == KeyEvent.VK_ENTER) {
            evt.consume();
            validarUsuario();
        }
    }//GEN-LAST:event_txpPasswordKeyPressed

    private void txpPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txpPasswordKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txpPasswordKeyTyped

    public void validarUsuario() {
        String sqlStmt;

        // Verifico que esté intentando ingresar
        // Valida que datos correctos
        if (FnBoolValidaDatos()) {
            // Prepara Variable para realizar el Query
            sqlStmt = "Select * from 01tblusers";
            sqlStmt += " Where strUserIde='" + txtUser.getText() + "'";
            sqlStmt += " And   strUserPass='" + String.valueOf(txpPassword.getPassword()) + "'";

            // Capturo el Error
            try {
                // Ejecuto la Consulta
                if (oConn.FnBoolQueryExecute(sqlStmt)) {

                    // Verifico que haya habido resultados
                    if (oConn.setResult.next()) {
                        //oConn.setResult.first();
                        //System.out.println ("Col 1:"+oConn.setResult.getString (1)); 
                        lblNameView.setText(oConn.setResult.getString("strUserName"));
                        lblRoleView.setText(oConn.setResult.getString("strRoleName"));
                        clsGlobales.sRole = oConn.setResult.getString("strRoleName");

                        // Coloco en variable global el usuario del sustema
                        clsGlobales.sSystemUser = txtUser.getText();

                        // Cierra esta forma
                        this.dispose();
                        // Declaro una variable de la Nueva Forma
                        frmClase04b frmPrincipal = new frmClase04b();

                        // Hago visible la forma
                        frmPrincipal.setVisible(true);
 
                        if (oGlobal.fnBoolBitacoraActiva()) {
                            oGlobal.sbGrabaBitacora(clsGlobales.sSystemUser, "Ingreso al Sistema");
                        }

                    } else {
                        lblNameView.setText("Usuario y Contraseña Incorrecta");
                        lblRoleView.setText("Intente nuevamente ...");
                    }

                    // Cierra la Consulta
                    oConn.setResult.close();
                }

            } catch (RuntimeException e) {
                // Mensaje de que no logrola conexion
                JOptionPane.showMessageDialog(null, "Este Mensaje" + e);

            } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
                // Mensaje de que no logrola conexion
                JOptionPane.showMessageDialog(null, "Este Mensaje" + e);

            } catch (SQLException ex) {
                Logger.getLogger(frmClase03.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    // Función para Validar Datos de Captura
    private boolean FnBoolValidaDatos() {

        // Variable para el Mensaje
        String sMensaje = "";

        // Valida el Usuario
        if (txtUser.getText().length() == 0) {
            // Añade el Usuario al Mensaje
            sMensaje = "Usuario";

            // Coloca el Foco en el Objeto
            txtUser.requestFocus();
        }

        // Valida el Password
        if (txpPassword.getPassword().length == 0) {
            // Valida si no falló con el usuario para mandar el foco
            if (sMensaje.length() == 0) // Mando el Foco al Password si no ha fallado algun dato previo
            {
                txpPassword.requestFocus();
            }

            // Añade el Usuario al Mensaje
            sMensaje = sMensaje + "\n" + "Contraseña";

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // java.awt.EventQueue.invokeLater(new Runnable() {

        // public void run() {
        new frmClase04().setVisible(true);

        //}
        //});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAccept;
    private javax.swing.JButton butCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameView;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblRoleView;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlSession;
    private javax.swing.JPasswordField txpPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}