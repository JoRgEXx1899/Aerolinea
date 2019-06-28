package aerolinea;

/**
 *
 * @author JORGE GOMEZ
 */
public class Ciudad {

    String nombre;
    int latitud, longitud;
    String coordenadas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int lat, int lon) {
        this.latitud = lat;
        this.longitud = lon;
        this.coordenadas = "(" + latitud + "," + longitud + ")";
    }

}
