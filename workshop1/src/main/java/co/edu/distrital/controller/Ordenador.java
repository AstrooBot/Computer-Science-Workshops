package controller;

import model.Almacen;
import model.Candidato.Candidato;

/**
 * Clase abstracta que define la estructura básica para los algoritmos de ordenamiento.
 * Proporciona métodos y atributos comunes para medir el rendimiento del algoritmo,
 * como el número de comparaciones, intercambios y el tiempo de ejecución.
 * 
 * Los algoritmos concretos deben implementar el método {@link #ordenar()}.
 * 
 * Campos principales:
 * <ul>
 *   <li>{@code almacen}: Referencia al almacén de datos a ordenar.</li>
 *   <li>{@code comparaciones}: Número de comparaciones realizadas durante el ordenamiento.</li>
 *   <li>{@code intercambios}: Número de intercambios realizados durante el ordenamiento.</li>
 *   <li>{@code tiempoPared}: Marca de tiempo para calcular la duración del algoritmo.</li>
 *   <li>{@code tiempoMs}: Tiempo total de ejecución en milisegundos.</li>
 *   <li>{@code datos}: Arreglo de datos extraído del almacén según el atributo especificado.</li>
 * </ul>
 * 
 * Métodos principales:
 * <ul>
 *   <li>{@link #ordenar()}: Método abstracto que debe implementar el algoritmo de ordenamiento.</li>
 *   <li>{@link #intercambiar(int, int)}: Intercambia dos elementos en el almacén y actualiza el contador de intercambios.</li>
 *   <li>{@link #best()}: Devuelve el mejor candidato (primer elemento del almacén).</li>
 *   <li>{@link #getComparaciones()}, {@link #setComparaciones()}: Obtienen e incrementan el contador de comparaciones.</li>
 *   <li>{@link #getIntercambios()}, {@link #setIntercambios()}: Obtienen e incrementan el contador de intercambios.</li>
 *   <li>{@link #getTiempoPared()}, {@link #setTiempoPared()}: Calculan y establecen el tiempo de ejecución.</li>
 * </ul>
 * 
 * @author TuNombre
 */

public abstract class Ordenador {

    public Almacen almacen;
    private int comparaciones;
    public int intercambios;
    private long tiempoPared;
    public double tiempoMs;
    public long[] datos;

    /**
     * Obtiene el tiempo de ejecución en milisegundos.
     *
     * @return el tiempo de ejecución en milisegundos.
     */

    public double getTiempoMs() {
        return tiempoMs;
    }
    /**
     * Establece el tiempo de ejecución en milisegundos.
     *
     * @param tiempoMs el tiempo de ejecución en milisegundos.
     */
    public void setTiempoMs(double tiempoMs) {
        this.tiempoMs = tiempoMs;
    }

    /**
     * Constructor de la clase Ordenador.
     *
     * @param almacen   el almacén de datos a ordenar.
     * @param atributo  el atributo por el cual se ordenarán los datos.
     */
    public Ordenador(Almacen almacen, String atributo) {
        this.almacen = almacen;
        this.datos = this.almacen.getDatos(atributo);
        this.comparaciones = 0;
        this.intercambios = 0;
        this.tiempoPared = 0;
    }

    /**
     * Obtiene el número de comparaciones realizadas durante la ordenación.
     *
     * @return el número de comparaciones.
     */
    public long getComparaciones() {
        return comparaciones;
    }
    /**
     * Incrementa en uno el contador de comparaciones.
     */
    public void setComparaciones() {
        this.comparaciones++;
    }

    /**
     * Obtiene el número de intercambios realizados durante la ordenación.
     *
     * @return el número de intercambios.
     */

    public long getIntercambios() {
        return intercambios;
    }

    /**
     * Incrementa en uno el contador de intercambios.
     */
    public void setIntercambios() {
        this.intercambios++;
    }

    /**
     * Calcula el tiempo transcurrido desde que se inició la medición.
     *
     * @return el tiempo transcurrido en milisegundos.
     */
    public double getTiempoPared() {
        long fin = System.nanoTime();
        long duracion = fin - tiempoPared;
        double milisegundos = duracion / 1_000_000.0;
        return milisegundos;
    }

    /**
     * Establece el tiempo de inicio para la medición del tiempo de ejecución.
     */
    public void setTiempoPared() {
        this.tiempoPared = System.nanoTime();
    }

    /**
     * Intercambia dos elementos en el almacén y actualiza el contador de intercambios.
     *
     * @param i índice del primer elemento.
     * @param j índice del segundo elemento.
     */
    public void intercambiar(int i, int j) {
        this.almacen.mover(i, j);
        this.setIntercambios();
    }

    /**
     * Obtiene el mejor candidato (primer elemento) del almacén.
     *
     * @return el mejor candidato.
     */
    public Candidato best() {
        return this.almacen.getCandidato(0);
    }

    /**
     * Devuelve una representación en cadena del objeto Ordenador.
     *
     * @return una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        return "Ordenamiento: " + this.getClass().getSimpleName() +
                ", comparaciones: " + comparaciones +
                ", intercambios: " + intercambios +
                ", tiempoMs: " + tiempoMs;
    }
    /**
     * Método abstracto que debe implementar el algoritmo de ordenamiento.
     */
    public abstract void ordenar();


}
