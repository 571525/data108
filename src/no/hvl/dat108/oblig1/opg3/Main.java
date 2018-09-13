package no.hvl.dat108.oblig1.opg3;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Ansatt> liste = Arrays.asList(new Ansatt("Bo", "Bosen", Kjønn.MANN, "Sjef", 25000),
				new Ansatt("Ana", "Anesen", Kjønn.KVINNE, "assistent", 15000),
				new Ansatt("Poul", "Poulsen", Kjønn.MANN, "Klovn", 12000),
				new Ansatt("Kristen", "Kristensen", Kjønn.KVINNE, "Marketing", 45000));

		for (Ansatt a : liste) {
			System.out.println(a);
		}
		System.out.println();

		// endre lønn med fast beløp å lige til.
		int økMed = 2000;
		liste.get(0).endreLønn(lønn -> lønn + økMed);

		// endre lønn med fast beløp hvis lønnen er under 16000
		int lønnGrense = 16000;
		for (Ansatt a : liste) {
			a.endreLønn(Ansatt.økLønnUnderGrense(a.getLønn(), lønnGrense, økMed));
		}

		// endre lønn med fast prosentdel
		double økPros = 1.1;
		liste.get(3).endreLønn(lønn -> (int) (lønn * økPros));

		System.out.println("Opdatert liste:");
		for (Ansatt a : liste) {
			System.out.println(a);
		}

	}

}
