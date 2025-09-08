package controller;

import model.Almacen;

public class Burbuja extends Ordenador {

    public Burbuja(Almacen almacen, String atributo) {
        super(almacen, atributo);

    }

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
