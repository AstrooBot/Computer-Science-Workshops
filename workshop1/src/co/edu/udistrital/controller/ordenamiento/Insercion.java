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
        comparaciones = 0;
        intercambios = 0;
        tiempoMs = 0;
        tiempoCpuMs = 0;
        
        long inicioWall = System.nanoTime();
        long inicioCpu = threadMXBean.getCurrentThreadCpuTime();

    this.setIntercambios(0);
    for (int i = 1; i < elementos.length; i++) {
        long ref = elementos[i];
        int innerIndex = i - 1;

        while (innerIndex >= 0 && elementos[innerIndex] > ref) {
            comparaciones++;
            elementos[innerIndex + 1] = elementos[innerIndex];
            this.banco.mover(innerIndex, innerIndex + 1);
            innerIndex--;
            intercambios++;
            }
        elementos[innerIndex + 1] = ref;
        }
    long finWall = System.nanoTime();
    long finCpu = threadMXBean.getCurrentThreadCpuTime();

    tiempoMs = (finWall - inicioWall) / 1_000_000;
    tiempoCpuMs = (finCpu - inicioCpu) / 1_000_000;  
    }
}