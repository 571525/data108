package no.hvl.dat108.oblig1.opg4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import no.hvl.dat108.oblig1.opg3.Ansatt;
import no.hvl.dat108.oblig1.opg3.Kj�nn;

public class Main {

	public static void main(String[] args) {
		List<Ansatt> liste = Arrays.asList(new Ansatt("Bo", "Bosen", Kj�nn.MANN, "Sjef", 25000),
				new Ansatt("Ana", "Anesen", Kj�nn.KVINNE, "assistent", 15000),
				new Ansatt("Karsten", "Poulsen", Kj�nn.MANN, "Klovn", 12000),
				new Ansatt("Birgit", "Nilsen", Kj�nn.KVINNE, "assistent", 15000),
				new Ansatt("Bo", "Klausen", Kj�nn.MANN, "assistent", 16000),
				new Ansatt("Kristian", "Poulsen", Kj�nn.MANN, "Kaffehenter", 11000),
				new Ansatt("Ola", "Nilsen", Kj�nn.KVINNE, "CEO", 82000),
				new Ansatt("Frederik", "Baron", Kj�nn.MANN, "assistent", 12000),
				new Ansatt("David", "Hylden", Kj�nn.MANN, "CTO", 51000),
				new Ansatt("Petter", "Eineren", Kj�nn.MANN, "marketing", 12000),
				new Ansatt("Petr", "Cech", Kj�nn.MANN, "salg", 42000),
				new Ansatt("Poul", "Poulsen", Kj�nn.MANN, "Klovn", 12000),
				new Ansatt("Kristen", "Kristensen", Kj�nn.KVINNE, "Marketing", 45000));

//		a) Lag en ny liste som kun inneholder etternavnene til de ansatte. 
		List<String> etternavne = liste.stream().map(e -> e.getEtternavn()).collect(Collectors.toList());

		etternavne.forEach(System.out::println);

//		b) Finn ut antall kvinner blant de ansatte.
		Long antall = liste.stream().filter(k -> k.getKj�nn() == Kj�nn.KVINNE).collect(Collectors.counting());

		System.out.println(antall);

//		c) Regn ut gjennomsnittsl�nnen til kvinnene.
		Double gns = liste.stream().filter(k -> k.getKj�nn() == Kj�nn.KVINNE).map(l -> l.getL�nn())
				.collect(Collectors.averagingLong(k -> k));

		System.out.println(gns);

//		d) Gi alle sjefer (stilling = "sjef") en l�nns�kning p� 7% (Bruk l�sning fra
//		   Oppg3)
		liste.stream().filter(s -> s.getStilling() == "Sjef").collect(Collectors.toList())
				.forEach(s -> s.endreL�nn(l -> (int) (l * 1.07)));

		// testcase
		System.out.println(liste.get(0));

//		e) Finn ut (true|false) om det er noen ansatte som tjener mer enn 800.000,-
		boolean finnes = liste.stream().filter(l -> l.getL�nn() > 800000).findFirst().isPresent();

		System.out.println(finnes);

//		f) Skriv ut alle de ansatte med System.out.println() uten � bruke l�kke.
		liste.forEach(System.out::println);

//		g) Finn og skriv ut den/de ansatte som har lavest l�nn.
		liste.stream()
		.map(x -> x.getL�nn())
		.collect(Collectors.groupingBy(x -> x))
		.entrySet().stream()
		.min((e1, e2) -> (e1.getValue()).toString().compareTo(e2.getValue().toString()))
		.ifPresent(System.out::println);
//		
//		h) Finn og skriv ut summen av alle heltall i [1, 1000> som er delelig med 3
//		   eller 5.

		Consumer<Integer> range = x -> {
			for (int i = 0; i < x; i++) {
				if (i % 3 == 0 || i % 5 == 0) {
					System.out.println(i);
				}
			}
		};
		//input var definerer n�r funksjonen skal stoppe
		range.accept(1000);
	}
	
}
