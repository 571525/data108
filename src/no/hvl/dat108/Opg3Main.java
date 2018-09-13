package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;

public class Opg3Main {

	public static void main(String[] args) {
		List<Opg3Ansatt> liste = Arrays.asList(new Opg3Ansatt("Bo", "Bosen", Kj�nn.MANN, "Sjef", 25000),
				new Opg3Ansatt("Ana", "Anesen", Kj�nn.KVINNE, "assistent", 15000),
				new Opg3Ansatt("Poul", "Poulsen", Kj�nn.MANN, "Klovn", 12000),
				new Opg3Ansatt("Kristen", "Kristensen", Kj�nn.KVINNE, "Marketing", 45000));

		for (Opg3Ansatt a : liste) {
			System.out.println(a);
		}
		System.out.println();

		// endre l�nn med fast bel�p � lige til.
		int bel�p = 2000;
		liste.get(0).endreL�nn(l�nn -> l�nn + bel�p);

		// endre l�nn med fast bel�p hvis l�nnen er under 16000
		int minL�nn = 16000;
		for (Opg3Ansatt a : liste) {
			if (Opg3Ansatt.sjekkGrense(a, l�nn -> l�nn < minL�nn)) {
				a.endreL�nn(l�nn -> l�nn + bel�p);
			}
		}

		// endre l�nn med fast prosentdel
		double �kPros = 1.1;
		liste.get(3).endreL�nn(l�nn -> (int) (l�nn * �kPros));
		
		System.out.println("Opdatert liste:");
		for (Opg3Ansatt a : liste) {
			System.out.println(a);
		}

	}

}
