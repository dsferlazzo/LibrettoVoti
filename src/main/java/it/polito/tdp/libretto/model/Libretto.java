package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.librettovoti.db.LibrettoDAO;


public class Libretto {
	
	List<Voto> listaVoti;

	public Libretto() {
		this.listaVoti=new ArrayList<Voto>();
	}
	
	

	public List<Voto> getListaVoti() {
		return listaVoti;
	}
	
	/*public boolean addVoto(Voto v ) {
		//lavoro con oggetto voto per non modificare campi in caso di modifica classe voto
		if(this.isConflitto(v))
			return false;
		if(this.isDuplicato(v))
			return false;
		listaVoti.add(v);
		//if(!isDuplicato(v) && !isConflitto(v))
		return true;
		
	}*/
	
	public boolean addVoto(Voto v) {
		LibrettoDAO dao = new LibrettoDAO();
		boolean result = dao.creaVoto(v);
		return result;
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
	
	/*public Libretto cercaEsame(int pt){
		Libretto output = new Libretto();
		for(int i = 0;i<listaVoti.size();i++)
		{
			if(listaVoti.get(i).getPunteggio()==25)
				output.addVoto(listaVoti.get(i));
		}
		
		return output;
	}*/
	
	public boolean isDuplicato(Voto v) {
		for(Voto v1:listaVoti)
		{
			if(v1.equals(v))		//delego alla classe voto questo controllo
				return true;
		}
		return false;
	}
	
	public boolean isConflitto(Voto v) {
		if(this.cercaVoto(v.getMateria())==null)
			return false;

		
		Integer punti = this.cercaVoto(v.getMateria()).getPunteggio();
		if(punti != v.getPunteggio())
			return true;
		else
			return false;
		
	}
	
	/*public List<Voto> getVoti(){
		return this.listaVoti;
	}*/
	
	public List<Voto> getVoti(){
		LibrettoDAO dao = new LibrettoDAO();
		return dao.readAllVoto();
	}
	
	/*public Libretto votiMigliorati() {
		
		Libretto nuovo = new Libretto();
		for(Voto v:listaVoti)
		{
			int punti = v.getPunteggio();
			if(punti>=24)
				punti+=2;
			else punti++;
			if(punti>30)		//CONTROLLO DI NON AVER SUPERATO 30
				punti=30;
			nuovo.addVoto(new Voto(v.getMateria(), punti));		//PER NON CAMBIARE L'ALTRO LIBRETTO
			//DEVO MANTENERE ENTRAMBI I LIBRETTI CONTEMPORANEAMENTE
		}		//IMPACCHETTO I NUOVI VOTI MIGLIORATI IN UN NUOVO LIBRETTO
		
		return nuovo;
		
	}*/
	
	public void cancellaVoti(int punti) {		//GNERALIZZO IL METODO
		
		for(Voto v: this.listaVoti) {
			if(v.getPunteggio()<punti)
				this.listaVoti.remove(v);
		}
		
	
		
	}

}
