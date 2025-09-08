package co.edu.distrital.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Reporte {
    
    String[] algoritmos;
    int[] comparaciones;
    int[] intercambios;
    double[] tiempoPared;
    String[] mejor;
    public void generateCSV() {

        String nombreArchivo = "src/report.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezados
            writer.println("Algortimo,Comparaciones,Intercambios,Tiempo ejecución (ms), Mejor Candidato");

            for (int i = 0; i < algoritmos.length; i++) {
                writer.println(algoritmos[i]+","+Integer.toString(comparaciones[i])+","+Integer.toString(intercambios[i])+","+Double.toString(tiempoPared[i])+","+mejor[i]);
            }
            System.out.println("Archivo CSV creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public Reporte(String[] algoritmos, int[] comparaciones, int[] intercambios, double[] tiempoPared, String[]mejor) {
        this.algoritmos = algoritmos;
        this.comparaciones = comparaciones;
        this.intercambios = intercambios;
        this.tiempoPared = tiempoPared;
        this.mejor = mejor;

    }
    
}
