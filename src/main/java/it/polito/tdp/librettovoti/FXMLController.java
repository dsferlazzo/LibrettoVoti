package it.polito.tdp.librettovoti;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbPunti;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtVoti;
    
    @FXML
    private Label txtStatus;

    @FXML
    void handleNuovoVoto(ActionEvent event) {
    	
    	//FASE 1: ACQUISIZIONE E CONTROLLO DATI
    	String nome = txtNome.getText();
    	Integer punti = cmbPunti.getValue();		//RITORNA L'ITEM SELEZIONATO
    	//FATTO COME INTEGER, PER EVITARE QUI NULLPOINTEREXCCEPTION
    	
    	//CONTROLLO DI VALIDITA
    	if(nome.equals("") || punti==null)
    	{
    		
    		txtStatus.setText("ERRORE: occorre inserire nome e voto\n");
    		return;		//ERRORE, NON POSSO ESEGUIRE L'OPERAZIONE
    	}
    	
    	
    	//FASE 2: ESECUZIONE DELL'OPERAZIONE
    	boolean ok = model.addVoto(new Voto(nome,punti));
    	//FASE 3: VISUALIZZAZIONE/AGGIORNAMENTO DEL RISULTATO
    	if(ok) {
	    	List<Voto> voti = model.getVoti();
	    	txtVoti.clear();
	    	txtVoti.appendText("Hai superato " + voti.size() + " esami\n");
	    	
	    	for(Voto v : voti)
	    	{
	    		txtVoti.appendText(v.toString()+"\n");
	    	}
	    	
	    	txtNome.clear();
	    	cmbPunti.setValue(null); 	//MODIFICA IL VALORE ATTUALMENTE SELEZIONATO
	    	txtStatus.setText("");
    	} else {
    		txtStatus.setText("Errore: esame già presente");
    	}
    	//String contenutoLibretto = model.toString();		//AGGIORNO INTERFACCIA
    	//txtVoti.setText(contenutoLibretto);

    }
    
    public void setModel(Libretto model) {
    	this.model=model;
    }		//CONTROLLER NON HA BISOGNO DI CREARSI IL MODELLO SU CUI LAVORARE

    @FXML
    void initialize() {
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";
        
        cmbPunti.getItems().clear();
        for(int i = 18;i<31;i++)
        	cmbPunti.getItems().add(i);
       

    }

}
