package co.edu.distrital.controller;


import java.util.Random;

import co.edu.distrital.model.Desposeidos;
import co.edu.distrital.model.ListaCircularEnlazadaDoble;
import co.edu.distrital.model.NodoDoble;
import co.edu.distrital.model.Pastores.Pastor;
import co.edu.distrital.model.Pastores.PastorFabrica;

public class ControladorPastores {

    private PastorFabrica pastorFabrica;
    private ListaCircularEnlazadaDoble<Pastor> listaPastores;
    private Desposeidos<Pastor> desposeidos = new Desposeidos<>();
    private Random random;

    public ControladorPastores(int semilla) {
        this.pastorFabrica = new PastorFabrica(semilla);
        this.listaPastores = new ListaCircularEnlazadaDoble<>();
        this.random = new Random(semilla);
    }

    public ListaCircularEnlazadaDoble<Pastor> crearListaPastores(int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            Pastor pastor = pastorFabrica.crearPastor(i + 1);
            listaPastores.insertarNodoInicio(pastor);
        }
        return listaPastores;

    }

    public ListaCircularEnlazadaDoble<Pastor> crearListaPastores() {

        for (int i = 0; i < listaPastores.tamano; i++) {
            Pastor pastor = pastorFabrica.crearPastor(i + 1);
            listaPastores.insertarNodoInicio(pastor);
        }
        return listaPastores;

    }

    public Pastor[] getPastores() {
        Pastor[] pastores = new Pastor[listaPastores.tamano];
        NodoDoble<Pastor> actual = listaPastores.getCabeza();
        for (int i = 0; i < listaPastores.tamano; i++) {
            pastores[i] = actual.getDato();
            actual = actual.getSiguiente();
        }
        return pastores;
    }

    public void imprimirListaPastores() {
        listaPastores.imprimir();
    }

    public void imprimirDesposeidos() {
        desposeidos.imprimir();
    }

    public void verificarOficio() {
        Pastor[] pastores = getPastores();
        boolean condition= true;
        while(condition) {
            condition = true;
        	for (int i = 1; i +1 < pastores.length; i++) 
        	{
        		Pastor valor1 = pastores[i];
        		Pastor valor2 = pastores[i+1];

        		if(valor1.getOficio().equals(valor2.getOficio())) {
        			Pastor swap = pastores[i];
        			pastores[i] = pastores[i-1];
        			pastores[i-1] = swap;
        			condition = false;
        		}
        	}
        }
        listaPastores = new ListaCircularEnlazadaDoble<>();
        for (int i = 0; i < pastores.length; i++) {
            pastores[i].setId(i + 1);
            listaPastores.insertarNodoInicio(pastores[i]);
        }
    }

    public Pastor escogerPastorRico() {
        Pastor[] pastores = getPastores();
        int maximo = pastores[0].getDoblones();
        Pastor pastorRico = pastores[0];
        for (int i = 0; i < pastores.length; i++) {
            if(pastores[i].getDoblones() > maximo) {
                maximo = pastores[i].getDoblones();
                pastorRico = pastores[i];
            }
        }
        return pastorRico;
    }

    public Pastor escogerMenorFieles(Pastor pastorRico) {
        boolean direccion = random.nextBoolean();
        int cantidadPastores = random.nextInt(1, listaPastores.tamano);
        NodoDoble<Pastor> actual = listaPastores.buscarNodo(pastorRico);

        int menorFieles = actual.getDato().getFieles();

        if(direccion) {
        for (int i = 0; i <= cantidadPastores; i++) {
                actual = actual.getSiguiente(); 
                if(actual.getDato().getFieles() < menorFieles) {
                    menorFieles = actual.getDato().getDoblones();
                }
            }
        }
        else {
            for (int i = 0; i <= cantidadPastores; i++) {
                actual = actual.getAnterior(); 
                if(actual.getDato().getFieles() < menorFieles) {
                    menorFieles = actual.getDato().getFieles();
                }
            }
        }
        System.out.println(direccion ? "Dirección: Derecha" : "Dirección: Izquierda");
        return actual.getDato();        

    }

    public String transferirRiqueza(Pastor pastorRico, Pastor pastorPobre) {
        NodoDoble<Pastor> nodoRico = listaPastores.buscarNodo(pastorRico);
        NodoDoble<Pastor> nodoPobre = listaPastores.buscarNodo(pastorPobre);
        if (nodoRico == null || nodoPobre == null) {
            return "Uno o ambos pastores no se encuentran en la lista.";
        }
        int cantidadTransferida = pastorRico.getDoblones();
        int cantidadFieles = pastorRico.getFieles();
        pastorRico.setDoblones(0);
        pastorRico.setFieles(0);
        pastorPobre.setDoblones(pastorPobre.getDoblones() + cantidadTransferida);
        pastorPobre.setFieles(pastorPobre.getFieles() + cantidadFieles);
        return "El pastor " + pastorRico.getId() + " ha transferido " + cantidadTransferida + " doblones al pastor " + pastorPobre.getId() + ".";
    }

    public void enviarDesposeidos(Pastor pastorDespoceido) {
        listaPastores.eliminarNodo(pastorDespoceido);
        desposeidos.insertarNodo(pastorDespoceido);
        System.out.println(desposeidos.getCabeza().getDato().getDoblones());
        System.out.println(desposeidos.getCabeza().getDato().getFieles());
        listaPastores.imprimir();
        desposeidos.imprimir();
    }

    public int getTamanoDesposeidos() {
        return desposeidos.getTamano();
    }

    public void transferirAlDesposeido(Pastor pastorRico) {
        
        if (listaPastores.buscarNodo(pastorRico).equals(null)) {
            System.out.println("El pastor rico no se encuentra en la lista.");
        }
        if (desposeidos.getCabeza().equals(null)) {
            System.out.println("No hay desposeidos a quienes transferir riqueza.");
        }
        Pastor pastorDesposeido = desposeidos.getCabeza().getDato();
        int cantidadDoblonesTransferida = (int) pastorRico.getDoblones() / 2;
        int cantidadFielesTransferida = (int) pastorRico.getFieles() / 2;
        pastorRico.setDoblones(cantidadDoblonesTransferida);
        pastorRico.setFieles(cantidadFielesTransferida);
        Pastor newPastor = new Pastor(pastorDesposeido.getId(), pastorDesposeido.getNombre(), cantidadDoblonesTransferida, cantidadFielesTransferida, pastorDesposeido.getOficio());
        listaPastores.insertarNodoInicio(newPastor);
        desposeidos.eliminarNodo();
        
    }
    
}
