package model;

import model.attributes.ActoCorrupcion;
import model.attributes.Clases;
import model.attributes.IDato;
import model.attributes.Marcha;
import model.attributes.Prebenda;
import model.attributes.Soborno;

/**
 * Representa un candidato político con información relevante sobre su campaña y actividades.
 * 
 * <p>
 * Un candidato tiene un nombre, un partido político al que pertenece, y listas de marchas,
 * clases, sobornos, actos de corrupción y prebendas asociadas.
 * </p>
 * 
 * @author Juan Nicolas Diaz <jndiazs@udistrital.edu.co>
 * @version 1.0
 */
public class Candidato {

    private String nombre;
    private String partido;
    private int id;
    private Marcha[] marchas;
    private Clases[] clases;
    private Soborno[] sobornos;
    private ActoCorrupcion[] actosCorrupcion;
    private Prebenda[] prebendas;

    public Candidato(String nombre, String partido, Marcha[] marchas, Clases[] clases, Soborno[] sobornos,
            ActoCorrupcion[] actosCorrupcion, Prebenda[] prebendas) {
        this.nombre = nombre;
        this.partido = partido;
        this.marchas = marchas;
        this.clases = clases;
        this.sobornos = sobornos;
        this.actosCorrupcion = actosCorrupcion;
        this.prebendas = prebendas;
    }
    //TODO: posible memory leak
    public String mostrarDatos(IDato[] datos) {
        String acum = "";
        for (IDato dato : datos) {
            acum += dato.toString() + "\n";
        }
        return acum;
    }

    public long[] getAtributos(String atributo) {
        switch (atributo.toLowerCase()) {
            case "marchas":
                return this.getMarchas();
            case "clases":
                return this.getClases();
            case "sobornos":
                return this.getSobornos();
            case "actoscorrupcion":
                return this.getActosCorrupcion();
            case "prebendas":
                return this.getPrebendas();
            default:
                return null;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public long[] getMarchas() {
        long[] acum = new long[this.marchas.length];
        for (int i = 0; i < acum.length; i++) {
            acum[i] = this.marchas[i].getValor();
        }
        return acum;
    }

    public void setMarchas(Marcha[] marchas) {
        this.marchas = marchas;
    }

    public long[] getClases() {
        long[] acum = new long[this.clases.length];
        for (int i = 0; i < acum.length; i++) {
            acum[i] = this.clases[i].getValor();
        }
        return acum;
    }

    public void setClases(Clases[] clases) {
        this.clases = clases;
    }

    public long[] getSobornos() {
        long[] acum = new long[this.sobornos.length];
        for (int i = 0; i < acum.length; i++) {
            acum[i] = this.sobornos[i].getValor();
        }
        return acum;
    }

    public void setSobornos(Soborno[] sobornos) {
        this.sobornos = sobornos;
    }

    public long[] getActosCorrupcion() {
        long[] acum = new long[this.actosCorrupcion.length];
        for (int i = 0; i < acum.length; i++) {
            acum[i] = this.actosCorrupcion[i].getValor();
        }
        return acum;
    }

    public void setActosCorrupcion(ActoCorrupcion[] actosCorrupcion) {
        this.actosCorrupcion = actosCorrupcion;
    }

    public long[] getPrebendas() {
        long[] acum = new long[this.prebendas.length];
        for (int i = 0; i < acum.length; i++) {
            acum[i] = this.prebendas[i].getValor();
        }
        return acum;
    }

    public void setPrebendas(Prebenda[] prebendas) {
        this.prebendas = prebendas;
    }

    @Override
    public String toString() {
        return "Candidato: " + id + "\n"
            + "Nombre: " + nombre + "\n"
            + "Partido: " + partido + "\n"
            + "Marchas: " + this.mostrarDatos(marchas) + "\n"
            + "Clases: " + this.mostrarDatos(clases) + "\n"
            + "Sobornos: " + this.mostrarDatos(sobornos) + "\n"
            + "Actos de Corrupcion: " + this.mostrarDatos(actosCorrupcion) + "\n"
            + "Prebendas: " + this.mostrarDatos(prebendas) + "\n";
    }        
}
