import co.edu.distrital.controller.ControladorPastores;

public class Test5 {

    public static void main(String[] args) {
        ControladorPastores controlador = new ControladorPastores(1234);
        controlador.crearListaPastores(10).imprimir();

    }
    
}
