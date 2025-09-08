package model.Fabrica;

import model.Dato.Clase;

public class FabricaClase extends Fabrica {

    public FabricaClase(int semilla) {
        super(semilla);
    }

    @Override
    public Clase[] crearDato(int cantidad) {
        Clase[] clases = new Clase[cantidad];
        for (int i = 0; i < cantidad; i++) {
            clases[i] = new Clase(this.baseDatos.getNombreClase(), this.baseDatos.getCarrera(), this.baseDatos.getLong());
        }
        return clases;
        
    }
    
}
