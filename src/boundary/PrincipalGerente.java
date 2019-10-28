package boundary;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrincipalGerente extends Application
{
	private Button VB = new Button(" Visualizar Balan�o ");
	private Button MF = new Button(" Manter Funcion�rio ");
	private Button MD = new Button("  Manter Devolu��o  ");
	private Tooltip VBT = new Tooltip(" Visualizar Balan�o ");
	private Tooltip MFT = new Tooltip(" Manter Funcion�rio ");
	private Tooltip MDT = new Tooltip("  Manter Devolu��o  ");
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception 
	{
		/* Configurando coisas b�sicas da Tela */
		stage.setTitle("Gerente");
		stage.getIcons().add(new Image(PrincipalGerente.class.getResourceAsStream("icon2.png")));
		VBox prGerente = new VBox();
		BorderPane brp = new BorderPane();
		Scene Scn = new Scene(brp, 250, 250);
		MF.setTooltip(MFT);
		MD.setTooltip(MDT);
		VB.setTooltip(VBT);
		/* Configurando Layout */
		prGerente.getChildren().addAll(VB,MF,MD);
		prGerente.setSpacing(20);
		prGerente.setAlignment(Pos.CENTER);
		brp.setCenter(prGerente);
		/* Mostrando */
		stage.setScene(Scn);
		stage.show();
		
	}
}
