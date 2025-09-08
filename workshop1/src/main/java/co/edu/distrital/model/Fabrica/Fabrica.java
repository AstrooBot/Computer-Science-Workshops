package model.Fabrica;

import model.BaseDatos;
import model.Dato.Idato;

public abstract class Fabrica {
    private int semilla;
    public BaseDatos baseDatos;

    public Fabrica(int semilla) {
        this.semilla = semilla;
        this.baseDatos = BaseDatos.getInstance(semilla);
    }

    public abstract Idato[] crearDato(int cantidad);
    
}
