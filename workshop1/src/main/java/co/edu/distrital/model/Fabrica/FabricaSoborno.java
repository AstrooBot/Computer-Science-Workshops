package model.Fabrica;

import model.Dato.Soborno;

/**
 * La clase FabricaSoborno extiende la clase abstracta Fabrica y se encarga de crear arreglos de objetos Soborno.
 * Utiliza una base de datos interna para generar los datos necesarios para cada instancia de Soborno.
 *
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class FabricaSoborno extends Fabrica {

    public FabricaSoborno(int semilla) {
        super(semilla);
    }

    @Override
    public Soborno[] crearDato(int cantidad) {
        Soborno[] sobornos = new Soborno[cantidad];
        for (int i = 0; i < cantidad; i++) {
            sobornos[i] = new Soborno(this.baseDatos.getFecha(), this.baseDatos.getLong(), this.baseDatos.getNombre() + " " + this.baseDatos.getApellido());
        }
        return sobornos;
        
    }
    
}
