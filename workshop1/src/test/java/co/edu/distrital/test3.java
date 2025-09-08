package co.edu.distrital;

import co.edu.distrital.model.Fabrica.*;
import co.edu.distrital.model.Dato.*;

public class test3 {
//Testing fabricas
    public static void main(String[] args) {
        int semilla = 12345;
        long cantidad = 5;

        FabricaMarcha fabricaMarcha = new FabricaMarcha(semilla);
        FabricaPrebenda fabricaPrebenda = new FabricaPrebenda(semilla);
        FabricaClase fabricaClase = new FabricaClase(semilla);
        FabricaActoCorrupcion fabricaActo = new FabricaActoCorrupcion(semilla);
        FabricaSoborno fabricaSobornos = new FabricaSoborno(semilla);

        Marcha[] marchas = fabricaMarcha.crearDato((int) cantidad);
        Prebenda[] prebendas = fabricaPrebenda.crearDato((int) cantidad);
        Clase[] clases = fabricaClase.crearDato((int) cantidad);
        ActoCorrupcion[] actos = fabricaActo.crearDato((int) cantidad);
        Soborno[] sobornos = fabricaSobornos.crearDato((int) cantidad);

        for (Idato marcha : marchas) {
            System.out.println(marcha);
        }
        for (Idato prebenda : prebendas) {
            System.out.println(prebenda);
        }
        for (Idato clase : clases) {
            System.out.println(clase);
        }
        for (Idato acto : actos) {
            System.out.println(acto);
        }
        for (Idato soborno : sobornos) {
            System.out.println(soborno);
        }

    }
    
}
