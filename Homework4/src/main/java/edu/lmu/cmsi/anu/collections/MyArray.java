package edu.lmu.cmsi.anu.collections;

import java.util.Iterator;

public class MyArray<E> extends MyCollection<E> implements Iterable<E> {
	private E[] arrayCollection;
    private int nElements;

	public MyArray(int size) {
		super(size);
        nElements = 0;
	}

    public int getSize() {
        return nElements;
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
            nElements = 0;
		}
	}

	public Iterator<E> iterator() {
        return new MyArrayIterator<E>(arrayCollection);
    }

    /*
    public static void main (String[] args) {
    	MyArray<String> a1 = new MyArray (2);
    	a1.add("First");
    	a1.add("Second");

    	System.out.println("Items in collection:");
        for(String s: a1) {
            System.out.println(s);
        }
    }
    */

}