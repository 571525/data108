package no.hvl.dat108.oblig1.opg2;

import java.util.LinkedList;
import java.util.NoSuchElementException;

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
				// Mens bufferen er full, vent
				while (buffer.size() == SIZE) {
					try {
						System.out.println("bufferen er full");
						wait();
					} catch (InterruptedException e) {}
				}
				
				// tilføj element
				buffer.add(item);
				
				// sig til Consumer thread at den skal fortsette
				notify();
				
				//Vent litt med å fortsette. kan sløyfes
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
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
				
				// Mens bufferen er tom, vent.
				while (buffer.size() == 0) {
					try {
						System.out.println("bufferen er tom");
						wait();
					} catch (InterruptedException e) {}
				}
				
				// fjern neste
				Integer back = buffer.removeFirst();
				
				// Start produktionen igen
				notify();
				
				//vent litt med å fortsette. Kan sløyfes
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
				return back;
			}
		}

	}

}
