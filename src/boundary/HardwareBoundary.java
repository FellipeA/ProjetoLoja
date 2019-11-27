package boundary;

import ENUM.TipoGarantia;
import ENUM.TipoHardware;
import control.HardwareControl;
import entity.Hardware;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HardwareBoundary extends Application implements EventHandler<ActionEvent> {
	private HardwareControl control = new HardwareControl();
	private TextField txtNome = new TextField();
	private ComboBox<TipoHardware> txtTipo = new ComboBox<TipoHardware>();
	private TextField txtPreco = new TextField();
	private ComboBox<TipoGarantia> txtGarantia = new ComboBox<TipoGarantia>();
	private Button btnAdicionar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnLimpar = new Button("Limpar");
	private Button btnRemover = new Button("Remover");
	private Tooltip dicaRemover = new Tooltip("Remover Hardware");
	private Tooltip dicaSalvar = new Tooltip("Salvar Novo Hardware");
	private Tooltip dicaPesquisar = new Tooltip("Pesquisar Hardware pelo Nome");
	private Tooltip dicaLimpar = new Tooltip("Limpar Todos os Campos");
	private FlowPane painelBotoes = new FlowPane();
	private GridPane painelCampos = new GridPane();
	private BorderPane painelPrincipal = new BorderPane();
	private Scene scn = new Scene(painelPrincipal, 350, 190);
	
	public HardwareBoundary() {
		painelPrincipal.setStyle("-fx-padding: 20px");
		painelPrincipal.setPrefSize(500, 300);
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(30);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(70);
		painelCampos.getColumnConstraints().addAll(col0, col1);
		
		painelPrincipal.setCenter(painelCampos);
		painelPrincipal.setBottom(painelBotoes);
		
		painelCampos.setVgap(5);
		painelCampos.setHgap(10);
		
		painelCampos.add(new Label("Nome"), 0, 0);
		painelCampos.add(txtNome, 1, 0);
		painelCampos.add(new Label("Tipo"), 0, 1);
		txtTipo.getItems().setAll(TipoHardware.values());
		painelCampos.add(txtTipo, 1, 1);
		painelCampos.add(new Label("Preço"), 0, 2);
		txtPreco.setMaxSize(80, 30);
        txtPreco.setMinSize(80, 30);
		painelCampos.add(txtPreco, 1, 2);
		painelCampos.add(new Label("Garantia"), 0, 3);
		txtGarantia.getItems().setAll(TipoGarantia.values());
		painelCampos.add(txtGarantia, 1, 3);

		btnRemover.setTooltip(dicaRemover);
		btnAdicionar.setTooltip(dicaSalvar);
		btnPesquisar.setTooltip(dicaPesquisar);
		btnLimpar.setTooltip(dicaLimpar);
		painelBotoes.getChildren().addAll(btnAdicionar, btnPesquisar,btnRemover, btnLimpar);
		
		btnRemover.addEventHandler(ActionEvent.ANY, this);
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		btnPesquisar.addEventHandler(ActionEvent.ANY, this);
		btnLimpar.addEventHandler(ActionEvent.ANY, this);
		painelBotoes.setHgap(15);
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		HardwareBoundary hb = new HardwareBoundary();
		primaryStage.setScene(scn);
		primaryStage.getIcons().add(new Image(HardwareBoundary.class.getResourceAsStream("icon.png")));
		primaryStage.setTitle("Manter Produto");
		primaryStage.show();
	}
	
	public Hardware boundaryParaEntidade() { 
		Hardware h = new Hardware();
		try {
			h.setTipo(txtTipo.getValue());
			h.setGarantia(txtGarantia.getValue());
			h.setNome(txtNome.getText());
			h.setPreco(Double.parseDouble(txtPreco.getText()));
			Limpatxt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return h;
	}
	
	public void entidadeParaBoundary(Hardware h) { 
		if (h != null) { 
			txtTipo.setValue(h.getTipo());
			txtGarantia.setValue(h.getGarantia());
			txtNome.setText(h.getNome());
			txtPreco.setText(String.valueOf(h.getPreco()));
		} else {
			AlertBox.display("ERRO", "HARDWARE NAO ENCONTRADO!");
		}
	}
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnAdicionar) { 
			control.adicionar(boundaryParaEntidade());
			
		} else if (event.getTarget() == btnPesquisar) {
			String nome = txtNome.getText();
			Hardware h = control.pesquisarPorNome(nome);			
			entidadeParaBoundary(h);
		} else if (event.getTarget() == btnRemover) {
			control.remover(boundaryParaEntidade());
			Limpatxt();
		} else {
			Limpatxt();
		}
	}

	public static void main(String[] args) {
		HardwareBoundary.launch(args);
	}	
	
	public void Limpatxt() {
		txtNome.clear();
		txtPreco.clear();
		txtTipo.setValue(null);
		txtGarantia.setValue(null);
	}
}