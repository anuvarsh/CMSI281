package edu.lmu.cmsi.anu.collections;

public class Node<E> {

	private E value = null;
    private Node next = null;

    public Node(E value) {
        this.value = value;
        this.next = null;
    }

    public Node(E nextValue, Node nextNode) {
        this.value = nextValue;
        this.next = nextNode;
    }

    public E getValue() {
        return this.value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}