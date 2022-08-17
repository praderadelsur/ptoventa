
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author C.CLAGOM
 */
public class DetalleVentaDTO {
   
    private List<DetalleArticulos> detalleArticulos;
       
     private String fecha;
     private String totalImporte;
        
     private String aCuenta ;
     private String restan;
     private String saldoAnterior;

    public List<DetalleArticulos> getDetalleArticulos() {
        return detalleArticulos;
    }

    public void setDetalleArticulos(List<DetalleArticulos> detalleArticulos) {
        this.detalleArticulos = detalleArticulos;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotalImporte() {
        return totalImporte;
    }

    public void setTotalImporte(String totalImporte) {
        this.totalImporte = totalImporte;
    }

    public String getaCuenta() {
        return aCuenta;
    }

    public void setaCuenta(String aCuenta) {
        this.aCuenta = aCuenta;
    }

    public String getRestan() {
        return restan;
    }

    public void setRestan(String restan) {
        this.restan = restan;
    }

    public String getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(String saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    @Override
    public String toString() {
        return "DetalleVentaDTO{" + "detalleArticulos=" + detalleArticulos + ", fecha=" + fecha + ", totalImporte=" + totalImporte + ", aCuenta=" + aCuenta + ", restan=" + restan + ", saldoAnterior=" + saldoAnterior + '}';
    }

     
     
     
   }