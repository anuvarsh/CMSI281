package edu.lmu.cmsi.anu.collections;

import java.util.Iterator;

public class MyArray<E> extends MyCollection<E> implements Iterable<E> {
	private E[] arrayCollection;

	public MyArray(int size) {
		super(size);
	}

	public E getOldest() {
		return arrayCollection[size - 1];
	}

	public E getNewest() {
		return arrayCollection[0];
	}

	public void add(E newElement) {
		if (newElement == null) {
			throw new IllegalArgumentException("This collection does not accept nulls.");
		}
		for (int i = 0; i < arrayCollection.length; i++) {
			if (arrayCollection[i] == null) {
				arrayCollection[i] = newElement;
			}
			else {
				for (int j = 1; j < arrayCollection.length-1; i++) {
					arrayCollection[0] = newElement;
					arrayCollection[j] = arrayCollection[i];
				}
			}
		}
	}

	public void reset() {
		for (int i = 0; i < arrayCollection.length; i++) {
			arrayCollection[i] = null;
		}
	}

	public Iterator<E> iterator() {
        return new MyArrayIterator<E>(arrayCollection);
    }

    public static void main (String[] args) {
    	MyArray<String> a1 = new MyArray (2);
    	a1.add("First");
    	a1.add("Second");

    	System.out.println("Items in collection:");
        for(String s: a1) {
            System.out.println(s);
        }
    }

}