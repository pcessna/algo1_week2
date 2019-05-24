import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] a;
	private int size = 0;

	public RandomizedQueue() {
		a = (Item[]) new Object[2];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void enqueue(Item item) {
		if (item == null)
			throw new NullPointerException();
		enlarge();
		a[size] = item;
		size++;
	}

	public Item dequeue() {
		int i = StdRandom.uniform(0, size);
		Item result = a[i];
		while (i < size) {
			a[i] = a[i + 1];
			i++;
		}
		a[size] = null;
		size--;
		this.autoShrink();
		return result;
	}

	private void autoShrink() {
		if (size > 0 && size == a.length / 4)
			resize(a.length / 2);
	}

	public Item sample() {
		return a[StdRandom.uniform(0, size)];

	}

	private void resize(int newSize) {
		Item[] temp = (Item[]) new Object[newSize];
		for (int i = 0; i < size; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	private void enlarge() {
		int length = a.length;
		if (length == size) {
			resize(length * 2);
		}
	}

	private class RandomArrayIterator implements Iterator<Item> {
		private Item[] r;
		private int i;

		public RandomArrayIterator() {
			copyQueue();
			StdRandom.shuffle(r);
		}

		private void copyQueue() {
			r = (Item[]) new Object[size];
			for (int i = 0; i < size; i++) {
				r[i] = a[i];
			}
		}

		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return r[i++];
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new RandomArrayIterator();
	} // return an iterator that returns the items in random order

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
