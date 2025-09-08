package co.edu.distrital;

import co.edu.distrital.model.BaseDatos;

//Testing BaseDatos class
public class test2 {

    public static void main(String[] args) {
        BaseDatos bd = BaseDatos.getInstance(12345);
        BaseDatos bd2 = BaseDatos.getInstance(67890);
        System.out.println("Nombre: " + bd.getNombre());
        System.out.println("Apellido: " + bd.getApellido());
        System.out.println("Lugar: " + bd.getLugar());
        System.out.println("Partido: " + bd.getPartido());
        System.out.println("Nombre Iglesia: " + bd.getNombreIglesia());
        System.out.println("Nombre Clase: " + bd.getNombreClase());
        System.out.println("Nombre Marcha: " + bd.getNombreMarcha());
        System.out.println("Entidad: " + bd.getEntidad());
        System.out.println("Tipo Iglesia: " + bd.getTipoIglesia());
        System.out.println("Carrera: " + bd.getCarrera());
        System.out.println("-----");
        System.out.println("Nombre: " + bd2.getNombre());
        System.out.println("Apellido: " + bd2.getApellido());
        System.out.println("Lugar: " + bd2.getLugar());
        System.out.println("Partido: " + bd2.getPartido());
        System.out.println("Nombre Iglesia: " + bd2.getNombreIglesia());
        System.out.println("Nombre Clase: " + bd2.getNombreClase());
        System.out.println("Nombre Marcha: " + bd2.getNombreMarcha());
        System.out.println("Entidad: " + bd2.getEntidad());
        System.out.println("Tipo Iglesia: " + bd2.getTipoIglesia());
        System.out.println("Carrera: " + bd2.getCarrera());
        System.out.println("Fecha: " + bd2.getFecha());
    }
    
}
