package co.edu.distrital;

import co.edu.distrital.controller.*;
import co.edu.distrital.model.Almacen;

public class test8 {
    public static void main(String[] args) {
        
    
        Almacen almacen = new Almacen(1234, 10);
        Burbuja burbuja = new Burbuja(almacen, "soborno");
        Insercion insercion = new Insercion(almacen, "soborno");
        Merge merge = new Merge(almacen, "soborno");
        Quick quick = new Quick(almacen, "soborno");
        Selection seleccion = new Selection(almacen, "soborno");
        burbuja.ordenar();
        insercion.ordenar();
        merge.ordenar();
        quick.ordenar();
        seleccion.ordenar();

        Reporte reporte = new Reporte(
            new String[]{"Burbuja", "Inserción", "Merge", "Quick", "Selección"},
            new int[]{burbuja.getComparaciones(), insercion.getComparaciones(), merge.getComparaciones(), quick.getComparaciones(), seleccion.getComparaciones()},
            new int[]{burbuja.getIntercambios(), insercion.getIntercambios(), merge.getIntercambios(), quick.getIntercambios(), seleccion.getIntercambios()},
            new double[]{burbuja.getTiempoPared(), insercion.getTiempoPared(), merge.getTiempoPared(), quick.getTiempoPared(), seleccion.getTiempoPared()},
            new String[]{burbuja.best().toString(), insercion.best().toString(), merge.best().toString(), quick.best().toString(), seleccion.best().toString()}
        );
        reporte.generateCSV();
            

    }
    
}
