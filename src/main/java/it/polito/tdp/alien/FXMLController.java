package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Dizionario dizionario=new Dizionario();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelCom;

    @FXML
    private TextField txtTraduzione;

    @FXML
    private TextArea txtResult;

    @FXML
    void doClear(ActionEvent event) {
    	dizionario.pulisci();
    	txtTraduzione.clear();
    	txtResult.clear();
    }

    @FXML
    void doTraduzione(ActionEvent event) {
    	String stringa =txtTraduzione.getText();
    	txtTraduzione.clear();
    	
    	if(!stringa.matches("[a-zA-Z ]+"))
    		return;
    	
    	stringa.toLowerCase();
    	String[] array=stringa.split(" ");
    	
    	if(array.length==1) {
    		String aliena=array[0];
    		String traduzione=dizionario.traduzione(aliena);
    		if(traduzione.compareTo("0")==0) {
    			txtResult.setText("Non conosciamo ancora la traduzione di questa parola."+"\n");
    		} else {
    			txtResult.setText("La traduzione di "+aliena+" e': "+traduzione+".\n");
    		}
   
    	}	
    	
    	if(array.length==2) {
    		String aliena=array[0];
    		String traduzione=array[1];
    		dizionario.addTraduzione(aliena, traduzione);
    	}
    }

    @FXML
    void initialize() {
        assert labelCom != null : "fx:id=\"labelCom\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtrResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
