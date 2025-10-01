import co.edu.distrital.model.Desposeidos;
import co.edu.distrital.model.Pastores.Pastor;
import co.edu.distrital.model.Pastores.PastorFabrica;

public class Test6 {

    public static void main(String[] args) {
       Desposeidos<Pastor> desposeidos = new Desposeidos<>();
       PastorFabrica pastorFabrica = new PastorFabrica(1234);
       Pastor pastor1 = pastorFabrica.crearPastor(1);
       Pastor pastor2 = pastorFabrica.crearPastor(2);
       Pastor pastor3 = pastorFabrica.crearPastor(3);
       Pastor pastor4 = pastorFabrica.crearPastor(4);
       Pastor pastor5 = pastorFabrica.crearPastor(5);
       Pastor pastor6 = pastorFabrica.crearPastor(6);

       desposeidos.insertarNodo(pastor1);
       desposeidos.insertarNodo(pastor2);
       desposeidos.insertarNodo(pastor3);
       desposeidos.insertarNodo(pastor4);
       desposeidos.insertarNodo(pastor5);
       desposeidos.insertarNodo(pastor6);
       desposeidos.imprimir();

       System.out.println(desposeidos.eliminarNodo());
       desposeidos.imprimir();
       System.out.println(desposeidos.eliminarNodo());
       desposeidos.imprimir();
       System.out.println(desposeidos.eliminarNodo());
       desposeidos.imprimir();
       System.out.println(desposeidos.eliminarNodo());
       desposeidos.imprimir();
       System.out.println(desposeidos.eliminarNodo());
       desposeidos.imprimir();
       System.out.println(desposeidos.eliminarNodo());
       desposeidos.imprimir();



    }
    
}
