package edu.lmu.cmsi.anu.collections;

import java.util.Iterator;

public class MyArrayIterator<E> implements Iterator<E> {
	private E[] arrayCollection;
	private int currentObject = 0;

	public MyArrayIterator(E[] inputArray) {
		this.arrayCollection = inputArray;
	}

	public boolean hasNext() {
		return arrayCollection[currentObject] != null;
	}

	public E next() {
		if (this.currentObject == this.arrayCollection.length) {
			this.currentObject = 0;
		}
		else {
			this.currentObject++;
		}
		return this.arrayCollection[currentObject];
	}

	public void remove() {
		throw new UnsupportedOperationException("Sorry, can't do that");
	}
}