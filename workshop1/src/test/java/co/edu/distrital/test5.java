package co.edu.distrital;

import co.edu.distrital.model.Candidato.Candidato;
import co.edu.distrital.model.Candidato.CandidatoBuilder;

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
