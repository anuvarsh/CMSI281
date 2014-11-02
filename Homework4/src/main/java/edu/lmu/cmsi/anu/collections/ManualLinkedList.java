package edu.lmu.cmsi.anu.collections;

import java.util.Iterator;

public class ManualLinkedList<E> extends MyCollection<E> implements Iterable<E> {
	private Node head;
	private int count;
	private int size;

	public ManualLinkedList(int maxSize) {
		super(maxSize);
		this.head = new Node(null);
		this.count = 0;
	}

	public int maxSize() {
		return size;
	}

	public int currentSize() {
		return count;
	}

	public void add(E newElement) {
		Node temp = new Node(newElement);
		Node current = head;

		if (newElement == null) {
			throw new IllegalArgumentException("This collection does not accept nulls.");
		}

		if (count > size) {
			this.remove(1);
		} 
		else {
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(temp);
			count++;
		}	
	}
	
	public E getOldest() {
        return null;
	}

	public E getNewest() {
		return null;
	}

	public boolean remove(int index) {
		if (index < 1 || index > size) {
			return false;
		}

		Node current = head;
		for (int i = 1; i <= index; i++) {
			if (current.getNext() == null) {
				return false;
			}

			current = current.getNext();
		}

		current.setNext(current.getNext().getNext());
		count--;
		return true;
	}

	public void reset() {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current != null) {
                current = null;
            }
        }
	}

	public Iterator<E> iterator() {
        return new ManualLinkedListIterator<E>();
    }
}