package controller;

import java.util.Arrays;

import model.Banco;
import model.Candidato;

public abstract class IOrdenador {

    public Banco banco;
    public long[] elementos;

    public IOrdenador(Banco banco) {
        this.banco = banco;
    }

    public long[] getAtributos(String atributo) {
        long[] acum;
        int pos = 0;
        for (int i = 0; i < this.banco.getOcupados(); i++) {
            Candidato candidato = this.banco.buscar(i);
            acum = System.arraycopy(candidato.getAtributos(atributo), 0, acum, pos, candidato.getAtributos(atributo).length);
            pos += candidato.getAtributos(atributo).length;
        }
        return acum;
    }

    //TODO: verificar optimización
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

    public abstract void ordenar();
    
}
