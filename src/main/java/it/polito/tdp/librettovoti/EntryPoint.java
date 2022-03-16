package it.polito.tdp.librettovoti;

import it.polito.tdp.libretto.model.Libretto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
   //     Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        Parent root = loader.load();
        
        //POSSO ACCEDERE DIRETTAMENTE AL LOADER, PASSATO DA METODO STATICO A NORMALE
        
        
        FXMLController controller = loader.getController();
        
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
     
        Libretto model = new Libretto();	//LOGICA APPLICATIVA
        
        controller.setModel(model);		//HO DETTO AL CONTROLLER QUALE è IL MODEL
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
