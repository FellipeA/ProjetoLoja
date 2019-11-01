package boundary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import control.ClienteControl;
import entity.Cliente;
import entity.Endereco;
import entity.Hardware;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ClienteBoundary extends Application implements EventHandler<ActionEvent>{
	private TextField txtNome = new TextField();
	private TextField txtcpf = new TextField();
	private TextField txtcep = new TextField();
	private TextField txtnum = new TextField();
	private TextField txtlog = new TextField();
	private TextField txtbrr = new TextField();
	private TextField txtcid = new TextField();
	private TextField txtest = new TextField();
	private Button S = new Button("Salvar"); 
	private Button P = new Button("Pesquisar");
	private Button D = new Button("Desativar");
	private GridPane grid = new GridPane();
	
	@Override
	public void start(Stage stage) {
		stage.getIcons().add(new Image(PrincipalGerente.class.getResourceAsStream("icon2.png")));
		
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
		
		grid.getRowConstraints().addAll(row1, row2, row4, row5, row3);
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

		
		FlowPane botoes = new FlowPane();
		botoes.getChildren().addAll(S, P, D);
		botoes.setAlignment(Pos.CENTER_LEFT);
		botoes.setHgap(60);
		grid.add(botoes, 1, 4);
		grid.setVgap(10);
		grid.setAlignment(Pos.BOTTOM_LEFT);
		S.addEventHandler(ActionEvent.ANY, this);
		P.addEventHandler(ActionEvent.ANY, this);
		D.addEventHandler(ActionEvent.ANY, this);
		
		stage.setTitle("Cadastro de Clientes");
		stage.show();
}

	public Cliente EntityBoundary () {
		Cliente c = new Cliente();
		Endereco end = new Endereco();
		if (c != null) { 
			try {
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
				c.setEnd(end);
				
				c.setCpf(txtcpf.getText());
				c.setNome(txtNome.getText());
				c.setNum(Integer.parseInt(txtnum.getText()));;
				c.setCep(txtcep.getText());

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return c;
}

public void BoundaryEntity (Cliente C) { 
		if (C != null) { 
			try {
				txtcpf.setText(C.getCpf());
				txtNome.setText(C.getNome());
				txtnum.setText(String.valueOf(C.getNum()));
				txtcep.setText(C.getCep());
				txtbrr.setText(C.getEnd().getBairro());
				txtcid.setText(C.getEnd().getCidade());
				txtlog.setText(C.getEnd().getLog());
				txtest.setText(C.getEnd().getEs());
			} catch (Exception E) {
				E.printStackTrace();
			}
	
		} else {
			AlertBox.display("ERRO", "CLIENTE NAO ENCONTRADO!");
		}
}

public static void main(String[] args) {
		ClienteBoundary.launch(args);
	}
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == S) { 
			ClienteControl.adicionar(EntityBoundary());
			Limpatxt();
		} else if (event.getTarget() == P) {
			String cpf = txtcpf.getText();
			Cliente C = ClienteControl.pesquisarPorCPF(cpf);
			BoundaryEntity(C);
		} else if (event.getTarget() == D) {
			String cpf = txtcpf.getText();
			ClienteControl.remover(cpf);
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
	}

}
