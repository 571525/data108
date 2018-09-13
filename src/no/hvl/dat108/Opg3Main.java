package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;

public class Opg3Main {

	public static void main(String[] args) {
		List<Opg3Ansatt> liste = Arrays.asList(new Opg3Ansatt("Bo", "Bosen", Kjønn.MANN, "Sjef", 25000),
				new Opg3Ansatt("Ana", "Anesen", Kjønn.KVINNE, "assistent", 15000),
				new Opg3Ansatt("Poul", "Poulsen", Kjønn.MANN, "Klovn", 12000),
				new Opg3Ansatt("Kristen", "Kristensen", Kjønn.KVINNE, "Marketing", 45000));

		for (Opg3Ansatt a : liste) {
			System.out.println(a);
		}
		System.out.println();

		// endre lønn med fast beløp å lige til.
		int beløp = 2000;
		liste.get(0).endreLønn(lønn -> lønn + beløp);

		// endre lønn med fast beløp hvis lønnen er under 16000
		int minLønn = 16000;
		for (Opg3Ansatt a : liste) {
			if (Opg3Ansatt.sjekkGrense(a, lønn -> lønn < minLønn)) {
				a.endreLønn(lønn -> lønn + beløp);
			}
		}

		// endre lønn med fast prosentdel
		double økPros = 1.1;
		liste.get(3).endreLønn(lønn -> (int) (lønn * økPros));
		
		System.out.println("Opdatert liste:");
		for (Opg3Ansatt a : liste) {
			System.out.println(a);
		}

	}

}
