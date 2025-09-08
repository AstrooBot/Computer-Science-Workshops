package co.edu.distrital;

import model.Almacen;

/**
 * Clase de prueba para la clase {@link Almacen}.
 * 
 * <p>
 * Este programa crea una instancia de {@code Almacen} con un identificador y una capacidad determinada.
 * Realiza varias operaciones como obtener elementos por ID, mover elementos entre posiciones y consultar datos específicos.
 * Imprime los resultados de estas operaciones en la consola para verificar el comportamiento de la clase {@code Almacen}.
 * </p>
 * 
 * <p>
 * Métodos principales utilizados:
 * <ul>
 *   <li>{@code getById(int id)}: Obtiene un elemento del almacén por su identificador.</li>
 *   <li>{@code mover(int origen, int destino)}: Mueve un elemento de una posición a otra dentro del almacén.</li>
 *   <li>{@code getDatos(String clave)}: Obtiene un arreglo de datos asociados a una clave específica.</li>
 * </ul>
 * </p>
 * 
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class test7 {


    public static void main(String[] args) {
        Almacen almacen = new Almacen(1234, 2);
        System.out.println(almacen.getById(1));
        System.out.println(almacen.getById(2));
        almacen.mover(0, 1);
        System.out.println(almacen.getById(1));
        System.out.println(almacen.getById(2));
        System.out.println("-----------------------");
        System.out.println(almacen.getById(1).getLongActosCorrupcion());
        System.out.println(almacen.getDatos("actocorrupcion").length);

    }
    
}
