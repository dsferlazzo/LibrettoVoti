package it.polito.tdp.libretto.model;

public class Voto {
	
	String materia;
	int punteggio;
	
	
	public Voto(String materia, int punteggio) {
		super();
		this.materia = materia;
		this.punteggio = punteggio;
	}
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	@Override
	public String toString() {
		return materia +" : "+ punteggio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((materia == null) ? 0 : materia.hashCode());
		result = prime * result + punteggio;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (punteggio != other.punteggio)
			return false;
		return true;
	}
	
	

	
	
	
	
	
	

}
