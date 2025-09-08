package model.Fabrica;

import model.Dato.Clase;

/**
 * La clase {@code FabricaClase} extiende la clase abstracta {@code Fabrica} y se encarga de crear arreglos de objetos {@code Clase}.
 * Utiliza una base de datos interna para generar los atributos de cada instancia de {@code Clase}.
 *
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class FabricaClase extends Fabrica {

    public FabricaClase(int semilla) {
        super(semilla);
    }

    @Override
    public Clase[] crearDato(int cantidad) {
        Clase[] clases = new Clase[cantidad];
        for (int i = 0; i < cantidad; i++) {
            clases[i] = new Clase(this.baseDatos.getNombreClase(), this.baseDatos.getCarrera(), this.baseDatos.getLong());
        }
        return clases;
        
    }
    
}
