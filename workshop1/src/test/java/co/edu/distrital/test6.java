package co.edu.distrital;

import model.Almacen;

/**
 * Clase de prueba para medir el rendimiento de la clase {@code Almacen}
 * al generar 700,000 candidatos, lo cual puede estar cerca del límite de memoria.
 * 
 * <p>El método {@code main} crea una instancia de {@code Almacen} con un identificador
 * y una cantidad grande de elementos, midiendo el tiempo de ejecución en milisegundos.
 * 
 * <p>Uso típico para pruebas de performance y detección de posibles problemas de memoria.
 * 
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class test6 {
//Performance test for Almacen class, generating 700,000 candidates may be the edge for memory issues
    public static void main(String[] args) {
        long inicio = System.nanoTime();
        Almacen almacen = new Almacen(1234, 700_000);
        long fin = System.nanoTime();
        long duracion = fin - inicio; 
        double milisegundos = duracion / 1_000_000.0;

        System.out.println("Tiempo de ejecución: " + milisegundos + " ms");
        
        
    }
    
}
