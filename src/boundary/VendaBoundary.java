package boundary;

import javax.swing.JOptionPane;

import control.ClienteControl;
import control.HardwareControl;
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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class VendaBoundary extends Application implements EventHandler<ActionEvent>{
	private ComboBox<Hardware> comboProduto = new ComboBox<Hardware>();
	
	@Override
	public void start(Stage stage) {
		GridPane grid = new GridPane();
		grid.setStyle("-fx-padding:10px; -fx-background-color:white");
		grid.setMaxSize(500, 500);
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(30);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(70);
		grid.getColumnConstraints().addAll(col0, col1);
		
		grid.add((new Label("Produto")), 0, 0);
		HardwareControl hc = new HardwareControl();
		
		for (Hardware h : hc.getListaHardware()) {
			comboProduto.getItems().add(h);
		}
		grid.add(comboProduto, 1, 1);
		
		Scene scn = new Scene(grid, 500, 500);
		stage.setScene(scn);
		stage.setTitle("Venda");
		stage.show();
	}


	public static void main(String[] args) {
		VendaBoundary.launch(args);
	}
	
	
	
	public void addTableColumns() { 
		TableColumn<Hardware, Long> columnId = new TableColumn<>("Id");
		columnId.setCellValueFactory(
				new PropertyValueFactory<Hardware, Long>("id"));
		
		TableColumn<Hardware, String> columnTipo = new TableColumn<>("Tipo");
		columnTipo.setCellValueFactory(
				new PropertyValueFactory<Hardware, String>("tipo"));
		
		TableColumn<Hardware, String> columnFabricante = new TableColumn<>("Fabricante");
		columnFabricante.setCellValueFactory(
				new PropertyValueFactory<Hardware, String>("fabricante"));
		
	}

	@Override
	public void handle(ActionEvent event) {
		
	}

}
