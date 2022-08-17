
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @
 */
public class frmClase17 extends javax.swing.JDialog {

    // Constantes para las Columnas
    static final int INT_COL_CODIGO = 0;
    static final int INT_COL_NOMBRE = 1;
    static final int INT_COL_PRECIO = 2;
    static final int INT_COL_CANTIDAD = 3;
    static final int INT_COL_IMPORTE = 4;

    // Constantes para las Columnas
    static final int INT_COL_EMPRESA = 0;
    static final int INT_COL_SUCURSAL = 1;
    static final int INT_COL_DIRECCION1 = 2;
    static final int INT_COL_DIRECCION2 = 3;
    static final int INT_COL_TELEFONOS = 4;
    static final int INT_COL_RFC = 5;

    static final int INT_KEY_LF = 10;
    static final int INT_KEY_RETURN = 13;
    static final int INT_KEY_F1 = 112;

    // Variable para las funciones propias
    clsFunciones oFunc = new clsFunciones();
    clsConnection oConn = new clsConnection();

    // Variable para la operación de la venta
    boolean bAgruparProductos;
    boolean bVerificarExistencias;
    boolean bMensajesExito;
    String sTextoFinalTicket;
    JTable tabla;

    private String portName = "COM5";
    private int baudRate = SerialPort.BAUDRATE_9600;
    private int dataBits = SerialPort.DATABITS_8;
    private int stopBits = SerialPort.STOPBITS_1;
    private int parity = SerialPort.PARITY_NONE;
    private SerialPort serialPort;

    Map<String, Object> parametros;

    /**
     * Creates new form frmClase09
     */
    public frmClase17(java.awt.Frame parent, boolean modal, JTable table) {
        super(parent, modal);
        initComponents();
        this.tabla = table;

        btnPesar.setText("Leer Balanza");
        this.setLocationRelativeTo(null);

        // Inicializa
        sbInicializa();

//        }
        updatePortInfo();
    }

    private boolean updatePortInfo() {
        boolean returnValue = false;
        String info = "";
        if (!portName.equals("")) {
            info += (portName + " @ ");
            info += (baudRate + "-");
            info += (dataBits + "-");
            switch (parity) {
                case SerialPort.PARITY_NONE:
                    info += ("N-");
                    break;
                case SerialPort.PARITY_EVEN:
                    info += ("E-");
                    break;
                case SerialPort.PARITY_ODD:
                    info += ("O-");
                    break;
                case SerialPort.PARITY_SPACE:
                    info += ("S-");
                    break;
                case SerialPort.PARITY_MARK:
                    info += ("M-");
                    break;
            }
            switch (stopBits) {
                case SerialPort.STOPBITS_1:
                    info += ("1");
                    break;
                case SerialPort.STOPBITS_1_5:
                    info += ("1.5");
                    break;
                case SerialPort.STOPBITS_2:
                    info += ("2");
                    break;
            }
            jLabelPortInfo.setText(info);
            returnValue = true;
        } else {
            // jLabelPortInfo.setText("");
        }
        return returnValue;
    }

    public void AperturarPuertoSerial() {
        // TODO add your handling code here:

        if (btnPesar.getText().equals("Leer Balanza")) {
            serialPort = new SerialPort(portName);
            jLabelPortInfo.setText(portName);
            try {
                if (serialPort.openPort()) {
                    if (serialPort.setParams(baudRate, dataBits, stopBits, parity)) {
                        btnPesar.setText("Cerrar Balanza");
                        serialPort.addEventListener(new Reader(), SerialPort.MASK_RXCHAR
                                | SerialPort.MASK_RXFLAG
                                | SerialPort.MASK_CTS
                                | SerialPort.MASK_DSR
                                | SerialPort.MASK_RLSD);

                        // jLabelPortInfo.setText("");
                    } else {
                        oFunc.SubSistemaMensaje("sbProductoBuscar:" + "Parametros de Configuracion - No se puede establecer la conexion con los parametros indicados");
                        serialPort.closePort();
                    }
                } else {
                    oFunc.SubSistemaMensaje("sbProductoBuscar:" + "Abriendo Puertos - No se puede abrir el puerto. Debe tener una sola ventana abierta");
                }
            } catch (Exception ex) {
                //Do nothing
            }
        } else {
            try {
                if (serialPort.closePort()) {
                    btnPesar.setText("Leer Balanza");
                    clearFields();
                } else {
                    oFunc.SubSistemaMensaje("sbProductoBuscar:" + "Port closing - Can't close port.");
                }
            } catch (Exception ex) {
                //Do nothing
            }
        }
    }

    private class Reader implements SerialPortEventListener {

        private String str = "";

        public void serialEvent(SerialPortEvent spe) {

            if (spe.isRXCHAR() || spe.isRXFLAG()) {
                if (spe.getEventValue() > 0) {
                    try {
                        str = "";
                        byte[] buffer = serialPort.readBytes(spe.getEventValue());
                        if (0 == 0) {//Chars
                            str = new String(buffer);
                            //       System.out.println("valor obtenido de la balanza: " + str);
                        }

                        SwingUtilities.invokeAndWait(
                                new Runnable() {
                            public void run() {

                            String entrada="";
                            String salida="";
                            int i=0;
                                
                            entrada = str;

                            for(i=entrada.length()-2;i>=0;i--){

                            salida= salida + entrada.charAt(i);
                            }
                                txtPeso.setText(salida.replaceFirst("^0+(?!$)", "").replace("=", ""));
                            }
                        }
                        );
                    } catch (Exception ex) {
                        //Do nothing
                    }
                }
            }
        }
    }

    private void sbInicializa() {
        // Variable para la fecha
        Date dateHoy = new Date();

        // Variable para dar formato
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        sbHabilitaVenta(true);

        // Inicializa tabla de Productos
        sbTablaProductosInicializa();

        String sqlStmt;
        String strPuerto = "";

        // Prepara Variable para realizar el Query
        sqlStmt = "Select * from 15tblconfigpuertoserial";

        if (oConn.FnBoolQueryExecute(sqlStmt)) {
            try {
                // Verifica resultados
                while (oConn.setResult.next()) {
                    // Obtiene los datos de la Consulta
                    strPuerto = oConn.setResult.getString("strPuerto");
                }

                portName = strPuerto;
                oConn.setResult.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
                Logger.getLogger(frmClase05.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    // Habilita la Venta
    private void sbHabilitaVenta(boolean bVenta) {

        // Habilitados en Venta        
        txtCodigo.setEnabled(bVenta);
        tblProductos.setEnabled(bVenta);
        btnPesar.setEnabled(Boolean.FALSE);
        btnAgregarArticulo.setEnabled(Boolean.FALSE);

        // Deshabilitados en Venta
    }

    private void clearFields() {
        txtPeso.setText("");
    }

    public void sbProductoBuscar() {

        if (cmbPrecio.getItemCount() > 0) {
            cmbPrecio.removeAllItems();
        }

        // Para el Query
        String sQuery;

        // Valida que haya algo en el Codigo
        if (!txtCodigo.getText().trim().isEmpty()) {
            // Prepara el Query
            sQuery = "Select * from 04tblProductos Where strProductoCodigo='" + txtCodigo.getText() + "'";

            //Ejecuta el Query
            oConn.FnBoolQueryExecute(sQuery);

            // Capturo el Error
            try {
                // Verifico que haya habido resultados
                if (oConn.setResult.next()) {

                    lblCodigoProducto.setText(oConn.setResult.getString("strProductoCodigo"));
                    lblNombreProducto.setText(oConn.setResult.getString("strProductoNombre"));

                    cmbPrecio.addItem(oConn.setResult.getString("decProductoPrecio1") + " - Lista 1");
                    cmbPrecio.addItem(oConn.setResult.getString("decProductoPrecio2") + " - Lista 2");
                    cmbPrecio.addItem(oConn.setResult.getString("decProductoPrecio3") + " - Lista 3");
                    cmbPrecio.addItem(oConn.setResult.getString("decProductoPrecio4") + " - Lista 4");
                    cmbPrecio.addItem(oConn.setResult.getString("decProductoPrecio5") + " - Lista 5");
                    cmbPrecio.addItem(oConn.setResult.getString("decProductoPrecio6") + " - Lista 6");
                    cmbPrecio.addItem(oConn.setResult.getString("decProductoPrecio7") + " - Lista 7");
                    cmbPrecio.addItem(oConn.setResult.getString("decProductoPrecio8") + " - Lista 8");
                    cmbPrecio.addItem(oConn.setResult.getString("decProductoPrecio9") + " - Lista 9");
                    cmbPrecio.addItem(oConn.setResult.getString("decProductoPrecio10") + " - Lista 10");
                    
                    txtCodigo.setForeground(Color.black);

                    // Limpia el código al final
                    txtCodigo.setText(null);

                    btnPesar.setEnabled(Boolean.TRUE);
                    btnAgregarArticulo.setEnabled(Boolean.TRUE);

                    txtPeso.requestFocus();

                } else {
                    oFunc.SubSistemaMensaje("Producto No Existe");
                    txtCodigo.setForeground(Color.red);
                }

                // Cierro los Resultados
                oConn.setResult.close();

            } catch (SQLException ex) {
                oFunc.SubSistemaMensaje("sbProductoBuscar:" + ex.getMessage().toString());
            }
        }

    }

    public void sbProductoAgrega() {
        // Para el Total

        double decImporte;
        double decPrecio;
        double decCantidad;
        boolean bContinua = true;
        // Para el Número de Artículos

        // Variable para formato
        DecimalFormat formateador = new DecimalFormat("####.00");

        // Variable para el modelo de la tabla
        DefaultTableModel tblDatos = (DefaultTableModel) tblProductos.getModel();

        // Prepara los datos vacios iniciales
        Object[] oFila = new Object[20];

        // Capturo el Error
        // Verifico que haya habido resultados
        if (!lblCodigoProducto.getText().isEmpty()) {

//                    {
            // Obtengo los datos en el Objeto Fila
            oFila[INT_COL_CODIGO] = lblCodigoProducto.getText();
            oFila[INT_COL_NOMBRE] = lblNombreProducto.getText();
            oFila[INT_COL_PRECIO] = String.valueOf(cmbPrecio.getSelectedItem());

            String string = String.valueOf(cmbPrecio.getSelectedItem());
            String[] precios = string.split(" - ");
            String precio = precios[0]; // precio
         //   String nombre = precios[1]; // lista
           
            
            decPrecio = Double.valueOf(precio);
         
         
            if (txtPeso.getText() != null) {
                if (!txtPeso.getText().isEmpty()) {
                    decCantidad = Double.valueOf(txtPeso.getText());
                }

            }
            
            decCantidad = Double.valueOf(txtPeso.getText());

            oFila[INT_COL_CANTIDAD] = decCantidad;
            oFila[INT_COL_IMPORTE] = decPrecio * decCantidad;

            // Obtengo valores de Precio y Costo
            // Agrega el Dato
            //tblDatos.addRow(oFila);
            tblDatos.insertRow(0, oFila);

            // Coloca el Modelo de Nueva Cuenta
            tblProductos.setModel(tblDatos);
            txtCodigo.setForeground(Color.black);

            // Limpia el código al final
            txtCodigo.setText(null);

            lblCodigoProducto.setText(null);
            lblNombreProducto.setText(null);
            cmbPrecio.removeAllItems();
            txtPeso.setText(null);
            txtCodigo.setForeground(Color.black);
            //btnPesar.setEnabled(Boolean.FALSE);
            btnAgregarArticulo.setEnabled(Boolean.FALSE);

        } else {
            oFunc.SubSistemaMensaje("Producto No Existe");
            txtCodigo.setForeground(Color.red);
            txtCodigo.requestFocus();
        }

    }

    // Procedimiento para dar formato a la Tabla
    private void sbTablaProductosInicializa() {

        // Declaro un modelo de datos
        DefaultTableModel modelo = new DefaultTableModel();

        // Añadimos columnas al modelo de datos
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Importe");;

        // Coloca el Modelo en la Tabla
        tblProductos.setModel(modelo);

        // Directamente
        tblProductos.getColumn("Codigo").setWidth(150);
        tblProductos.getColumn("Codigo").setPreferredWidth(150);
        tblProductos.getColumn("Nombre").setWidth(450);
        tblProductos.getColumn("Nombre").setPreferredWidth(450);
        tblProductos.setFont(new java.awt.Font("Lucida Sans", 0, 14));

        // Alinear a la derecha las cantidades y precios
        DefaultTableCellRenderer cellAlinear = new DefaultTableCellRenderer();

        // Asignamos el Alineamiento Horizontal a la derecha
        cellAlinear.setHorizontalAlignment(SwingConstants.RIGHT);

        // Asignamos la Variable de celda de alineamiento a cada una de las columnas a alinear
        tblProductos.getColumnModel().getColumn(2).setCellRenderer(cellAlinear);
        tblProductos.getColumnModel().getColumn(3).setCellRenderer(cellAlinear);
        tblProductos.getColumnModel().getColumn(4).setCellRenderer(cellAlinear);

        // Color de los Encabezados
        tblProductos.getTableHeader().setBackground(Color.lightGray);
        tblProductos.getTableHeader().setForeground(Color.blue);
        tblProductos.getTableHeader().setFont(new java.awt.Font("Lucida Sans", 0, 14));

        // Remueve la Columna de la Vista
        tblProductos.removeColumn(tblProductos.getColumnModel().getColumn(4));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBuscar = new javax.swing.JPanel();
        btnPesar = new javax.swing.JButton();
        lblCancelada = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCodigoProducto = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        cmbPrecio = new javax.swing.JComboBox<>();
        lblCodigoProducto1 = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        btnAgregarArticulo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPeso = new javax.swing.JTextPane();
        pnlProductos = new javax.swing.JPanel();
        jLabelPortInfo = new javax.swing.JLabel();
        pnlTabla = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabelPortInfo1 = new javax.swing.JLabel();
        btnAceptar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventas");

        pnlBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 14))); // NOI18N

        btnPesar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnPesar.setText("Leer Balanza");
        btnPesar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPesar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesarActionPerformed(evt);
            }
        });

        lblCancelada.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        lblCancelada.setText(" ");

        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));
        txtCodigo.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        txtCodigo.setToolTipText("F1 Consulta Productos");
        txtCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese codigo"));
        txtCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCodigo.setMaximumSize(new java.awt.Dimension(32767, 32767));
        txtCodigo.setMinimumSize(new java.awt.Dimension(466, 82));
        txtCodigo.setNextFocusableComponent(txtPeso);
        txtCodigo.setOpaque(false);
        txtCodigo.setPreferredSize(new java.awt.Dimension(466, 82));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        lblCodigoProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblNombreProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cmbPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPrecioActionPerformed(evt);
            }
        });

        lblCodigoProducto1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCodigoProducto1.setText("Cod. Producto:");

        lblProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblProducto.setText("Producto:");

        lblPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPrecio.setText("Precio:");

        lblCantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCantidad.setText("Cantidad:");

        btnAgregarArticulo.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnAgregarArticulo.setText("Agregar");
        btnAgregarArticulo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarArticulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarArticulo.setNextFocusableComponent(txtCodigo);
        btnAgregarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarArticuloActionPerformed(evt);
            }
        });

        txtPeso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtPeso);

        javax.swing.GroupLayout pnlBuscarLayout = new javax.swing.GroupLayout(pnlBuscar);
        pnlBuscar.setLayout(pnlBuscarLayout);
        pnlBuscarLayout.setHorizontalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBuscarLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(cmbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnPesar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBuscarLayout.createSequentialGroup()
                        .addComponent(lblCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(lblCancelada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBuscarLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnAgregarArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
        );
        pnlBuscarLayout.setVerticalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addComponent(lblCancelada)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBuscarLayout.createSequentialGroup()
                        .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigoProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPesar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCodigo.getAccessibleContext().setAccessibleName("Código");
        txtCodigo.getAccessibleContext().setAccessibleDescription("Consulta Productos");

        pnlProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 14))); // NOI18N

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblProductosFocusGained(evt);
            }
        });
        pnlTabla.setViewportView(tblProductos);

        jLabelPortInfo1.setText("Puerto conectado:");

        btnAceptar2.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnAceptar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aceptar_venta.png"))); // NOI18N
        btnAceptar2.setText("Aceptar");
        btnAceptar2.setMaximumSize(new java.awt.Dimension(135, 57));
        btnAceptar2.setMinimumSize(new java.awt.Dimension(135, 57));
        btnAceptar2.setPreferredSize(new java.awt.Dimension(135, 57));
        btnAceptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProductosLayout = new javax.swing.GroupLayout(pnlProductos);
        pnlProductos.setLayout(pnlProductosLayout);
        pnlProductosLayout.setHorizontalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(jLabelPortInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPortInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnlProductosLayout.setVerticalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductosLayout.createSequentialGroup()
                            .addComponent(jLabelPortInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15))
                        .addComponent(jLabelPortInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAceptar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pnlBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
    
        // TODO add your handling code here:
        // Verifica fin de linea
        if (evt.getKeyCode() == INT_KEY_LF) {
            sbProductoBuscar();
            // Consume el caracter
            evt.consume();
        }
        // Verifica return
        if (evt.getKeyCode() == INT_KEY_RETURN) {
            sbProductoBuscar();
            // Consume el caracter
            evt.consume();
        }

        // Verifica si presionó la tecla F1
        if (evt.getKeyCode() == INT_KEY_F1) // 
        {
            // Inicializa el dato de consulta
            clsGlobales.sConsultaDato = "";

            // Coloca el Query de la Consulta
            clsConnection.sQuery = "select strProductoCodigo as Codigo, strProductoNombre as Nombre from 04tblProductos";

            // Declaro una variable instancia de la forma de consulta
            frmClase08b frmCodigos = new frmClase08b(null, true);
            frmCodigos.setTitle("Consulta de Códigos");
            frmCodigos.setVisible(true);

            // Despliega el Dato Seleccionado
            txtCodigo.setText(clsGlobales.sConsultaDato);

            sbProductoBuscar();
            // Consume el caracter
            evt.consume();

        }


    }//GEN-LAST:event_txtCodigoKeyPressed
    /**/

    private void btnPesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesarActionPerformed

        AperturarPuertoSerial();

    }//GEN-LAST:event_btnPesarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void cmbPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPrecioActionPerformed

    private void btnAgregarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarArticuloActionPerformed
            String string = String.valueOf(cmbPrecio.getSelectedItem());
            String[] precios = string.split(" - ");
            String precio = precios[0]; // precio
        if (precio.equals("0.00")){
            oFunc.SubSistemaMensaje("El articulo no tiene precio.");
            txtCodigo.requestFocus();
        }else if (txtPeso.getText().isEmpty() ) {
            oFunc.SubSistemaMensaje("Ingrese el peso para agregar el articulo.");
            txtPeso.requestFocus();
        }else{
             sbProductoAgrega();
             txtCodigo.requestFocus();
             
        }
    }//GEN-LAST:event_btnAgregarArticuloActionPerformed

    private void tblProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblProductosFocusGained
        // TODO add your handling code here:
        txtCodigo.requestFocus();
    }//GEN-LAST:event_tblProductosFocusGained

    private void btnAceptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar2ActionPerformed
        // TODO add your handling code here:
        
          DefaultTableModel tblDatos = (DefaultTableModel) tabla.getModel();

        Object[] oFila = new Object[20];
        int iFila;
        for (iFila = 0; iFila < tblProductos.getRowCount(); iFila++) {
            // Obtengo los datos en el Objeto Fila
            oFila[INT_COL_CODIGO] = tblProductos.getModel().getValueAt(iFila, INT_COL_CODIGO).toString();
            oFila[INT_COL_NOMBRE] = tblProductos.getModel().getValueAt(iFila, INT_COL_NOMBRE).toString();
            oFila[INT_COL_PRECIO] = tblProductos.getModel().getValueAt(iFila, INT_COL_PRECIO).toString();
            oFila[INT_COL_CANTIDAD] = tblProductos.getModel().getValueAt(iFila, INT_COL_CANTIDAD).toString();
            //       oFila[INT_COL_IMPORTE]= tblProductos.getModel().getValueAt(iFila, INT_COL_IMPORTE).toString();
            // Agrega el Dato
            tblDatos.insertRow(iFila, oFila);

            // Coloca el Modelo de Nueva Cuenta
            tabla.setModel(tblProductos.getModel());
            
           
        }

        this.setVisible(false);
        this.dispose();
        
        try {
            serialPort.closePort();
        } catch (SerialPortException ex) {
            Logger.getLogger(frmClase17.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnAceptar2ActionPerformed

    private void txtPesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoKeyPressed

    private void txtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyTyped
        // TODO add your handling code here:
                    char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE)
                || (vChar == KeyEvent.VK_PERIOD))) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtPesoKeyTyped

    // Rutina para Imprimir el Ticket
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
            java.util.logging.Logger.getLogger(frmClase09.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClase09.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClase09.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClase09.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmClase09 dialog = new frmClase09(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAceptar2;
    private javax.swing.JButton btnAgregarArticulo;
    private javax.swing.JButton btnPesar;
    private javax.swing.JComboBox<String> cmbPrecio;
    private javax.swing.JLabel jLabelPortInfo;
    private javax.swing.JLabel jLabelPortInfo1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCancelada;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCodigoProducto;
    private javax.swing.JLabel lblCodigoProducto1;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JScrollPane pnlTabla;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextPane txtPeso;
    // End of variables declaration//GEN-END:variables

}
