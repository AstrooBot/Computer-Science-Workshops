package controller;

import model.Almacen;

public class Merge extends Ordenador {

    /**
     * La clase Merge implementa el algoritmo de ordenamiento por mezcla (Merge Sort).
     * Extiende la clase Ordenador y utiliza un almacén de datos y un atributo específico para ordenar.
     * Este algoritmo es eficiente para listas grandes y desordenadas.
     *
     * @author Juan Esteban Galeano
        */
    public Merge(Almacen almacen, String atributo) {
        super(almacen, atributo);

    }
    /**
     * Constructor de la clase Merge.
     * Inicializa el objeto con el almacén y el atributo a ordenar.
     *
     * @param almacen  El almacén de datos a ordenar.
     * @param atributo El atributo por el cual se realizará el ordenamiento.
     */
   @Override
    public void ordenar() 
    {
        this.setTiempoPared();
        mergeSort(0, this.datos.length - 1);
        this.setTiempoMs(this.getTiempoPared());
    }

    /**
     * Método recursivo que divide el arreglo en mitades y aplica MergeSort.
     *
     * @param inicio índice inicial del subarreglo.
     * @param fin índice final del subarreglo.
     */
    private void mergeSort(int inicio, int fin) 
    {
        if (inicio < fin) 
        {
            int medio = (inicio + fin) / 2;

            // Ordenar recursivamente ambas mitades
            mergeSort(inicio, medio);
            mergeSort(medio + 1, fin);

            // Combinar las dos mitades ordenadas
            merge(inicio, medio, fin);
        }
    }

    /**
     * Combina dos subarreglos ordenados en uno solo.
     *
     * @param inicio índice inicial del subarreglo izquierdo.
     * @param medio índice medio donde termina el subarreglo izquierdo.
     * @param fin índice final del subarreglo derecho.
     */
    private void merge(int inicio, int medio, int fin) 
    {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        // Crear arreglos temporales
        long[] izquierda = new long[n1];
        long[] derecha = new long[n2];

        // Copiar datos a arreglos temporales
        for (int i = 0; i < n1; i++) 
        {
            izquierda[i] = this.datos[inicio + i];
        }
        for (int j = 0; j < n2; j++) 
        {
            derecha[j] = this.datos[medio + 1 + j];
        }

        // Índices iniciales para subarreglos y fusión
        int i = 0, j = 0, k = inicio;

        // Fusionar los arreglos temporales de vuelta en datos[]
        while (i < n1 && j < n2) 
        {
        	this.setComparaciones();
        	
            if (izquierda[i] <= derecha[j]) 
            {
                this.datos[k] = izquierda[i];
                i++;
            } else 
            {
                this.datos[k] = derecha[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de izquierda[]
        while (i < n1) 
        {
            this.datos[k] = izquierda[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de derecha[]
        while (j < n2) 
        {
            this.datos[k] = derecha[j];
            j++;
            k++; 
        }

        // Actualizar el banco según el nuevo orden
        for (int pos = inicio; pos <= fin; pos++) 
        {
            this.intercambiar(pos, pos); 
        }
    }


}
