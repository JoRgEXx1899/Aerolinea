package aerolinea;

import java.util.*;

/**
 *
 * @author estudiantes
 */
public class Vuelo {

    String numVuelo;
    boolean disponibilidad;
    ArrayList<Reserva> reservas = new ArrayList();
    Avion avion = new Avion();
    Ciudad ciudad = new Ciudad();

    public Vuelo() {
        for (int i = 0; i < 14; i++) {
            for (int k = 0; k < 4; k++) {
                if (avion.getDisponibilidadAsiento(avion.FilaNumL(i), k+1)==true){
                    disponibilidad=true;
                }                
            }
        }
    }

    public void agregarReservas(Pasajero pasajero) {
        int c=reservas.size()+1;
        String codigo=Integer.toString(c);
        this.reservas.add(new Reserva(codigo,pasajero));
    }
    
}
