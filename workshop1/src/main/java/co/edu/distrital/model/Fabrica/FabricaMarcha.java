package model.Fabrica;

import model.Dato.Marcha;

/**
 * La clase {@code FabricaMarcha} extiende la clase abstracta {@code Fabrica} y se encarga de crear arreglos de objetos {@code Marcha}.
 * Utiliza una base de datos interna para generar los atributos de cada instancia de {@code Marcha}.
 * 
 * <p>
 * El constructor recibe una semilla para inicializar la base de datos utilizada en la generación de datos aleatorios.
 * </p>
 * 
 * <p>
 * El método sobrescrito {@code crearDato} genera un arreglo de {@code Marcha} con la cantidad especificada, 
 * utilizando métodos de la base de datos para obtener los valores de nombre, longitud y fecha de cada marcha.
 * </p>
 * 
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 * @see Fabrica
 * @see Marcha
 */
public class FabricaMarcha extends Fabrica {

    public FabricaMarcha(int semilla) {
        super(semilla);
    }

    @Override
    public Marcha[] crearDato(int cantidad) {
        Marcha[] marchas = new Marcha[cantidad];
        for (int i = 0; i < cantidad; i++) {
            marchas[i] = new Marcha(this.baseDatos.getNombreMarcha(), this.baseDatos.getLong(), this.baseDatos.getFecha());
        }
        return marchas;
        
    }
    
}
