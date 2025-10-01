/* Test to check the Pastor and PAstorFabrica classes */

import co.edu.distrital.model.Pastores.Pastor;
import co.edu.distrital.model.Pastores.PastorFabrica;

public class Test1 {

    public static void main(String[] args) {
        PastorFabrica fabrica = new PastorFabrica(12345);
        Pastor pastor1 = fabrica.crearPastor(1);
        Pastor pastor2 = fabrica.crearPastor(2);
        System.out.println(pastor1);
        System.out.println(pastor2);
        
    }
    
}
