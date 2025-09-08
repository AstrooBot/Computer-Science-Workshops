package co.edu.distrital.model.Candidato;

import co.edu.distrital.model.Dato.*;

public class Candidato {

    private int id;
    private String nombre;
    private String partido;
    private Soborno[] sobornos;
    private ActoCorrupcion[] actosCorrupcion;
    private Prebenda[] prebendas;
    private Clase[] clases;
    private Marcha[] marchas;

    public Candidato(int id, String nombre, String partido, Soborno[] sobornos, ActoCorrupcion[] actosCorrupcion,
            Prebenda[] prebendas, Clase[] clases, Marcha[] marchas) {
        this.id = id;
        this.nombre = nombre;
        this.partido = partido;
        this.sobornos = sobornos;
        this.actosCorrupcion = actosCorrupcion;
        this.prebendas = prebendas;
        this.clases = clases;
        this.marchas = marchas;
    }

    public long[] getLongSobornos() {
        long[] longSobornos = new long[sobornos.length];
        for (int i = 0; i < sobornos.length; i++) {
            longSobornos[i] = sobornos[i].getLong();
        }
        return longSobornos;
    }

    public Soborno[] getSobornos() {
        return sobornos;
    }

    public void setSobornos(Soborno[] sobornos) {
        this.sobornos = sobornos;
    }

    public long getLongActosCorrupcion() {
        long longSobornos = 0;
        for (int i = 0; i < sobornos.length; i++) {
            longSobornos += sobornos[i].getLong();
        }
        return longSobornos;
    }
    public ActoCorrupcion[] getActosCorrupcion() {
        return actosCorrupcion;
    }

    public void setActosCorrupcion(ActoCorrupcion[] actosCorrupcion) {
        this.actosCorrupcion = actosCorrupcion;
    }

    public long[] getLongPrebendas() {
        long[] longPrebendas = new long[prebendas.length];
        for (int i = 0; i < sobornos.length; i++) {
            longPrebendas[i] = sobornos[i].getLong();
        }
        return longPrebendas;
    }

    public Prebenda[] getPrebendas() {
        return prebendas;
    }

    public void setPrebendas(Prebenda[] prebendas) {
        this.prebendas = prebendas;
    }

    public long[] getLongClases() {
        long[] longClases = new long[clases.length];
        for (int i = 0; i < clases.length; i++) {
            longClases[i] = clases[i].getLong();
        }
        return longClases;
    }

    public Clase[] getClases() {
        return clases;
    }

    public void setClases(Clase[] clases) {
        this.clases = clases;
    }

    public long[] getLongMarchas() {
        long[] longMarchas = new long[marchas.length];
        for (int i = 0; i < marchas.length; i++) {
            longMarchas[i] = marchas[i].getLong();
        }
        return longMarchas;
    }

    public Marcha[] getMarchas() {
        return marchas;
    }

    public void setMarchas(Marcha[] marchas) {
        this.marchas = marchas;
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

    private String mostrarDatos(Idato[] datos) {
        String resultado = "";
        if (datos != null && datos.length > 0) {
            for (Idato dato : datos) {
                resultado += dato.toString() + " \n";
            }
        } else {
            resultado = "No hay datos disponibles.";
        }
        return resultado;
    }
    @Override
    public String toString() {
            return "Candidato: " + id + "\n"
            + "Nombre: " + nombre + "\n"
            + "Partido: " + partido + "\n"
            + "Marchas: \n" + this.mostrarDatos(marchas) + "\n"
            + "Clases: \n" + this.mostrarDatos(clases) + "\n"
            + "Sobornos: \n" + this.mostrarDatos(sobornos) + "\n"
            + "Actos de Corrupcion: \n" + this.mostrarDatos(actosCorrupcion) + "\n"
            + "Prebendas: \n" + this.mostrarDatos(prebendas) + "\n";
    }  
}
    

