/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea;

/**
 *
 * @author estudiantes
 */
public class Reserva {
    private String codigoReserva;
    Pasajero pasajero;
    
    public Reserva(String cod,String nombreP, String cedulaP ){
        setCodigoReserva(cod);
        this.pasajero.setNombre(nombreP);
        this.pasajero.setCedula(cedulaP);
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }    
    
    public String getNombre() {
        return pasajero.getNombre();
    }
    
    
    public String getCedula() {
        return pasajero.getCedula();
    }
}
