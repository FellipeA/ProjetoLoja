package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DevolucaoBoundary extends Application
{
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception 
	{
		/* Configura��es Gerais */
		stage.setTitle("Devolu��o");
		stage.getIcons().add(new Image(DevolucaoBoundary.class.getResourceAsStream("icon3.png")));
		BorderPane principal = new BorderPane();
		FlowPane botoes = new FlowPane();
		GridPane grp = new GridPane();
		Scene Scn = new Scene(principal);
		/* Configura��es Espec�ficas */
		principal.setCenter(grp);
		principal.setBottom(botoes);
		
	}
}
