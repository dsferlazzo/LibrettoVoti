package it.polito.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.libretto.model.Voto;

public class LibrettoDAO {
	
	public boolean creaVoto(Voto v) {
		//FACCIO LA INSERT AL DATABASE
		try {
		Connection conn = DBConnect.getConnection();
		String sql = "INSERT INTO voti (nome, punti) "
				+ "VALUES (?, ?)";
		PreparedStatement st = conn.prepareStatement(sql);
		//String sql = "INSERT INTO voti (nome, punti) "
		//		+ "VALUES ('" + nome +"', " + punti + ")";		//PROCEDURA RSCHIOSA
		//NECESSITA DI SCRIVERE, PRIMA DI INSERIRE DELLE STRING, "'
		
		st.setString(1, v.getMateria());
		st.setInt(2, v.getPunteggio());
		
		int res = st.executeUpdate();
		st.close();
		conn.close();
		
		return(res==1);
		
		
		} catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	public List<Voto> readAllVoto() {
		
		try {
			Connection conn = DBConnect.getConnection();
			String sql = "SELECT * FROM voti";
			PreparedStatement st = conn.prepareStatement(sql);
			
			
			ResultSet res = st.executeQuery();		//INSIEME DEI RISULTATI DELLA QUERY
			
			List<Voto> result = new ArrayList<Voto>();
			while(res.next())
			{
				String nome = res.getString("nome");
				int punti = res.getInt("punti");
				result.add(new Voto(nome, punti));
			}
			st.close();		
			
			conn.close();	//DA CHIUDERE PRIMA DI RITORNARE IL RISULTATO
			return result;
			
		} catch(SQLException e){
			System.out.println(e);
			e.printStackTrace();
			return null;
			
		}
		
		
	
	}
	
	public Voto readVotoByNome(String nome) {
		
		
		
		return null;
	}

}		//LA CLASSE OFFRE I METODI PER OPERARE IL DATABASE
