package co.edu.distrital;

import model.Candidato.Candidato;
import model.Candidato.CandidatoBuilder;

/**
 * Clase de prueba para la clase {@code CandidatoBuilder}.
 * <p>
 * Este programa crea una cantidad específica de objetos {@code Candidato}
 * utilizando una semilla dada para la generación aleatoria, y luego imprime
 * cada candidato generado en la consola.
 * </p>
 *
 * <p>
 * Parámetros:
 * <ul>
 *   <li>{@code semilla}: Semilla utilizada para la generación aleatoria de candidatos.</li>
 *   <li>{@code cantidadCandidatos}: Número de candidatos a generar.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Uso:
 * <pre>
 *   java test5
 * </pre>
 * </p>
 *
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class test5 {

//Testing candidato builder class
    public static void main(String[] args) {

        int semilla = 12345;
        int cantidadCandidatos = 5;

        CandidatoBuilder candidatoBuilder = new CandidatoBuilder(semilla);
        Candidato[] candidatos = candidatoBuilder.buildCandidatos(cantidadCandidatos);

        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }
        
    }
    
}
