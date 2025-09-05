package controller.ordenamiento;

import model.Banco;

/**
 * La clase Quick implementa el algoritmo de ordenamiento QuickSort
 * para organizar los candidatos del banco.
 *
 * <p>
 * Características principales:
 * <ul>
 *   <li>Utiliza el algoritmo de ordenamiento rápido (QuickSort).</li>
 *   <li>Ordena los candidatos en función de un atributo específico.</li>
 *   <li>Registra comparaciones, intercambios y tiempo de ejecución.</li>
 *   <li>Actualiza el banco con cada intercambio mediante el método {@code mover}.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Uso típico:
 * <pre>
 *     Quick quick = new Quick(banco);
 *     quick.ordenar("sobornos");
 *     System.out.println("Comparaciones: " + quick.getComparaciones());
 *     System.out.println("Intercambios: " + quick.getIntercambios());
 *     System.out.println("Tiempo: " + quick.getTiempoMs() + " ms");
 * </pre>
 * </p>
 *
 * @author  Juan Esteban Galindo <jegalindom@udistrital.edu.co>
 * @version 1.1
 */
public class Quick extends IOrdenador {

    public Quick(Banco banco) 
    {
        super(banco);
    }

    @Override
    public void ordenar(String atributo) 
    {
        comparaciones = 0;
        intercambios = 0;
        tiempoMs = 0;
        tiempoCpuMs = 0;
        
        this.elementos = this.banco.getAtributos(atributo);
        
        long inicioWall = System.nanoTime();
        long inicioCpu = threadMXBean.getCurrentThreadCpuTime();

        quickSort(0, this.elementos.length - 1);
        
        long finWall = System.nanoTime();
        long finCpu = threadMXBean.getCurrentThreadCpuTime();

        tiempoMs = (finWall - inicioWall) / 1_000_000;
        tiempoCpuMs = (finCpu - inicioCpu) / 1_000_000;
    }

    /**
     * Método recursivo que aplica QuickSort sobre un subarreglo.
     */
    private void quickSort(int inicio, int fin) 
    {
        if (inicio < fin) 
        {
            int pivoteIndex = particion(inicio, fin);
            quickSort(inicio, pivoteIndex - 1);
            quickSort(pivoteIndex + 1, fin);
        }
    }

    /**
     * Reorganiza el subarreglo usando el esquema de Lomuto.
     */
    private int particion(int low, int high) 
    {
        long pivot = elementos[high];
        int i = low - 1;

        for (int j = low; j < high; j++) 
        {
            comparaciones++;
            if (elementos[j] <= pivot) 
            {
                i++;
                intercambiar(i, j);
            }
        }

        intercambiar(i + 1, high);
        return i + 1;
    }

    /**
     * Intercambia dos elementos del arreglo y actualiza el banco.
     */
    private void intercambiar(int i, int j) 
    {
        long temp = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = temp;
        banco.mover(i, j);
        intercambios++;
    }
}