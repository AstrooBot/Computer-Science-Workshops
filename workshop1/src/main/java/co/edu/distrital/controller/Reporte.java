package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Clase Reporte que permite generar un reporte en formato CSV con los resultados de ejecución
 * de diferentes algoritmos, incluyendo el número de comparaciones, intercambios, tiempo de ejecución
 * y el mejor candidato encontrado por cada algoritmo.
 */
 
    /**
     * Genera un archivo CSV llamado "report.csv" con los datos de los algoritmos,
     * incluyendo comparaciones, intercambios, tiempo de ejecución y mejor candidato.
     * Si ocurre un error durante la creación del archivo, se muestra un mensaje por consola.
     */
     
    /**
     * Constructor de la clase Reporte.
     * 
     * @param algoritmos     Arreglo con los nombres de los algoritmos evaluados.
     * @param comparaciones  Arreglo con el número de comparaciones realizadas por cada algoritmo.
     * @param intercambios   Arreglo con el número de intercambios realizados por cada algoritmo.
     * @param tiempoPared    Arreglo con el tiempo de ejecución (en milisegundos) de cada algoritmo.
     * @param mejor          Arreglo con el mejor candidato encontrado por cada algoritmo.
     * 
     * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
     */
public class Reporte {
    
    String[] algoritmos;
    long[] comparaciones;
    long[] intercambios;
    double[] tiempoPared;
    String[] mejor;
    public void generateCSV() {

        String nombreArchivo = "report.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezados
            writer.println("Algortimo,Comparaciones,Intercambios,Tiempo ejecución (ms), Mejor Candidato");

            for (int i = 0; i < algoritmos.length; i++) {
                writer.println(algoritmos[i]+","+Long.toString(comparaciones[i])+","+Long.toString(intercambios[i])+","+Double.toString(tiempoPared[i])+","+mejor[i]);
            }
            System.out.println("Archivo CSV creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public Reporte(String[] algoritmos, long[] comparaciones, long[] intercambios, double[] tiempoPared, String[]mejor) {
        this.algoritmos = algoritmos;
        this.comparaciones = comparaciones;
        this.intercambios = intercambios;
        this.tiempoPared = tiempoPared;
        this.mejor = mejor;

    }
    
}
