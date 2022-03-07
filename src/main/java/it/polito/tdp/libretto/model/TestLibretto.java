package it.polito.tdp.libretto.model;

public class TestLibretto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Libretto lib = new Libretto();
		lib.addVoto(new Voto("Analisi 1", 30));
		lib.addVoto(new Voto("Fisica 1", 27));
		lib.addVoto(new Voto("Informatica", 25));
		lib.addVoto(new Voto("Algebra lineare", 25));
		System.out.println(lib);
		
		System.out.println("\nVoti uguali a 25");
		Libretto lib25= lib.cercaEsame(25);
		System.out.println(lib25);
		
		System.out.println("\nVoto dell'esame: Fisica 1");
		System.out.println(lib.cercaVoto("Fisica 1").getPunteggio());
		
		
		
		
		

	}
	
	

}
