package boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import control.FuncionarioControl;
import entity.Funcionario;
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

public class FuncionarioBoundary extends Application implements EventHandler<ActionEvent>{
	private TextField txtNome = new TextField();
	private TextField txtcpf = new TextField();
	private TextField txtcep = new TextField();
	private TextField txtnum = new TextField();
	private TextField txtlog = new TextField();
	private TextField txtbrr = new TextField();
	private TextField txtcid = new TextField();
	private TextField txtest = new TextField();
	private TextField txtSalario = new TextField();
	private Button S = new Button("Salvar"); 
	private Button P = new Button("Pesquisar");
	private Button D = new Button("Desativar");
	private Button End = new Button("Gerar Endereço");
	
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
		grid.add(End, 4, 1);
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

		
		FlowPane botoes = new FlowPane();
		botoes.getChildren().addAll(S, P, D);
		botoes.setAlignment(Pos.CENTER_LEFT);
		botoes.setHgap(60);
		grid.add(botoes, 1, 5);
		grid.setVgap(10);
		grid.setAlignment(Pos.BOTTOM_LEFT);
		S.addEventHandler(ActionEvent.ANY, this);
		P.addEventHandler(ActionEvent.ANY, this);
		D.addEventHandler(ActionEvent.ANY, this);
		End.addEventHandler(ActionEvent.ANY, this);
		
		stage.setTitle("Cadastro de Funcionario");
		stage.show();
}

	public Funcionario EntityBoundary () {
		Funcionario F = new Funcionario();
		if (F != null) { 
			try {
				F.setCpf(txtcpf.getText());
				F.setNome(txtNome.getText());
				F.setNum(Integer.parseInt(txtnum.getText()));;
				F.setCep(txtcep.getText());
				F.setSalario(Double.parseDouble(txtSalario.getText()));
				F.setEnd(gerarEnd());

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return F;
}

public void BoundaryEntity (Funcionario F) { 
		if (F != null) { 
			try {
				txtcpf.setText(F.getCpf());
				txtNome.setText(F.getNome());
				txtnum.setText(String.valueOf(F.getNum()));
				txtcep.setText(F.getCep());
				txtSalario.setText(String.valueOf(F.getSalario()));
				txtbrr.setText(F.getEnd().getBairro());
				txtcid.setText(F.getEnd().getCidade());
				txtlog.setText(F.getEnd().getLog());
				txtest.setText(F.getEnd().getEs());

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
			Funcionario F = FuncionarioControl.pesquisarPorCPF(txtcpf.getText());
			BoundaryEntity(F);
		} else if (event.getTarget() == D) {
			String cpf = txtcpf.getText();
			FuncionarioControl.remover(cpf);
			Limpatxt();
		} else {
			mostraEnd(gerarEnd());
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
		txtSalario.clear();
	}

	private void mostraEnd(Endereco end) {
		txtcep.setText(end.getCep());
		txtcid.setText(end.getCidade());
		txtest.setText(end.getEs());
		txtbrr.setText(end.getBairro());
		txtlog.setText(end.getLog());
	}
	
	public Endereco gerarEnd() {
		try {
			Endereco end = new Endereco();
			URL api = new URL("https://api.postmon.com.br/v1/cep/"+txtcep.getText());
			BufferedReader br = new BufferedReader(new InputStreamReader(api.openStream()));
			String retorno = br.readLine();
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(retorno);
			end.setBairro(json.get("bairro").toString());
			end.setCep(txtcep.getText());
			end.setLog(json.get("logradouro").toString());
			end.setCidade(json.get("cidade").toString());
			end.setEs(json.get("estado").toString());
			return end;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;	
		}
}
