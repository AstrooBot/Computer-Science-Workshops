package controller.ordenamiento;

import model.Banco;

/**
 * La clase Quick implementa el algoritmo de ordenamiento QuickSort
 * para organizar los candidatos del banco
 *
 * <p>
 * Características principales:
 * <ul>
 *   <li>Utiliza el algoritmo de ordenamiento rápido (QuickSort).</li>
 *   <li>Ordena los candidatos en función de un atributo específico.</li>
 *   <li>Registra el número de intercambios realizados durante el proceso.</li>
 *   <li>Actualiza el banco con cada intercambio mediante el método {@code mover}.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Uso típico:
 * <pre>
 *     Quick quick = new Quick(banco);
 *     quick.ordenar("sobornos");
 * </pre>
 * </p>
 *
 * @author Juan Esteban Galindo <jegalindom@udistrital.edu.co>
 * @version 1.0
 */
public class Quick extends IOrdenador {

    /**
     * Constructor de la clase Quick.
     *
     * @param banco instancia de la clase Banco que contiene los candidatos a ordenar.
     */
    public Quick(Banco banco) 
    {
        super(banco);
        this.setIntercambios(0);
    }

    /**
     * Ordena los elementos del banco usando el algoritmo QuickSort.
     *
     * @param atributo el nombre del atributo por el cual se realizará la ordenación.
     */
    @Override
    public void ordenar(String atributo) 
    {   this.elementos = this.getAtributos(atributo);
        setIntercambios(0);
        quickSort(0, this.banco.getOcupados() - 1);
    }

    /**
     * Método recursivo que aplica el algoritmo QuickSort.
     *
     * @param inicio índice inicial del subarreglo.
     * @param fin índice final del subarreglo.
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
     * Reorganiza el subarreglo colocando todos los elementos menores o iguales al pivote
     * a su izquierda y los mayores a su derecha.
     *
     * @param inicio índice inicial del subarreglo.
     * @param fin índice final del subarreglo, que contiene el pivote.
     * @return la nueva posición del pivote después de la partición.
     */
    private int particion(int inicio, int fin) 
    {
        long pivote = elementos[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) 
        {
            if (elementos[j] <= pivote) 
            {
                i++;
                intercambiar(i, j);
            }
        }
        intercambiar(i + 1, fin);
        return i + 1;
    }

    /**
     * Intercambia dos elementos del arreglo y actualiza el banco.
     *
     * @param i índice del primer elemento.
     * @param j índice del segundo elemento.
     */
    private void intercambiar(int i, int j) 
    {
        if (i != j) 
        {
            long temp = elementos[i];
            elementos[i] = elementos[j];
            elementos[j] = temp;
            this.banco.mover(i, j);
            setIntercambios(getIntercambios() + 1);
        }
    }

}