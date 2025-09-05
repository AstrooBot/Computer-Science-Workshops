package controller.ordenamiento;

import model.Banco;

/**
 * La clase Selection implementa el algoritmo de ordenamiento por selección
 * para organizar los candidatos del banco
 *
 * <p>
 * Características principales:
 * <ul>
 *   <li>Utiliza el algoritmo de selección (Selection Sort).</li>
 *   <li>Ordena los candidatos en función de un atributo específico.</li>
 *   <li>Registra el número de intercambios realizados durante el proceso.</li>
 *   <li>Actualiza el banco con cada intercambio mediante el método {@code mover}.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Uso típico:
 * <pre>
 *     Selection selection = new Selection(banco);
 *     selection.ordenar("soborno");
 * </pre>
 * </p>
 *
 * @author Juan Esteban Galindo <jegalindom@udistrital.edu.co>
 * @version 1.0
 */
public class Selection extends IOrdenador {

    /**
     * Constructor de la clase Selection.
     *
     * @param banco instancia de la clase Banco que contiene los candidatos a ordenar.
     */
    public Selection(Banco banco) 
    {
        super(banco);
        this.setIntercambios(0);
    }

    /**
     * Ordena los elementos del banco usando el algoritmo Selection Sort.
     *
     * @param atributo el nombre del atributo por el cual se realizará la ordenación.
     */
    @Override
    public void ordenar(String atributo) 
    {
        comparaciones = 0;
        intercambios = 0;
        tiempoMs = 0;
        tiempoCpuMs = 0;

        long inicioWall = System.nanoTime();
        long inicioCpu = threadMXBean.getCurrentThreadCpuTime();
    	
        int n = this.banco.getOcupados();

        for (int i = 0; i < n - 1; i++) 
        {
            int minIndex = i;

            // Buscar el índice del menor elemento en el resto del arreglo
            for (int j = i + 1; j < n; j++) 
            {	
            	comparaciones++;
                if (elementos[j] < elementos[minIndex]) 
                {
                    minIndex = j;
                }
            }

            // Intercambiar si se encontró un elemento menor
            if (minIndex != i) 
            {
                intercambiar(i, minIndex);
            }
        }
        
        long finWall = System.nanoTime();
        long finCpu = threadMXBean.getCurrentThreadCpuTime();

        tiempoMs = (finWall - inicioWall) / 1_000_000;
        tiempoCpuMs = (finCpu - inicioCpu) / 1_000_000;
    }

    /**
     * Intercambia dos elementos del arreglo y actualiza el banco.
     *
     * @param i índice del primer elemento.
     * @param j índice del segundo elemento.
     */
    private void intercambiar(int i, int j) 
    {
        long temp = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = temp;
        this.banco.mover(i, j);
        setIntercambios(getIntercambios() + 1);
    }
    
	public long getComparaciones() {
		return comparaciones;
	}

	public void setComparaciones(long comparaciones) {
		this.comparaciones = comparaciones;
	}

	public long getIntercambios() {
		return intercambios;
	}

	public void setIntercambios(long intercambios) {
		this.intercambios = intercambios;
	}

	public long getTiempoMs() {
		return tiempoMs;
	}

	public void setTiempoMs(long tiempoMs) {
		this.tiempoMs = tiempoMs;
	}
    
}
