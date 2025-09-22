package co.edu.distrital.controller;


import co.edu.distrital.model.ListaCircularEnlazadaDoble;
import co.edu.distrital.model.Pastores.Pastor;
import co.edu.distrital.model.Pastores.PastorFabrica;

public class ControladorPastores {

    private PastorFabrica pastorFabrica;
    private ListaCircularEnlazadaDoble<Pastor> listaPastores;

    public ControladorPastores(int semilla) {
        this.pastorFabrica = new PastorFabrica(semilla);
        this.listaPastores = new ListaCircularEnlazadaDoble<>();
    }

    public ListaCircularEnlazadaDoble<Pastor> crearListaPastores(int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            Pastor pastor = pastorFabrica.crearPastor(i + 1);
            listaPastores.insertarNodoInicio(pastor);
        }
        return listaPastores;

    }
    
}
