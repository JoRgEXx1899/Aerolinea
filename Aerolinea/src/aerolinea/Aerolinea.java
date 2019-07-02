package aerolinea;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JORGE GOMEZ
 */
public class Aerolinea {

    private Ciudad origen;

    private Ciudad ciudad1;

    ArrayList<Ciudad> ciudades;

    public Aerolinea(String nombreCiudadOrigen, int coordenada_x, int coordenada_y) {
        origen = new Ciudad(nombreCiudadOrigen, coordenada_x, coordenada_y);
        ciudad1 = null;

    }

    public Ciudad getCiudadBase() {
        return origen;
    }

    public Ciudad getCiudad(String nombreCiudad) {
        for (Ciudad p = ciudad1; p != null; p = p.darSiguiente()) {
            if (p.getNombre().equalsIgnoreCase(nombreCiudad)) {
                return p;
            }
        }
        return null;
    }

    public void agregarCiudad(String nombre, int coord_x, int coord_y) {
        /*if( nombre.equalsIgnoreCase( origen.darNombre( ) ) )
            throw new AerolineaExcepcion( "El nombre de la nueva ciudad no puede ser igual al de la ciudad base" );

        if( darCiudad( nombre ) != null )
            throw new AerolineaExcepcion( "El nombre de la nueva ciudad no puede ser igual al de otra ciudad ya existente" );*/

        // Agrega la nueva ciudad como primera de la lista
        Ciudad nuevaCiudad = new Ciudad(nombre, coord_x, coord_y);
        nuevaCiudad.agregarDespues(ciudad1);
        ciudad1 = nuevaCiudad;
        //ciudades.add(ciudad1);
    }

    public void eliminarCiudad(String nombre) {
        /*if( ciudad1 == null )
            throw new AerolineaExcepcion( "No existe una ciudad llamada " + nombre );*/

        if (nombre.equalsIgnoreCase(ciudad1.getNombre())) {
            // Es la primera ciudad de la lista
            ciudad1 = ciudad1.darSiguiente();
        } else {
            Ciudad anterior = localizarAnterior(nombre);
            if (anterior != null) {
                anterior.desconectarSiguiente();
            }

        }

    }

    /**
     * Busca la ciudad anterior a la ciudad con el nombre especificado. <br>
     * <b>pre: </b> ciudad1 != null && nombre != ciudad1.darNombre( )
     *
     * @param nombre Nombre de la ciudad de la que se desea la ciudad anterior -
     * nombre != null
     * @return La ciudad anterior a la ciudad con el nombre dado. Se retorna
     * null si la ciudad con nombre dado no existe o si es la primera de la
     * lista
     */
    private Ciudad localizarAnterior(String nombre) {
        Ciudad anterior = ciudad1;
        Ciudad actual = ciudad1.darSiguiente();
        while (actual != null && !actual.getNombre().equalsIgnoreCase(nombre)) {
            anterior = actual;
            actual = actual.darSiguiente();
        }
        return actual != null ? anterior : null;
    }
    int contReserva = 0, contVuelo = 0;

    public int CodVuelo() {
        return contVuelo++;
    }

    public static void main(String[] args) throws ParseException {
        Aerolinea aerolinea = new Aerolinea("Bogota", 0, 0);
        int i = 1, j = 1, aux1, aux2;
        String auxString, auxString2, auxString3, auxString4;
        System.out.println("Bienvenido a AERO DISTRI");
        Scanner s = new Scanner(System.in);
        while (i > 0) {
            System.out.println("Elija una de las siguientes opciones:\n1.Modificar Ciudad\n2.Modificar Vuelos\n3.Modificar Avion\n4.Modificar Reserva");
            i = s.nextInt();
            switch (i) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Elija entre las siguientes opciones:\n1.Agregar Ciudad\n2.Eliminar Ciudad\n3.Localizar ciudad Anterior");
                    j = s.nextInt();
                    switch (j) {
                        case 1:
                            System.out.println("Ingrese el nombre y las corrdenadas de la ciudad a agregar...");
                            System.out.println("Nombre:");

                            auxString = s.next();
                            System.out.println("Coordenada X:");
                            aux1 = s.nextInt();
                            System.out.println("Coordenada Y:");
                            aux2 = s.nextInt();
                            aerolinea.agregarCiudad(auxString, aux1, aux2);
                            break;
                        case 2:
                            System.out.println("Digite el nombre de la ciudad que desea eliminar");
                            auxString = s.next();
                            Ciudad temporal;
                            temporal = aerolinea.getCiudad(auxString);
                            if (temporal != null) {
                                aerolinea.eliminarCiudad(auxString);
                            } else {
                                System.out.println("La ciudad digitada no existe");
                            }
                            break;
                        case 3:
                            System.out.println("Digite el nombre de la ciudad actual");
                            auxString = s.next();
                            System.out.println(aerolinea.localizarAnterior(auxString).getNombre() + " Coordenadas:" + aerolinea.localizarAnterior(auxString).getCoordenadas());
                        default:
                            System.out.println("Por favor digite alguno de los numeros indicados");
                            break;

                    }
                    break;
                case 2:
                    System.out.println("Elija entre las siguientes opciones:\n1.Agregar Vuelo\n2.Consultar info de Vuelo\n3.Realizar Reserva\n4.Consultar cantidad de reservas de una persona");
                    j = s.nextInt();
                    switch (j) {
                        case 1:
                            System.out.println("Para agregar un vuelo debe suministrar \b Ciudad del vuelo,Fecha, hora y minuto del vuelo");
                            //System.out.println("Ciudad destino:");
                            auxString = s.next();
                            System.out.println("Fecha:");
                            auxString2 = s.next();
                            System.out.println("Hora:");
                            auxString3 = s.next();
                            System.out.println("Minutos:");
                            auxString4 = s.next();
                            Ciudad temporal;
                            temporal = aerolinea.getCiudad(auxString);
                            if (temporal != null) {
                                temporal.agregarVuelo(aerolinea.CodVuelo(), auxString2, auxString3, auxString4);
                            } else {
                                System.out.println("La ciudad ingresada no está en el sistema;");
                            }
                            break;
                        case 2:
                            System.out.println("Para realizar una reserva debe ingresar el codigo de vuelo y la ciudad destino,la fila y columna del asiento, su nombre y cedula");
                            System.out.println("Ingrese la ciudad destino:");
                            auxString3 = s.next();
                            Ciudad tempi;
                            tempi = aerolinea.getCiudad(auxString3);
                            if (tempi != null) {
                                System.out.println("Ingrese el cod de vuelo:");
                                auxString4 = s.next();
                                if (tempi.buscarVuelo(auxString4) != null) {
                                    System.out.println("CODIGO DE VUELO " + tempi.buscarVuelo(auxString4).getCodVuelo()
                                            + "\nDestino " + tempi.getNombre() + "\nCapacidad " + tempi.buscarVuelo(auxString4).getCapacidad()
                                            + "\nSillas disponibles" + tempi.buscarVuelo(auxString4).getSillasDisponibles()
                                            + "\nFecha " + tempi.buscarVuelo(auxString4).getFechaYHora()
                                            + "\n\nLos vuelo siguiente y anterior son a las " + tempi.buscarVuelo(auxString4).darVueloAnterior().getFechaYHora() + "y" + tempi.buscarVuelo(auxString4).darVueloSiguiente().getFechaYHora());
                                } else {
                                    System.out.println("El codigo de vuelo suministrado es erroneo");
                                }
                            } else {
                                System.out.println("La ciudad ingresada no está en el sistema;");
                            }

                            break;

                        case 3:
                            System.out.println("Para realizar una reserva debe ingresar el codigo de vuelo y la ciudad destino,la fila y columna del asiento, su nombre y cedula");
                            System.out.println("Ingrese la ciudad destino:");
                            auxString3 = s.next();
                            Ciudad temp;
                            temp = aerolinea.getCiudad(auxString3);
                            if (temp != null) {
                                System.out.println("Ingrese el cod de vuelo:");
                                auxString4 = s.next();
                                if (temp.buscarVuelo(auxString4) != null) {
                                    System.out.println("Ingrese la fila:");
                                    aux1 = s.nextInt();
                                    System.out.println("Ingrese la columna:");
                                    aux2 = s.nextInt();
                                    System.out.println("Ingrese la cedula:");
                                    auxString = s.next();
                                    System.out.println("Ingrese el nombre:");
                                    auxString2 = s.next();
                                    temp.buscarVuelo(auxString4).reservarSilla(aux1, aux2, auxString, auxString2);
                                } else {
                                    System.out.println("El codigo de vuelo suministrado es erroneo");
                                }
                            } else {
                                System.out.println("La ciudad ingresada no está en el sistema;");
                            }

                            break;
                        case 4:
                            System.out.println("Para consultar la cantidad de reservas que tiene una persona para un vuelo\nDebe suministrar la ciudad destino, el vuelo y la cedula");
                            System.out.println("Ingrese la ciudad destino:");
                            auxString3 = s.next();
                            Ciudad tempo;
                            tempo = aerolinea.getCiudad(auxString3);
                            if (tempo != null) {
                                System.out.println("Ingrese el cod de vuelo:");
                                auxString4 = s.next();
                                if (tempo.buscarVuelo(auxString4) != null) {
                                    System.out.println("Ingrese la cedula:");
                                    auxString2 = s.next();
                                    System.out.println(tempo.buscarVuelo(auxString4).contarReservas(auxString2));
                                } else {
                                    System.out.println("El codigo de vuelo suministrado es erroneo");
                                }
                            } else {
                                System.out.println("La ciudad ingresada no está en el sistema;");
                            }
                            break;

                    }
                    break;

            }
        }

    }

}
