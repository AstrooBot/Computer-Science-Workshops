package model.Candidato;

import model.Dato.*;

/**
 * La clase Candidato representa un candidato político con información relevante
 * como su identificador, nombre, partido político y diferentes tipos de datos
 * asociados a su actividad (sobornos, actos de corrupción, prebendas, clases y marchas).
 * 
 * Proporciona métodos para acceder y modificar estos datos, así como para obtener
 * representaciones en formato long de los montos asociados y una representación en
 * cadena de texto de toda la información del candidato.
 * 
 * Atributos:
 * - id: Identificador único del candidato.
 * - nombre: Nombre del candidato.
 * - partido: Partido político al que pertenece el candidato.
 * - sobornos: Arreglo de objetos Soborno asociados al candidato.
 * - actosCorrupcion: Arreglo de objetos ActoCorrupcion asociados al candidato.
 * - prebendas: Arreglo de objetos Prebenda asociados al candidato.
 * - clases: Arreglo de objetos Clase asociados al candidato.
 * - marchas: Arreglo de objetos Marcha asociados al candidato.
 * 
 * Métodos principales:
 * - Getters y setters para todos los atributos.
 * - Métodos para obtener los valores long de los arreglos de datos.
 * - Método para mostrar los datos en formato de texto.
 * - Método toString() para obtener una representación completa del candidato.
 * 
 * Nota: Esta clase asume que las clases Soborno, ActoCorrupcion, Prebenda, Clase,
 * Marcha e Idato están definidas en el sistema.
 * 
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
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
        long longActos = 0;
        for (int i = 0; i < actosCorrupcion.length; i++) {
            longActos += actosCorrupcion[i].getLong();
        }
        return longActos;
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
    

