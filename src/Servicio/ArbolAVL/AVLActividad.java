package Servicio.ArbolAVL;
import model.Actividad.*;

public class AVLActividad {

    private class Nodo {
        Actividad dato;
        Nodo izq, der;
        int altura;

        Nodo(Actividad dato) {
            this.dato = dato;
            this.altura = 1;
        }
    }

    private Nodo raiz;

    // ALTURA
    private int altura(Nodo n) {
        return (n == null) ? 0 : n.altura;
    }

    // BALANCE
    private int balance(Nodo n) {
        return (n == null) ? 0 : altura(n.izq) - altura(n.der);
    }

    // ROTACIONES
    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izq;
        Nodo T2 = x.der;

        x.der = y;
        y.izq = T2;

        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;

        return x;
    }

    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.der;
        Nodo T2 = y.izq;

        y.izq = x;
        x.der = T2;

        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;

        return y;
    }

    // INSERTAR
    public void insertar(Actividad a) {
        raiz = insertarRec(raiz, a);
    }

    private Nodo insertarRec(Nodo nodo, Actividad a) {

        if (nodo == null) return new Nodo(a);

        if (a.getImportancia() < nodo.dato.getImportancia()) {
            nodo.izq = insertarRec(nodo.izq, a);
        } else {
            nodo.der = insertarRec(nodo.der, a);
        }

        nodo.altura = 1 + Math.max(altura(nodo.izq), altura(nodo.der));

        int balance = balance(nodo);

        // ROTACIONES
        if (balance > 1 && a.getImportancia() < nodo.izq.dato.getImportancia())
            return rotarDerecha(nodo);

        if (balance < -1 && a.getImportancia() > nodo.der.dato.getImportancia())
            return rotarIzquierda(nodo);

        if (balance > 1 && a.getImportancia() > nodo.izq.dato.getImportancia()) {
            nodo.izq = rotarIzquierda(nodo.izq);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && a.getImportancia() < nodo.der.dato.getImportancia()) {
            nodo.der = rotarDerecha(nodo.der);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // MOSTRAR ORDENADO
    public void inOrder() {
        inOrderRec(raiz);
    }

    private void inOrderRec(Nodo nodo) {
        if (nodo != null) {
            inOrderRec(nodo.izq);
            System.out.println(nodo.dato);
            inOrderRec(nodo.der);
        }
    }
}
