
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @
 */
public class FrmTabuladores extends javax.swing.JDialog {

    /**
     * Creates new form FrmTabuladores
     */
    public FrmTabuladores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
        // Paneles para los objetos
        JPanel	pnlProveedores;
	JPanel	pnlClientes;
	JPanel	panel1;
        JPanel	panel2;
        
         // Configura el Primer panel
        pnlProveedores = new JPanel();
	//pnlProveedores.setLsetLayout( null );	
        
        //Agrega el Panel al tab
        tabProCli.addTab( "Proveedores", pnlProveedores );
       
        
        // Configura el Primer panel
        pnlClientes = new JPanel();
	pnlClientes.setLayout( null );	
        tabProCli.addTab( "Clientes", pnlClientes );
        
        panel1 = new JPanel();
	panel1.setLayout( null );
       

	JLabel label1 = new JLabel( "Username:" );
	label1.setBounds( 10, 15, 150, 20 );
	//panel1.add( label1 );
        label1.setText("Usuario");
        
        pnlClientes.add(label1);
        
        // Prepara los objetos del Tab de Proveedores
        panel2 = new JPanel();
	panel2.setLayout( null );
        JLabel label2 = new JLabel( "Username2:" );
	label2.setBounds( 10, 15, 150, 20 );	
        pnlProveedores.add(label2);
        
        
        

	
        
        
        
	
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabProCli = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabProCli.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabProCli, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabProCli, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmTabuladores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTabuladores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTabuladores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTabuladores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FrmTabuladores dialog = new FrmTabuladores(new javax.swing.JFrame(), true);
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
    private javax.swing.JTabbedPane tabProCli;
    // End of variables declaration//GEN-END:variables
}
