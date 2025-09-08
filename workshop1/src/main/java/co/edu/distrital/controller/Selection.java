package controller;

import model.Almacen;

/**
 * La clase {@code Selection} implementa el algoritmo de ordenamiento Selection Sort
 * para ordenar los elementos almacenados en un {@link Almacen} según un atributo específico.
 * Hereda de la clase {@code Ordenador} y sobreescribe el método {@code ordenar()} para
 * realizar la ordenación, registrando el número de comparaciones, intercambios y el tiempo
 * de ejecución.
 *
 * <p>El algoritmo Selection Sort recorre el arreglo buscando el elemento más pequeño
 * en cada iteración y lo intercambia con el elemento en la posición actual, hasta que
 * el arreglo esté completamente ordenado.</p>
 *
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class Selection extends Ordenador {

    public Selection(Almacen almacen, String atributo) {
        super(almacen, atributo);
    }

    /**
     * Ordena los elementos del banco usando el algoritmo Selection Sort.
     *
     * @param atributo el nombre del atributo por el cual se realizará la ordenación.
     */
    @Override
    public void ordenar() 
    {
        this.setTiempoPared();
        int n = this.datos.length;

        for (int i = 0; i < n - 1; i++) 
        {
            int minIndex = i;

            // Buscar el índice del menor elemento en el resto del arreglo
            for (int j = i + 1; j < n; j++) 
            {	
            	this.setComparaciones();
                if (this.datos[j] < this.datos[minIndex]) 
                {
                    minIndex = j;
                }
            }

            // Intercambiar si se encontró un elemento menor
            if (minIndex != i) 
            {
                intercambiar(i, minIndex);
            }
        }
    this.setTiempoMs(this.getTiempoPared());    

    }  
}
