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
//	System.out b�r v�re synchronized da begge tr�de bruker den. 
//	N�r den ikke er synchronized s� kan begge tr�de skrive ut p� 
//	samme tid. Dermed kan System.out teoretisk set blive brukt samtidigt, men 
//	vi vil helst ikke bruke den samtidigt. Ideelt var den synchronized s� kun en ting 
//  blev skrevet ut om gangen.
	


}
