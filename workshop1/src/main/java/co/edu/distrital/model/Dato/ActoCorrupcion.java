package model.Dato;

/**
 * Representa un acto de corrupción con información relevante como la fecha, el responsable y el lugar donde ocurrió.
 * Implementa la interfaz {@code Idato}.
 * 
 * <p>
 * Ejemplo de uso:
 * <pre>
 *     ActoCorrupcion acto = new ActoCorrupcion("2024-06-01", "Juan Perez", "Bogotá");
 * </pre>
 * </p>
 * 
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class ActoCorrupcion implements Idato {

    private String fecha;
    private String responsable;
    private String lugar;
    
    public ActoCorrupcion(String fecha, String responsable, String lugar) {
        this.fecha = fecha;
        this.responsable = responsable;
        this.lugar = lugar;
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }


    @Override
    public long getLong() {
        return 1;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {

        return "Acto de Corrupcion [fecha=" + this.getFecha() + ", responsable=" + this.getResponsable() + ", lugar=" + this.getLugar() + "]";
    }
    
}
