package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Candidato.Candidato;
import model.Candidato.CandidatoBuilder;

/**
 * La clase {@code Almacen} representa un almacén de candidatos, permitiendo su generación,
 * manipulación y obtención de datos asociados a cada candidato.
 * 
 * <p>Provee métodos para acceder a candidatos por posición o ID, obtener diferentes tipos de datos
 * relacionados con los candidatos, y preparar los datos en diferentes modos de ordenamiento.
 * 
 * <p>Utiliza un {@code CandidatoBuilder} para la creación de los candidatos y mantiene la
 * reproducibilidad mediante el uso de una semilla para la generación aleatoria.
 * 
 * <ul>
 *   <li>{@link #getById(int)}: Obtiene un candidato por su ID.</li>
 *   <li>{@link #getCandidato(int)}: Obtiene un candidato por su posición en el arreglo.</li>
 *   <li>{@link #getDatos(String)}: Obtiene datos específicos de los candidatos según el tipo solicitado.</li>
 *   <li>{@link #mover(int, int)}: Intercambia dos candidatos en posiciones dadas.</li>
 *   <li>{@link #prepararDatos(long[], String)}: Prepara un arreglo de datos en diferentes modos de ordenamiento.</li>
 * </ul>
 * 
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class Almacen {

    private CandidatoBuilder candidatoBuilder;
    private Candidato[] candidatos;
    private Random random;


    public Almacen(int semilla, int cantidadCandidatos) {
        this.candidatoBuilder = new CandidatoBuilder(semilla);
        this.candidatos = this.generarCandidatos(cantidadCandidatos);
        this.random = new Random(semilla);
    }

    private Candidato[] generarCandidatos(int cantidadCandidatos) {
        return this.candidatoBuilder.buildCandidatos(cantidadCandidatos);
    }

    public Candidato getById(int id) {

        for (Candidato candidato : this.candidatos) {
            if (candidato.getId() == id - 1) {
                return candidato;
            }
        }
        return null;

    }

    public Candidato getCandidato(int posicion) {
        return this.candidatos[posicion];
  
    }
    private long[] reduce2Dto1D(long[][] array2d) {

        int tamaño = 0;
        for (long[] row : array2d) {
            tamaño += row.length;
        }

        long[] array1d = new long[tamaño];
        int index = 0;
        for (long[] row : array2d) {
            for (long num : row) {
                array1d[index++] = num;
            }
        }
        return array1d;
    }

    public long[] getDatos(String tipoDato) {
        long[][] datos = new long[candidatos.length][];
        long[] datos1d = null;
        switch (tipoDato.toLowerCase()) {
            case"soborno":
                for (int i = 0; i < candidatos.length; i++){datos[i] = this.getCandidato(i).getLongSobornos();}
                datos1d = this.reduce2Dto1D(datos);
                break;
            case"actocorrupcion":
                datos1d = new long[candidatos.length];
                for (int i = 0; i < candidatos.length; i++) {datos1d[i] = this.getCandidato(i).getLongActosCorrupcion();}
                break;
            case"prebenda":
                for (int i = 0; i < candidatos.length; i++) {datos[i] = this.getCandidato(i).getLongPrebendas();}
                datos1d = this.reduce2Dto1D(datos);
                break;
            case"clase":
                for (int i = 0; i < candidatos.length; i++) {datos[i] = this.getCandidato(i).getLongClases();}
                datos1d = this.reduce2Dto1D(datos);
                break;
            case"marcha":
                for (int i = 0; i < candidatos.length; i++) {datos[i] = this.getCandidato(i).getLongMarchas();}
                datos1d = this.reduce2Dto1D(datos);
                break;
            default:
                datos1d = new long[0];
                break;
        }
        return datos1d;
    }

	public void mover(int posicionVieja, int posicionNueva) {
		if(posicionVieja >= 0 && posicionVieja < candidatos.length && posicionNueva >= 0 && posicionNueva < candidatos.length) {
			Candidato temp = this.candidatos[posicionVieja];
			this.candidatos[posicionVieja] = this.candidatos[posicionNueva];
			this.candidatos[posicionNueva] = temp;
		}
	}

public void prepararDatos(long[] elementos, String modo) {
        
        int n = elementos.length;
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

            case "casi ordenada":
                Collections.sort(lista);
                // Realizar algunas perturbaciones al azar
                int perturbaciones = Math.max(1, n / 10); // 10% del tamaño
                for (int i = 0; i < perturbaciones; i++) {
                    int a = random.nextInt(n);
                    int b = random.nextInt(n);
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
            this.mover(i, i); // mantiene sincronía
        }
    }




 
    
}
