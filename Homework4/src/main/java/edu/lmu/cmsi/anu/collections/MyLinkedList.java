package edu.lmu.cmsi.anu.collections;

import java.util.LinkedList;

public class MyLinkedList<E> {
	private LinkedList<E> linkedListCollection;
	private int size;
	private int counter = 0;

	public MyLinkedList(int size) {
		this.size = size;
		linkedListCollection = new LinkedList<E> ();
	}

	public void add(E o1) {
		if (counter <= size) {
		linkedListCollection.add(o1);
		counter++;
		} else {
			linkedListCollection.remove();
			linkedListCollection.add(o1);
		}
		
	}
}