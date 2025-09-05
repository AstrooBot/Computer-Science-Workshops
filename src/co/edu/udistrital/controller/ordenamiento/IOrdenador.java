package controller.ordenamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Banco;
import model.Candidato;

public abstract class IOrdenador {

    public Banco banco;
    private int intercambios;
    public long[] elementos;


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

    public void prepararDatos(String modo) {
        int n = this.banco.getOcupados();

        // Pasar elementos[] a lista para manipular fácilmente
        List<Long> lista = new ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            lista.add(elementos[i]);
        }

        switch (modo.toLowerCase()) 
        {
            case "aleatoria uniforme":
                Collections.shuffle(lista);
                break;

            case "Casi ordenada":
                Collections.sort(lista);
                // Realizar algunas perturbaciones al azar
                Random rand = new Random();
                int perturbaciones = Math.max(1, n / 10); // 10% del tamaño
                for (int i = 0; i < perturbaciones; i++) {
                    int a = rand.nextInt(n);
                    int b = rand.nextInt(n);
                    Collections.swap(lista, a, b);
                }
                break;

            case "orden inverso":
                lista.sort(Collections.reverseOrder());
                break;
        }

        // Copiar de vuelta a elementos[] y actualizar banco
        for (int i = 0; i < n; i++) {
            elementos[i] = lista.get(i);
            this.banco.mover(i, i); // mantiene sincronía
        }
    }
    public int getIntercambios() {
		return intercambios;
	}

	public void setIntercambios(int intercambios) {
		this.intercambios = intercambios;
	}

    public abstract void ordenar(String atributo);
    
}
