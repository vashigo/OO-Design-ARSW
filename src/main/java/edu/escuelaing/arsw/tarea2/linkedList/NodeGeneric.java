package edu.escuelaing.arsw.tarea2.linkedList;

/**
 * Node Generic for LinkedList Generic
 * 
 * @author vashi
 * @param <E>
 */
public class NodeGeneric<E> {

    private E valor;
    private NodeGeneric<E> next;

    public NodeGeneric(E valor) {
        this.valor = valor;
        next = null;
    }

    public NodeGeneric<E> getNext() {
        return next;
    }

    public void setNext(NodeGeneric<E> next) {
        this.next = next;
    }

    public E getValor() {
        return valor;
    }

}
