package model.Dato;

/**
 * Representa una marcha con un nombre, distancia y fecha.
 * Implementa la interfaz {@link Idato}.
 * 
 * <p>
 * Esta clase almacena la información básica de una marcha, incluyendo su nombre,
 * la distancia recorrida y la fecha en la que se realizó.
 * </p>
 * 
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class Marcha implements Idato {

    private String nombre;
    private long distancia;
    private String fecha;

    public Marcha(String nombre, long distancia, String fecha) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.fecha = fecha;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setDistancia(long distancia) {
        this.distancia = distancia;
    }
    @Override
    public long getLong() {
        return distancia;
    }

    @Override
    public String toString() {
        return "Marcha [nombre=" + this.getNombre() + ", distancia=" + this.getLong() + ", fecha=" + this.getFecha() + "]";
    }
    
}
