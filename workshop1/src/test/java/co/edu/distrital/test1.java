package co.edu.distrital;


import co.edu.distrital.model.Dato.*;

//Testing Idato interface and its implementation
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
