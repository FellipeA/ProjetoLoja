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

public class PrincipalFuncionario extends Application
{
	private Button btnProduto = new Button(" Manter Produto ");
	private Button btnVenda = new Button(" Manter Venda ");
	private Button btnCliente = new Button("  Manter Cliente  ");
	private Tooltip dicaProduto = new Tooltip(" Manter Produto ");
	private Tooltip dicaVenda = new Tooltip(" Manter Funcionário ");
	private Tooltip dicaCliente = new Tooltip("  Manter Devolução  ");
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception 
	{
		/* Configurando coisas básicas da Tela */
		stage.setTitle("Menu Principal (Funcionário)");
		stage.getIcons().add(new Image(PrincipalGerente.class.getResourceAsStream("icon2.png")));
		VBox prFuncionario = new VBox();
		BorderPane brp = new BorderPane();
		Scene Scn = new Scene(brp, 250, 250);
		btnProduto.setTooltip(dicaProduto);
		btnVenda.setTooltip(dicaVenda);
		btnCliente.setTooltip(dicaCliente);
		/* Configurando Layout */
		prFuncionario.getChildren().addAll(btnProduto,btnVenda,btnCliente);
		prFuncionario.setSpacing(10);
		prFuncionario.setAlignment(Pos.CENTER);
		brp.setCenter(prFuncionario);
		/* Mostrando */
		stage.setScene(Scn);
		stage.show();
		
	}
}