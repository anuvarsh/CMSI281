package edu.lmu.cmsi.anu.collections;

import java.util.Iterator;

public class ManualLinkedList<E> extends MyCollection<E> implements Iterable<E> {
	private Node<E> head;
	private int nElements;

	public ManualLinkedList(int maxSize) {
		super(maxSize);
		this.head = new Node<E>(null);
		this.nElements = 0;
	}

	public int getSize() {
		return nElements;
	}

	public void add(E newElement) {
		Node<E> temp = new Node(newElement);
		Node<E> current = head;

		if (newElement == null) {
			throw new IllegalArgumentException("This collection does not accept nulls.");
		}

		if (nElements >= size) {
			head.setNext((head.getNext()).getNext());
            nElements--;
		} 

		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(temp);
		nElements++;
	}
	
	public E getOldest() {
        return head.getNext().getValue();
	}

	public E getNewest() {
        Node<E> current = head;
        if (head.getNext() == null) {
            throw new IllegalStateException("getNewest attempted on empty list");
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
		return current.getValue();
	}

	public void reset() {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current != null) {
                current = null;
            }
        }
        nElements = 0;
	}

	public Iterator<E> iterator() {
        return new ManualLinkedListIterator<E>(head);
    }
}