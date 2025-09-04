package model.attributes;

public class ActoCorrupcion extends IDato {

    public ActoCorrupcion(String nombre, long valor) {
        super(nombre, valor);
    }

    @Override
    public String toString() {
        return "Entidad: " + getNombre() + ", Monto: " + getValor();
    }
    
}
