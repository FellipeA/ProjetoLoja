package boundary;

import ENUM.TipoGarantia;
import ENUM.TipoHardware;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DevolucaoBoundary extends Application
{
	private TextField txtCliente = new TextField();
	private TextField txtVenda = new TextField();
	private ComboBox<TipoHardware> txtProduto = new ComboBox<TipoHardware>();
	private ComboBox<TipoGarantia> txtGarantia = new ComboBox<TipoGarantia>();
	private TextArea txtRazao = new TextArea();
		
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception 
	{
		/* Configurações Gerais */
		stage.setTitle("Devolução");
		BorderPane principal = new BorderPane();
		FlowPane botoes = new FlowPane();
		GridPane grp = new GridPane();
		Scene Scn = new Scene(principal, 550, 400);
		stage.getIcons().add(new Image(DevolucaoBoundary.class.getResourceAsStream("icon3.jpg")));
		/* Configurações Específicas */
		principal.setCenter(grp);
		principal.setPrefSize(50, 50);
		principal.setBottom(botoes);
		
		grp.setHgap(10);
		grp.setVgap(5);

		
		grp.add(new Label("Cliente: "), 0, 0);
		grp.add(txtCliente, 1, 0);
		grp.add(new Label("Venda: "), 0, 1);
		grp.add(txtVenda, 1, 1);
		grp.add(new Label("Produto: "), 0, 2);
		grp.add(txtProduto, 1, 2);
		txtProduto.getItems().setAll(TipoHardware.values());
		grp.add(new Label("Garantia: "), 0, 3);
		grp.add(txtGarantia, 1, 3);
		txtGarantia.getItems().setAll(TipoGarantia.values());
		grp.add(new Label("Razão: "), 0, 4);
		grp.add(txtRazao, 1, 4);
		
		stage.setScene(Scn);
		stage.show();
	}
}
