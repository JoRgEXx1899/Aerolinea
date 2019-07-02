
package aerolinea;

/**
 *
 * @author JORGE GOMEZ
 */
public class Asiento {
    String fila;
    int numero;
    Reserva reserva;

    public Asiento(String fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.reserva = null;
    }    

    public boolean isReservada() {
        return reserva!=null;
    }

    public void setReserva(Reserva reserva) {
        this.reserva=reserva;
    }

    public Reserva getReserva() {
        return reserva;
    }
    
    public String getAsiento() {
        return fila+numero;
    }    
    
}
