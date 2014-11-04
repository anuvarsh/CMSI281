package edu.lmu.cmsi.anu.collections;

import java.util.Iterator;

public class MyArray<E> extends MyCollection<E> {
	private E[] arrayCollection;
    private int nElements;

	public MyArray(int size) {
		super(size);
        arrayCollection = (E[])new Object[size];
        nElements = 0;
	}

    public int getSize() {
        return nElements-1;
    }

	public E getOldest() {
		return arrayCollection[0];
	}

	public E getNewest() {
		return arrayCollection[nElements-1];
	}

	public void add(E newElement) {
		if (newElement == null) {
			throw new IllegalArgumentException("This collection does not accept nulls.");
		}

        boolean added = false;
		for (int i = 0; i < arrayCollection.length; i++) {
            if (arrayCollection[i] == null) {
                arrayCollection[i] = newElement;
                added = true;
                nElements++;
            }
        }

        if (added == false) {
            for (int i = 1; i < arrayCollection.length; i++) {
                arrayCollection[i-1] = arrayCollection[i];
            }
            arrayCollection[arrayCollection.length-1] = newElement;
        }
	}

	public void reset() {
		for (int i = 0; i < arrayCollection.length; i++) {
			arrayCollection[i] = null;
            nElements = 1;
		}
	}

	public Iterator<E> iterator() {
        return new MyArrayIterator<E>(arrayCollection);
    }
}