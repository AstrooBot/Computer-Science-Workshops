package co.edu.distrital.model.Fabrica;

import co.edu.distrital.model.Dato.Marcha;

public class FabricaMarcha extends Fabrica {

    public FabricaMarcha(int semilla) {
        super(semilla);
    }

    @Override
    public Marcha[] crearDato(int cantidad) {
        Marcha[] marchas = new Marcha[cantidad];
        for (int i = 0; i < cantidad; i++) {
            marchas[i] = new Marcha(this.baseDatos.getNombreMarcha(), this.baseDatos.getLong(), this.baseDatos.getFecha());
        }
        return marchas;
        
    }
    
}
