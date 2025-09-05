package controller.ordenamiento;

import model.Banco;

public class Insercion extends IOrdenador {

    private long[] elementos;
    
     /**
     * Constructor de la clase Insercion.
     *
     * @param banco instancia de la clase Banco que contiene los candidatos a ordenar.
     */
    public Insercion(Banco banco) {
        super(banco);
    }
    @Override
    public void ordenar(String atributo) {

    this.elementos = this.getAtributos(atributo);
    this.setIntercambios(0);
    for (int i = 1; i < elementos.length; i++) {
        long ref = elementos[i];
        int innerIndex = i - 1;

        while (innerIndex >= 0 && elementos[innerIndex] > ref) {
            elementos[innerIndex + 1] = elementos[innerIndex];
            this.banco.mover(innerIndex, innerIndex + 1);
            innerIndex--;
            this.setIntercambios(this.getIntercambios() + 1);
            }
        elementos[innerIndex + 1] = ref;
        }  
    }
}