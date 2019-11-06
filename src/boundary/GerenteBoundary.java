package boundary;

import javax.swing.JOptionPane;

import control.FuncionarioControl;
import entity.Funcionario;
import entity.Gerente;
import entity.Endereco;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class GerenteBoundary extends Application implements EventHandler<ActionEvent>{
	private TextField txtNome = new TextField();
	private TextField txtcpf = new TextField();
	private TextField txtcep = new TextField();
	private TextField txtnum = new TextField();
	private TextField txtlog = new TextField();
	private TextField txtbrr = new TextField();
	private TextField txtcid = new TextField();
	private TextField txtest = new TextField();
	private TextField txtSalario = new TextField();
	private TextField txtSenha = new TextField();
	private Button S = new Button("Salvar"); 
	private Button P = new Button("Pesquisar");
	private Button D = new Button("Desativar");
	
	@Override
	public void start(Stage stage) {
		stage.getIcons().add(new Image(PrincipalGerente.class.getResourceAsStream("icon2.png")));
		GridPane grid = new GridPane();
		grid.setStyle("-fx-padding:10px; -fx-background-color:white");
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(8);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(60);
		
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(16.66);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(16.66);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(16.66);
		RowConstraints row4 = new RowConstraints();
		row4.setPercentHeight(16.66);
		RowConstraints row5 = new RowConstraints();
		row5.setPercentHeight(16.66);
		RowConstraints row6 = new RowConstraints();
		row5.setPercentHeight(16.66);

		
		grid.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6);
		grid.getColumnConstraints().addAll(col1, col2);
		
		Scene scn = new Scene(grid, 800, 300);
		stage.setScene(scn);
		

		grid.add(new Label ("CPF: "), 0, 0);
		txtcpf.setMaxSize(100, 0);
		grid.add(txtcpf, 1, 0);
		grid.add(new Label ("Nome: "), 0, 1);
		txtNome.setMaxSize(400, 1);
		grid.add(txtNome, 1, 1);
		grid.add(new Label ("	      Cep: "), 2, 1);
		txtcep.setMaxSize(80, 0);
		grid.add(txtcep, 3, 1);
		grid.add(new Label ("Log: "), 0, 2);
		txtlog.setMaxSize(400, 0);
		txtlog.setEditable(false);
		grid.add(txtlog, 1, 2);
		grid.add(new Label ("		Nº: "), 2, 2);
		txtnum.setMaxSize(50, 0);
		grid.add(txtnum, 3, 2);
		grid.add(new Label ("									Cidade: "), 1, 2, 3, 3 );
		GridPane.setHalignment(txtcid, HPos.RIGHT);
		txtcid.setMaxSize(180, 0);
		txtcid.setEditable(false);
		grid.add(txtcid, 1, 3);
		grid.add(new Label ("          Estado: "), 2, 3);
		GridPane.setHalignment(txtest, HPos.LEFT);
		txtest.setEditable(false);
		txtest.setMaxSize(50, 0);
		grid.add(txtest, 3, 3);
		grid.add(new Label ("Bairro: "), 0, 3);
		GridPane.setHalignment(txtbrr, HPos.LEFT);
		txtbrr.setEditable(false);
		txtbrr.setMaxSize(200, 0);
		grid.add(txtbrr, 1, 3);
		grid.add(new Label ("Salario: "), 0, 4);
		txtSalario.setMaxSize(100, 1);
		grid.add(txtSalario, 1, 4);
		grid.add(new Label ("									 Senha: "), 1, 4);
		txtSenha.setMaxWidth(180);
		txtSenha.setAlignment(Pos.BASELINE_LEFT);
		GridPane.setHalignment(txtSenha, HPos.RIGHT);
		grid.add(txtSenha, 1, 4);

		
		FlowPane botoes = new FlowPane();
		botoes.getChildren().addAll(S, P, D);
		botoes.setAlignment(Pos.CENTER_LEFT);
		botoes.setHgap(60);
		grid.add(botoes, 1, 6);
		grid.setVgap(10);
		grid.setAlignment(Pos.BOTTOM_LEFT);
		S.addEventHandler(ActionEvent.ANY, this);
		P.addEventHandler(ActionEvent.ANY, this);
		D.addEventHandler(ActionEvent.ANY, this);
		
		stage.setTitle("Cadastro de Gerente");
		stage.show();
}

	public Funcionario EntityBoundary () {
		Gerente G = new Gerente();
		if (G != null) { 
			try {
				G.setCpf(txtcpf.getText());
				G.setNome(txtNome.getText());
				G.setNum(Integer.parseInt(txtnum.getText()));;
				G.setCep(txtcep.getText());
				G.setSalario(Double.parseDouble(txtSalario.getText()));
				G.setSenha(txtSenha.getText());

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return G;
}

public void BoundaryEntity (Gerente G, Endereco e) { 
		if (G != null) { 
			try {
				txtcpf.setText(G.getCpf());
				txtNome.setText(G.getNome());
				txtnum.setText(String.valueOf(G.getNum()));
				txtcep.setText(G.getCep());
				txtSalario.setText(String.valueOf(G.getSalario()));
				txtSenha.setText(String.valueOf(G.getSenha()));
			if(G.getCep().equals(e.getCep())) {
				txtbrr.setText(e.getBairro());
				txtcid.setText(e.getCidade().toString());
				txtlog.setText(e.getLog());
				txtest.setText(e.getEs().toString());
			}

			} catch (Exception E) {
				E.printStackTrace();
			}
	
		} else {
			JOptionPane.showMessageDialog(null, "CADASTRO NAO ENCONTRADO!");
		}
}

public static void main(String[] args) {
		ClienteBoundary.launch(args);
	}
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == S) { 
			FuncionarioControl.adicionar(EntityBoundary());
			Limpatxt();
		} else if (event.getTarget() == P) {
			String cpf = txtcpf.getText();
			Gerente G = (Gerente) FuncionarioControl.pesquisarPorCPF(cpf);
			BoundaryEntity(G, new Endereco());
		} else if (event.getTarget() == D) {
			String cpf = txtcpf.getText();
			FuncionarioControl.remover(cpf);
			Limpatxt();
		} else {
			Limpatxt();
		}
	}
	
	public void Limpatxt() {
		txtNome.clear();
		txtcpf.clear();
		txtcep.clear();
		txtlog.clear();
		txtnum.clear();
		txtcid.clear();
		txtest.clear();
		txtbrr.clear();
		txtSenha.clear();
		txtSalario.clear();
	}

}
