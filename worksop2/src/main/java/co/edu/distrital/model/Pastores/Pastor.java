package co.edu.distrital.model.Pastores;

public class Pastor {

    private int id;
    private String nombre;
    private int doblones;
    private int fieles;
    private String oficio;

    public Pastor(int id, String nombre, int doblones, int fieles, String oficio) {
        this.id = id;
        this.nombre = nombre;
        this.doblones = doblones;
        this.fieles = fieles;
        this.oficio = oficio;
    }

    @Override
    public String toString() {
        
        return "{P" + id + "$" + doblones + "F" + fieles + "Of" + oficio.charAt(0) + "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDoblones() {
        return doblones;
    }

    public void setDoblones(int doblones) {
        this.doblones = doblones;
    }

    public int getFieles() {
        return fieles;
    }

    public void setFieles(int fieles) {
        this.fieles = fieles;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
    
}
