package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	List<Voto> listaVoti;

	public Libretto() {
		this.listaVoti=new ArrayList<Voto>();
	}
	
	

	public List<Voto> getListaVoti() {
		return listaVoti;
	}
	
	public void addVoto(Voto v ) {
		//lavoro con oggetto voto per non modificare campi in caso di modifica classe voto
		listaVoti.add(v);
	}
	
	@Override
	public String toString() {
		return this.listaVoti.toString();
	}
	
	/**
	 * Restituisce il punteggio ottenuto all'esame di cui
	 * specifico il nome
	 * @param s Nome dell'esame
	 * @return punteggio numerico, oppure null se esame non esiste
	 */
	public Voto cercaVoto(String s) {
		
		for(int i = 0;i<listaVoti.size();i++)
		{
			if(listaVoti.get(i).getMateria().compareTo(s)==0)
				return(listaVoti.get(i));
		}
		
		return null;
	}
	
	public Libretto cercaEsame(int pt){
		Libretto output = new Libretto();
		for(int i = 0;i<listaVoti.size();i++)
		{
			if(listaVoti.get(i).getPunteggio()==25)
				output.addVoto(listaVoti.get(i));
		}
		
		return output;
	}
	
	public boolean isDuplicato(Voto v) {
		for(Voto v1:listaVoti)
		{
			if(v1.equals(v))		//delego alla classe voto questo controllo
				return true;
		}
		return false;
	}
	
	public boolean isConflitto(Voto v) {
		Integer punti = this.cercaVoto(v.getMateria()).getPunteggio();
		if(punti !=null && punti != v.getPunteggio())
			return true;
		else
			return false;
		
	}

}
