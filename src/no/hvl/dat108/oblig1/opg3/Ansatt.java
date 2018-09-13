package no.hvl.dat108.oblig1.opg3;
import java.util.function.*;

public class Ansatt {
	
	private Kj�nn kj�nn;	
	private String fornavn;
	private String etternavn;
	private String stilling;
	private int l�nn;
	
public Ansatt(String fornavn, String etternavn, Kj�nn kj�nn, String stilling, int l�nn) {
	this.fornavn = fornavn;
	this.etternavn = etternavn;
	this.kj�nn = kj�nn;
	this.stilling = stilling;
	this.l�nn = l�nn;
}

public String getFornavn() {
	return fornavn;
}

public void setFornavn(String fornavn) {
	this.fornavn = fornavn;
}

public String getEtternavn() {
	return etternavn;
}

public void setEtternavn(String etternavn) {
	this.etternavn = etternavn;
}

public String getStilling() {
	return stilling;
}

public void setStilling(String stilling) {
	this.stilling = stilling;
}

public int getL�nn() {
	return l�nn;
}

public void setL�nn(int l�nn) {
	this.l�nn = l�nn;
}

public Kj�nn getKj�nn() {
	return kj�nn;
}

public void setKj�nn(Kj�nn kj�nn) {
	this.kj�nn = kj�nn;
}

public void endreL�nn(Function<Integer, Integer> funktion) {
	l�nn = funktion.apply(l�nn);
}


public static Function<Integer, Integer> �kL�nnUnderGrense(int l�nn, int l�nnGrense, int �k) {
	if (l�nn < l�nnGrense) {
		return i -> i + �k;
	}
	return i -> i;
} 

//Kunne evt ha brukt Predicate<T>
@FunctionalInterface
interface Betingelse {
	boolean sjekk(int l�nn);
}

@Override
public String toString() {
	return "Opg3Ansatt [fornavn=" + fornavn + ", etternavn=" + etternavn + ", kj�nn= " + kj�nn + ", stilling=" + stilling
			+ ", l�nn=" + l�nn + "]";
}
}
