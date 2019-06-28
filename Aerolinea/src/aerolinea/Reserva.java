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
    String codigoReserva;
    Pasajero pasajero;
    
    public Reserva(String cod,Pasajero pasajero){
        setCodigoReserva(cod);
        this.pasajero=pasajero;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }
}
