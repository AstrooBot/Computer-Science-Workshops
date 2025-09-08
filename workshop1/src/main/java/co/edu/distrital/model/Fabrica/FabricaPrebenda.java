package model.Fabrica;

import model.Dato.Prebenda;

/**
 * La clase {@code FabricaPrebenda} extiende la clase {@code Fabrica} y se encarga de crear arreglos de objetos {@code Prebenda}.
 * Utiliza una semilla para inicializar la fábrica y genera instancias de {@code Prebenda} utilizando datos obtenidos de la base de datos asociada.
 *
 * <p>El método sobrescrito {@link #crearDato(int)} permite crear un arreglo de {@code Prebenda} con la cantidad especificada,
 * inicializando cada elemento con los datos correspondientes de la base de datos.</p>
 *
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 * @see Fabrica
 * @see Prebenda
 */
public class FabricaPrebenda extends Fabrica {

    public FabricaPrebenda(int semilla) {
        super(semilla);
    }

    @Override
    public Prebenda[] crearDato(int cantidad) {
        Prebenda[] prebendas = new Prebenda[cantidad];
        for (int i = 0; i < cantidad; i++) {
            prebendas[i] = new Prebenda(this.baseDatos.getNombreIglesia(), this.baseDatos.getLong(), this.baseDatos.getTipoIglesia());
        }
        return prebendas;
        
    }
    
}
