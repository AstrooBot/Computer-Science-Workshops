package co.edu.distrital.controller;

public class Mesa {

    public ControladorPastores controladorPastores;

    public Mesa(int semilla, int cantidadPastores) {
        this.controladorPastores = new ControladorPastores(semilla);
        controladorPastores.crearListaPastores(cantidadPastores);
    }

    
    
}
