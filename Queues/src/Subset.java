import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset {

	public static void main(String[] args) {
		RandomizedQueue<String> randomQueue = new RandomizedQueue<String>();
		while (!StdIn.isEmpty()) {
			randomQueue.enqueue(StdIn.readString());
		}
		int num = Integer.parseInt(args[0]);
		while (num-- > 0) {
			StdOut.println(randomQueue.dequeue());
		}
	}
}
