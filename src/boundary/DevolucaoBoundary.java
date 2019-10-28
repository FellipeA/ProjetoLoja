package boundary;

import javax.swing.JOptionPane;

import ENUM.TipoGarantia;
import ENUM.TipoHardware;
import control.DevolucaoControl;
import entity.Devolucao;
import entity.Hardware;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DevolucaoBoundary extends Application implements EventHandler<ActionEvent>
{
	private DevolucaoControl control = new DevolucaoControl();
	private TextField txtCliente = new TextField();
	private TextField txtVenda = new TextField();
	private ComboBox<TipoHardware> txtProduto = new ComboBox<TipoHardware>();
	private ComboBox<TipoGarantia> txtGarantia = new ComboBox<TipoGarantia>();
	private TextArea txtRazao = new TextArea();
	private Button btnSalvar = new Button("Salvar");
	private Button btnVoltar = new Button("Voltar");
	private Tooltip dicaSalvar = new Tooltip("Salva a Nova Devolução");
	private Tooltip dicaVoltar = new Tooltip("Volta ao Menu Principal");
		
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
		Scene Scn = new Scene(principal, 600, 375);
		stage.getIcons().add(new Image(DevolucaoBoundary.class.getResourceAsStream("icon3.jpg")));
		/* Configurações Específicas */
		principal.setStyle("-fx-padding: 20px");
		principal.setCenter(grp);
		principal.setBottom(botoes);
		/* GAP entre os TextFields e Labels */
		grp.setHgap(10);
		grp.setVgap(5);
		/* Labels e TextFields */
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
		/* Botões */
		botoes.setAlignment(Pos.BASELINE_CENTER);
		botoes.setHgap(15);
		btnSalvar.setTooltip(dicaSalvar);
		btnVoltar.setTooltip(dicaVoltar);
		botoes.getChildren().addAll(btnSalvar, btnVoltar);
		btnSalvar.addEventHandler(ActionEvent.ANY, this);
		btnVoltar.addEventHandler(ActionEvent.ANY, this);
		/* Mostrando */
		stage.setScene(Scn);
		stage.show();
	}
	public Devolucao boundaryParaEntidade() { 
		Devolucao d = new Devolucao();
		try 
		{
			d.setGarantia(txtGarantia.getValue());
			d.setTipo(txtProduto.getValue());
			d.setCliente(txtCliente.getText());
			d.setVenda(txtVenda.getText());
			d.setRazao(txtRazao.getText());
			Limpatxt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public void handle(ActionEvent event) 
	{
		if (event.getTarget() == btnSalvar) 
		{ 
			control.adicionar(boundaryParaEntidade());
		} else if (event.getTarget() == btnVoltar) 
		{
			Limpatxt();
		} 
	}
	public void Limpatxt() 
	{
		txtCliente.clear();
		txtVenda.clear();
		txtProduto.setValue(null);
		txtGarantia.setValue(null);
		txtRazao.clear();
	}
}
