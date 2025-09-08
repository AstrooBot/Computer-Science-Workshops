package model.Dato;

/**
 * La clase {@code Prebenda} representa una prebenda eclesiástica, que contiene información
 * sobre el nombre de la iglesia, la renta asociada y el tipo de iglesia.
 * Implementa la interfaz {@code Idato}.
 * 
 * <p>
 * Ejemplo de uso:
 * <pre>
 *     Prebenda prebenda = new Prebenda("Catedral", 5000L, "Principal");
 * </pre>
 * </p>
 * 
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class Prebenda implements Idato {

    private String nombreIglesia;
    private long renta;
    private String TipoIglesia;

    public Prebenda(String nombreIglesia, long renta, String tipoIglesia) {
        this.nombreIglesia = nombreIglesia;
        this.renta = renta;
        this.TipoIglesia = tipoIglesia;
    }
    
    public String getNombreIglesia() {
        return nombreIglesia;
    }

    public void setNombreIglesia(String nombreIglesia) {
        this.nombreIglesia = nombreIglesia;
    }

    public void setRenta(long renta) {
        this.renta = renta;
    }

    public String getTipoIglesia() {
        return TipoIglesia;
    }

    public void setTipoIglesia(String tipoIglesia) {
        this.TipoIglesia = tipoIglesia;
    }

    @Override
    public String toString() {
        return "Prebenda [nombre Iglesia=" + this.getNombreIglesia() + ", Renta=" + this.getLong() + ", Tipo Iglesia=" + this.getTipoIglesia() + "]";
    }
    @Override
    public long getLong() {
        return renta;
    }
    
}
