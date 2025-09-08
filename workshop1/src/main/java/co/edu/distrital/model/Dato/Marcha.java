package co.edu.distrital.model.Dato;

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
