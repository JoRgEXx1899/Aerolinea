package aerolinea;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author estudiantes
 */
public class Vuelo {

    String codVuelo;
    int sillasDisponibles, capacidad = 75, codR = 1;

    Avion avion = new Avion();
    Ciudad ciudad;
    Date fechayhora;
    Vuelo siguiente, anterior;

    public Vuelo(int codigoVuelo, String fechaVuelo, String horasVuelo, String minutosVuelo) throws ParseException {
        this.codVuelo = Integer.toString(codigoVuelo);

        // Inicializa la fecha y hora
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        fechayhora = sdf.parse(fechaVuelo + " " + horasVuelo + ":" + minutosVuelo);
        avion = new Avion();
        sillasDisponibles = capacidad;
    }

    public int getSillasDisponibles() {
        return sillasDisponibles;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getFechaYHora() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(fechayhora);
    }

    public Date getFecha() {
        return fechayhora;
    }

    public void reservarSilla(int fila, int col, String nombre, String cedula) {
        // Verificar que la c�dula indicada no haya sido usada para otra reserva
        /*if( contarReservas( cedula ) != 0 )
            throw new AerolineaExcepcion( "La c�dula " + cedula + " ya fue usada para otra reserva en el mismo vuelo" );*/
        if (avion.getSilla(fila, col).isReservada()) {

        } else {
            avion.getSilla(fila, col).setReserva(new Reserva(Integer.toString(codR), nombre, cedula));
            codR++;
            sillasDisponibles--;
        }

    }

    public int contarReservas(String cedula) {
        int acum = 0;
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                if (avion.sillas[i][j].isReservada() && avion.sillas[i][j].getReserva().getCedula() == cedula) {
                    acum++;
                }
            }
        }
        return acum;
    }

    /*public void agregarReservas(Pasajero pasajero) {
        int c=reservas.size()+1;
        String codigo=Integer.toString(c);
        this.reservas.add(new Reserva(codigo,pasajero));
    }*/
    public String getCodVuelo() {
        return codVuelo;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strFecha = sdf.format(fechayhora);

        DecimalFormat df = new DecimalFormat("00.00");
        String disponibilidad = df.format(((double) sillasDisponibles / (double) capacidad * 100));

        return codVuelo + " - " + strFecha + " (" + disponibilidad + "% libre)";
    }

    public Vuelo darVueloAnterior() {
        return anterior;
    }

    public Vuelo darVueloSiguiente() {
        return siguiente;
    }

    public void insertarDespues(Vuelo vuelo) {
        vuelo.siguiente = siguiente;
        if (siguiente != null) {
            siguiente.anterior = vuelo;
        }
        vuelo.anterior = this;
        siguiente = vuelo;

    }

    public void insertarAntes(Vuelo vuelo) {
        if (anterior != null) {
            anterior.siguiente = vuelo;
        }
        vuelo.anterior = anterior;
        vuelo.siguiente = this;
        anterior = vuelo;
    }
}
