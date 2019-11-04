package boundary;

import javax.swing.JOptionPane;

import ENUM.TipoGarantia;
import ENUM.TipoHardware;
import ENUM.TipoPagamento;
import control.ClienteControl;
import control.HardwareControl;
import control.VendaControl;
import entity.Cliente;
import entity.Hardware;
import entity.Venda;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VendaBoundary extends Application implements EventHandler<ActionEvent>{
	private ComboBox<Hardware> comboProduto = new ComboBox<Hardware>();
	private ComboBox<Cliente> comboCliente = new ComboBox<Cliente>();
	private ComboBox<TipoPagamento> comboPagamento = new ComboBox<TipoPagamento>();
	private HardwareControl hc = new HardwareControl();
	private ClienteControl cc = new ClienteControl();
	private VendaControl vc = new VendaControl();
	private TableView<Hardware> table = new TableView<Hardware>();
	private Button btnAdicionar = new Button("+");
	private Button btnConfirmar = new Button("Confirmar Venda");
	private TableColumn<Hardware, String> columnNome = new TableColumn<>("Nome");
	private TableColumn<Hardware, TipoHardware> columnTipo = new TableColumn<>("Tipo");
	private TableColumn<Hardware, TipoGarantia> columnGarantia = new TableColumn<>("Garantia");
	private TableColumn<Hardware, String> columnPreco = new TableColumn<>("Preço");
	@Override
	public void start(Stage stage) {
		BorderPane painelPrincipal = new BorderPane();
		GridPane grid = new GridPane();
		FlowPane flow1 = new FlowPane();
		GridPane grid2 = new GridPane();
		painelPrincipal.setStyle("-fx-padding:25px");
		painelPrincipal.setTop(grid);
		painelPrincipal.setLeft(table);
		painelPrincipal.setBottom(grid2);
		grid.setStyle("-fx-padding:20px;");
		grid.setMaxSize(500, 500);
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(15);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(100);
		grid.getColumnConstraints().addAll(col0, col1);
		Label lblProduto = new Label("Produto");
		lblProduto.setStyle("-fx-font-size:17px;");
		grid.add(lblProduto, 0, 0);
		Hardware h1 = new Hardware(TipoGarantia.GARANTIA_PADRÃO, TipoHardware.PLACA_DE_VÍDEO, 321, "RX580");	
		Hardware h2 = new Hardware(TipoGarantia.GARANTIA_PADRÃO, TipoHardware.PLACA_DE_VÍDEO, 321, "RX590");
		Hardware h3 = new Hardware(TipoGarantia.GARANTIA_PADRÃO, TipoHardware.PLACA_DE_VÍDEO, 321, "RX560");
		hc.adicionar(h1);
		hc.adicionar(h2);
		hc.adicionar(h3);
		comboProduto.getItems().addAll(hc.getListaHardware());
		flow1.getChildren().addAll(comboProduto, btnAdicionar);
		flow1.setHgap(5);
		grid.add(flow1, 1, 0);
		grid.setVgap(10);
		table.setMinSize(515, 200);
		table.setMaxSize(600, 200);
		addTableColumns();
		grid2.add((new Label("Método de Pagamento")), 0, 0);
		comboCliente.getItems().addAll(cc.getListaCliente());
		comboPagamento.getItems().addAll(TipoPagamento.values());
		grid2.add(comboPagamento, 1, 0);
		grid2.add((new Label("Cliente")), 0, 1);
		grid2.add(comboCliente, 1, 1);
		grid2.add(btnConfirmar, 3, 3);
		grid2.setAlignment(Pos.BASELINE_LEFT);
		grid2.setHgap(10);
		grid2.setVgap(10);
		
		btnConfirmar.addEventHandler(ActionEvent.ANY, this);
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		
		Scene scn = new Scene(painelPrincipal, 800, 600);
		stage.setScene(scn);
		stage.setTitle("Venda");
		stage.show();
	}


	public static void main(String[] args) {
		VendaBoundary.launch(args);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void addTableColumns() { 
		columnNome.setCellValueFactory(new PropertyValueFactory<Hardware, String>("Nome"));
		columnTipo.setCellValueFactory(new PropertyValueFactory<Hardware, TipoHardware>("Tipo"));
		columnGarantia.setCellValueFactory(new PropertyValueFactory<Hardware, TipoGarantia>("Garantia"));
		columnPreco.setCellValueFactory(new PropertyValueFactory<Hardware, String>("Preco"));
		table.getColumns().addAll(columnNome, columnTipo,columnPreco, columnGarantia);
		table.setItems(vc.getlistaItens());
		table.resizeColumn(columnNome, 50);
		table.resizeColumn(columnGarantia, 50);
		table.resizeColumn(columnPreco, 30);
		table.resizeColumn(columnTipo, 60);
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget() == btnAdicionar) {
			vc.adicionar(comboProduto.getValue());
			attPreco();
		}
	}
	
	private void attPreco() {
		
	}

}
