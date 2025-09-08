package co.edu.distrital;

import model.Candidato.Candidato;
import model.Dato.ActoCorrupcion;
import model.Dato.Clase;
import model.Dato.Marcha;
import model.Dato.Prebenda;
import model.Dato.Soborno;
import model.Fabrica.FabricaActoCorrupcion;
import model.Fabrica.FabricaClase;
import model.Fabrica.FabricaMarcha;
import model.Fabrica.FabricaPrebenda;
import model.Fabrica.FabricaSoborno;

//Testing candidato class
/**
 * Clase de prueba para la creación y prueba de un objeto {@link Candidato} utilizando diferentes fábricas de datos.
 * <p>
 * Este programa genera instancias de {@link Marcha}, {@link Prebenda}, {@link Clase}, {@link ActoCorrupcion} y {@link Soborno}
 * utilizando semillas y cantidades definidas, y luego crea un {@link Candidato} con estos datos.
 * </p>
 *
 * <p>
 * Uso principal:
 * <ul>
 *   <li>Inicializa las fábricas con una semilla específica para obtener datos reproducibles.</li>
 *   <li>Crea arreglos de objetos de cada tipo usando las fábricas.</li>
 *   <li>Construye un {@link Candidato} con los datos generados y lo imprime por consola.</li>
 * </ul>
 * </p>
 *
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
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
