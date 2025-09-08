package model;

import java.util.Random;


public class BaseDatos {

    private static BaseDatos instance = null;
    private Random random;

    private String[] nombres = {
            "Ana", "Luis", "María", "José", "Carla", "Andrés", "Sofía", "Mateo", "Lucía", "Diego",
            "Valentina", "Pedro", "Camila", "Juan", "Isabella", "Fernando", "Paula", "Sebastián", "Elena", "Ricardo",
            "Alejandra", "Marco", "Daniela", "Tomás", "Natalia", "Raúl", "Gabriela", "Javier", "Clara", "Héctor",
            "Esteban", "Mónica", "Bruno", "Patricia", "Benjamín", "Adriana", "Cristian", "Renata", "Alejandro", "Fabiola",
            "Kevin", "Lorena", "Enrique", "Nicole", "Julio", "Bianca", "Samuel", "Rosa", "Iván", "Cecilia"
        };

    private String[] apellidos = {
            "González", "Rodríguez", "Pérez", "López", "Hernández", "García", "Martínez", "Sánchez", "Ramírez", "Torres",
            "Flores", "Jiménez", "Morales", "Vargas", "Castillo", "Cruz", "Reyes", "Díaz", "Ortiz", "Ramos",
            "Herrera", "Mendoza", "Silva", "Guerrero", "Chávez", "Delgado", "Pineda", "Campos", "Vega", "Suárez",
            "Navarro", "Romero", "Aguilar", "Salazar", "Peña", "Rivas", "Mora", "Ibarra", "Carrillo", "Arroyo",
            "Montoya", "Valdez", "Soto", "Calderón", "Cuevas", "Esparza", "Rosales", "Treviño", "Franco", "Zamora"
        };
    private String[] lugares = {
            "Calle Olmo 123, Col. Centro, Ciudad Esperanza",
            "Av. Las Rosas 456, Col. Jardines, Nueva Aurora",
            "Calle 5 de Mayo 789, Col. Reforma, San Miguel",
            "Boulevard del Sol 321, Col. Dorada, Villa Clara",
            "Calle Cedro 112, Col. La Paz, Puerto Bello",
            "Av. Libertad 908, Col. San Juan, Monte Verde",
            "Calle Lirio 554, Col. Primavera, Valle Azul",
            "Callejón del Río 677, Col. Campestre, Flor del Valle",
            "Calle Roble 234, Col. Las Palmas, Villa Hermosa",
            "Av. Revolución 998, Col. Libertad, Ciudad Dorada",
            "Calle Nube 102, Col. Horizonte, Mirador Real",
            "Av. Universidad 879, Col. Estudiantes, Nueva Ciencia",
            "Calle Estrella 445, Col. Galaxia, Ciudad Futura",
            "Av. Industria 567, Col. Progreso, Sector Norte",
            "Calle Luna 333, Col. Nocturna, San Esteban",
            "Av. Tecnológica 712, Col. Digital, Tecnovilla",
            "Calle Aurora 888, Col. Amanecer, Jardín del Sol",
            "Av. Central 200, Col. Centro Sur, Villa del Río",
            "Calle Granito 419, Col. Piedra Blanca, Cerro Alto",
            "Av. del Trabajo 634, Col. Obrera, Pueblo Nuevo",
            "Calle Paraíso 515, Col. Maravilla, Isla Serena",
            "Av. Colinas 456, Col. Montaña, Ladera Verde",
            "Calle Jardín 789, Col. Florida, Oasis del Este",
            "Av. México 321, Col. Internacional, Frontera Viva",
            "Calle Sauce 159, Col. Arboleda, Monte Claro",
            "Calle del Valle 602, Col. Esperanza, Cumbre Azul",
            "Av. del Lago 777, Col. Marina, Puerto Verde",
            "Calle Rincón 343, Col. Serena, Las Lomas",
            "Av. Horizonte 222, Col. Alturas, Ciudad del Cielo",
            "Calle Trueno 121, Col. Tormenta, Rayo Norte",
            "Av. Tranquila 909, Col. Pacifica, Villa Azul",
            "Calle del Bosque 471, Col. Cedros, Trébol Real",
            "Av. del Mar 832, Col. Costera, Playa Brisa",
            "Calle Amanecer 567, Col. Lucero, Sol Poniente",
            "Av. del Estanque 290, Col. Reflejo, Laguna Clara",
            "Calle del Eco 683, Col. Sonora, Sierra Viva",
            "Av. Diamante 444, Col. Joyas, San Rafael",
            "Calle Carbón 347, Col. Minera, Monte de Hierro",
            "Calle del Sauce 909, Col. Armonía, Campo Sereno",
            "Av. Pacífico 158, Col. Brisa, Loma Fresca",
            "Calle Esmeralda 284, Col. Piedras Verdes, Bahía Clara",
            "Av. de la Ciencia 398, Col. Ingenieros, Tecnovía",
            "Calle Plenitud 111, Col. Renacimiento, Jardín Secreto",
            "Av. Centenario 123, Col. Historia, Pueblo Antiguo",
            "Calle Real 876, Col. Monarca, Reino Viejo",
            "Av. del Saber 654, Col. Académica, Universidad Alta",
            "Calle Rocío 472, Col. Niebla, Bosque Bajo",
            "Av. de las Torres 321, Col. Fortaleza, Ciudadela",
            "Calle Nueva Vida 204, Col. Esperanza, Monte Alegre",
            "Av. Mística 909, Col. Encanto, Valle Secreto"
    };

    private String[] partidos = {

            "Partido de la Unidad Popular",
            "Movimiento Progreso Nacional",
            "Frente Verde Democrático",
            "Alianza por la Justicia Social",
            "Partido de la Soberanía Ciudadana",
            "Unión Patriótica del Pueblo",
            "Fuerza Democrática Independiente",
            "Partido Nuevo Horizonte",
            "Movimiento de Renovación Nacional",
            "Partido Igualdad y Futuro"

        };

    private String[] nombreIglesias = {

            "Iglesia de San Pedro",
            "Catedral de Santa María",
            "Iglesia del Sagrado Corazón",
            "Iglesia de la Paz",
            "Iglesia de la Esperanza",
            "Iglesia de la Luz Divina",
            "Iglesia de la Resurrección",
            "Iglesia de la Gracia Eterna",
            "Iglesia del Buen Pastor",
            "Iglesia de la Fe Viva"
        };

    private String[] nombreClases = {

            "Cálculo Diferencial",
            "Cálculo Integral",
            "Álgebra Lineal",
            "Ecuaciones Diferenciales",
            "Física Clásica",
            "Física Moderna",
            "Química General",
            "Estática",
            "Dinámica",
            "Mecánica de Materiales"

        };
        
    private String[] nombreMarchas = {

            "Marcha Nupcial",
            "Marcha Radetzky",
            "Marcha Imperial",
            "Marcha de los Soldados",
            "Marcha de la Victoria",
            "Marcha de la Libertad",
            "Marcha de la Paz",
            "Marcha de los Héroes",
            "Marcha Triunfal",
            "Marcha de la Alegría"
        };

    private String[] entidades = {

            "Banco de la Nación",
            "Banco Popular",
            "Banco Central",
            "Banco de Comercio",
            "Banco Industrial",
            "Banco Financiero",
            "Banco de Inversiones",
            "Banco de Ahorros",
            "Banco Internacional",
            "Banco de Desarrollo"
        };

    private String[] tiposIglesias = {

            "Católica Romana",
            "Ortodoxa Oriental",
            "Anglicana",
            "Luterana",
            "Presbiteriana",
            "Metodista",
            "Bautista",
            "Pentecostal",
            "Adventista del Séptimo Día",
            "Iglesia de Cristo"
        };
    private String[] carreras = {

            "Ingeniería Civil",
            "Ingeniería Mecánica",
            "Ingeniería Eléctrica",
            "Ingeniería Electrónica",
            "Ingeniería Industrial",
            "Ingeniería en Sistemas Computacionales",
            "Ingeniería Química",
            "Ingeniería en Telecomunicaciones",
            "Ingeniería Biomédica",
            "Ingeniería Aeroespacial"
        };

    private BaseDatos(int semilla) {
        this.random = new Random(semilla);

    }

    public static BaseDatos getInstance(int semilla) {
        if (instance == null) {
            instance = new BaseDatos(semilla);
        }
        return instance;
    }

    public String getNombre() {;
        return nombres[random.nextInt(0,nombres.length)];
    }

    public String getApellido() {
        return apellidos[random.nextInt(0,apellidos.length)];
    }

    public String getLugar() {
        return lugares[random.nextInt(0,lugares.length)];
    }

    public String getPartido() {

        return partidos[random.nextInt(0,partidos.length)];
    }

    public String getNombreIglesia() {
        return nombreIglesias[random.nextInt(0,nombreIglesias.length)];
    }

    public String getNombreClase() {
        return nombreClases[random.nextInt(0,nombreClases.length)];
    }

    public String getNombreMarcha() {
        return nombreMarchas[random.nextInt(0,nombreMarchas.length)];
    }

    public String getEntidad() {
        return entidades[random.nextInt(0,entidades.length)];
    }

    public String getTipoIglesia() {
        return tiposIglesias[random.nextInt(0,tiposIglesias.length)];
    }

    public String getCarrera() {
        return carreras[random.nextInt(0,carreras.length)];
    }

    public String getFecha() {
        int year = random.nextInt(1990, 2024);
        int month = random.nextInt(1, 13);
        int day = random.nextInt(1, 32);
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public long getLong() {
        return random.nextLong(1000, 100000000);
    }

    public int getInt() {
        return random.nextInt(1, 25);
    }
    
}
