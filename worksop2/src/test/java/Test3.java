import co.edu.distrital.model.ListaCircularEnlazadaDoble;
import co.edu.distrital.model.Pastores.Pastor;
import co.edu.distrital.model.Pastores.PastorFabrica;

public class Test3 {
    //NUNCA AGREGAR UN DATO YA EXISTENTE
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
       //System.out.println(listaPastores.getNodoAnterior(pastor4));
       //System.out.println(listaPastores.getNodoPosterior(pastor4));

       listaPastores.insertarNodoFinal(pastor5);
       listaPastores.insertarNodoFinal(pastor1);
       listaPastores.imprimir();
       System.out.println(listaPastores.buscarNodo(pastor6));
       System.out.println(listaPastores.buscarNodo(pastor1));
       listaPastores.imprimir();
       listaPastores.eliminarNodo(pastor3);
       listaPastores.imprimir();
       listaPastores.insertarNodoFinal(pastor3);
        listaPastores.imprimir();



  

    }
    
}
