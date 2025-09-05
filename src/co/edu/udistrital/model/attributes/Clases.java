package model.attributes;

public class Clases extends IDato {

    public Clases(String nombre, long valor) {
        super(nombre, valor);
    }

    @Override
    public String toString() {
        return "Clase: " + getNombre() + ", Horas perdidas: " + getValor();
    }
    
}
