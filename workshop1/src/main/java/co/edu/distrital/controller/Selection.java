package controller;

import model.Almacen;

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
                this.setIntercambios();
            }
        }
    this.setTiempoMs(this.getTiempoPared());    

    }


    
}
