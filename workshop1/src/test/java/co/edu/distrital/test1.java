package co.edu.distrital;


import model.Dato.*;

//Testing Idato interface and its implementation
/**
 * Clase de prueba para la creación y demostración de diferentes tipos de objetos que implementan la interfaz Idato.
 * 
 * <p>Esta clase instancia varios objetos representando diferentes eventos o entidades, como actos de corrupción,
 * sobornos, prebendas, clases y marchas. Luego imprime la representación en cadena de cada uno de ellos.</p>
 * 
 * <p>Variables utilizadas:</p>
 * <ul>
 *   <li>fecha: Fecha del evento.</li>
 *   <li>responsable: Persona responsable del evento.</li>
 *   <li>lugar: Lugar donde ocurre el evento.</li>
 *   <li>cantidad: Cantidad asociada al evento (por ejemplo, dinero o número de personas).</li>
 *   <li>nombreIglesia: Nombre de la iglesia involucrada.</li>
 *   <li>tipoIglesia: Tipo de iglesia.</li>
 *   <li>carrera: Carrera universitaria asociada.</li>
 *   <li>nombreClase: Nombre de la clase.</li>
 *   <li>nombre: Nombre de la marcha.</li>
 *   <li>distancia: Distancia recorrida en la marcha.</li>
 * </ul>
 * 
 * <p>Objetos creados:</p>
 * <ul>
 *   <li>ActoCorrupcion</li>
 *   <li>Soborno</li>
 *   <li>Prebenda</li>
 *   <li>Clase</li>
 *   <li>Marcha</li>
 * </ul>
 * 
 * <p>Cada objeto es impreso usando su método {@code toString()}.</p>
 * 
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class test1 {

    public static void main(String[] args) {
        String fecha = "2023-10-10";
        String responsable = "John Doe";
        String lugar = "Bogota";
        long cantidad = 1000000L;
        String nombreIglesia = "Iglesia Central";
        String tipoIglesia = "Catolica";
        String carrera = "Ingenieria de Sistemas";
        String nombreClase = "Programacion I";
        String nombre = "Marcha por la Paz";
        long distancia = 5L;

        Idato acto = new ActoCorrupcion(fecha, responsable, lugar);
        Idato soborno = new Soborno(fecha, cantidad, responsable);
        Idato prebenda = new Prebenda(nombreIglesia, cantidad, tipoIglesia);
        Idato clase = new Clase(nombreClase, carrera, cantidad);
        Idato marcha = new Marcha(nombre,distancia,fecha);

        System.out.println(acto.toString());
        System.out.println(soborno.toString());
        System.out.println(prebenda.toString());
        System.out.println(clase.toString());
        System.out.println(marcha.toString());
 
    }
    
}
