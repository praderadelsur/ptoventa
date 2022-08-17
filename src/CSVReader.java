/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CSVReader {

    public static void actualizarTablaProductos(clsConnection oConn) {

        //clsConnection oConn = new clsConnection();
        //oConn.FnBoolConnectionOpen("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "root", "");
             
        String csvFile = ""; /* = "C:/productos_imp.csv"; */
        String sqlStmt;
        String strPuerto = "";
        
         // Prepara Variable para realizar el Query
        sqlStmt = "Select * from 16tblconfigarchivoimportar";
        
        if (oConn.FnBoolQueryExecute(sqlStmt))
        {
            try 
            {
                // Verifica resultados
                 while (oConn.setResult.next())
                 {
                     // Obtiene los datos de la Consulta
                     strPuerto = oConn.setResult.getString ("strRuta");
                 }                 
                  
                 csvFile = (strPuerto);

                 // Cierra Resultados
                 oConn.setResult.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(frmClase05.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //String csvFile = "C:/productos_imp.csv";
        String line = "";
        String cvsSplitBy = ",";

        String strSqlStmt = "";
        strSqlStmt =  "delete from test.04tblproductos";
        oConn.FnBoolQueryExecuteUpdate(strSqlStmt); 
        
        
        String[] productos = new String[0];
        
        int cont = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            strSqlStmt = "";
            while ((line = br.readLine()) != null) {
                if (cont > 0) {
                // use comma as separator
                    productos = line.split(cvsSplitBy);
                    if (productos[0] != null){
                                
                                strSqlStmt  = "insert into test.04tblproductos (strProductoCodigo, strProductoNombre, strProductoDescripcion, "
                                        + "decProductoPrecio1, decProductoPrecio2, decProductoPrecio3, decProductoPrecio4, decProductoPrecio5, "
                                        + "decProductoPrecio6, decProductoPrecio7, decProductoPrecio8, decProductoPrecio9, decProductoPrecio10)";
                                strSqlStmt += " values ("+productos[0]+",";
                                strSqlStmt += " '"+productos[1]+"',";
                                strSqlStmt += " '"+productos[2]+"',";
                                strSqlStmt += " "+productos[3]+",";
                                strSqlStmt += " "+productos[4]+",";
                                strSqlStmt += " "+productos[5]+",";
                                strSqlStmt += " "+productos[6]+",";
                                strSqlStmt += " "+productos[7]+",";
                                strSqlStmt += " "+productos[8]+",";
                                strSqlStmt += " "+productos[9]+",";
                                strSqlStmt += " "+productos[10]+",";
                                strSqlStmt += " "+productos[11]+",";
                                strSqlStmt += " "+productos[12]+")";
                             
                                if (oConn.FnBoolQueryExecuteUpdate(strSqlStmt)){
                                    System.out.println("Productos [codigo= " + productos[0] + ", nombre=" + productos[1] + "]");
                                }    
                    }
                }
                strSqlStmt = "";
                             
                cont++;
                    
            }
            
            // oConn.SubAutoCommit(true);
             //System.out.println("Productos importados [ "+ cont + "]");
             JOptionPane.showMessageDialog(null,"Articulos importados exitosamente desde excel: [ "+ (cont-1) + " ] .");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}