package controller;

import model.Almacen;

public class Quick extends Ordenador {

    public Quick(Almacen almacen, String atributo) {
        super(almacen, atributo);

    }

    @Override
    public void ordenar() 
    {
        this.setTiempoPared();
        quickSort(0, this.datos.length - 1);
        this.setTiempoMs(this.getTiempoPared());
    }

    /**
     * Método recursivo que aplica QuickSort sobre un subarreglo.
     */
    private void quickSort(int inicio, int fin) 
    {
        if (inicio < fin) 
        {
            int pivoteIndex = particion(inicio, fin);
            quickSort(inicio, pivoteIndex - 1);
            quickSort(pivoteIndex + 1, fin);
        }
    }

    /**
     * Reorganiza el subarreglo usando el esquema de Lomuto.
     */
    private int particion(int low, int high) 
    {
        long pivot = this.datos[high];
        int i = low - 1;

        for (int j = low; j < high; j++) 
        {
            this.setComparaciones();
            if (this.datos[j] <= pivot) 
            {
                i++;
                intercambiar(i, j);
            }
        }

        intercambiar(i + 1, high);
        return i + 1;
    }

    
    
}
