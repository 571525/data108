package no.hvl.dat108.oblig1.opg4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import no.hvl.dat108.oblig1.opg3.Ansatt;
import no.hvl.dat108.oblig1.opg3.Kjønn;

public class Main {

	public static void main(String[] args) {
		List<Ansatt> liste = Arrays.asList(new Ansatt("Bo", "Bosen", Kjønn.MANN, "Sjef", 25000),
				new Ansatt("Ana", "Anesen", Kjønn.KVINNE, "assistent", 15000),
				new Ansatt("Karsten", "Poulsen", Kjønn.MANN, "Klovn", 12000),
				new Ansatt("Birgit", "Nilsen", Kjønn.KVINNE, "assistent", 15000),
				new Ansatt("Bo", "Klausen", Kjønn.MANN, "assistent", 16000),
				new Ansatt("Kristian", "Poulsen", Kjønn.MANN, "Kaffehenter", 11000),
				new Ansatt("Ola", "Nilsen", Kjønn.KVINNE, "CEO", 82000),
				new Ansatt("Frederik", "Baron", Kjønn.MANN, "assistent", 12000),
				new Ansatt("David", "Hylden", Kjønn.MANN, "CTO", 51000),
				new Ansatt("Petter", "Eineren", Kjønn.MANN, "marketing", 12000),
				new Ansatt("Petr", "Cech", Kjønn.MANN, "salg", 42000),
				new Ansatt("Poul", "Poulsen", Kjønn.MANN, "Klovn", 12000),
				new Ansatt("Kristen", "Kristensen", Kjønn.KVINNE, "Marketing", 45000));

//		a) Lag en ny liste som kun inneholder etternavnene til de ansatte. 
		List<String> etternavne = liste.stream().map(e -> e.getEtternavn()).collect(Collectors.toList());

		etternavne.forEach(System.out::println);

//		b) Finn ut antall kvinner blant de ansatte.
		Long antall = liste.stream().filter(k -> k.getKjønn() == Kjønn.KVINNE).collect(Collectors.counting());

		System.out.println(antall);

//		c) Regn ut gjennomsnittslønnen til kvinnene.
		Double gns = liste.stream().filter(k -> k.getKjønn() == Kjønn.KVINNE).map(l -> l.getLønn())
				.collect(Collectors.averagingLong(k -> k));

		System.out.println(gns);

//		d) Gi alle sjefer (stilling = "sjef") en lønnsøkning på 7% (Bruk løsning fra
//		   Oppg3)
		liste.stream().filter(s -> s.getStilling() == "Sjef").collect(Collectors.toList())
				.forEach(s -> s.endreLønn(l -> (int) (l * 1.07)));

		// testcase
		System.out.println(liste.get(0));

//		e) Finn ut (true|false) om det er noen ansatte som tjener mer enn 800.000,-
		boolean finnes = liste.stream().filter(l -> l.getLønn() > 800000).findFirst().isPresent();

		System.out.println(finnes);

//		f) Skriv ut alle de ansatte med System.out.println() uten å bruke løkke.
		liste.forEach(System.out::println);

//		g) Finn og skriv ut den/de ansatte som har lavest lønn.
		liste.stream()
		.map(x -> x.getLønn())
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
		//input var definerer når funksjonen skal stoppe
		range.accept(1000);
	}
	
}
