package co.edu.distrital;

import co.edu.distrital.model.Candidato.Candidato;
import co.edu.distrital.model.Dato.ActoCorrupcion;
import co.edu.distrital.model.Dato.Clase;
import co.edu.distrital.model.Dato.Marcha;
import co.edu.distrital.model.Dato.Prebenda;
import co.edu.distrital.model.Dato.Soborno;
import co.edu.distrital.model.Fabrica.FabricaActoCorrupcion;
import co.edu.distrital.model.Fabrica.FabricaClase;
import co.edu.distrital.model.Fabrica.FabricaMarcha;
import co.edu.distrital.model.Fabrica.FabricaPrebenda;
import co.edu.distrital.model.Fabrica.FabricaSoborno;

//Testing candidato class
public class test4 {

    public static void main(String[] args) {

        int semilla = 12345;
        int cantidad = 5;

        FabricaMarcha fabricaMarcha = new FabricaMarcha(semilla);
        FabricaPrebenda fabricaPrebenda = new FabricaPrebenda(semilla);
        FabricaClase fabricaClase = new FabricaClase(semilla);
        FabricaActoCorrupcion fabricaActo = new FabricaActoCorrupcion(semilla);
        FabricaSoborno fabricaSobornos = new FabricaSoborno(semilla);

        Marcha[] marchas = fabricaMarcha.crearDato(cantidad);
        Prebenda[] prebendas = fabricaPrebenda.crearDato(cantidad);
        Clase[] clases = fabricaClase.crearDato(cantidad);
        ActoCorrupcion[] actos = fabricaActo.crearDato(cantidad);
        Soborno[] sobornos = fabricaSobornos.crearDato(cantidad);

        Candidato candidato = new Candidato(1, "Jhon Doe", "lol", sobornos, actos, prebendas, clases, marchas);
        System.out.println("Candidato: " + candidato);
        
    }

}
