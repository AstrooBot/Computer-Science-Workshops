package co.edu.distrital.model.Fabrica;

import co.edu.distrital.model.Dato.Prebenda;

public class FabricaPrebenda extends Fabrica {

    public FabricaPrebenda(int semilla) {
        super(semilla);
    }

    @Override
    public Prebenda[] crearDato(int cantidad) {
        Prebenda[] prebendas = new Prebenda[cantidad];
        for (int i = 0; i < cantidad; i++) {
            prebendas[i] = new Prebenda(this.baseDatos.getNombreIglesia(), this.baseDatos.getLong(), this.baseDatos.getTipoIglesia());
        }
        return prebendas;
        
    }
    
}
