package edu.lmu.cmsi.anu.collections;

import java.util.Iterator;

public class ManualLinkedListIterator<E> implements Iterator {


    public boolean hasNext() {
        return false;
    }

    public E next() {
        return null;
    }

    public void remove() {
        throw new UnsupportedOperationException("Sorry, can't do that");
    }
}