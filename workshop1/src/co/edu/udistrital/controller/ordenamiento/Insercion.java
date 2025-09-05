package controller.ordenamiento;

import model.Banco;

public class Insercion extends IOrdenador {

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
        this.comparaciones = 0;
        this.intercambios = 0;
        tiempoMs = 0;
        tiempoCpuMs = 0;

        this.elementos = this.banco.getAtributos(atributo);
        
        long inicioWall = System.nanoTime();
        long inicioCpu = threadMXBean.getCurrentThreadCpuTime();

    this.setIntercambios(0);
    for (int i = 1; i < elementos.length; i++) {
        long ref = elementos[i];
        int innerIndex = i - 1;

        while (innerIndex >= 0 && elementos[innerIndex] > ref) {
            
            elementos[innerIndex + 1] = elementos[innerIndex];
            intercambiar(innerIndex, innerIndex + 1);
            innerIndex--;
            this.setIntercambios(this.getIntercambios() + 1);
            }
    
        this.comparaciones++; 

        elementos[innerIndex + 1] = ref;
        }
    long finWall = System.nanoTime();
    long finCpu = threadMXBean.getCurrentThreadCpuTime();

    tiempoMs = (finWall - inicioWall) / 1_000_000;
    tiempoCpuMs = (finCpu - inicioCpu) / 1_000_000;  
    }
        private void intercambiar(int i, int j) 
    {
        long temp = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = temp;
        banco.mover(i, j);
        intercambios++;
    }
}