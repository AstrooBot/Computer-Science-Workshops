package controller.ordenamiento;

import model.Banco;
/**
 * La clase Merge implementa el algoritmo de ordenamiento MergeSort
 * para organizar los candidatos del banco
 *
 * <p>
 * Características principales:
 * <ul>
 *   <li>Utiliza el algoritmo de mezcla (MergeSort), basado en divide y vencerás.</li>
 *   <li>Ordena los candidatos en función de un atributo específico.</li>
 *   <li>Registra el número de intercambios realizados durante el proceso.</li>
 *   <li>Actualiza el banco con cada intercambio mediante el método {@code mover}.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Uso típico:
 * <pre>
 *     Merge merge = new Merge(banco);
 *     merge.ordenar("soborno");
 * </pre>
 * </p>
 *
 * @author Juan Esteban Galindo <jegalindom@udistrital.edu.co>
 * @version 1.0
 */
public class Merge extends IOrdenador {

    private int intercambios;
    private long[] elementos;

    /**
     * Constructor de la clase Merge.
     *
     * @param banco instancia de la clase Banco que contiene los candidatos a ordenar.
     */
    public Merge(Banco banco) 
    {
        super(banco);
        this.setIntercambios(0);
    }

    /**
     * Ordena los candidatos del banco usando el algoritmo MergeSort.
     *
     * @param atributo el nombre del atributo por el cual se realizará la ordenación.
     */
    @Override
    public void ordenar(String atributo) 
    {   this.elementos = this.getAtributos(atributo);
        setIntercambios(0);
        mergeSort(0, this.banco.getOcupados() - 1);
    }

    /**
     * Método recursivo que divide el arreglo en mitades y aplica MergeSort.
     *
     * @param inicio índice inicial del subarreglo.
     * @param fin índice final del subarreglo.
     */
    private void mergeSort(int inicio, int fin) 
    {
        if (inicio < fin) 
        {
            int medio = (inicio + fin) / 2;

            // Ordenar recursivamente ambas mitades
            mergeSort(inicio, medio);
            mergeSort(medio + 1, fin);

            // Combinar las dos mitades ordenadas
            merge(inicio, medio, fin);
        }
    }

    /**
     * Combina dos subarreglos ordenados en uno solo.
     *
     * @param inicio índice inicial del subarreglo izquierdo.
     * @param medio índice medio donde termina el subarreglo izquierdo.
     * @param fin índice final del subarreglo derecho.
     */
    private void merge(int inicio, int medio, int fin) 
    {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        // Crear arreglos temporales
        long[] izquierda = new long[n1];
        long[] derecha = new long[n2];

        // Copiar datos a arreglos temporales
        for (int i = 0; i < n1; i++) 
        {
            izquierda[i] = elementos[inicio + i];
        }
        for (int j = 0; j < n2; j++) 
        {
            derecha[j] = elementos[medio + 1 + j];
        }

        // Índices iniciales para subarreglos y fusión
        int i = 0, j = 0, k = inicio;

        // Fusionar los arreglos temporales de vuelta en elementos[]
        while (i < n1 && j < n2) 
        {
            if (izquierda[i] <= derecha[j]) 
            {
                elementos[k] = izquierda[i];
                i++;
            } else 
            {
                elementos[k] = derecha[j];
                j++;
            }
            k++;
            setIntercambios(getIntercambios() + 1);
        }

        // Copiar los elementos restantes de izquierda[]
        while (i < n1) 
        {
            elementos[k] = izquierda[i];
            i++;
            k++;
            setIntercambios(getIntercambios() + 1);
        }

        // Copiar los elementos restantes de derecha[]
        while (j < n2) 
        {
            elementos[k] = derecha[j];
            j++;
            k++;
            setIntercambios(getIntercambios() + 1);
        }

        // Actualizar el banco según el nuevo orden
        for (int pos = inicio; pos <= fin; pos++) 
        {
            this.banco.mover(pos, pos); // mantiene sincronía con el banco
        }
    }

	public int getIntercambios() {
		return intercambios;
	}

	public void setIntercambios(int intercambios) {
		this.intercambios = intercambios;
	}
}