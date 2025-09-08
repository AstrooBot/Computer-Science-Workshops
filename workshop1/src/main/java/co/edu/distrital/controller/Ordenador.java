package co.edu.distrital.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import co.edu.distrital.model.Almacen;
import co.edu.distrital.model.Candidato.Candidato;

public abstract class Ordenador {

    public Almacen almacen;
    private int comparaciones;
    private int intercambios;
    private long tiempoPared;
    public double tiempoMs;
    public long[] datos;

    public double getTiempoMs() {
        return tiempoMs;
    }

    public void setTiempoMs(double tiempoMs) {
        this.tiempoMs = tiempoMs;
    }

    public Ordenador(Almacen almacen, String atributo) {
        this.almacen = almacen;
        this.datos = this.almacen.getDatos(atributo);
        this.comparaciones = 0;
        this.intercambios = 0;
        this.tiempoPared = 0;
    }

    public int getComparaciones() {
        return comparaciones;
    }

    public void setComparaciones() {
        this.comparaciones++;
    }

    public int getIntercambios() {
        return intercambios;
    }

    public void setIntercambios() {
        this.intercambios++;
    }

    public double getTiempoPared() {
        long fin = System.nanoTime();
        long duracion = fin - tiempoPared;
        double milisegundos = duracion / 1_000_000.0;
        return milisegundos;
    }

    public void setTiempoPared() {
        this.tiempoPared = System.nanoTime();
    }

    public void intercambiar(int i, int j) {
        this.almacen.mover(i, j);
        this.setIntercambios();
    }

    public Candidato best() {
        return this.almacen.getCandidato(0);
    }


    @Override
    public String toString() {
        return "Ordenamiento: " + this.getClass().getSimpleName() +
                ", comparaciones: " + comparaciones +
                ", intercambios: " + intercambios +
                ", tiempoMs: " + tiempoMs;
    }
    public abstract void ordenar();


}
