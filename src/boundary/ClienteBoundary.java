package boundary;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ClienteBoundary extends Application {
	private TextField txtNome = new TextField();
	private TextField txtcpf = new TextField();
	private TextField txtcep = new TextField();
	private TextField txtnum = new TextField();
	private TextField txtsalario = new TextField();
	private TextField txtSenha = new TextField();
	private TextField txtlog = new TextField();
	private TextField txtbrr = new TextField();
	private TextField txtcid = new TextField();
	private TextField txtest = new TextField();
	private Button S = new Button("Salvar"); 
	private Button P = new Button("Pesquisar");
	private Button D = new Button("Desativar");
	
	@Override
	public void start(Stage stage) {
		GridPane grid = new GridPane();
		grid.setStyle("-fx-padding:10px; -fx-background-color:white");
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(8);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(60);
		
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(20);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(20);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(20);
		RowConstraints row4 = new RowConstraints();
		row4.setPercentHeight(20);
		RowConstraints row5 = new RowConstraints();
		row5.setPercentHeight(20);
//		RowConstraints row6 = new RowConstraints();
//		row6.setPercentHeight(16.66);
		
		grid.getRowConstraints().addAll(row1, row2, row4, row5, row3);
		grid.getColumnConstraints().addAll(col1, col2);
		
		Scene scn = new Scene(grid, 800, 300);
		stage.setScene(scn);
		
//		grid.setHgap(0);
//		grid.setVgap(0);
//	    lblNome.setStyle("-fx-text-fill: black; -fx-font-size:125%;");
//		grid.setHalignment(lblNome, HPos.RIGHT);
//		comentario		
		
		grid.add(new Label ("CPF: "), 0, 0);
		txtcpf.setMaxSize(100, 0);
		grid.add(txtcpf, 1, 0);
		grid.add(new Label ("Nome: "), 0, 1);
		txtNome.setMaxSize(400, 1);
		grid.add(txtNome, 1, 1);
		grid.add(new Label ("Cep: "), 2, 1);
		txtcep.setMaxSize(80, 0);
		grid.add(txtcep, 3, 1);
		grid.add(new Label ("Log: "), 0, 2);
		txtlog.setMaxSize(400, 0);
		grid.add(txtlog, 1, 2);
		grid.add(new Label ("Nº: "), 2, 2);
		txtnum.setMaxSize(50, 0);
		grid.add(txtnum, 3, 2);
		grid.add(new Label ("Cidade: "), 0, 3);
		txtcid.setMaxSize(200, 0);
		grid.add(txtcid, 1, 3);
		grid.add(new Label ("Estado: "), 2, 3);
		txtest.setMaxSize(50, 0);
		grid.add(txtest, 3, 3);

		
	
//		grid.add(new Label ("Salario: "), 0, 5);
//		grid.add(txtsalario, 1, 5);

		
		FlowPane botoes = new FlowPane();
//		botoes.getChildren().addAll("");
		
		stage.setTitle("Cadastro de Contatos");
		stage.show();	
	
}
//	public Gerente EntityGerente() {
//		Gerente g1 = new Gerente();
//		g1.setNome(txtNome.getText());
//		g1.setCep(txtcep.getText());
//		g1.setNum(Integer.parseInt(txtnum.getText()));
//		g1.setSalario(Double.parseDouble(txtsalario.getText()));
//		return g1;
//}
	
//	public Funcionario EntityFuncionario() {
//		Gerente f1 = new Gerente();
////		f1.setNome(txtNome.getText());
//		f1.setCep(txtcep.getText());
//		f1.setNum(Integer.parseInt(txtnum.getText()));
//		f1.setSalario(Double.parseDouble(txtsalario.getText()));
//		return f1;
//}
		
	public static void main(String[] args) {
		ClienteBoundary.launch(args);
	}

}
