
import java.awt.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class frmClase09 extends javax.swing.JDialog {

     // Constantes para las Columnas
    static final int INT_COL_CODIGO = 0;
    static final int INT_COL_NOMBRE = 1;
    static final int INT_COL_PRECIO = 2;
    static final int INT_COL_CANTIDAD = 3;
    static final int INT_COL_IMPORTE = 4;
    static final int INT_COL_EXISTENCIA = 5;
    static final int INT_COL_COSTO = 6;
    
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
    clsFunciones  oFunc = new clsFunciones();
    clsConnection oConn = new clsConnection();
    
    // Variable para la operación de la venta
    boolean bAgruparProductos;
    boolean bVerificarExistencias;
    boolean bMensajesExito;    
    String  sTextoFinalTicket;
    
    /**
     * Creates new form frmClase09
     */
    public frmClase09(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
         
        // Maximiza la Ventana
       // this.setSize(this.getToolkit().getScreenSize()); 
        
       this.setLocationRelativeTo(null);
       
        // Invisibiliza los label
        //lblUtilidad.setVisible(false);
        lblCancelada.setVisible(false);
        
        // Inicializa
        sbInicializa();
        
    }
    
    private void sbVentaParametros()
    {
       
        // Variable para el Query
        String sQuery;       
        
        // Prepara el Query
        sQuery ="Select * from 07tblparametros";
                
        //Ejecuta el Query
        oConn.FnBoolQueryExecute(sQuery);
        
        // Capturo el Error
        try {
            
            // Verifico que haya habido resultados
            if (oConn.setResult.next())
            {
        
                // Obtiene si agrupa productos
                if  (oConn.setResult.getInt("intAgruparProductos")==1)
                    bAgruparProductos = true;
                else
                    bAgruparProductos = false;
                
                // Obtiene si vende sin existencias
                if  (oConn.setResult.getInt("intVerificarExistencias")==1)
                    bVerificarExistencias = true;
                else
                    bVerificarExistencias = false;

                // Obtiene si vende sin existencias
                if  (oConn.setResult.getInt("intMensajesExito")==1)
                    bMensajesExito=true;
                else
                    bMensajesExito = false;
                
                // Obtiene si vende sin existencias
                sTextoFinalTicket = oConn.setResult.getString("strTicketInfoFinal");
                    

            }
        } catch (SQLException ex) {
            oFunc.SubSistemaMensaje("sbVentaParametros:"+ex.getMessage().toString());
        }
        
    
        
    }
    
    // Busca dato en la tabla
    private boolean fnCalcularTotales()
    {
        // Variables para Fila y Columns
        int fil;
        String sDato;
        String sPrecio;
        String sCantidad;
        boolean bResult=false;
        int iProductos = 0 ;
        double decTotal = 0;
        double decUtilidad = 0;
        
        // Variable para formato
        DecimalFormat formateador = new DecimalFormat("####.00");
       
        
        // Pasa a mayúsculas
        sDato =  ""; //txtCodigo.getText().trim().toUpperCase();
        
        if (tblProductos.getRowCount() > 0) {            

            // Ciclo para buscar en la Venta
            for(fil = 0; fil < tblProductos.getRowCount();fil++)
            {
                //Obtiene dato contenido en una celda de la tabla
                String value = (String)tblProductos.getValueAt(fil, 0);

                // lo pasa a Mayúsculas
                value = value.toUpperCase();

                // Aqui verifica si encuentra el dato
                if(value.lastIndexOf(sDato)>=0)
                {     
    
                    // Obtengo la Cantidad y el Precio
                    sCantidad = tblProductos.getModel().getValueAt(fil,INT_COL_CANTIDAD).toString().replace(",", ".");
                    sPrecio = tblProductos.getModel().getValueAt(fil,INT_COL_PRECIO).toString().replace(",", ".");

                    // Cantidad
                    iProductos = tblProductos.getRowCount();
                    //tblProductos.getModel().setValueAt(iProductos,fil, INT_COL_CANTIDAD);
                    
                    // Productos
                   // iProductos = Double.valueOf(lblProductos.getText()) + 1;
                    lblProductos.setText(String.valueOf(iProductos));

                    // Importe en la Venta
                    decTotal = Double.valueOf(tblProductos.getModel().getValueAt(fil,INT_COL_IMPORTE).toString().replace(",", "."));    
                    //tblProductos.getModel().setValueAt(formateador.format(decTotal),fil,INT_COL_IMPORTE);
                    
                    // El Total
                    decTotal = decTotal + Double.valueOf(lblTotal.getText().replace(",", "."));
                    
                    lblTotal.setText(formateador.format(decTotal));
                    bResult = true;
                }

            }    
        }
        
        // Retorna el Valor
        return bResult;
        
    }
    
    private void sbInicializa()
    {
        
        btnSeleccionProductos.setEnabled(Boolean.TRUE);
        // Variable para la fecha
        Date dateHoy = new Date();
    
        // Variable para dar formato
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        
        // Inicializa Folio y Fecha
        btnFecha.setText(formato.format(dateHoy));
        
        // Coloca el Costo
       // lblUtilidad.setText("0");
        lblProductos.setText("0");
        lblTotal.setText("0.00");
        
        //Habilita Controles
        sbHabilitaVenta(false);
        
        // Inicializa tabla de Productos
        sbTablaProductosInicializa();
        
        // Obtiene los parámetros de Venta
        sbVentaParametros();
        
    }
    
    // Habilita la Venta
    private void sbHabilitaVenta(boolean bVenta)
    {
        
        // Habilitados en Venta        
        tblProductos.setEnabled(!bVenta);
       // btnImprimir.setEnabled(bVenta);
       // btnCalcularTotales.setEnabled(bVenta);
        btnSeleccionProductos.setEnabled(!bVenta);

    }
    // Función para obtener el Folio de Venta
    private int fnIntGetFolioVenta()
    {
        // Variable para el Resultado
        int iResult=0;

        // Variable para el Query
        String sQuery;
        
        
        // Prepara el Query
        sQuery ="Select intFolioVenta from 05tblfolios";
                
        //Ejecuta el Query
        oConn.FnBoolQueryExecute(sQuery);
        
        // Capturo el Error
        try {
            
            // Verifico que haya habido resultados
            if (oConn.setResult.next())
            {
        
                // Obtiene el Folio Siguiente
                iResult = oConn.setResult.getInt("intFolioVenta");

            }
        } catch (SQLException ex) {
            oFunc.SubSistemaMensaje("fnIntGetFolioVenta:"+ex.getMessage().toString());
        }
        
        // Retorna el Resultado
        return iResult;
        
    }
    
    

    
    // Procedimiento para dar formato a la Tabla
    private void sbTablaProductosInicializa()
    {
        
        // Declaro un modelo de datos
        DefaultTableModel modelo = new DefaultTableModel();      
                
        // Añadimos columnas al modelo de datos
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Importe");
           
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
        tblProductos.getColumnModel().getColumn(0).setCellRenderer(cellAlinear);
        tblProductos.getColumnModel().getColumn(1).setCellRenderer(cellAlinear);
        tblProductos.getColumnModel().getColumn(2).setCellRenderer(cellAlinear);
        tblProductos.getColumnModel().getColumn(3).setCellRenderer(cellAlinear);
        tblProductos.getColumnModel().getColumn(4).setCellRenderer(cellAlinear);
       
       
        // Color de los Encabezados
        tblProductos.getTableHeader().setBackground(Color.lightGray);
        tblProductos.getTableHeader().setForeground(Color.blue);
        tblProductos.getTableHeader().setFont(new java.awt.Font("Lucida Sans", 0, 14)); 
        
        
        // Remueve la Columna de la Vista
      //  tblProductos.removeColumn(tblProductos.getColumnModel().getColumn(6));
                
    }
    
    
    // Función para Grabar el Encabezado de la Venta
    private boolean fnBoolGrabaVentaEncabezado()
    {
        
        String string = clsGlobales.codCliente;
        String[] parts = string.split("-");
        String codigo = parts[0]; // valor1
        String nombre = parts[1]; // valor2
        // Para los resultados
        boolean bResult = false;
                
        // Para la sentencia Sql
        String strSqlStmt; 
        
        // Query para actualizar el Folio
        strSqlStmt = "Insert into 08tblventas ";
        strSqlStmt = strSqlStmt + "(intVentaFolio,";
	strSqlStmt = strSqlStmt + "dateVentaFecha,";
	strSqlStmt = strSqlStmt + "intVentaProductos,";
	strSqlStmt = strSqlStmt + "decVentaImporte,";
	strSqlStmt = strSqlStmt + "decVentaUtilidad,";
	strSqlStmt = strSqlStmt + "strVentaFormaPago,";
	strSqlStmt = strSqlStmt + "strVentaCancelada,";
	strSqlStmt = strSqlStmt + "strVentaReferencia)";
        strSqlStmt = strSqlStmt + "Values ";        
        //strSqlStmt = strSqlStmt + "("+String.valueOf(fnIntGetFolioVenta())+",";    //ojo    
        strSqlStmt = strSqlStmt + "("+fnIntGetFolioVenta()+",";    //ojo    
        strSqlStmt = strSqlStmt + "'"+btnFecha.getText()+"',";
        strSqlStmt = strSqlStmt + lblProductos.getText()+",";
        strSqlStmt = strSqlStmt + lblTotal.getText().replace(",", ".")+",";
        // La utilidad esta desplegada momentaneamente en la forma de pago
        strSqlStmt = strSqlStmt + "1"+","; 
        strSqlStmt = strSqlStmt + "'"+clsGlobales.sFormaPago+"',"; 
        strSqlStmt = strSqlStmt + "'',"; 
        strSqlStmt = strSqlStmt + "'"+codigo+"')"; 
        
        // Ejecuta la Sentencia
        if (oConn.FnBoolQueryExecuteUpdate(strSqlStmt))
            bResult = true;
        
        // Retorna el Valor
        return bResult;
        
        
    }
// Función para obtener el Folio
    private int fnIntGetFolioInventario()
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
            oFunc.SubSistemaMensaje("fnIntGetFolioInventario:"+ex.getMessage().toString());
        }
        
        // Retorna el Resultado
        return iResult;
        
    }
    
  
    
    // Función para grabar el Detalle de la Venta
    private boolean fnBoolGrabaVentaDetalle()
    {
        // Para los resultados
        boolean bResult = true;
       
        clsGlobales.intFolio = fnIntGetFolioVenta();
        // Variable para las filas de la Tabla de Productos
        int iFila;
        
        // Variables para los diferentes datos
        String sCodigo, sNombre, sPrecio, sCantidad, sCosto, sImporte;
        
        // Para la sentencia Sql
        String strSqlStmt; // Para el Query
        
        // Ciclo para grabar el detalle de la venta
        for(iFila = 0; iFila < tblProductos.getRowCount();iFila++)
        {
            //Obtiene dato contenido en una celda de la tabla
            sCodigo = tblProductos.getModel().getValueAt(iFila, INT_COL_CODIGO).toString();
            sNombre = tblProductos.getModel().getValueAt(iFila, INT_COL_NOMBRE).toString();
            
            String string = tblProductos.getValueAt(iFila, INT_COL_PRECIO).toString();
            String[] precios = string.split(" - ");
            String precio = precios[0]; // precio
            
            sPrecio = precio;
            sCantidad = tblProductos.getModel().getValueAt(iFila, INT_COL_CANTIDAD).toString();
            sImporte = tblProductos.getModel().getValueAt(iFila, INT_COL_IMPORTE).toString();            
           
                    // Prepara Query para grabar venta detalle
                    strSqlStmt = " Insert into 09tblventasdetalle ";
                    strSqlStmt = strSqlStmt + "(intVentaFolio,";
                    strSqlStmt = strSqlStmt + " strProductoCodigo,";
                    strSqlStmt = strSqlStmt + " strProductoNombre,";
                    strSqlStmt = strSqlStmt + " intVentaCantidad,";
                    strSqlStmt = strSqlStmt + " decProductoPrecio,";
                    strSqlStmt = strSqlStmt + " decProductoCosto)";
                    strSqlStmt = strSqlStmt + " Values (";
                    strSqlStmt = strSqlStmt + clsGlobales.intFolio +",";
                    strSqlStmt = strSqlStmt + "'"+sCodigo+"',";
                    strSqlStmt = strSqlStmt + "'"+sNombre+"',";
                    strSqlStmt = strSqlStmt + sCantidad+",";
                    strSqlStmt = strSqlStmt + sPrecio.replace(",", ".")+",";
                    strSqlStmt = strSqlStmt + sImporte.replace(",", ".")+")";
                    
                    // Ejecuta la Sentencia
                    if ( ! oConn.FnBoolQueryExecuteUpdate(strSqlStmt))
                    {
                        bResult = false;
                        break;
                    }
                    
        
            
        }     
        
        // Retorna el Valor
        return bResult;
        
    }
    
    
    // Función para actualizar el Folio
    private boolean fnBoolActualizaFolioVenta()
    {
        // Para controlar el Resultado
        boolean bResult = false;
        
        // Para la sentencia Sql
        String strSqlStmt; // Para el Query
        
        // Query para actualizar el Folio
        strSqlStmt = "Update 05tblFolios set intFolioVenta = intFolioVenta + 1";
        
        // Ejecuta la Sentencia
        if (oConn.FnBoolQueryExecuteUpdate(strSqlStmt))
            bResult = true;
        
        // Retorna el Resultado
        return bResult;
        
    }
    
    
   
       // Función para actualizar el Folio
    private boolean fnBoolActualizaCuentaCliente()
    {
        
        
        String cliente = clsGlobales.codCliente;
        String[] parts = cliente.split("-");
        String codigo = parts[0]; // 123
        String nombre = parts[1]; // 654321
        
        
        String debe = "";
        String saldo = "";
        String aCuenta = "";
       
        String sQuery1 = "";
        sQuery1 = "select decSaldo, decDebe, decAFavor from test.13tbldetallectacte where intClienteCodigo =" + codigo;

        //Ejecuta el Query
        oConn.FnBoolQueryExecute(sQuery1);
        
        // Capturo el Error
        try {

            // Verifico que haya habido resultados
            while (oConn.setResult.next())
            {
                // Obtengo los datos en el Objeto combo
                debe = oConn.setResult.getString("decDebe") ;
                saldo = oConn.setResult.getString("decSaldo");
                aCuenta = oConn.setResult.getString("decAFavor");
            }
            
        // Cierro los Resultados
        oConn.setResult.close();
                
        } catch (SQLException ex) {
            oFunc.SubSistemaMensaje("obtenerCuentaCorriente:"+ex.getMessage().toString());
        }
        
        
        
        // Para controlar el Resultado
        boolean bResult = false;
        
        // Para la sentencia Sql
        String strSqlStmt; // Para el Query
        
        Date dateHoy = new Date();
        // Variable para dar formato
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        // Inicializa Folio y Fecha
       // btnFecha.setText(formato.format(dateHoy));
//            String valorrestan = "";
//            double valor = Double.valueOf(clsGlobales.cantRecibida) - Double.valueOf(clsGlobales.sTotalVenta);
//            if (clsGlobales.sTotalVenta.equals(clsGlobales.cantRecibida)){
//                valor = 0;
//            }
//            
//            if(Double.valueOf(clsGlobales.vuelto) > Double.valueOf(clsGlobales.sTotalVenta)){
//                valor = Double.valueOf(clsGlobales.sTotalVenta) - Double.valueOf(clsGlobales.vuelto);
//            }
            
            double saldoAnterior = Double.valueOf(aCuenta) - Double.valueOf(debe);
            
            if (saldoAnterior == 0){
                saldoAnterior = Double.valueOf(aCuenta);
            }
            
            
            clsGlobales.saldoAntesDeGuardar = saldo;
            
            debe = String.valueOf(Double.valueOf(clsGlobales.sTotalVenta.replace(",", ".")) - Double.valueOf(clsGlobales.cantRecibida.replace(",", ".")));
            
        // Query para actualizar el Folio
        if (clsGlobales.cantRecibida.equals("0")){
            strSqlStmt = "Update 13tbldetallectacte set decSaldo = "+ (Double.valueOf(clsGlobales.sTotalVenta.replace(",", ".")) - Double.valueOf(clsGlobales.cantRecibida) + Double.valueOf(clsGlobales.sReferencia) ) + ", decDebe = " 
                    + Double.valueOf(clsGlobales.cantRecibida.replace(",", ".")) +" , decAFavor = "+ Double.valueOf(clsGlobales.sTotalVenta.replace(",", ".")) +", datFecha = '"+  formato.format(dateHoy) 
                    +"'" + " where intClienteCodigo=" + codigo ;
        } else {
            strSqlStmt = "Update 13tbldetallectacte set decSaldo = "+ (Double.valueOf(clsGlobales.sTotalVenta.replace(",", ".")) - Double.valueOf(clsGlobales.cantRecibida) + Double.valueOf(clsGlobales.sReferencia) ) + ", "
                    + " decDebe = "+ debe +", datFecha = '"+  formato.format(dateHoy) +"'" +" where intClienteCodigo=" + codigo ;
        }
        // Ejecuta la Sentencia
        if (oConn.FnBoolQueryExecuteUpdate(strSqlStmt))
            bResult = true;
        
        // Retorna el Resultado
        return bResult;
        
    }
    
    // Procedimiento para grabar una Venta
    private void sbGrabaVenta()
    {
        
        // Obtengo la fecha y hora de nueva cuenta
        Date dateHoy = new Date();
    
        // Variable para dar formato
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        // Inicializa Folio y Fecha
        btnFecha.setText(formato.format(dateHoy));
        
        // Coloca el Folio de Nueva Cuenta
        //spnTicket.setValue(fnIntGetFolioVenta());
        
        // Para controlar la Transacción
        boolean bCommit=false;
        
        // Inicia la transacción colocando el commit a false
        oConn.SubAutoCommit(false);
        
        // Intenta ejecutar cada uno de los procesos
        if (fnBoolGrabaVentaEncabezado())
            if (fnBoolGrabaVentaDetalle())
                if (fnBoolActualizaFolioVenta())
                    bCommit = true;
        
        // Verifica si debe hacer commit
        if (bCommit)
        {
            // Realiza la confirmación de la transaccion
            fnBoolActualizaCuentaCliente();

             sbImprimeTicketJasper();
            
            
            oConn.SubCommit();
        }
        else
            oConn.SubRollBack();
        
        // Inicializa despues de grabar
        sbInicializa();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTIcket = new javax.swing.JPanel();
        btnFecha = new javax.swing.JButton();
        lblCancelada = new javax.swing.JLabel();
        btnSeleccionProductos = new javax.swing.JButton();
        pnlProductos = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        pnlTabla = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        lblProductos = new javax.swing.JLabel();
        lblImporteLetras = new javax.swing.JLabel();
        lbl$ = new javax.swing.JLabel();
        btnCobrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventas");

        pnlTIcket.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12))); // NOI18N

        btnFecha.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnFecha.setForeground(new java.awt.Color(0, 102, 204));
        btnFecha.setText("13/11/2019  00:00");
        btnFecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaActionPerformed(evt);
            }
        });

        lblCancelada.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        lblCancelada.setText(" ");

        btnSeleccionProductos.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnSeleccionProductos.setText("Ingresar Productos");
        btnSeleccionProductos.setToolTipText("");
        btnSeleccionProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSeleccionProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSeleccionProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTIcketLayout = new javax.swing.GroupLayout(pnlTIcket);
        pnlTIcket.setLayout(pnlTIcketLayout);
        pnlTIcketLayout.setHorizontalGroup(
            pnlTIcketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTIcketLayout.createSequentialGroup()
                .addGap(1072, 1072, 1072)
                .addComponent(lblCancelada, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTIcketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSeleccionProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlTIcketLayout.setVerticalGroup(
            pnlTIcketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTIcketLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTIcketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblCancelada))
        );

        pnlProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12))); // NOI18N

        lblTotal.setFont(new java.awt.Font("Lucida Sans", 0, 50)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 153, 51));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0.00");
        lblTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Total de Venta"));
        lblTotal.setPreferredSize(new java.awt.Dimension(135, 82));
        lblTotal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblTotalPropertyChange(evt);
            }
        });

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
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        pnlTabla.setViewportView(tblProductos);

        lblProductos.setFont(new java.awt.Font("Lucida Sans", 0, 42)); // NOI18N
        lblProductos.setForeground(new java.awt.Color(0, 102, 204));
        lblProductos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProductos.setText("0");
        lblProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("Articulos"));
        lblProductos.setPreferredSize(new java.awt.Dimension(42, 82));

        lblImporteLetras.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        lblImporteLetras.setForeground(new java.awt.Color(0, 102, 204));
        lblImporteLetras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImporteLetras.setText("Cero Pesos 00/100");
        lblImporteLetras.setBorder(javax.swing.BorderFactory.createTitledBorder("Importe en Letra"));

        lbl$.setFont(new java.awt.Font("Lucida Sans", 0, 48)); // NOI18N
        lbl$.setForeground(new java.awt.Color(0, 153, 51));
        lbl$.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl$.setText("$");
        lbl$.setPreferredSize(new java.awt.Dimension(135, 82));

        btnCobrar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnCobrar.setText("Cobrar");
        btnCobrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCobrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnCancelar.setText("Borrar Listado");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProductosLayout = new javax.swing.GroupLayout(pnlProductos);
        pnlProductos.setLayout(pnlProductosLayout);
        pnlProductosLayout.setHorizontalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductosLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lbl$, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImporteLetras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTabla, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnlProductosLayout.setVerticalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImporteLetras)
                .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(pnlProductosLayout.createSequentialGroup()
                                .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl$, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlProductosLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 11, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        lblProductos.getAccessibleContext().setAccessibleName("00000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTIcket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTIcket, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        // TODO add your handling code here:
        if (tblProductos.getRowCount() == 0)
            oFunc.SubSistemaMensaje("Debe ingresar por lo menos 1 producto");
        else
        {
            
            //fnCalcularTotales();
            
            // Coloca el total de la venta
            clsGlobales.sTotalVenta = lblTotal.getText().replace(",", ".");
            clsGlobales.bVentaRealizada=false;
            
            // Crea la instancia de la Forma
            frmClase09b frmCobro = new frmClase09b(null,true);
            
            // Coloca los datos
            frmCobro.setVisible(true);

            // Verifica que la venta se haya realizado
            if (clsGlobales.bVentaRealizada)
                sbGrabaVenta();
            else
                sbInicializa();
        
        }    
        
        btnSeleccionProductos.setEnabled(Boolean.TRUE);
            
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void sbCancelaVenta()
    {
                
        // Para controlar la Transacción
        boolean bCommit=false;
        
        // Inicia la transacción colocando el commit a false
        oConn.SubAutoCommit(false);
        
        // Verifica si debe hacer commit
        if (bCommit)
        {
            oConn.SubCommit();
            if (bMensajesExito)
               oFunc.SubSistemaMensaje("Se ha Cancelado la Venta Correctamente");
        }
        else
            oConn.SubRollBack();

        // Inicializa despues de grabar
        sbInicializa();  
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        if (!btnSeleccionProductos.isEnabled()){
            sbInicializa();
        }else{
            sbInicializa();
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    // Obtiene le encabezado del ticket a Imprimir
    void sbGetDatosEmpresa(String sDatos[])
    {        
        // Variable para el Query
        String sQuery;
       
        // Prepara el Query
        sQuery ="Select * from 10tblEmpresa";
                
        //Ejecuta el Query
        oConn.FnBoolQueryExecute(sQuery);
        
        // Capturo el Error
        try {
            // Verifico que haya habido resultados
            if (oConn.setResult.next())
            {
        
                // Obtiene los datos en el vector
                sDatos[INT_COL_EMPRESA] = oConn.setResult.getString("strEmpresaNombre");
                sDatos[INT_COL_SUCURSAL] = oConn.setResult.getString("strEmpresaSucursal");
                sDatos[INT_COL_DIRECCION1] = oConn.setResult.getString("strEmpresaDireccion1");
                sDatos[INT_COL_DIRECCION2] = oConn.setResult.getString("strEmpresaDireccion2");
                sDatos[INT_COL_TELEFONOS] = oConn.setResult.getString("strEmpresaTelefonos");
                sDatos[INT_COL_RFC] = oConn.setResult.getString("strEmpresaRfc");

            }
        } catch (SQLException ex) {
            oFunc.SubSistemaMensaje("sbGetDatosEmpresa:"+ex.getMessage().toString());
        }        
    }
    
    
    
    void sbImprimeTicketJasper() {

        int iFila;
        Frame f = new Frame();
        String cliente = clsGlobales.codCliente;
        String[] parts = cliente.split("-");
        String codigo = parts[0]; // 123
        String nombre = parts[1]; // 654321

        Date dateHoy = new Date();
        // Variable para dar formato
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        
        String debe = "";
        String saldo = "";
        String aFavor = "";
        
        
        String sQuery = "";
        sQuery = "select decSaldo, decDebe, decAFavor from test.13tbldetallectacte where intClienteCodigo =" + codigo;

        //Ejecuta el Query
        oConn.FnBoolQueryExecute(sQuery);
        
        // Capturo el Error
        try {

            // Verifico que haya habido resultados
            while (oConn.setResult.next())
            {
                // Obtengo los datos en el Objeto combo
                debe = oConn.setResult.getString("decDebe") ;
                saldo = oConn.setResult.getString("decSaldo");
                aFavor = oConn.setResult.getString("decAFavor");
            }
            
        // Cierro los Resultados
        oConn.setResult.close();
                
        } catch (SQLException ex) {
            oFunc.SubSistemaMensaje("obtenerCuentaCorriente:"+ex.getMessage().toString());
        }
        
        DecimalFormat formateador = new DecimalFormat("####.00");
        System.out.println("valor saldo: " + saldo + " - " + "valor cantrecibida: " +clsGlobales.cantRecibida);
        
        String valorcerodecimal = "0.00";
        String valorcero = "0";
        
        /*
        if (clsGlobales.saldoAntesDeGuardar.equals(valorcerodecimal) && clsGlobales.cantRecibida.equals(valorcero)){
          //  debe = clsGlobales.sTotalVenta;
            System.out.println("entró a la condicion");
          //  saldo = valorcerodecimal;
        }else{
            debe = String.valueOf(formateador.format(Double.valueOf(clsGlobales.saldoAntesDeGuardar) - Double.valueOf(clsGlobales.cantRecibida) + Double.valueOf(aFavor)));
            System.out.println("no entró a la condicion");
        }
        */
        debe = String.valueOf(Double.valueOf(clsGlobales.sTotalVenta.replace(",", ".")) - Double.valueOf(clsGlobales.cantRecibida) + Double.valueOf(clsGlobales.sReferencia));
        
        //debe.replace("-", "");
        
        Map parameters = new HashMap();

        parameters.put("ticket", clsGlobales.intFolio);
        parameters.put("saldoAnterior", clsGlobales.sReferencia);
        parameters.put("pago", clsGlobales.cantRecibida);
        //parameters.put("aCuenta", aFavor.replace(".", ","));
        parameters.put("restan", debe.replace(".", ","));
        parameters.put("cliente", nombre);
        parameters.put("tipo", "ORIGINAL");
      
        try {
            // Carga el archivo jasper al objeto JasperReport
            JasperReport myReport = (JasperReport) JasperCompileManager.compileReport("rptVentas2.jrxml");
            // JasperReport myReport = (JasperReport) JRLoader.("reporte_de_ventas.jasper");
            // Genera el reporte usando el objeto JasperReport e indicando la conexion
            JasperPrint myPrint = JasperFillManager.fillReport(myReport, parameters, clsConnection.oConnection);

            // Visualiza el Reporte
            //JasperViewer.viewReport(myPrint);
            JasperPrintManager.printReport(myPrint, false);
            
                    Map parameters2 = new HashMap();

        parameters2.put("ticket", clsGlobales.intFolio);
        parameters2.put("saldoAnterior", clsGlobales.sReferencia);
        parameters2.put("pago", clsGlobales.cantRecibida);
        //parameters2.put("aCuenta", aFavor.replace(".", ","));
        parameters2.put("restan", debe.replace(".", ","));
        parameters2.put("cliente", nombre);
        parameters2.put("tipo", "COPIA");
        
            myPrint = JasperFillManager.fillReport(myReport, parameters2, clsConnection.oConnection);
            JasperPrintManager.printReport(myPrint, false);
            // pg.dispose();
            // pjob.end(); 
        } catch (JRException ex) {
            Logger.getLogger(frmClase04b.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Se hace que la impresora termine el trabajo y escupa la página
    }
        
 
    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked

        // TODO add your handling code here:
        int iProductos ;
        int iRow;
        double decTotal = Double.valueOf(lblTotal.getText().replace(",", "."));
        String sImporte;

        // Variable para formato
        DecimalFormat formateador = new DecimalFormat("####.00");

        // Obtiene la Cantidad y el Precio para disminuir del importe
        // y del Total
        iRow = tblProductos.getSelectedRow();

        // Variable para el modelo de la tabla
        DefaultTableModel tblDatos = (DefaultTableModel) tblProductos.getModel();

        // Obtengo el precio la cantidad el importe y el costo
        sImporte =  tblDatos.getValueAt(iRow,INT_COL_IMPORTE).toString();
  
        // Actualiza el Numero de Productos
        iProductos = tblProductos.getRowCount() ;
        lblProductos.setText(String.valueOf(iProductos));

        // El Total
        decTotal = decTotal - Double.valueOf(sImporte);
     //   decUtilidad = Double.valueOf(lblUtilidad.getText()) - ((Double.valueOf(sPrecio) - Double.valueOf(sCosto)) *  Double.valueOf(sCantidad));

        // Este if valida que no sea 0 la cantidad
        if (iProductos>0)
        {
            lblTotal.setText(formateador.format(decTotal));
          //  lblUtilidad.setText(formateador.format(decUtilidad));
        }

        else
        {
            lblTotal.setText("0.00");
       //     lblUtilidad.setText("0.00");
        }

        // Elimina el Row
        tblDatos.removeRow(iRow);
        tblProductos.setModel(tblDatos);
    }//GEN-LAST:event_tblProductosMouseClicked

    private void tblProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblProductosFocusGained
        // TODO add your handling code here:
   //     txtCodigo.requestFocus();
    }//GEN-LAST:event_tblProductosFocusGained

    private void lblTotalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblTotalPropertyChange

        // TODO add your handling code here:
        String sEntero;
        String sDecimal;
        int iLongitud;
        int iEntero;

        // Obtengo la Longitud
        iLongitud = lblTotal.getText().length();

        // Obtengo la parte entera
        sEntero = lblTotal.getText().substring(0,iLongitud-3);
        iEntero = Integer.valueOf(sEntero.trim());

        // Obtengo la parte decimal
        sDecimal = lblTotal.getText().substring(iLongitud-2)+"/100.";
        lblImporteLetras.setText(oFunc.getStringOfNumber(iEntero)+ " PESOS "+sDecimal);

    }//GEN-LAST:event_lblTotalPropertyChange

    private void btnSeleccionProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionProductosActionPerformed
         sbInicializa();
         btnSeleccionProductos.setEnabled(Boolean.FALSE);
        // TODO add your handling code here:
        // Declaro la Variable de la Forma de Procesos
        // Declaro la variable para la forma de ABC Productos
        frmClase17 frmProductosABC = new frmClase17(null, true, tblProductos);

        // Muestra la Forma
        frmProductosABC.setTitle(frmProductosABC.getTitle()+"-Insertar");
        frmProductosABC.setVisible(true);

        fnCalcularTotales();
        //   btnCalcularTotales.setEnabled(Boolean.TRUE);
        //  btnImprimir.setEnabled(Boolean.TRUE);

    }//GEN-LAST:event_btnSeleccionProductosActionPerformed

    private void btnFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFechaActionPerformed

    
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnFecha;
    private javax.swing.JButton btnSeleccionProductos;
    private javax.swing.JLabel lbl$;
    private javax.swing.JLabel lblCancelada;
    private javax.swing.JLabel lblImporteLetras;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JPanel pnlTIcket;
    private javax.swing.JScrollPane pnlTabla;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}
