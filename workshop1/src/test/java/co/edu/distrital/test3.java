package co.edu.distrital;

import model.Fabrica.*;
import model.Dato.*;

/**
 * Clase de prueba para la generación y prueba de diferentes tipos de datos usando fábricas.
 * <p>
 * Esta clase crea instancias de varias fábricas (FabricaMarcha, FabricaPrebenda, FabricaClase,
 * FabricaActoCorrupcion, FabricaSoborno) utilizando una semilla fija para asegurar la reproducibilidad.
 * Luego, genera una cantidad específica de objetos de cada tipo y los imprime en consola.
 * </p>
 * 
 * <p>
 * Las fábricas utilizadas deben implementar el método {@code crearDato(int cantidad)} que retorna
 * un arreglo de objetos correspondientes a cada tipo de dato.
 * </p>
 * 
 * <p>
 * Este programa es útil para probar la correcta generación y representación de los objetos
 * creados por cada fábrica.
 * </p>
 * 
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
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
