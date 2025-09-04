package controller;

public class Burbuja extends IOrdenador {

    public Burbuja(model.Banco banco) {
        super(banco);
    }

    @Override
    public void ordenar(String atributo) {
       long valor1, valor2, swap;
       int swapped;

        while(true) {
        swapped = 0;
        for (int i = 0; i+1 < this.banco.getOcupados(); i++) {
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
