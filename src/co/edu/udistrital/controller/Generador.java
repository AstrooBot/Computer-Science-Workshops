package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import model.Banco;
import model.Candidato;
import model.attributes.ActoCorrupcion;
import model.attributes.Clases;
import model.attributes.Marcha;
import model.attributes.Prebenda;
import model.attributes.Soborno;

public class Generador {

    private long semilla; 
    private Random random;
    private String[] filepaths = {
        "co/edu/udistrital/resources/nombres.txt",
        "co/edu/udistrital/resources/apellidos.txt",
        "co/edu/udistrital/resources/clases.txt",
        "co/edu/udistrital/resources/direcciones.txt",
        "co/edu/udistrital/resources/partidos.txt",
        "co/edu/udistrital/resources/sindicatos.txt",
        "co/edu/udistrital/resources/entidades.txt"
    };
    public String[] nombres = new String[101];
    public String[] apellidos = new String[101];
    public String[] clases = new String[27];
    public String[] direcciones = new String[26];
    public String[] partidos = new String[26];
    public String[] sindicatos = new String[26];
    public String[] entidades = new String[26];

    public String[][] atributos = new String[][] {nombres, apellidos, clases, direcciones, partidos, sindicatos, entidades};

    private int cantidad;
    
    public Generador(int cantidad, long semilla) {
        this.semilla = semilla; 
        this.random = new Random(semilla);
        this.cantidad = cantidad;
    }

    public void cargarDatos() {
        
        for (int i = 0; i < filepaths.length; i++) {

            try {
            File archivo = new File(filepaths[i]);
            Scanner scanner = new Scanner(archivo);
            int j = 0;

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                atributos[i][j] = linea;
                j++; 
            }

            scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }   
        }
    }

    public String generarNombre() {
        int indiceNombre = random.nextInt(100);
        int indiceApellido = random.nextInt(100);
        return nombres[indiceNombre] + " " + apellidos[indiceApellido];
    }

    public Clases generarClase() {
        int indiceClase = random.nextInt(25);
        return new Clases(clases[indiceClase], random.nextInt(200));
    }
    
    public Marcha generarMarcha() {
        int indiceDireccion = random.nextInt(25);
        return new Marcha(direcciones[indiceDireccion], random.nextInt(200));
    }

    public String generarPartido() {
        int indicePartido = random.nextInt(25);
        return partidos[indicePartido];
    }
    public Prebenda generarPrebenda() {
        int indiceSindicato = random.nextInt(25);
        return new Prebenda(sindicatos[indiceSindicato], this.generarNumero());
    }

    public ActoCorrupcion generarActoCorrupcion() {
        return new ActoCorrupcion(entidades[random.nextInt(25)], this.generarNumero());
    }

    public Soborno generarSoborno() {
        return new Soborno(this.generarNombre(), this.generarNumero());
    }

    public long generarNumero() {
        return 10000000L + (long)(random.nextDouble() * 90000000L);
    }

    public Marcha[] generarMarchas(int cantidad) {
        Marcha[] marchas = new Marcha[cantidad];
        for (int i = 0; i < cantidad; i++) {
            marchas[i] = this.generarMarcha();
        }
        return marchas;
    }

    public Clases[] generarClases(int cantidad) {
        Clases[] clases = new Clases[cantidad];
        for (int i = 0; i < cantidad; i++) {
            clases[i] = this.generarClase();
        }
        return clases;
    }
    public Prebenda[] generarPrebendas(int cantidad) {
        Prebenda[] prebendas = new Prebenda[cantidad];
        for (int i = 0; i < cantidad; i++) {
            prebendas[i] = this.generarPrebenda();
        }
        return prebendas;
    }
    public ActoCorrupcion[] generarActosCorrupcion(int cantidad) {
        ActoCorrupcion[] actos = new ActoCorrupcion[cantidad];
        for (int i = 0; i < cantidad; i++) {
            actos[i] = this.generarActoCorrupcion();
        }
        return actos;
    }
    public Soborno[] generarSobornos(int cantidad) {
        Soborno[] sobornos = new Soborno[cantidad];
        for (int i = 0; i < cantidad; i++) {
            sobornos[i] = this.generarSoborno();
        }
        return sobornos;
    }
    
    public Candidato generarCandidato(int cantidad) {
        return new Candidato(
            this.generarNombre(),
            this.generarPartido(),
            this.generarMarchas(random.nextInt(cantidad)),
            this.generarClases(random.nextInt(cantidad)),
            this.generarSobornos(random.nextInt(cantidad)),
            this.generarActosCorrupcion(random.nextInt(cantidad)),
            this.generarPrebendas(random.nextInt(cantidad))
        );

    }

    public Candidato[] generarCandidatos(int cantidadAtributos) {
        Candidato[] candidatos = new Candidato[this.cantidad];
        for (int i = 0; i < this.cantidad; i++) {
            candidatos[i] = this.generarCandidato(cantidadAtributos);
        }
        return candidatos;
    }

    public Banco generarBanco(int cantidadAtributos) {
        Banco banco = new Banco(this.cantidad);
        Candidato[] candidatos = this.generarCandidatos(cantidadAtributos);
        for (int i = 0; i < candidatos.length; i++) {
            banco.añadir(candidatos[i]);
        }
        banco.setCandidatos(candidatos);
        return banco;
    }

}
