package boundary;

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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VendaBoundary extends Application implements EventHandler<ActionEvent>{
	private ComboBox<Hardware> comboProduto = new ComboBox<Hardware>();
	private ComboBox<Cliente> comboCliente = new ComboBox<Cliente>();
	private ComboBox<TipoPagamento> comboPagamento = new ComboBox<TipoPagamento>();
	private HardwareControl hc = new HardwareControl();
	private ClienteBoundary cb = new ClienteBoundary();
	private ClienteControl cc = new ClienteControl();
	private VendaControl vc = new VendaControl();
	private TableView<Hardware> table = new TableView<Hardware>();
	private Button btnAdicionar = new Button("+");
	private Button btnConfirmar = new Button("Confirmar Venda");
	private TableColumn<Hardware, String> columnNome = new TableColumn<>("Nome");
	private TableColumn<Hardware, TipoHardware> columnTipo = new TableColumn<>("Tipo");
	private TableColumn<Hardware, TipoGarantia> columnGarantia = new TableColumn<>("Garantia");
	private TableColumn<Hardware, String> columnPreco = new TableColumn<>("Preço");
	private DatePicker data = new DatePicker();
	private Button btnNovo = new Button("Novo Cliente");
	private BorderPane painelPrincipal = new BorderPane();
	private GridPane grid = new GridPane();
	private FlowPane flow1 = new FlowPane();
	private GridPane grid2 = new GridPane();
	private Scene scn = new Scene(painelPrincipal, 800, 600);
	
	
	public VendaBoundary() {
		comboCliente.getItems().addAll(cc.getListaCliente());
		comboProduto.getItems().addAll(hc.getListaHardware());
		comboPagamento.getItems().addAll(TipoPagamento.values());
		painelPrincipal.setStyle("-fx-padding:25px");
		painelPrincipal.setTop(grid);
		painelPrincipal.setLeft(table);
		painelPrincipal.setBottom(grid2);
		grid.setStyle("-fx-padding:20px;");
		grid.setMaxSize(500, 500);
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(20);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(100);
		grid.getColumnConstraints().addAll(col0, col1);
		Label lblProduto = new Label("Produto");
		lblProduto.setStyle("-fx-font-size:17px;");
		grid.add(lblProduto, 0, 0);
		flow1.getChildren().addAll(comboProduto, btnAdicionar);
		flow1.setHgap(5);
		grid.add(flow1, 1, 0);
		grid.setVgap(10);
		table.setMinSize(515, 200);
		table.setMaxSize(600, 200);
		addTableColumns();
		grid2.add((new Label("Método de Pagamento")), 0, 0);
		
		grid2.add(comboPagamento, 1, 0);
		grid2.add((new Label("Cliente")), 0, 1);
		comboCliente.setMinWidth(180);
		grid2.add(comboCliente, 1, 1);
		grid2.add(btnNovo, 2, 1);
		grid2.add(new Label("Data"), 0, 2);
		grid2.add(data, 1, 2);
		grid2.add(btnConfirmar, 6, 6);
		grid2.setAlignment(Pos.BASELINE_LEFT);
		grid2.setHgap(10);
		grid2.setVgap(10);
		
		btnConfirmar.addEventHandler(ActionEvent.ANY, this);
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		btnNovo.addEventHandler(ActionEvent.ANY, this);
	}
	
	public void start(Stage stage) {
		VendaBoundary vb = new VendaBoundary();
		stage.getIcons().add(new Image(VendaBoundary.class.getResourceAsStream("icon6.png")));
		stage.setScene(scn);
		stage.setTitle("Venda");
		stage.show();
	}

	public static void main(String[] args) {
		VendaBoundary.launch(args);
	}
	
	public Venda boundaryParaEntidade() { 
		Venda v = new Venda();
		try {
			v.setProdutos(vc.getlistaItens());
			v.setData(data.getValue());
			v.setCliente(comboCliente.getValue());
			v.setTipo(comboPagamento.getValue());
			double valorTotal=0;
			for (Hardware h : vc.getlistaItens()) {
				valorTotal += h.getPreco();
			}
			if (comboPagamento.getValue() == TipoPagamento.DINHEIRO) {
				valorTotal = valorTotal * TipoPagamento.DINHEIRO.getDesconto();
			}
			v.setValorTotal(valorTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
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
		} else if (event.getTarget() == btnConfirmar){
			boundaryParaEntidade();
		} else {
			cb.start(new Stage());
		}
	}

}
