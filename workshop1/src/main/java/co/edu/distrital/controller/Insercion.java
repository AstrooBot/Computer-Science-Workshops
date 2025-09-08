package controller;

import model.Almacen;

/**
 * La clase Insercion implementa el algoritmo de ordenamiento por inserción.
 * Extiende la clase Ordenador y utiliza un almacén de datos y un atributo específico para ordenar.
 * Este algoritmo es eficiente para listas pequeñas y casi ordenadas.
 *
 * @author Nicolas Diaz Salamanca <jndiasz@udistrital.edu.co>
 */
public class Insercion extends Ordenador {

    /**
     * Constructor de la clase Insercion.
     * Inicializa el objeto con el almacén y el atributo a ordenar.
     *
     * @param almacen  El almacén de datos a ordenar.
     * @param atributo El atributo por el cual se realizará el ordenamiento.
     */
    public Insercion(Almacen almacen, String atributo) {
        super(almacen, atributo);
    }

    /**
     * Ordena los datos utilizando el algoritmo de inserción.
     * Realiza un seguimiento del tiempo de ejecución, número de comparaciones e intercambios.
     * Actualiza las métricas de rendimiento durante el proceso de ordenamiento.
     */
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
                }
        
            this.setComparaciones(); 
            this.datos[innerIndex + 1] = ref;
            }
        this.setTiempoMs(this.getTiempoPared());
    }
    
    
}
