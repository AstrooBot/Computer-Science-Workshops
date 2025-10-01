import co.edu.distrital.controller.ControladorPastores;
import co.edu.distrital.model.Pastores.Pastor;

public class Test7 {

    public static void main(String[] args) {
        ControladorPastores controlador = new ControladorPastores(12345);
        controlador.crearListaPastores(5);
        controlador.imprimirListaPastores();
        controlador.verificarOficio();
        controlador.imprimirListaPastores();

        Pastor pastorRico = controlador.escogerPastorRico();
        System.out.println("Pastor Rico: " + pastorRico);
        Pastor pastorMenorFieles = controlador.escogerMenorFieles(pastorRico);
        System.out.println("Pastor con menor fieles: " + pastorMenorFieles);
        System.out.println(controlador.transferirRiqueza(pastorRico, pastorMenorFieles));
        controlador.enviarDesposeidos(pastorRico);
        System.out.println("Lista despues de enviar desposeidos:");
        controlador.imprimirListaPastores();
        System.out.println("Lista de desposeidos:");
        controlador.imprimirDesposeidos();
        //controlador.verificarOficio();
        controlador.transferirAlDesposeido(controlador.escogerPastorRico());
        System.out.println("Lista despues de transferir al desposeido:");
        controlador.imprimirListaPastores();
        System.out.println("Lista de desposeidos:");
        controlador.imprimirDesposeidos();

        
        

        
    }
    
}
