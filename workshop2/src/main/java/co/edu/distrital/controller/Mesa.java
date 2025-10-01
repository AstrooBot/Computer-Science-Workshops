package co.edu.distrital.controller;

import java.util.Random;

import co.edu.distrital.model.Pastores.Pastor;

public class Mesa {

    public ControladorPastores controladorPastores;
    public Random random;

    public Mesa(int semilla, int cantidadPastores) {
        this.controladorPastores = new ControladorPastores(semilla);
        controladorPastores.crearListaPastores(cantidadPastores);
        this.random = new Random(semilla);
        
    }

    public void  inicioJuego() {
        System.out.println("Lista de Pastores inicial:");
        controladorPastores.imprimirListaPastores();
        System.out.println("Lista verificada de Pastores:");
        controladorPastores.verificarOficio();
        controladorPastores.imprimirListaPastores();

    }
    //Retorna el pastor que sera enviado a la pila de desposeidos
    public void Turno() {
        System.out.println("Lista de Pastores inicial:");
        controladorPastores.imprimirListaPastores();
        System.out.println("Lista verificada de Pastores:");
        controladorPastores.verificarOficio();
        controladorPastores.imprimirListaPastores();

        System.out.println("Seleccion del Pastor inicial:");
        Pastor rico = controladorPastores.escogerPastorRico();
        System.out.println("Pastor rico seleccionado: " + rico);

        System.out.println("Cantidad de pastores a apuntar: " + controladorPastores.getCantidadApuntarPastores());
        Pastor desposeido = controladorPastores.escogerMenorFieles(rico);
        System.out.println("Pastor id:" + rico.getId() + " " + controladorPastores.getDireccion());
        System.out.println("Pastor rico: " + rico);
        System.out.println("Pastor menos fieles: " + desposeido);
        System.out.println(controladorPastores.transferirRiqueza(rico, desposeido));
        controladorPastores.enviarDesposeidos(rico);
        System.out.println("Lista de Pastores actualizada:");
        controladorPastores.imprimirListaPastores();
        System.out.println("Lista de Desposeidos actualizada:");
        controladorPastores.imprimirDesposeidos();
        System.out.println("---------------------------------------------------");
    }

    public void salvarDesposeidos(Pastor pastorRico) {
        controladorPastores.transferirAlDesposeido(pastorRico);

    }


    public void loop() {
        Turno();
        int ronda = 1;
        while (controladorPastores.listaPastores.tamano > 0) {
            System.out.println("--- Ronda " + ronda + " ---");
            System.out.println("Lista de Pastores actual:");
            controladorPastores.imprimirListaPastores();
            System.out.println("Lista verificada de Pastores:");
            controladorPastores.verificarOficio();
            controladorPastores.imprimirListaPastores();

            System.out.println("Seleccion del Pastor:");
            Pastor rico = controladorPastores.escogerPastorRico();
            System.out.println("Pastor rico seleccionado: " + rico);

            boolean salvar = random.nextBoolean();
            if(controladorPastores.getTamanoDesposeidos() != 0 && salvar) {
                System.out.println("El pastor rico ha decidido salvar a un desposeido.");
                salvarDesposeidos(rico);
            }
            else {
                System.out.println("El pastor rico ha decidido no salvar a un desposeido.");
                Turno();
            }
            ronda++;
            System.out.println("---------------------------------------------------");
        }
        System.out.println(getWinner().getNombre() + " es el ganador con " + getWinner().getDoblones() + " doblones y " + getWinner().getFieles() + " fieles.");
        System.out.println("¡El juego ha terminado!");
        System.out.println(controladorPastores.getDesposeidos());
        
    }

    public Pastor getWinner() {
        return controladorPastores.getWinner();
    }

    
    
}
