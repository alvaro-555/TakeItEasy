package Servicio.ListaEnlazada;

public class ListaEnlazada<T> {

    private Nodo<T> cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> aux = cabeza;

        while (aux != null) {
            sb.append(aux.getDato()).append("\n");
            aux = aux.getSiguiente();
        }
        return sb.toString();
    }
}