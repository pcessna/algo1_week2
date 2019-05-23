
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private Node first, last;
	private int size = 0;

	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	public Deque() {
		size = 0;
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException();
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		first.prev = null;
		if (isEmpty())
			last = first;
		else
			oldFirst.prev = first;
		size++;
	}

	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException();
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = oldLast;
		if (isEmpty())
			first = last;
		else
			oldLast.next = last;
		size++;
	}

	public Item removeFirst() {
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		Item item = first.item;
		first = first.next;
		size--;

		if (isEmpty())
			last = first;
		else
			first.prev = null;
		return item;

	}

	public Item removeLast() {
		Item item = last.item;
		last = last.prev;
		size--;

		if (isEmpty())
			first = last;
		else
			last.prev = null;
		return item;
	}

	private class DequeIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}

	public static void main(String[] args) {
		Deque test = new Deque();
		test.addFirst("hi");
		test.addLast("goodbye");

		System.out.print(test.removeFirst() + "\n");
		System.out.print(test.removeLast() + "\n");
	}

}
