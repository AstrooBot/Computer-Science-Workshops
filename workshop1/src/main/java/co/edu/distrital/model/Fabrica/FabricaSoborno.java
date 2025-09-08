package co.edu.distrital.model.Fabrica;

import co.edu.distrital.model.Dato.Soborno;

public class FabricaSoborno extends Fabrica {

    public FabricaSoborno(int semilla) {
        super(semilla);
    }

    @Override
    public Soborno[] crearDato(int cantidad) {
        Soborno[] sobornos = new Soborno[cantidad];
        for (int i = 0; i < cantidad; i++) {
            sobornos[i] = new Soborno(this.baseDatos.getFecha(), this.baseDatos.getLong(), this.baseDatos.getNombre() + " " + this.baseDatos.getApellido());
        }
        return sobornos;
        
    }
    
}
