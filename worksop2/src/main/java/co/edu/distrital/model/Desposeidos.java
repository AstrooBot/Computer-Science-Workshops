package co.edu.distrital.model;

public class Desposeidos<T> {

    private NodoSimple<T> cabeza;
    private NodoSimple<T> cola;
    private int tamano;

    public Desposeidos() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return tamano == 0;
    }

    public int getTamano() {
        return this.tamano;
    }

    public NodoSimple<T> getCabeza() {
        return this.cabeza;
    }

    public void insertarNodo(T dato) {
        NodoSimple<T> nuevoNodo = new NodoSimple<>(dato, this.cabeza);
        this.cabeza = nuevoNodo;
        if (this.cola == null) { // Si la lista estaba vacía
            this.cola = this.cabeza; // El nuevo nodo es también la cola
        }
        this.tamano++;
    }

    public NodoSimple<T> eliminarNodo() {
        if (estaVacia()) {
            return null; // O lanzar una excepción si se prefiere
        }
        NodoSimple<T> nodoEliminado = this.cabeza;
        this.cabeza = this.cabeza.getSiguiente();
        nodoEliminado.setSiguiente(null); // Desconectar el nodo eliminado
        this.tamano--;
        return nodoEliminado;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Pila Vacía");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("HEAD -> ");
        NodoSimple<T> actual = this.cabeza;
        for (int i = 0; i < tamano; i++) {
            sb.append(actual + " -> "); 
            actual = actual.getSiguiente();   
        }
        sb.append("END");
        System.out.println(sb.toString());

    }

}
