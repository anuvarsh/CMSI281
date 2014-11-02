package edu.lmu.cmsi.anu.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<E> extends MyCollection<E> {
	private LinkedList<E> linkedListCollection;
	private int nElements;

	public MyLinkedList(int size) {
		super(size);
		linkedListCollection = new LinkedList<E> ();
        nElements = 0;
	}

    public int getSize() {
        return nElements;
    }
    public E getOldest() {
        return linkedListCollection.getFirst();
    }

    public E getNewest() {
        return linkedListCollection.getLast();
    }

	public void add(E newElement) {
        if (newElement == null) {
            throw new IllegalArgumentException("This collection does not accept nulls.");
        }

        if (nElements >= size) {
            linkedListCollection.remove();
            nElements--;
        }

        linkedListCollection.add(newElement);
        nElements++;

	}

    public void reset() {
        linkedListCollection = new LinkedList<E>();
        nElements = 0;
    }

    public Iterator<E> iterator() {
        return new MyLinkedListIterator(linkedListCollection);
    }
}