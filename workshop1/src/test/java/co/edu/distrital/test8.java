package co.edu.distrital;

import controller.*;
import model.Almacen;

/**
 * Clase de prueba para comparar el desempeño de diferentes algoritmos de ordenamiento.
 * <p>
 * Esta clase crea un objeto {@code Almacen} con datos de prueba y ejecuta los algoritmos
 * de ordenamiento Burbuja, Inserción, Merge, Quick y Selección sobre los mismos datos.
 * Posteriormente, recopila estadísticas como el número de comparaciones, intercambios,
 * tiempo de ejecución y el mejor caso de cada algoritmo, generando un reporte en formato CSV.
 * </p>
 *
 * <p>
 * Algoritmos evaluados:
 * <ul>
 *   <li>Burbuja</li>
 *   <li>Inserción</li>
 *   <li>Merge</li>
 *   <li>Quick</li>
 *   <li>Selección</li>
 * </ul>
 * </p>
 *
 * <p>
 * Requiere las clases {@code Almacen}, {@code Burbuja}, {@code Insercion}, {@code Merge},
 * {@code Quick}, {@code Selection} y {@code Reporte}.
 * </p>
 *
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class test8 {
    public static void main(String[] args) {
        
    
        Almacen almacen = new Almacen(1234, 50_000);
        Burbuja burbuja = new Burbuja(almacen, "soborno");
        Insercion insercion = new Insercion(almacen, "soborno");
        Merge merge = new Merge(almacen, "soborno");
        Quick quick = new Quick(almacen, "soborno");
        Selection seleccion = new Selection(almacen, "soborno");
        burbuja.ordenar();
        insercion.ordenar();
        merge.ordenar();
        quick.ordenar();
        seleccion.ordenar();

        Reporte reporte = new Reporte(
            new String[]{"Burbuja", "Inserción", "Merge", "Quick", "Selección"},
            new long[]{burbuja.getComparaciones(), insercion.getComparaciones(), merge.getComparaciones(), quick.getComparaciones(), seleccion.getComparaciones()},
            new long[]{burbuja.getIntercambios(), insercion.getIntercambios(), merge.getIntercambios(), quick.getIntercambios(), seleccion.getIntercambios()},
            new double[]{burbuja.getTiempoPared(), insercion.getTiempoPared(), merge.getTiempoPared(), quick.getTiempoPared(), seleccion.getTiempoPared()},
            new String[]{burbuja.best().toString(), insercion.best().toString(), merge.best().toString(), quick.best().toString(), seleccion.best().toString()}
        );
        reporte.generateCSV();
            

    }
    
}
