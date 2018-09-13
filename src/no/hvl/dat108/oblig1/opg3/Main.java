package no.hvl.dat108.oblig1.opg3;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Ansatt> liste = Arrays.asList(new Ansatt("Bo", "Bosen", Kj�nn.MANN, "Sjef", 25000),
				new Ansatt("Ana", "Anesen", Kj�nn.KVINNE, "assistent", 15000),
				new Ansatt("Poul", "Poulsen", Kj�nn.MANN, "Klovn", 12000),
				new Ansatt("Kristen", "Kristensen", Kj�nn.KVINNE, "Marketing", 45000));

		for (Ansatt a : liste) {
			System.out.println(a);
		}
		System.out.println();

		// endre l�nn med fast bel�p � lige til.
		int �kMed = 2000;
		liste.get(0).endreL�nn(l�nn -> l�nn + �kMed);

		// endre l�nn med fast bel�p hvis l�nnen er under 16000
		int l�nnGrense = 16000;
		for (Ansatt a : liste) {
			a.endreL�nn(Ansatt.�kL�nnUnderGrense(a.getL�nn(), l�nnGrense, �kMed));
		}

		// endre l�nn med fast prosentdel
		double �kPros = 1.1;
		liste.get(3).endreL�nn(l�nn -> (int) (l�nn * �kPros));

		System.out.println("Opdatert liste:");
		for (Ansatt a : liste) {
			System.out.println(a);
		}

	}

}
