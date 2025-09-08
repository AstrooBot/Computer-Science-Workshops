package model.Fabrica;

import model.Dato.ActoCorrupcion;

/**
 * La clase {@code FabricaActoCorrupcion} extiende la clase abstracta {@code Fabrica}
 * y se encarga de crear instancias de {@code ActoCorrupcion}.
 * Utiliza una semilla para inicializar la fábrica y genera un arreglo de actos de corrupción
 * con datos obtenidos de la base de datos interna.
 *
 * <p>
 * Cada acto de corrupción generado contiene una fecha, un nombre completo (nombre y apellido)
 * y un lugar, todos obtenidos de la base de datos asociada a la fábrica.
 * </p>
 *
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class FabricaActoCorrupcion extends Fabrica {

    public FabricaActoCorrupcion(int semilla) {
        super(semilla);
    }

    @Override
    public ActoCorrupcion[] crearDato(int cantidad) {
        ActoCorrupcion[] actosCorrupcion = new ActoCorrupcion[cantidad];
        for (int i = 0; i < cantidad; i++) {
            actosCorrupcion[i] = new ActoCorrupcion(this.baseDatos.getFecha(), this.baseDatos.getNombre() + " " + this.baseDatos.getApellido(), this.baseDatos.getLugar());
        }
        return actosCorrupcion;
        
    }
    
}