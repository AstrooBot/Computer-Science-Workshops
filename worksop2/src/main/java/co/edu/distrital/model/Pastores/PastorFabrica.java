package co.edu.distrital.model.Pastores;

import java.util.Random;

public class PastorFabrica {
    
    private int semilla;
    private String[] nombresDeCuras = {"Padre Juan", "Padre José", "Padre Francisco", "Padre Antonio", "Padre Carlos", "Padre Luis",
            "Padre Pedro", "Padre Miguel", "Padre Rafael", "Padre Andrés", "Padre Tomás", "Padre Esteban", "Padre Mateo", "Padre Gabriel", "Padre Ignacio"};
    private String[] oficios = {"Confesor", "Predicador", "Misionero", "Sacerdote", "Monje", "Obispo", "Cura Párroco", "Capellán", "Teólogo", "Liturgista"};
    private Random random;

    public PastorFabrica(int semilla) {
        this.semilla = semilla;
        this.random = new Random(this.semilla);
    }

    //TODO: hacer metodo para hacer pastores en masa
    public Pastor crearPastor(int id) {
        String nombre = nombresDeCuras[random.nextInt(nombresDeCuras.length)];
        int doblones = getInt(100_000_000);
        int fieles = random.nextInt(10_000_000);
        String oficio = oficios[random.nextInt(oficios.length)];
        return new Pastor(id, nombre, doblones, fieles, oficio);
    }

    private int getInt(int max) {
        return random.nextInt(max);
    }

}
