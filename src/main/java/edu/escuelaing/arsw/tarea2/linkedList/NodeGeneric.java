/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.tarea2.linkedList;

/**
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
