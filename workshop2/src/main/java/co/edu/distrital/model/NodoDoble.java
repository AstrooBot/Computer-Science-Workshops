package co.edu.distrital.model;

import java.util.Objects;

public class NodoDoble<T> {

    private T dato;
    private NodoDoble<T> siguiente;
    private NodoDoble<T> anterior;

    public NodoDoble(T dato, NodoDoble<T> siguiente, NodoDoble<T> anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    
    public NodoDoble(T dato) {
        this(dato, null, null);
    }

    @Override
    public String toString() {
        return Objects.toString(dato, "null");
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble<T> getAnterior() {
        return this.anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }
    
}
