package co.edu.distrital;

import co.edu.distrital.model.Almacen;

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
