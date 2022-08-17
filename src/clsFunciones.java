
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaor
 */
public class clsFunciones {
     Integer counter=0;
     String value=""; 
    void SubSistemaMensaje(String strMensaje)
    {
        
        // Añade el Usuario al Mensaje
        //JOptionPane.showMessageDialog(null,strMensaje);
        JOptionPane.showMessageDialog(null, strMensaje, "Pradera del Sur",JOptionPane.INFORMATION_MESSAGE);
        
        
    }
    
    String fnIntSistemaSolicitaDatos(String strMensaje)
    {
        
        // Añade el Usuario al Mensaje        
        return JOptionPane.showInputDialog(null, strMensaje);
        
        
    }
    
    int fnIntSistemaPregunta(String strMensaje)
    {
        
        // Añade el Usuario al Mensaje
        return JOptionPane.showConfirmDialog(null, strMensaje);
        
        
    }
    
    // Valida que un caracter sea un número
    boolean fnBoolIsNumeric(char cCaracter)
    {
        // Variable de Resultados
        boolean bResult=false;
        
        // Valida uno por uno los caracteres
        if (cCaracter =='0')
            bResult = true;
        else
        if (cCaracter =='1')
            bResult = true;
        else
        if (cCaracter =='2')
            bResult = true;
        else
        if (cCaracter =='3')
            bResult = true;
        else
        if (cCaracter =='4')
            bResult = true;
        else
        if (cCaracter =='5')
            bResult = true;
        else
        if (cCaracter =='6')
            bResult = true;
        else
        if (cCaracter =='7')
            bResult = true;
        else
        if (cCaracter =='8')
            bResult = true;
        else
        if (cCaracter =='9')
            bResult = true;        
            
        // Valor de Retorno
        return bResult;
    }
    
    boolean fnBoolIsInteger(String sCadena)
    {
        // Valor de Resultado
        boolean bResult = true;
        int iCuenta;
        
        if (sCadena.isEmpty())
            bResult = false;
        else
            for (iCuenta=0;iCuenta < sCadena.length();iCuenta++)
                if (! fnBoolIsNumeric(sCadena.charAt(iCuenta)))
                {
                    bResult = false;       
                    break;
                }
        // Retorna el Valor
        return bResult;
    }
    
    boolean fnBoolIsDecimal(String sCadena)
    {
        // Valor de Resultado
        boolean bResult = true;
        boolean bPunto = false;
        int iCuenta;
        
        if (sCadena.isEmpty())
            bResult = false;
        else
            for (iCuenta=0;iCuenta < sCadena.length();iCuenta++)            
                // Verifica que sea un punto
                if (sCadena.charAt(iCuenta)=='.')
                    // Verifica que no haya ya un punto
                    if (bPunto)
                    {
                        bResult = false;
                        break;
                    }
                    else
                        bPunto = true;
                else
                    if (! fnBoolIsNumeric(sCadena.charAt(iCuenta)))
                    {
                        bResult = false;       
                        break;
                    }            
        // Retorna el Valor
        return bResult;
    }
    
    public String getStringOfNumber(Integer $num){
        this.counter = $num;
        return doThings($num);
    }
    
    private String doThings(Integer _counter){
        //Limite
        if(_counter >2000000)
            return "DOS MILLONES";
        
        switch(_counter){
            case 0: return "CERO";
            case 1: return "UN"; //UNO
            case 2: return "DOS";
            case 3: return "TRES";
            case 4: return "CUATRO";
            case 5: return "CINCO"; 
            case 6: return "SEIS";
            case 7: return "SIETE";
            case 8: return "OCHO";
            case 9: return "NUEVE";
            case 10: return "DIEZ";
            case 11: return "ONCE"; 
            case 12: return "DOCE"; 
            case 13: return "TRECE";
            case 14: return "CATORCE";
            case 15: return "QUINCE";
            case 20: return "VEINTE";
            case 30: return "TREINTA";
            case 40: return "CUARENTA";
            case 50: return "CINCUENTA";
            case 60: return "SESENTA";
            case 70: return "SETENTA";
            case 80: return "OCHENTA";
            case 90: return "NOVENTA";
            case 100: return "CIEN";
            
            case 200: return "DOSCIENTOS";
            case 300: return "TRESCIENTOS";
            case 400: return "CUATROCIENTOS";
            case 500: return "QUINIENTOS";
            case 600: return "SEISCIENTOS";
            case 700: return "SETECIENTOS";
            case 800: return "OCHOCIENTOS";
            case 900: return "NOVECIENTOS";
            
            case 1000: return "MIL";
            
            case 1000000: return "UN MILLON";
            case 2000000: return "DOS MILLONES";
        }
        if(_counter<20){
            //System.out.println(">15");
            return "DIECI"+ doThings(_counter-10);
        }
        if(_counter<30){
            //System.out.println(">20");
            return "VEINTI" + doThings(_counter-20);
        }
        if(_counter<100){
            //System.out.println("<100"); 
            return doThings( (int)(_counter/10)*10 ) + " Y " + doThings(_counter%10);
        }        
        if(_counter<200){
            //System.out.println("<200"); 
            return "CIENTO " + doThings( _counter - 100 );
        }         
        if(_counter<1000){
            //System.out.println("<1000");
            return doThings( (int)(_counter/100)*100 ) + " " + doThings(_counter%100);
        } 
        if(_counter<2000){
            //System.out.println("<2000");
            return "MIL " + doThings( _counter % 1000 );
        } 
        if(_counter<1000000){
            String var;
            //System.out.println("<1000000");
            var = doThings((int)(_counter/1000)) + " MIL" ;
            if(_counter % 1000!=0){
                //System.out.println(var);
                var += " " + doThings(_counter % 1000);
            }
            return var;
        }
        if(_counter<2000000){
            return "UN MILLON " + doThings( _counter % 1000000 );
        } 
        return "";
    }    
}
