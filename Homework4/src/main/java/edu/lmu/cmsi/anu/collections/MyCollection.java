package edu.lmu.cmsi.anu.collections;

import java.util.Iterator;

public abstract class MyCollection<E> implements Iterable<E>{
	protected int size;

	public MyCollection (int size) {
		this.size = size;
	}

    public int getMaxSize() {
        return size;
    }

	public abstract int getSize();
	public abstract E getOldest();
	public abstract E getNewest();
	public abstract void add(E newElement);
	public abstract void reset();

}