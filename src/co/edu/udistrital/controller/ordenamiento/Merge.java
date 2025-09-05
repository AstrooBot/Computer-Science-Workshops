package controller.ordenamiento;

import java.util.Arrays;

import model.Banco;

public class Merge extends IOrdenador {

    public Merge(Banco banco) {
        super(banco);
    }

    public long[] dividir(long [] elementos) {

        int numDivide = 0;
        if(elementos.length % 2 != 0) {
        //impares
            numDivide = (elementos.length + 2) / 2;
        }
        else {
            //pares
            numDivide = elementos.length / 2;
        }
        long[] izq = Arrays.copyOfRange(elementos, 0, numDivide);
        long[] der = Arrays.copyOfRange(elementos, numDivide, elementos.length);
        
    }

    @Override
    public void ordenar(String atributo) {
        long[] elementos = this.getAtributos(atributo);
    }

    
    
}
