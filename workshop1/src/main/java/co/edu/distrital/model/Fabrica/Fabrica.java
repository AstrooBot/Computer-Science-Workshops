package model.Fabrica;

import model.BaseDatos;
import model.Dato.Idato;

/**
 * Clase abstracta que representa una fábrica para la creación de objetos de tipo {@link Idato}.
 * Mantiene una referencia a una instancia de {@link BaseDatos} inicializada con una semilla específica.
 * 
 * Las subclases deben implementar el método {@link #crearDato(int)} para definir la lógica de creación
 * de los datos.
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public abstract class Fabrica {
    private int semilla;
    public BaseDatos baseDatos;

    public Fabrica(int semilla) {
        this.semilla = semilla;
        this.baseDatos = BaseDatos.getInstance(semilla);
    }

    public abstract Idato[] crearDato(int cantidad);
    
}
