package no.hvl.dat108.oblig1.opg2;

import java.util.LinkedList;

/**
 * A shared buffer for consumers and producers. The item type is int. The buffer
 * is implemented by using a double ended queue.
 *
 * @author Atle Geitung
 * @version 17.05.2018 C++ version
 * @version 30.08.2018 Java version
 */
public class Buffer {

	private final static int SIZE = 10;
	private LinkedList<Integer> buffer = new LinkedList<Integer>();

	/**
	 * Add a new item to the buffer. If the buffer is full, wait.
	 *
	 * @param item the new item
	 */
	public void add(Integer item) {
		while (true) {
			synchronized (this) {
				while (buffer.size() == SIZE) {
					try {
						wait();
						System.out.println("FULL");
					} catch (Exception e) {
					}
				}
				buffer.add(item);
				try {
					notify();
				} catch (Exception e) {}
				return;
			}
		}
	}

	/**
	 * Remove next available item from the buffer. If the buffer is empty, wait.
	 *
	 * @return next item
	 */
	public Integer remove() {
		while (true) {
			synchronized (this) {
				while (buffer.size() == 0) {
					try {
						wait();
						System.out.println("TOM");
					} catch (Exception e) {
					}
				}

				Integer back = buffer.removeFirst();
				try {
					notify();
				} catch (Exception e) {
				}
				return back;
			}
		}

	}

}
