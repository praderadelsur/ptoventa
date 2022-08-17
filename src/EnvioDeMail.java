
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class EnvioDeMail {
    
    String PASSWORD = "nuveaxhzmsdzargf"; // GMail password
    String USER_NAME = "infopraderadelsur@gmail.com";  // GMail user name (just the part before "@gmail.com")
    String[] RECIPIENT = new String[2]; 

   
    // Declaro variable de Conexion
    clsConnection oConn = new clsConnection();
    
    
    public void enviarMail(String body) {
        obtenerDestinarios();
       
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = RECIPIENT; // list of recipient email addresses
        String subject = "Informe Diario";
        //String body = "Welcome to JavaMail!";

        sendFromGMail(from, pass, to, subject, body);
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    
    
     private void obtenerDestinarios()
    {
        // Para instrucción sql
        String sqlStmt;
        String strRemitente = "";
        String strDestinatario = "";
        String strCopia = "";
        String strCopiaOculta = "";
        
         // Prepara Variable para realizar el Query
        sqlStmt = "Select * from 14tblConfigMail";
        
        if (oConn.FnBoolQueryExecute(sqlStmt))
        {
            try 
            {
                // Verifica resultados
                 while (oConn.setResult.next())
                 {
                     // Obtiene los datos de la Consulta
                     strRemitente = oConn.setResult.getString ("strRemitente");
                     strDestinatario = oConn.setResult.getString ("strDestinatario");
                     strCopia = oConn.setResult.getString ("strCopia");
                     strCopiaOculta = oConn.setResult.getString ("strCopiaOculta");
                 }                 
                 
                 USER_NAME = strRemitente;  // GMail user name (just the part before "@gmail.com")
                 RECIPIENT[0] = strDestinatario;
                 RECIPIENT[1] = strCopia;
                 //RECIPIENT[2] = strCopiaOculta;
                 // Cierra Resultados
                 oConn.setResult.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(frmClase05.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
 
}
    