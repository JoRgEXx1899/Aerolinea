package aerolinea;

import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author JORGE GOMEZ
 */
public class Ciudad {

    String nombre;
    int latitud, longitud;
    String coordenadas;
    Ciudad siguiente;
    Vuelo vuelo1;
    ArrayList <Vuelo> vuelos;

    public Ciudad(String nombre, int latitud, int longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        setCoordenadas(latitud, longitud);
    }
        
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

    public void agregarVuelo( int codigo, String fecha, String horas, String minutos ) throws ParseException {
        Vuelo nuevo = new Vuelo( codigo, fecha, horas, minutos );
        if( vuelo1 == null )
            vuelo1 = nuevo;
        else if( Integer.parseInt(vuelo1.getCodVuelo())>= codigo )
        {
            vuelo1.insertarAntes( nuevo );
            vuelo1 = nuevo;
        }
        else
        {
            Vuelo vueloTemp0 = null;
            Vuelo vueloTemp1 = vuelo1;
            while( vueloTemp1 != null && Integer.parseInt(vueloTemp1.getCodVuelo())< codigo )
            {
                vueloTemp0 = vueloTemp1;
                vueloTemp1 = vueloTemp1.darVueloSiguiente( );
            }
            vueloTemp0.insertarDespues( nuevo );
        }
        vuelos.add(vuelo1);
    }
    public Vuelo buscarVuelo( String codigo )
    {
        for( Vuelo p = vuelo1; p != null; p = p.darVueloSiguiente( ) )
        {
            if( p.getCodVuelo()== codigo )
                return p;
        }
        return null;
    }
    public Vuelo darPrimerVuelo( )
    {
        return vuelo1;
    }

    
    public Ciudad darSiguiente( )
    {
        return siguiente;
    }

    
    public void agregarDespues( Ciudad ciudad )
    {
        siguiente = ciudad;
    }

    /**
     * Desconecta la ciudad que le sigue en la lista a la ciudad actual. <br>
     * <b>pre: </b> No es el la �ltima ciudad de la lista. <br>
     * <b>post: </b> La ciudad siguiente a la actual fue desconectada de la lista.<br>
     */
    public void desconectarSiguiente( )
    {
        siguiente = siguiente.siguiente;
    }
}
