package boundary;

import entity.Hardware;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrincipalFuncionario extends Application implements EventHandler<ActionEvent>
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
		btnProduto.addEventHandler(ActionEvent.ANY, this);
		btnCliente.addEventHandler(ActionEvent.ANY, this);
		btnVenda.addEventHandler(ActionEvent.ANY, this);
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

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnCliente) { 
			ClienteBoundary cb = new ClienteBoundary();
			cb.start(new Stage());
		} else if (event.getTarget() == btnProduto) {
			HardwareBoundary hb = new HardwareBoundary();
			try {
				hb.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			VendaBoundary vb = new VendaBoundary();
			vb.start(new Stage());
		}
	}
}