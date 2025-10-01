import co.edu.distrital.model.ListaCircularEnlazadaDoble;
import co.edu.distrital.model.NodoDoble;
import co.edu.distrital.model.Pastores.*;

public class Test2 {

    public static void main(String[] args) {
        
       PastorFabrica pastorFabrica = new PastorFabrica(1234);
       Pastor pastor1 = pastorFabrica.crearPastor(1);
       Pastor pastor2 = pastorFabrica.crearPastor(2);
       Pastor pastor3 = pastorFabrica.crearPastor(3);
       Pastor pastor4 = pastorFabrica.crearPastor(4);
    
       //Probando la construccion del objeto
       ListaCircularEnlazadaDoble<Pastor> listaPastores = new ListaCircularEnlazadaDoble<>();
       listaPastores.imprimir();
       
       //Probando que se pueden añadir nodos al inicio
       System.out.println("------------------");
       listaPastores.insertarNodoInicio(pastor1);
       listaPastores.insertarNodoInicio(pastor2);
       listaPastores.insertarNodoInicio(pastor3);
       listaPastores.insertarNodoInicio(pastor4);
       listaPastores.imprimir();
 
        
        NodoDoble<Pastor> actual = listaPastores.getCabeza();
        for (int i = 0; i < listaPastores.tamano; i++) {
            System.out.println(actual);
            System.out.println("Anterior: " + actual.getAnterior());
            System.out.println("Siguiente: " + actual.getSiguiente()); 
            actual = actual.getSiguiente();   
        }
        listaPastores.imprimirInversa();






    }
    
}
