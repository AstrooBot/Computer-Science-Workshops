package controller.ordenamiento;

import model.Banco;
import model.Candidato;

public abstract class IOrdenador {

    public Banco banco;

    public IOrdenador(Banco banco) {
        this.banco = banco;
    }
    //TODO: posible memoty leak y revisar funcionalidad
    public long[] getAtributos(String atributo) {

        int acumTamano = 0;

        for(int i = 0; i < this.banco.getOcupados(); i++) {
            acumTamano += (int) this.banco.buscar(i).getAtributos(atributo).length;
        } 

        long[] acum = new long[acumTamano];
        int pos = 0;
        for (int i = 0; i < this.banco.getOcupados(); i++) {
            Candidato candidato = this.banco.buscar(i);
            System.arraycopy(candidato.getAtributos(atributo), 0 , acum, pos, candidato.getAtributos(atributo).length);
            pos += candidato.getAtributos(atributo).length;
        }
        return acum;
    }

    //TODO: posible memory leak
    public long verficarData(long[] data) {
        long anterior = data[0];
        long contador = 0;

        for (int i = 1; i < data.length; i++) {
            long actual = data[i];
            if (actual < anterior) {
                contador++;
            }
            anterior = actual; 
        }
        return contador; 
    }

    public abstract void ordenar(String atributo);
    
}
