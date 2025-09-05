package controller.ordenamiento;

import model.Banco;

public class Burbuja extends IOrdenador {

    private long[] elementos;
    
     /**
     * Constructor de la clase Burbuja.
     *
     * @param banco instancia de la clase Banco que contiene los candidatos a ordenar.
     */

    public Burbuja(Banco banco) {
        super(banco);
    }
    @Override
    public void ordenar(String atributo) {
       long valor1, valor2, swap;
       int swapped;
       this.elementos = this.getAtributos(atributo);
        while(true) {
        swapped = 0;
        for (int i = 0; i+1 < elementos.length; i++) {
            valor1 = elementos[i];
            valor2 = elementos[i+1];

            if(valor1 > valor2) {
                swap = elementos[i];
                elementos[i] = elementos[i+1];
                this.banco.mover(i, i+1);
                elementos[i+1] = swap;
                swapped++;
            }
        }
            if (swapped == 0) break;
        }   
    }
}
