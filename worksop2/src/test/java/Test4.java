import co.edu.distrital.model.ListaCircularEnlazadaDoble;
import co.edu.distrital.model.Pastores.Pastor;
import co.edu.distrital.model.Pastores.PastorFabrica;

public class Test4 {
    public static void main(String[] args) {

       PastorFabrica pastorFabrica = new PastorFabrica(1234);
       Pastor pastor1 = pastorFabrica.crearPastor(1);
       Pastor pastor2 = pastorFabrica.crearPastor(2);
       Pastor pastor3 = pastorFabrica.crearPastor(3);
       Pastor pastor4 = pastorFabrica.crearPastor(4);
       Pastor pastor5 = pastorFabrica.crearPastor(5);
       Pastor pastor6 = pastorFabrica.crearPastor(6);
       ListaCircularEnlazadaDoble<Pastor> listaPastores = new ListaCircularEnlazadaDoble<>();
       listaPastores.insertarNodoInicio(pastor1);
       listaPastores.insertarNodoInicio(pastor2);
       listaPastores.insertarNodoInicio(pastor3);
       listaPastores.insertarNodoInicio(pastor4);
       listaPastores.imprimir();
       listaPastores.insertarNodoAnteriorA(pastor2, pastor5);
       listaPastores.imprimir();
       listaPastores.insertarNodoPosteriorA(pastor2, pastor6);
       listaPastores.imprimir();
       listaPastores.eliminarNodoInicio();
       listaPastores.imprimir();
       listaPastores.eliminarNodoFinal();
       listaPastores.imprimir();
       listaPastores.eliminarNodoAnteriorA(pastor2);
       listaPastores.eliminarNodoPosteriorA(pastor2);
       listaPastores.imprimir();
    }
}
