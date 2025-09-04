package model.attributes;

public class Marcha extends IDato {

    public Marcha(String nombre, long valor) {
        super(nombre, valor);
    }

    @Override
    public String toString() {
        return "Marcha: " + getNombre() + ", Distancia: " + getValor();
    }
    
}
