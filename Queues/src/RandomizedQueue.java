import java.util.Iterator;

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
		enlarge();
		a[size] = item;
	} // add the item

	public Item dequeue() {

	} // delete and return a random item

	public Item sample(int ) {
		int i = StdRandom.uniform(9);
	} // return (but do not delete) a random item

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

	@Override
	public Iterator<Item> iterator() {
	} // return an iterator that returns the items in random order

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
