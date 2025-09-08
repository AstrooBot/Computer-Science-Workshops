package co.edu.distrital.model.Dato;

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
