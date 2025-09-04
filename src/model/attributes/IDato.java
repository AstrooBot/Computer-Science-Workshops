package model.attributes;

public abstract class IDato {
    
    private String nombre;
    private long valor;

    public IDato(String nombre, long valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public long getValor() {
        return valor;
    }
    public void setValor(long valor) {
        this.valor = valor;
    }

}
