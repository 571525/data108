package no.hvl.dat108.oblig1.opg3;
import java.util.function.*;

public class Ansatt {
	
	private Kjønn kjønn;	
	private String fornavn;
	private String etternavn;
	private String stilling;
	private int lønn;
	
public Ansatt(String fornavn, String etternavn, Kjønn kjønn, String stilling, int lønn) {
	this.fornavn = fornavn;
	this.etternavn = etternavn;
	this.kjønn = kjønn;
	this.stilling = stilling;
	this.lønn = lønn;
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

public int getLønn() {
	return lønn;
}

public void setLønn(int lønn) {
	this.lønn = lønn;
}

public Kjønn getKjønn() {
	return kjønn;
}

public void setKjønn(Kjønn kjønn) {
	this.kjønn = kjønn;
}

public void endreLønn(Function<Integer, Integer> funktion) {
	lønn = funktion.apply(lønn);
}


public static Function<Integer, Integer> økLønnUnderGrense(int lønn, int lønnGrense, int øk) {
	if (lønn < lønnGrense) {
		return i -> i + øk;
	}
	return i -> i;
} 

//Kunne evt ha brukt Predicate<T>
@FunctionalInterface
interface Betingelse {
	boolean sjekk(int lønn);
}

@Override
public String toString() {
	return "Opg3Ansatt [fornavn=" + fornavn + ", etternavn=" + etternavn + ", kjønn= " + kjønn + ", stilling=" + stilling
			+ ", lønn=" + lønn + "]";
}
}
