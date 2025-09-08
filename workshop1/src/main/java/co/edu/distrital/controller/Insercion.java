package co.edu.distrital.controller;

import co.edu.distrital.model.Almacen;

public class Insercion extends Ordenador {

    public Insercion(Almacen almacen, String atributo) {
        super(almacen, atributo);

    }

   @Override
    public void ordenar() {
    this.setTiempoPared();
        for (int i = 1; i < this.datos.length; i++) {
            long ref = this.datos[i];
            int innerIndex = i - 1;

            while (innerIndex >= 0 && this.datos[innerIndex] > ref) {
                
                this.datos[innerIndex + 1] = this.datos[innerIndex];
                intercambiar(innerIndex, innerIndex + 1);
                innerIndex--;
                this.setIntercambios();
                }
        
            this.setComparaciones(); 
            this.datos[innerIndex + 1] = ref;
            }
        this.setTiempoMs(this.getTiempoPared());
    }
    
    
}
