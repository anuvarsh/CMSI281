package edu.lmu.cmsi.anu.collections;

import java.util.Iterator;

public class ManualLinkedListIterator<E> implements Iterator {
    Node<E> head;

    public ManualLinkedListIterator(Node<E> input) {
        this.head = input;
    }

    public boolean hasNext() {
        return head.getNext() != null;
    }

    public E next() {
        E val = head.getNext().getValue();
        head = head.getNext();
        return val;
    }

    public void remove() {
        throw new UnsupportedOperationException("Sorry, can't do that");
    }
}