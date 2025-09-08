package co.edu.distrital.model.Fabrica;

import co.edu.distrital.model.Dato.ActoCorrupcion;

public class FabricaActoCorrupcion extends Fabrica {

    public FabricaActoCorrupcion(int semilla) {
        super(semilla);
        //TODO Auto-generated constructor stub
    }

    @Override
    public ActoCorrupcion[] crearDato(int cantidad) {
        ActoCorrupcion[] actosCorrupcion = new ActoCorrupcion[cantidad];
        for (int i = 0; i < cantidad; i++) {
            actosCorrupcion[i] = new ActoCorrupcion(this.baseDatos.getFecha(), this.baseDatos.getNombre() + " " + this.baseDatos.getApellido(), this.baseDatos.getLugar());
        }
        return actosCorrupcion;
        
    }
    
}