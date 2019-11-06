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
	private Button VB = new Button("  Visualizar Balanço  ");
	private Button MF = new Button(" Manter Funcionário ");
	private Button MD = new Button("  Manter Devolução  ");
	private Button btnProduto = new Button("    Manter Produto    ");
	private Button btnVenda = new Button("      Manter Venda     ");
	private Button btnCliente = new Button("     Manter Cliente     ");
	private Tooltip VBT = new Tooltip(" Visualizar Balanço ");
	private Tooltip MFT = new Tooltip(" Manter Funcionário ");
	private Tooltip MDT = new Tooltip("  Manter Devolução  ");
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
		stage.setTitle("Gerente");
		stage.getIcons().add(new Image(PrincipalGerente.class.getResourceAsStream("icon2.png")));
		VBox prGerente = new VBox();
		BorderPane brp = new BorderPane();
		Scene Scn = new Scene(brp, 350, 350);
		MF.setTooltip(MFT);
		MD.setTooltip(MDT);
		VB.setTooltip(VBT);
		btnProduto.setTooltip(dicaProduto);
		btnVenda.setTooltip(dicaVenda);
		btnCliente.setTooltip(dicaVenda);
		DevolucaoBoundary bd = new DevolucaoBoundary();
		MD.setOnAction(e -> 
		{
			try 
			{
				bd.start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		FuncionarioBoundary fb = new FuncionarioBoundary();
		MF.setOnAction(e -> {
			try {
				fb.start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		VisualizarBalanco vb = new VisualizarBalanco();
		VB.setOnAction(e -> {
			try {
				vb.start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
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
		
		prGerente.getChildren().addAll(VB,MF, MD, btnProduto, btnCliente, btnVenda);
		prGerente.setSpacing(20);
		prGerente.setAlignment(Pos.CENTER);
		brp.setCenter(prGerente);
		stage.setScene(Scn);
		stage.show();
	}
}
