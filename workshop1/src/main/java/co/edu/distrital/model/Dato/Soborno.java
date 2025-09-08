package model.Dato;

/**
 * La clase {@code Soborno} representa un dato de soborno con información relevante
 * como la fecha, la cantidad y el responsable del soborno.
 * Implementa la interfaz {@code Idato}.
 *
 * <p>Proporciona métodos para obtener y establecer los valores de sus atributos,
 * así como un método para obtener una representación en cadena del objeto.</p>
 *
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class Soborno implements Idato {

    private String fecha;
    private long cantidad;
    private String responsable;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
    public Soborno(String fecha, long cantidad, String responsable) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Soborno [fecha=" + this.getFecha() + ", cantidad=" + this.getLong() + ", responsable=" + this.getResponsable() + "]";
    }
    @Override
    public long getLong() {
        return cantidad;
    }
    
}
