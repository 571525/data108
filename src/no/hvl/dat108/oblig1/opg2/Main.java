package no.hvl.dat108.oblig1.opg2;

public class Main {

	public static void main(String[] args) {
		
		Buffer buffer = new Buffer();
		Producer p = new Producer(buffer);
		Consumer c = new Consumer(buffer);
		c.start();
		p.start();
	}
	
//// Opg 2d)
//	System.out bør være synchronized da begge tråde bruker den. 
//	Når den ikke er synchronized så kan begge tråde skrive ut på 
//	samme tid. Dermed kan System.out teoretisk set blive brukt samtidigt, men 
//	vi vil helst ikke bruke den samtidigt. Ideelt var den synchronized så kun en ting 
//  blev skrevet ut om gangen.
	


}
