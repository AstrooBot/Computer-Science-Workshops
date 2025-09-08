package controller;

import model.Almacen;

public class Burbuja extends Ordenador {
	/**
	 * La clase Insercion implementa el algoritmo de ordenamiento por burbuja.
	 * Extiende la clase Ordenador y utiliza un almacén de datos y un atributo específico para ordenar.
	 * Este algoritmo es eficiente para listas pequeñas y casi ordenadas.
	 *
	 * @author Nicolas Diaz Salamanca <jndiasz@udistrital.edu.co>
	 */
    public Burbuja(Almacen almacen, String atributo) {
        super(almacen, atributo);

    }
    /**
     * Constructor de la clase burbuja.
     * Inicializa el objeto con el almacén y el atributo a ordenar.
     *
     * @param almacen  El almacén de datos a ordenar.
     * @param atributo El atributo por el cual se realizará el ordenamiento.
     */

    @Override
    public void ordenar() 
    {
       this.setTiempoPared();
       long valor1, valor2, swap;
       int swapped;

        while(true) 
        {
        	swapped = 0;
        	for (int i = 0; i+1 < this.datos.length; i++) 
        	{
        		this.setComparaciones();
        	
        		valor1 = this.datos[i];
        		valor2 = this.datos[i+1];

        		if(valor1 > valor2) {
        			swap = this.datos[i];
        			this.datos[i] = this.datos[i+1];
        			this.almacen.mover(i, i+1);
        			this.datos[i+1] = swap;

        			this.setIntercambios();
        			swapped++;
        		}
            
        	}
            if (swapped == 0) break;
        }
        
    }
    
}
