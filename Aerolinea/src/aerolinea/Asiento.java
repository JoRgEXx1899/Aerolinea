
package aerolinea;

/**
 *
 * @author JORGE GOMEZ
 */
public class Asiento {
    String fila;
    int numero;
    boolean estado=true;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAsiento() {
        return fila+numero;
    }
    
    
}
