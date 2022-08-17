
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @
 */
public class frmClase08 extends javax.swing.JDialog {

    /**
     * Creates new form frmClase08
     */
     // Variable para las funciones propias
    clsFunciones  oFunc = new clsFunciones();
    clsConnection oConn = new clsConnection();
    
    // Las posiciones de la venta
    int iPosX;
    int iPosY;
     
    public frmClase08(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //Centro la Forma   
        this.setLocationRelativeTo(null);      
        
        // Obtiene la posición de la ventana
        iPosX = this.getLocation().x;
        iPosY = this.getLocation().y;
        
        // deshabilita resize
        this.setResizable(false);
        
        // Inicializa la captura
        sbInicializaCaptura();
        
        
    }
    
    // Inicializa los datos
    private void sbInicializaCaptura()
    {
        // Variable para la fecha
        Date dateHoy = new Date();
    
        // Variable para dar formato
        SimpleDateFormat formato = new SimpleDateFormat("yyyy.MM.dd hh.mm.ss");
        
        // Inicializa Folio y Fecha
        btnFolio.setText(String.format("%05d",fnIntFolioGet()));
        lblFechaView.setText(formato.format(dateHoy));
        
        // Inicializa Código, Nombre y Existencia
        txtCodigo.setText(null);
        txtNombreView.setText(null);
        txtExistenciaView.setText(null);
        
        // Inicializa Costo, Precio y Cantidad
        txtCosto.setText("0");
        txtPrecio.setText("0");
        txtCantidad.setText("0");
        
        // Inicializa Descripcion
        txtDescripcion.setText(null);
        
    }
    
    // Función para obtener el Folio
    private int fnIntFolioGet()
    {
        // Variable para el Resultado
        int iResult=0;

        // Variable para el Query
        String sQuery;
        
        
        // Prepara el Query
        sQuery ="Select intFolioInventario from 05tblfolios";
                
        //Ejecuta el Query
        oConn.FnBoolQueryExecute(sQuery);
        
        // Capturo el Error
        try {
            
            // Verifico que haya habido resultados
            if (oConn.setResult.next())
            {
        
                // Obtiene el Folio Siguiente
                iResult = oConn.setResult.getInt("intFolioInventario");

            }
        } catch (SQLException ex) {
            oFunc.SubSistemaMensaje("fnIntFolioGet:"+ex.getMessage().toString());
        }
        
        // Retorna el Resultado
        return iResult;
        
    }
    
    
    // Verifica que el Folio exista
    public boolean fnBoolFolioExiste()
    {
        // Para devolver el resultado
        boolean bResultado=false;
        
        // Para el Query
        String sQuery;
        
        // Prepara el Query
        sQuery  = "Select * from 06tblinventario Where intInvFolio="+btnFolio.getText();
        
        //Ejecuta el Query
        oConn.FnBoolQueryExecute(sQuery);
        
        // Capturo el Error
        try {
            
            // Verifico que haya habido resultados
            if (oConn.setResult.next())
            {
                //Coloca los datos del Folio
                lblFechaView.setText(oConn.setResult.getString("datInvFecha"));
                if (oConn.setResult.getString("strInvMovimiento").lastIndexOf("Entrada")>=0)
                   cboMovimiento.setSelectedIndex(0);
                else
                   cboMovimiento.setSelectedIndex(1);
                
                // Obtengo los datos
                txtCodigo.setText(oConn.setResult.getString("strProductoCodigo"));
                txtCantidad.setText(oConn.setResult.getString("intInvCantidad"));
                txtDescripcion.setText(oConn.setResult.getString("txtInvDescripcion"));

                // Resultado
                bResultado = true;

            }
            
            // Cierro los Resultados
            oConn.setResult.close();
                
        } catch (SQLException ex) {
            oFunc.SubSistemaMensaje("fnBoolProductoExiste:"+ex.getMessage().toString());
        }
        
        
        
        // Retorna el Resultado
        return bResultado;
        
    }
    
    // Verifica que el Producto exista
    public boolean fnBoolProductoExiste(boolean bDisplay)
    {
        // Para devolver el resultado
        boolean bResultado=false;
        
        // Para el Query
        String sQuery;
        
        // Prepara el Query
        sQuery  = "Select * from 04tblProductos Where strProductoCodigo='"+txtCodigo.getText()+"'";
        
        //Ejecuta el Query
        oConn.FnBoolQueryExecute(sQuery);
        
        // Capturo el Error
        try {
            // Verifico que haya habido resultados
            if (oConn.setResult.next())
            {
        
                if (bDisplay)
                {
                    // Obtengo los datos
                    txtNombreView.setText(oConn.setResult.getString("strProductoNombre"));
                    txtExistenciaView.setText(oConn.setResult.getString("decProductoPrecio4"));
                    txtCosto.setText(oConn.setResult.getString("decProductoPrecio5"));
                    txtPrecio.setText(oConn.setResult.getString("decProductoPrecio6"));
                }
                // Resultado
                bResultado = true;

            }
            else         
            {
                if (bDisplay)
                {
                    txtNombreView.setText("Producto No existe");
                    txtExistenciaView.setText("*****");
                    txtCosto.setText("*****");
                    txtPrecio.setText("*****");
                }
            }
            
            // Cierro los Resultados
            oConn.setResult.close();
                
        } catch (SQLException ex) {
            oFunc.SubSistemaMensaje("fnBoolProductoExiste:"+ex.getMessage().toString());
        }
        
        
        
        // Retorna el Resultado
        return bResultado;
        
    }
    
    // Función para validar datos
    private boolean fnBoolDatosCorrectos()
    {
        // Variable de Resultado
        boolean bResultado=true;
        String sMensaje="";
        int iValor;
        String sValor;
        
        
        // Valida el Código
        if (txtCodigo.getText().trim().isEmpty() || txtCodigo.getText().trim().length()> 15 )
        {    
            sMensaje = "Código \n";
            bResultado = false;
        }
        else       
            if (! fnBoolProductoExiste(false))
            {    
                sMensaje = "Producto no Existe \n";
                bResultado = false;
            }    
        
        
        // Valida el Costo
        sValor = txtCosto.getText().toString();      
        if (! oFunc.fnBoolIsDecimal(sValor))        
        {    
            sMensaje = sMensaje + "Costo \n";
            bResultado = false;
        }
        else
             if(Double.valueOf(sValor) <= 0)
             {
                sMensaje = sMensaje + "Costo \n";
                bResultado = false;
             }
            
        // Valida el Precio
        sValor = txtPrecio.getText().toString();      
        if (! oFunc.fnBoolIsDecimal(sValor))        
        {    
            sMensaje = sMensaje + "Precio \n";
            bResultado = false;
        }
        else
             if(Double.valueOf(sValor)<=0)
             {
                sMensaje = sMensaje + "Precio \n";
                bResultado = false;
             }
        
        // Valida la Cantidad
        sValor = txtCantidad.getText().toString();      
        if (! oFunc.fnBoolIsInteger(sValor))        
        {    
            sMensaje = sMensaje + "Cantidad \n";
            bResultado = false;
        }
        else
             if(Integer.valueOf(sValor) <= 0)
             {
                sMensaje = sMensaje + "Cantidad \n";
                bResultado = false;
             }
        
        if (txtDescripcion.getText().isEmpty())        
        {    
            sMensaje = sMensaje + "Descripcion \n";
            bResultado = false;
        }
        if (! sMensaje.isEmpty())
            oFunc.SubSistemaMensaje("Debe revisar los siguientes datos:\n"+sMensaje);
        
        // retorna el Resultado
        return bResultado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetalle2 = new javax.swing.JPanel();
        lblFolio = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblMovimiento = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblExistencia = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        btnFolio = new javax.swing.JButton();
        lblFechaView = new javax.swing.JLabel();
        cboMovimiento = new javax.swing.JComboBox();
        txtCodigo = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        pnlDescripcion = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtExistenciaView = new javax.swing.JTextField();
        txtNombreView = new javax.swing.JTextField();
        btnInicializar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Control de Inventario");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        pnlDetalle2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Capture Movimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 1, 12))); // NOI18N

        lblFolio.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblFolio.setText("Ticket:");

        lblFecha.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblFecha.setText("Fecha:");

        lblMovimiento.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblMovimiento.setText("Movimiento:");

        lblCodigo.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblCodigo.setText("Código:");

        lblNombre.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblNombre.setText("Nombre:");

        lblExistencia.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblExistencia.setText("Existencia:");
        lblExistencia.setAlignmentY(0.0F);

        lblCosto.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblCosto.setText("Costo:");

        lblPrecio.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblPrecio.setText("Precio:");

        lblCantidad.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblCantidad.setText("Cantidad:");

        lblDescripcion.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblDescripcion.setText("Descripción:");

        btnFolio.setText("00000");
        btnFolio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnFolio.setPreferredSize(new java.awt.Dimension(170, 21));
        btnFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFolioActionPerformed(evt);
            }
        });

        lblFechaView.setBackground(new java.awt.Color(255, 255, 255));
        lblFechaView.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lblFechaView.setForeground(new java.awt.Color(51, 51, 255));
        lblFechaView.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFechaView.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cboMovimiento.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        cboMovimiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entrada", "Salida" }));
        cboMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMovimientoActionPerformed(evt);
            }
        });

        txtCodigo.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtCodigo.setToolTipText("F1 - Lista de Productos");
        txtCodigo.setMaximumSize(new java.awt.Dimension(170, 25));
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        txtCosto.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtCosto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCosto.setText("0");
        txtCosto.setMaximumSize(new java.awt.Dimension(170, 21));
        txtCosto.setPreferredSize(new java.awt.Dimension(170, 21));

        txtPrecio.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecio.setText("0");
        txtPrecio.setMaximumSize(new java.awt.Dimension(170, 21));
        txtPrecio.setPreferredSize(new java.awt.Dimension(170, 21));

        txtCantidad.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCantidad.setText("0");
        txtCantidad.setMaximumSize(new java.awt.Dimension(170, 21));
        txtCantidad.setPreferredSize(new java.awt.Dimension(170, 21));

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtDescripcion.setRows(5);
        pnlDescripcion.setViewportView(txtDescripcion);

        txtExistenciaView.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtExistenciaView.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtExistenciaView.setText("0");
        txtExistenciaView.setMaximumSize(new java.awt.Dimension(170, 21));
        txtExistenciaView.setPreferredSize(new java.awt.Dimension(170, 21));

        txtNombreView.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        txtNombreView.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNombreView.setText("0");
        txtNombreView.setMaximumSize(new java.awt.Dimension(170, 21));
        txtNombreView.setPreferredSize(new java.awt.Dimension(170, 21));
        txtNombreView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetalle2Layout = new javax.swing.GroupLayout(pnlDetalle2);
        pnlDetalle2.setLayout(pnlDetalle2Layout);
        pnlDetalle2Layout.setHorizontalGroup(
            pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalle2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDescripcion)
                    .addGroup(pnlDetalle2Layout.createSequentialGroup()
                        .addComponent(lblCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDetalle2Layout.createSequentialGroup()
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFechaView, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDetalle2Layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDetalle2Layout.createSequentialGroup()
                        .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblExistencia)
                            .addComponent(lblCosto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txtExistenciaView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlDetalle2Layout.createSequentialGroup()
                        .addComponent(lblPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDetalle2Layout.createSequentialGroup()
                        .addComponent(lblFolio)
                        .addGap(57, 57, 57)
                        .addComponent(btnFolio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDetalle2Layout.createSequentialGroup()
                        .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetalle2Layout.createSequentialGroup()
                                .addComponent(lblMovimiento)
                                .addGap(18, 18, 18)
                                .addComponent(cboMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDescripcion))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDetalle2Layout.setVerticalGroup(
            pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalle2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFolio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFolio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMovimiento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboMovimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre)
                    .addComponent(txtNombreView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblExistencia)
                    .addComponent(txtExistenciaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCosto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCosto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(lblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        btnInicializar.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnInicializar.setText("Inicializar");
        btnInicializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicializarActionPerformed(evt);
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
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnInicializar)
                        .addGap(134, 134, 134)
                        .addComponent(btnAceptar))
                    .addComponent(pnlDetalle2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pnlDetalle2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInicializar)
                    .addComponent(btnAceptar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFolioActionPerformed
        // TODO add your handling code here:
        clsGlobales.sConsultaDato="";
        
        // Coloca el Query de la Consulta
        clsConnection.sQuery ="Select intInvFolio as Folio, strInvMovimiento as Movto, datInvFecha as Fecha from `06tblinventario` ";
            
        // Crea la forma Coloca el título y la hace visible
        frmClase08b frmFolios = new frmClase08b(null,true);
        frmFolios.setTitle("Consulta de Folios");
        frmFolios.setVisible(true);
        
        // Despliega el Dato Seleccionado
        btnFolio.setText(String.format("%05d", Integer.parseInt(clsGlobales.sConsultaDato)));
        
        // Despliega los datos del Folio        
        fnBoolFolioExiste();
        fnBoolProductoExiste(true);
        
    }//GEN-LAST:event_btnFolioActionPerformed

    private void cboMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMovimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMovimientoActionPerformed

    private void btnInicializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicializarActionPerformed
        
        // Inicializa la captura
        sbInicializaCaptura();
    }//GEN-LAST:event_btnInicializarActionPerformed

    private boolean fnBoolProductoActualiza(boolean bEntrada)
    {
        // Variable de Resultados
        boolean bResult=false;
        
         // TODO add your handling code here:
        String strSqlStmt; // Para el Query
        
        
//        // Query para actualiza el Precio, Costo,Entradas y Existencias del Producto
//        strSqlStmt = "Update 04tblProductos set ";
//        strSqlStmt = strSqlStmt + " decProductoCosto = "+txtCosto.getText()+",";
//        strSqlStmt = strSqlStmt + " decProductoPrecio = "+txtPrecio.getText()+",";
//        
        // Verifica si es entrada o salida
      /*  if (bEntrada)
        {
            strSqlStmt = strSqlStmt + " intProductoEntradas = intProductoEntradas + "+txtCantidad.getText()+",";
            strSqlStmt = strSqlStmt + " intProductoActual   = intProductoActual   + "+txtCantidad.getText();
        }
        else
        {
            strSqlStmt = strSqlStmt + " intProductoSalidas = intProductoSalidas + "+txtCantidad.getText()+",";
            strSqlStmt = strSqlStmt + " intProductoActual   = intProductoActual   - "+txtCantidad.getText();            
        }
        */
        // Condiciona de acuerdo al código
//        strSqlStmt = strSqlStmt + " Where strProductoCodigo = '"+txtCodigo.getText()+ "'";
//        
//        if (oConn.FnBoolQueryExecuteUpdate(strSqlStmt))
//            bResult = true;
        
        // Retorna el resultado de la operación
        return bResult;
        
    }
    
    private boolean fnBoolInventarioRegistra(boolean bEntrada)
    {
         // Variable para la fecha
        Date dateHoy = new Date();
        
        // Variable para dar formato
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        // Variable de Resultados
        boolean bResult=false;
        
         // TODO add your handling code here:
        String strSqlStmt; // Para el Query
        
        
        // Query para Insertar el Movimiento de Inventario
        strSqlStmt = "Insert into 06tblInventario (intInvFolio,strInvMovimiento,datInvFecha,intInvCantidad,strProductoCodigo,intVentaFolio,txtInvDescripcion)";
        strSqlStmt = strSqlStmt + " Values ("+btnFolio.getText()+",";
        if (bEntrada)
           strSqlStmt = strSqlStmt + "'Entrada',";
        else
           strSqlStmt = strSqlStmt + "'Salida',";
        strSqlStmt = strSqlStmt + "'"+formato.format(dateHoy)+"',";
        strSqlStmt = strSqlStmt + txtCantidad.getText()+",";
        strSqlStmt = strSqlStmt + "'"+txtCodigo.getText()+"',0,";
        strSqlStmt = strSqlStmt + "'"+txtDescripcion.getText()+"')";
        
        // Ejecuta la Inserción
        if (oConn.FnBoolQueryExecuteUpdate(strSqlStmt))
            bResult = true;
        
        // Retorna el resultado de la operación
        return bResult;
        
    }
    
    private boolean fnBoolFolioIncrementa()
    {
        // Variable de Resultados
        boolean bResult=false;
        
         // TODO add your handling code here:
        String strSqlStmt; // Para el Query
        
        // Query para actualizar el Folio
        strSqlStmt = "Update 05tblFolios set intFolioInventario = intFolioInventario + 1";
        
        if (oConn.FnBoolQueryExecuteUpdate(strSqlStmt))
            bResult = true;
        
        // Retorna el resultado de la operación
        return bResult;
        
    }
    
    
    // Registra Entrada en la Base de Datos
    private void sbRegistraEntrada()
    {
        // TODO add your handling code here:
        String strSqlStmt; // Para el Query
        String sPass;      // Para el Password
        
        // Coloca la transacción a false para que sea una transaccion
        oConn.SubAutoCommit(false);
    
        // Intenta realizar las 3 afectaciones a la BD
        if (fnBoolProductoActualiza(true))
            if (fnBoolFolioIncrementa())
               if (fnBoolInventarioRegistra(true))
               {
                   // Commit
                   oConn.SubCommit();
                   
                    // Mensaje
                    oFunc.SubSistemaMensaje("Se ha registrado la Entrada con Éxito");
               }
               else               
                   // Realizo Rollback    
                   oConn.SubRollBack();                   
            else
               // realiza el rollback
               oConn.SubRollBack();
        else
            // realiza el rollback
            oConn.SubRollBack();
        
    }
    
    // Registra Salida en la Base de Datos
    private void sbRegistraSalida()
    {
        // TODO add your handling code here:
        String strSqlStmt; // Para el Query
        String sPass;      // Para el Password
        
        // Coloca la transacción a false para que sea una transaccion
        oConn.SubAutoCommit(false);
    
        // Intenta realizar las 3 afectaciones a la BD
        if (fnBoolProductoActualiza(false))
            if (fnBoolFolioIncrementa())
               if (fnBoolInventarioRegistra(false))
               {
                   // Commit
                   oConn.SubCommit();
                   
                    // Mensaje
                    oFunc.SubSistemaMensaje("Se ha registrado la Salida con Éxito");
               }
               else               
                   // Realizo Rollback    
                   oConn.SubRollBack();                   
            else
                // realiza el rollback
                oConn.SubRollBack();
        else
            // realiza el rollback
            oConn.SubRollBack();  
        
    }
    
    
    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        
        if (fnBoolDatosCorrectos())
            
            // Valida que operación va a realizar
            if (cboMovimiento.getSelectedIndex()==0)
                sbRegistraEntrada();
            else
                sbRegistraSalida();
               
            // Inicializa la captura
            sbInicializaCaptura();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        // TODO add your handling code here:
        fnBoolProductoExiste(true);
        
        // Verifica si presionó la tecla F1
        if (evt.getKeyCode()==112) // F1 = 112
        {
            // Inicializa el dato de consulta
            clsGlobales.sConsultaDato ="";
            
            // Coloca el Query de la Consulta
            clsConnection.sQuery ="select strProductoCodigo as Codigo, strProductoNombre as Nombre from 04tblProductos";
            
            // Declaro una variable instancia de la forma de consulta
            frmClase08b frmCodigos = new frmClase08b(null,true);
            frmCodigos.setTitle("Consulta de Códigos");            
            frmCodigos.setVisible(true);
            
            // Despliega el Dato Seleccionado
            txtCodigo.setText(clsGlobales.sConsultaDato);
            
            // Despliega el Producto
            fnBoolProductoExiste(true);
            
        }
           
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        // TODO add your handling code here:
        // Código para evitar que la forma se mueva       
        this.setLocation(iPosX,iPosY);
    }//GEN-LAST:event_formComponentMoved

    private void txtNombreViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreViewActionPerformed

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
            java.util.logging.Logger.getLogger(frmClase08.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClase08.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClase08.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClase08.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmClase08 dialog = new frmClase08(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnFolio;
    private javax.swing.JButton btnInicializar;
    private javax.swing.JComboBox cboMovimiento;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblExistencia;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaView;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblMovimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JScrollPane pnlDescripcion;
    private javax.swing.JPanel pnlDetalle2;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtExistenciaView;
    private javax.swing.JTextField txtNombreView;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
