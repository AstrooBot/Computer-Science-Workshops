package co.edu.distrital;

import co.edu.distrital.model.Almacen;

public class test7 {


    public static void main(String[] args) {
        Almacen almacen = new Almacen(1234, 2);
        System.out.println(almacen.getById(1));
        System.out.println(almacen.getById(2));
        almacen.mover(0, 1);
        System.out.println(almacen.getById(1));
        System.out.println(almacen.getById(2));
        System.out.println("-----------------------");

        System.out.println(almacen.getDatos("soborno").length);

    }
    
}
