package edu.lmu.cmsi.anu.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedListIterator<E> implements Iterator<E> {
    private LinkedList<E> list;
    private Iterator<E> listIterator;

    public MyLinkedListIterator(LinkedList<E> input) {
        this.list = input;
        this.listIterator = input.iterator();
    }

    public boolean hasNext() {
        return listIterator.hasNext();
    }

    public E next() {
        return listIterator.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("Sorry, can't do that");
    }
}