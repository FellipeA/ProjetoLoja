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
	private Button btnVenda = new Button("   Manter Venda  ");
	private Button btnCliente = new Button("  Manter Cliente  ");
	private Tooltip dicaProduto = new Tooltip(" Manter Produto ");
	private Tooltip dicaVenda = new Tooltip(" Manter Funcionário ");
	private Tooltip dicaCliente = new Tooltip("  Manter Devolução  ");
	private BorderPane brp = new BorderPane();
	private Scene Scn = new Scene(brp, 250, 250);
	private VBox prFuncionario = new VBox();
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	public PrincipalFuncionario() {
		btnProduto.setTooltip(dicaProduto);
		btnVenda.setTooltip(dicaVenda);
		btnCliente.setTooltip(dicaCliente);
		HardwareBoundary hw = new HardwareBoundary();
		btnProduto.setOnAction(e -> {
			try {
				hw.start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		ClienteBoundary cb = new ClienteBoundary();
		btnCliente.setOnAction(e -> {
			try {
				cb.start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		VendaBoundary vb = new VendaBoundary();
		btnVenda.setOnAction(e -> vb.start(new Stage()));
		prFuncionario.getChildren().addAll(btnProduto,btnVenda,btnCliente);
		prFuncionario.setSpacing(20);
		prFuncionario.setAlignment(Pos.CENTER);
		brp.setCenter(prFuncionario);
	}

	@Override
	public void start(Stage stage) throws Exception 
	{
		PrincipalFuncionario pf = new PrincipalFuncionario();
		stage.setTitle("Menu Principal (Funcionário)");
		stage.getIcons().add(new Image(PrincipalGerente.class.getResourceAsStream("icon2.png")));
		stage.setScene(Scn);
		stage.show();
		
	}
}