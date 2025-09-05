package model.attributes;

public class Prebenda extends IDato {

    public Prebenda(String nombre, long valor) {
        super(nombre, valor);
    }

    @Override
    public String toString() {
        return "Sindicato: " + getNombre() + ", Prebenda: " + getValor();
    }
    
}
