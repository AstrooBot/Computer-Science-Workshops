package co.edu.distrital.model;

import java.util.Objects;

public class NodoSimple<T> {

    private T dato;
    private NodoSimple<T> siguiente;

    public NodoSimple(T dato, NodoSimple<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public NodoSimple(T dato) {
        this(dato, null);
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoSimple<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return Objects.toString(dato, "null"); // Forma segura de manejar null
    }
    
}
