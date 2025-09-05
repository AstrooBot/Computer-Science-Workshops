package model.attributes;

public class Soborno extends IDato {

    public Soborno(String nombre, long valor) {
        super(nombre, valor);
    }

    @Override
    public String toString() {
        return "Politico: " + getNombre() + ", Monto: " + getValor();
    }

    
    
}
