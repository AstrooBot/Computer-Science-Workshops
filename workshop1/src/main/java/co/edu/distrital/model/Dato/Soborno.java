package model.Dato;

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
