package co.edu.distrital.model;

import java.util.NoSuchElementException;
import java.util.Objects;


public class ListaCircularEnlazadaDoble<T> {

    public int tamano;
    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;

    public NodoDoble<T> getCabeza() {
        return cabeza;
    }

    public NodoDoble<T> getCola() {
        return cola;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Lista Doble Vacía");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("HEAD <-> ");
        NodoDoble<T> actual = this.cabeza;
        for (int i = 0; i < tamano; i++) {
            sb.append(actual + " <-> "); 
            actual = actual.getSiguiente();   
        }
        sb.append("TAIL");
        System.out.println(sb.toString());

    }
    public void imprimirInversa() {
        if (estaVacia()) {
            System.out.println("Lista Doble Vacía");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("TAIL <-> ");
        NodoDoble<T> actual = this.cola;
        for (int i = 0; i < tamano; i++) {
            sb.append(actual + " <-> "); 
            actual = actual.getAnterior();   
        }
        sb.append("HEAD");
        System.out.println(sb.toString());

    }

    public ListaCircularEnlazadaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return tamano == 0;
    }

    public NodoDoble<T> getNodoAnterior(T datoBusqueda) {
        return buscarNodo(datoBusqueda).getAnterior();
    }

    public NodoDoble<T> getNodoPosterior(T datoBusqueda) {
        return buscarNodo(datoBusqueda).getSiguiente();
    }

    public void insertarNodoInicio(T dato) {
        agregarNodo(dato);
    }

    public void insertarNodoFinal(T dato) {
        insertarNodoInicio(dato);
        if(!estaVacia()) {
            NodoDoble<T> colaOriginal = this.cola;
            this.cola = this.cabeza;
            this.cabeza = this.cabeza.getSiguiente();
            this.cola.setAnterior(colaOriginal);

        }
    }

    public boolean insertarNodoAnteriorA(T datoExistente, T datoNuevo) {
        NodoDoble<T> nodoExistente = buscarNodo(datoExistente);
        if(nodoExistente == null) return false;
        if(nodoExistente == this.cabeza) agregarNodo(datoNuevo);
        else {
        NodoDoble<T> nodoNuevo = new NodoDoble<T>(datoNuevo, nodoExistente, nodoExistente.getAnterior());
        nodoExistente.getAnterior().setSiguiente(nodoNuevo);
        nodoExistente.setAnterior(nodoNuevo);
        this.tamano++;
        }
        return true;
    }

    public boolean insertarNodoPosteriorA(T datoExistente, T datoNuevo) {
        NodoDoble<T> nodoExistente = buscarNodo(datoExistente);
        if(nodoExistente == null) return false;
        if(nodoExistente == this.cola) insertarNodoFinal(datoNuevo);
        else {
        NodoDoble<T> nodoNuevo = new NodoDoble<T>(datoNuevo, nodoExistente.getSiguiente(), nodoExistente);
        nodoExistente.getSiguiente().setAnterior(nodoNuevo);
        nodoExistente.setSiguiente(nodoNuevo);
        this.tamano++;
        }
        return true;    
    }

    public T eliminarNodoInicio() {
        if (estaVacia()) {
            throw new NoSuchElementException("No se puede eliminar de una lista doble vacía.");
        }
        T datoEliminado = this.cabeza.getDato();
        NodoDoble<T> antiguaCabeza = this.cabeza;
        this.cabeza = this.cabeza.getSiguiente(); 
        this.tamano--;
        if (this.cabeza != null) {
            this.cabeza.setAnterior(null);
        } else {
            this.cola = null;
        }
        antiguaCabeza.setSiguiente(null);
        return datoEliminado;
    }

    public T eliminarNodoFinal() {
        if (estaVacia()) {
            throw new NoSuchElementException("No se puede eliminar de una lista doble vacía.");
        }
        if (this.tamano == 1) return eliminarNodoInicio();
        T datoEliminado = this.cola.getDato();
        NodoDoble<T> antiguaCola = this.cola;
        this.cola = this.cola.getAnterior(); // Retrocede la cola
        this.cola.setSiguiente(null);       // La nueva cola no tiene siguiente
        this.tamano--;
        antiguaCola.setAnterior(null);
        return datoEliminado;
    }

    public void eliminarNodoAnteriorA(T datoExistente) {
        NodoDoble<T> nodoExistente = buscarNodo(datoExistente);
        eliminarNodo(nodoExistente.getAnterior());
    }

    public void eliminarNodoPosteriorA(T datoExistente) {
        NodoDoble<T> nodoExistente = buscarNodo(datoExistente);
        eliminarNodo(nodoExistente.getSiguiente());   
    }

    // --- Métodos fundamentales para el resto de operaciones publicas -- 

    public NodoDoble<T> buscarNodo(T datoBusqueda) {
        NodoDoble<T> actual = this.cabeza;
        if(estaVacia()) return null;
        do {
            if (Objects.equals(actual.getDato(), datoBusqueda)) {
                return actual;
            }
            actual = actual.getSiguiente();

        }
        while(actual != this.cabeza);
        return null; 
    }

    private void agregarNodo(T dato) {
        if(estaVacia()) {
            NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
            this.cabeza.setAnterior(this.cola); 
            this.cola.setSiguiente(this.cabeza);
        }
        else {

            NodoDoble<T> nuevoNodo = new NodoDoble<>(dato, this.cabeza, this.cabeza.getAnterior());
            this.cabeza.setAnterior(nuevoNodo);
            this.cabeza = nuevoNodo;

            this.cola.setSiguiente(this.cabeza);
            NodoDoble<T> penultimo = this.cabeza;
            while(penultimo.getSiguiente() != this.cabeza) {
                penultimo = penultimo.getSiguiente();
            }
            this.cola.setAnterior(penultimo); 
        }
        this.tamano++;
    }

    public void eliminarNodo(NodoDoble<T> nodoAEliminar ) {
        // No verificar null aquí, se asume que viene de una búsqueda válida.
        if (nodoAEliminar == null) throw new NoSuchElementException("No se ha encontrado dato a eliminar."); 
        // Identificar los vecinos
        NodoDoble<T> nodoAnterior = nodoAEliminar.getAnterior();
        NodoDoble<T> nodoSiguiente = nodoAEliminar.getSiguiente();

        // --- Actualizar enlaces de los vecinos ---
        if (nodoAnterior == null) {
            // Se está eliminando la cabeza
            this.cabeza = nodoSiguiente;
        } else {
            // El anterior ahora apunta al siguiente del nodo eliminado
            nodoAnterior.setSiguiente(nodoSiguiente);
        }

        if (nodoSiguiente == null) {
            // Se está eliminando la cola
            this.cola = nodoAnterior;
        } else {
            // El siguiente ahora apunta al anterior del nodo eliminado
            nodoSiguiente.setAnterior(nodoAnterior);
        }

        // --- Actualizar tamaño ---
        this.tamano--;

        // --- Opcional: limpiar punteros del nodo eliminado ---
        nodoAEliminar.setAnterior(null);
        nodoAEliminar.setSiguiente(null);
        nodoAEliminar.setDato(null); 
    }

    public void eliminarNodo(T DatoEliminar) {
        NodoDoble<T> nodoAEliminar = buscarNodo(DatoEliminar);
        if (nodoAEliminar == null) throw new NoSuchElementException("No se ha encontrado dato a eliminar.");
        // Identificar los vecinos
        NodoDoble<T> nodoAnterior = nodoAEliminar.getAnterior();
        NodoDoble<T> nodoSiguiente = nodoAEliminar.getSiguiente();

        // --- Actualizar enlaces de los vecinos ---
        if (nodoAnterior == null) {
            // Se está eliminando la cabeza
            this.cabeza = nodoSiguiente;
        } else {
            // El anterior ahora apunta al siguiente del nodo eliminado
            nodoAnterior.setSiguiente(nodoSiguiente);
        }

        if (nodoSiguiente == null) {
            // Se está eliminando la cola
            this.cola = nodoAnterior;
        } else {
            // El siguiente ahora apunta al anterior del nodo eliminado
            nodoSiguiente.setAnterior(nodoAnterior);
        }
        // --- Actualizar tamaño ---
        this.tamano--;
        // --- Opcional: limpiar punteros del nodo eliminado ---
        nodoAEliminar.setAnterior(null);
        nodoAEliminar.setSiguiente(null);
        nodoAEliminar.setDato(null);
    }

}
