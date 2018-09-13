package no.hvl.dat108.oblig1.opg2;

public class Main {

	public static void main(String[] args) {
		
		Buffer buffer = new Buffer();
		Producer p = new Producer(buffer);
		Consumer c = new Consumer(buffer);
		c.start();
		p.start();
	}

}
