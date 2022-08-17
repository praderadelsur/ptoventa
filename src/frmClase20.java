

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.*;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @
 */
public class frmClase20 extends javax.swing.JDialog {

    /**
     * Creates new form frmClase07
     */
    
     // Variable para las funciones propias
    clsFunciones  oFunc = new clsFunciones();
    clsConnection oConn = new clsConnection();
     
 
    public frmClase20(java.awt.Frame parent, boolean modal) 
    {
        // Inicialización de la Forma    
        super(parent, modal);
        initComponents();
        
        // Maximiza la Ventana
       // this.setSize(this.getToolkit().getScreenSize());  
        this.setLocationRelativeTo(null);   
        
        
        // Formate la tabla y Carga los Productos
        sbTablaProductosFormat();
        sbClientesCarga();
        
    }
    
    // Procedimiento para dar formato a la Tabla
    private void sbTablaProductosFormat()
    {
        
        // Declaro un modelo de datos
        DefaultTableModel modelo = new DefaultTableModel();      
                
        // Añadimos columnas al modelo de datos
              
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Domicilio");
        modelo.addColumn("Localidad");
        modelo.addColumn("Cod. Postal");
        modelo.addColumn("Telefono");
        modelo.addColumn("Cod. CtaCte");
        
        // Coloca el Modelo en la Tabla
        tblClientes.setModel(modelo);
        
        // Establezco los anchos de las columnas
        TableColumn tblColumn = tblClientes.getColumn("Codigo"); 
        tblColumn.setPreferredWidth(60);
        
        
        // Nombre Corto
        tblColumn = tblClientes.getColumn("Nombre");        
        tblColumn.setPreferredWidth(120);
        
        // Nombre largo
        tblColumn = tblClientes.getColumn("Apellido");
        tblColumn.setPreferredWidth(180);
        
        // Directamente
       // tblProductos.getColumn("Medida").setPreferredWidth(50);
        
        // Alinear a la derecha las cantidas y precios
        DefaultTableCellRenderer cellAlinear = new DefaultTableCellRenderer();
        
        // Asignamos el Alineamiento Horizontal a la derecha
        cellAlinear.setHorizontalAlignment(SwingConstants.RIGHT);
        
        // Asignamos la Variable de celda de alineamiento a cada una de las columnas a alinear
        tblClientes.getColumnModel().getColumn(4).setCellRenderer(cellAlinear);
        tblClientes.getColumnModel().getColumn(5).setCellRenderer(cellAlinear);

       
        // Color de los Encabezados
        tblClientes.getTableHeader().setBackground(Color.lightGray);
        tblClientes.getTableHeader().setForeground(Color.blue);
         tblClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        
    }
    // Procedimiento para cargar los productos
    private void sbClientesCarga()
    {
        // Variable para el Query
        String sQuery;
        int iCuenta;
        int iMaxRows;
        
        // Variable para el modelo de la tabla
        DefaultTableModel tblDatos = (DefaultTableModel) tblClientes.getModel();
        
        //tblProductos.removeAll();
        
        // Obtiene el Número de Datos
        iMaxRows = tblDatos.getRowCount();
        
        // Ciclo para Borrar
        for (iCuenta=0; iCuenta<iMaxRows;iCuenta++)
             tblDatos.removeRow(0);
        
        // Prepara los datos vacios iniciales
        Object [] oFila = new Object[20];
        
        // Prepara el Query
        sQuery = "Select * from 12tblclientes";
        
        //Ejecuta el Query
        oConn.FnBoolQueryExecute(sQuery);
        
        // Capturo el Error
        try {

            // Verifico que haya habido resultados
            iCuenta=0;
            while (oConn.setResult.next())
            {
                
                // Obtengo los datos en el Objeto Fila
                oFila[0]=oConn.setResult.getString("intClienteCodigo");
                oFila[1]=oConn.setResult.getString("strClienteNombre");                
                oFila[2]=oConn.setResult.getString("strClienteApellido");
                oFila[3]=oConn.setResult.getString("strClienteDomicilio");
                oFila[4]=oConn.setResult.getString("strClienteLocalidad");
                oFila[5]=oConn.setResult.getString("strCodigoPostal");
                oFila[6]=oConn.setResult.getString("strClienteTelefono");
                oFila[7]=oConn.setResult.getString("intCodigoCuentaCorriente");

                
                // Agrega el Dato
                tblDatos.addRow(oFila);
                //tblDatos.setValueAt(oFila[1], iCuenta++, 1); // Cambia el valor de la fila 1, columna 2.

            }
            
        // Cierro los Resultados
        oConn.setResult.close();
                
        } catch (SQLException ex) {
            oFunc.SubSistemaMensaje("sbClientesCarga:"+ex.getMessage().toString());
        }
        
        // Coloca el Modelo de Nueva Cuenta
        tblClientes.setModel(tblDatos);
        
        //modelo.setValueAt ("nuevo valor", 0, 1); // Cambia el valor de la fila 1, columna 2.
        //modelo.removeRow (1); // Borra la primera fila
    }
    
    

    
     //----------------------------------------------------------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        tbProductos = new javax.swing.JToolBar();
        btnProductoAdd = new javax.swing.JButton();
        btnProductoUpd = new javax.swing.JButton();
        btnProductoDel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnProductoBuscar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnProductoAyuda = new javax.swing.JButton();
        pnlProductos = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setFocusable(false);
        setFocusableWindowState(false);
        setResizable(false);

        btnProductoAdd.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        btnProductoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        btnProductoAdd.setText("Agregar");
        btnProductoAdd.setFocusable(false);
        btnProductoAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductoAdd.setMaximumSize(new java.awt.Dimension(64, 64));
        btnProductoAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoAddActionPerformed(evt);
            }
        });
        tbProductos.add(btnProductoAdd);

        btnProductoUpd.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        btnProductoUpd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        btnProductoUpd.setText("Editar");
        btnProductoUpd.setFocusable(false);
        btnProductoUpd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductoUpd.setMaximumSize(new java.awt.Dimension(64, 64));
        btnProductoUpd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductoUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoUpdActionPerformed(evt);
            }
        });
        tbProductos.add(btnProductoUpd);

        btnProductoDel.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        btnProductoDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/del.png"))); // NOI18N
        btnProductoDel.setText("Borrar");
        btnProductoDel.setFocusable(false);
        btnProductoDel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductoDel.setMaximumSize(new java.awt.Dimension(64, 64));
        btnProductoDel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductoDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoDelActionPerformed(evt);
            }
        });
        tbProductos.add(btnProductoDel);
        tbProductos.add(jSeparator1);

        btnProductoBuscar.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        btnProductoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar.png"))); // NOI18N
        btnProductoBuscar.setText("Buscar");
        btnProductoBuscar.setFocusable(false);
        btnProductoBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductoBuscar.setMaximumSize(new java.awt.Dimension(64, 64));
        btnProductoBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoBuscarActionPerformed(evt);
            }
        });
        tbProductos.add(btnProductoBuscar);
        tbProductos.add(jSeparator4);

        btnProductoAyuda.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        btnProductoAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/help.png"))); // NOI18N
        btnProductoAyuda.setText("Ayuda");
        btnProductoAyuda.setFocusable(false);
        btnProductoAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductoAyuda.setMaximumSize(new java.awt.Dimension(64, 64));
        btnProductoAyuda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbProductos.add(btnProductoAyuda);

        tblClientes.setAutoCreateRowSorter(true);
        tblClientes.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", "3", "4", "5"},
                {"6", "7", "8", null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClientesMousePressed(evt);
            }
        });
        pnlProductos.setViewportView(tblClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
            .addComponent(pnlProductos)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMousePressed
        // TODO add your handling code here:
        
        // Para Obtener el Código
        String sCodigo;
        
        // Verifica doble Click
        if (evt.getClickCount() == 1) 
        {
            
             // Variable para el modelo de la tabla
             DefaultTableModel tblDatos = (DefaultTableModel) tblClientes.getModel();
            
            // Obtengo el Codigo de la celda
            sCodigo = tblDatos.getValueAt(tblClientes.getSelectedRow(),7).toString();
            
             // Declaro la variable para la forma de ABC 
             frmClase23 frmCuentaCte = new frmClase23(null, true);
        
             // Muestra la Forma
             frmCuentaCte.setTitle(frmCuentaCte.getTitle()+"-Editar");
             frmCuentaCte.setCodigo(sCodigo);
             frmCuentaCte.fnBoolCteCteExiste(true);
             frmCuentaCte.setVisible(true);
             
             // Carga los productos al terminar        
            //acá llamo al form cte cte para abrirlo con los parametros seleccionados
            
            
        }
    }//GEN-LAST:event_tblClientesMousePressed

    private void btnProductoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoAddActionPerformed
        // TODO add your handling code here:
        // Declaro la Variable de la Forma de Procesos
        
        // Declaro la variable para la forma de ABC Productos
        frmClase18 frmCliente = new frmClase18(null, true);
        
        // Muestra la Forma
        frmCliente.setTitle(frmCliente.getTitle() + " - Insertar");
        frmCliente.setVisible(true);
        
        // Carga los productos al terminar        
        sbClientesCarga();
        
        
    }//GEN-LAST:event_btnProductoAddActionPerformed

    
//        private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {                                          
//
//        // TODO add your handling code here:
//        int iCliente ;
//        int iRow;
//
//        // Obtiene la Cantidad y el Precio para disminuir del importe
//        // y del Total
//        iRow = tblClientes.getSelectedRow();
//
//        // Variable para el modelo de la tabla
//        DefaultTableModel tblDatos = (DefaultTableModel) tblClientes.getModel();
//
//        
//        // Actualiza el Numero de Productos
//        iCliente = tblClientes.getRowCount() ;
//       
//        // Elimina el Row
//        tblDatos.removeRow(iRow);
//        tblClientes.setModel(tblDatos);
//    }       
    
    
    private void btnProductoUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoUpdActionPerformed
        // TODO add your handling code here:
        
        // Variable para el Código
        String sCodigo;
        
        // Valida que esté seleccionado  un dato
        if (tblClientes.getSelectedRow()>=0)
        {
            // Variable para el modelo de la tabla
             DefaultTableModel tblDatos = (DefaultTableModel) tblClientes.getModel();
            
            // Obtengo el Codigo de la celda
            sCodigo = tblDatos.getValueAt(tblClientes.getSelectedRow(),0).toString();
            
             // Declaro la variable para la forma de ABC Productos
             frmClase18 frmClientes = new frmClase18(null, true);
        
             // Muestra la Forma
             frmClientes.setTitle(frmClientes.getTitle()+"-Editar");
             frmClientes.setCodigo(sCodigo);
             frmClientes.fnBoolClienteExiste(true);
             frmClientes.setVisible(true);
             
             // Carga los productos al terminar        
             sbClientesCarga();
        }
        else
            oFunc.SubSistemaMensaje("Seleccione un Cliente");
    }//GEN-LAST:event_btnProductoUpdActionPerformed

    private void btnProductoDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoDelActionPerformed
        // TODO add your handling code here:
        // Variable para el Código
        String sCodigo;
        String sQuery;
        int iResult;
        
       
        // Valida que esté seleccionado  un dato
        if (tblClientes.getSelectedRow()>=0)
        {
             // Confirmación de la Eliminación
             if (oFunc.fnIntSistemaPregunta("Desea realmente eliminar el Registro")==JOptionPane.YES_OPTION)
             {     
                // Variable para el modelo de la tabla
                DefaultTableModel tblDatos = (DefaultTableModel) tblClientes.getModel();

                // Obtengo el Codigo de la celda
                sCodigo = tblDatos.getValueAt(tblClientes.getSelectedRow(),0).toString();

                // Prepara el Query para Borrar
                sQuery = "Delete from 12tblclientes Where intClienteCodigo='"+sCodigo+"'";

                if (oConn.FnBoolQueryExecuteUpdate(sQuery))
                   oFunc.SubSistemaMensaje("El Cliente ha sido eliminado");

                // Carga los productos al terminar        
                sbClientesCarga();
             }
        }
        else
            oFunc.SubSistemaMensaje("Seleccione un Producto");
    }//GEN-LAST:event_btnProductoDelActionPerformed

    private void sbProductoBuscaDato(String sDato)
    {
        // Variables para Fila y Columns
        int fil, col;
        boolean bEncontro=false;
        
        // Pasa a mayúsculas
        sDato = sDato.toUpperCase();
        
        //Limpia selección de la tabla
        tblClientes.clearSelection();

        for(fil = 0; fil < tblClientes.getRowCount();fil++)
        {
            for(col = 0; col < tblClientes.getColumnCount(); col++)
            {              
                 //Obtiene dato contenido en una celda de la tabla
                 String value = (String)tblClientes.getValueAt(fil, col);
                 
                 // lo pasa a Mayúsculas
                 value = value.toUpperCase();
                                  
                 //if(value.equals(sDato))
                 if(value.lastIndexOf(sDato)>=0)
                 {     
                       //Selecciona celda si el texto es encontrado     
                       //tblProductos.changeSelection(col, col, bEncontro, bEncontro);
                       tblClientes.changeSelection(fil, col, false, false);
                       bEncontro=true;
                       break;
                 }
             }
             if (bEncontro)
                 break;
        }
    }
    private void btnProductoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoBuscarActionPerformed
        // TODO add your handling code here:
        //opcProductoBuscarActionPerformed(evt);
    }//GEN-LAST:event_btnProductoBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(frmClase07.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClase07.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClase07.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClase07.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmClase07 dialog = new frmClase07(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnProductoAdd;
    private javax.swing.JButton btnProductoAyuda;
    private javax.swing.JButton btnProductoBuscar;
    private javax.swing.JButton btnProductoDel;
    private javax.swing.JButton btnProductoUpd;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JScrollPane pnlProductos;
    private javax.swing.JToolBar tbProductos;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
