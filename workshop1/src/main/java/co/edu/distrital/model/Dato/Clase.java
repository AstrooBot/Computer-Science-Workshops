package co.edu.distrital.model.Dato;

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
