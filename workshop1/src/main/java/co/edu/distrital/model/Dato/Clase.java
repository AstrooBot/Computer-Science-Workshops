package model.Dato;

/**
 * Representa una clase académica con un nombre, una carrera asociada y una cantidad.
 * Implementa la interfaz {@code Idato}.
 * 
 * <p>
 * Esta clase almacena información básica sobre una clase, incluyendo su nombre,
 * la carrera a la que pertenece y una cantidad asociada (por ejemplo, número de estudiantes).
 * </p>
 * 
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class Clase implements Idato {

    private String nombre;
    private String carrera;
    private long cantidad;

    public Clase(String nombre, String carrera, long cantidad) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.cantidad = cantidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
   
    @Override
    public String toString() {
        return "Clase [nombre=" + this.getNombre() + ", carrera=" + this.getCarrera() + ", cantidad=" + this.getLong() + "]";
    }
    @Override
    public long getLong() {
        return cantidad;
    }
    
}
