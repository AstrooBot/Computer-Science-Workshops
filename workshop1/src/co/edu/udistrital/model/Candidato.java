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
        long[] res = null;
        switch (atributo.toLowerCase()) {
            case "marchas":
                res = this.getMarchas();
                break;
            case "clases":
                res =  this.getClases();
                break;
            case "sobornos":
                res = this.getSobornos();
                break;
            case "actoscorrupcion":
                res = this.getActosCorrupcion();
                break;
            case "prebendas":
                res = this.getPrebendas();
                break;
            default:
                res = new long[0]; // Retornar array vacío en lugar de null
                break;
        }
        return res != null ? res : new long[0]; // Doble protección
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
        if (this.marchas == null || this.marchas.length == 0) {
            return new long[0];
        }
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
        if (this.clases == null || this.clases.length == 0) {
            return new long[0];
        }
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
        if (this.sobornos == null || this.sobornos.length == 0) {
            return new long[0];
        }
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
        if (this.actosCorrupcion == null || this.actosCorrupcion.length == 0) {
            return new long[0];
        }
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
        if (this.prebendas == null || this.prebendas.length == 0) {
            return new long[0];
        }
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
