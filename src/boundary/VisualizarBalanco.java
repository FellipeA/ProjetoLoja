package boundary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VisualizarBalanco extends Application implements EventHandler<ActionEvent>
{
	private DatePicker txtDataInicio = new DatePicker();
	private DatePicker txtDataFim = new DatePicker();
	private Button btnVoltar = new Button("Voltar");
	private Tooltip dicaVoltar = new Tooltip("Voltar ao Menu Principal");
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void handle(ActionEvent event) 
	{
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void start(Stage stage) throws Exception 
	{
		/* Configurações Gerais */
		stage.setTitle("Visualizar Balanços");
		stage.getIcons().add(new Image(PrincipalGerente.class.getResourceAsStream("icon4.jpg")));
		BorderPane principal = new BorderPane();
		FlowPane botoes = new FlowPane();
		GridPane campos = new GridPane();
		GridPane grafico = new GridPane();
		Scene scn = new Scene(principal, 700, 400);
		principal.setStyle("-fx-padding: 20px");
		principal.setCenter(campos);
		principal.setRight(botoes);
		principal.setBottom(grafico);
		/* Configurações Específicas */
		campos.setHgap(10);
		campos.setVgap(5);
		/* Adicionando Labels e Text */
		campos.add(new Label("Data Inicio: "), 0, 0);
		campos.add(txtDataInicio, 1, 0);
		campos.add(new Label("Data Fim: "), 0, 1);
		campos.add(txtDataFim, 1, 1);
		/* Adicionando Botões */
		botoes.setAlignment(Pos.BASELINE_RIGHT);
		botoes.setHgap(15);
		btnVoltar.setTooltip(dicaVoltar);
		botoes.getChildren().add(btnVoltar);
		/* Voltando a Tela Principal */
		PrincipalGerente pg = new PrincipalGerente();
		btnVoltar.setOnAction(e -> 
		{
			try 
			{
				pg.start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		/* Adicionando Gráficos */
		/* Gráfico Pizza */
	
		
		
		
		txtDataFim.setOnAction(new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) { 
				PieChart graficoPizza = new PieChart();
				graficoPizza.setTitle("Lucros / Prejuízos");
				graficoPizza.setPrefSize(300, 300);
				graficoPizza.getData().addAll(new PieChart.Data("Faturamento", 70), new PieChart.Data("Lucro", 40));
				grafico.add(graficoPizza, 0, 10);
				/* Gráfico de linhas */
				LineChart GraficoLinha = new LineChart<>(new CategoryAxis(), new NumberAxis());
				final String tempo0 = "Tempo 0";
			    final String tempo1 = "Tempo 1";
				final String tempo2 = "Tempo 2";
				final String tempo3 = "Tempo 3";
				XYChart.Series mes0 = new XYChart.Series();
				mes0.setName("Agosto");
				mes0.getData().add(new XYChart.Data(tempo0, 10));
				mes0.getData().add(new XYChart.Data(tempo1, -2));
				mes0.getData().add(new XYChart.Data(tempo2, 5));
				mes0.getData().add(new XYChart.Data(tempo3, 3));

				XYChart.Series mes1 = new XYChart.Series();
				mes1.setName("Setembro");
				mes1.getData().add(new XYChart.Data(tempo0, -5));
				mes1.getData().add(new XYChart.Data(tempo1, -1));
				mes1.getData().add(new XYChart.Data(tempo2, 12));
				mes1.getData().add(new XYChart.Data(tempo3, 8));

				XYChart.Series mes2 = new XYChart.Series();
				mes2.setName("Outubro");
				mes2.getData().add(new XYChart.Data(tempo0, 3));
				mes2.getData().add(new XYChart.Data(tempo1, 6));
				mes2.getData().add(new XYChart.Data(tempo2, 2));
				mes2.getData().add(new XYChart.Data(tempo3, 10));
				GraficoLinha.getData().addAll(mes0, mes1, mes2);
				GraficoLinha.setPrefSize(300, 300);
				grafico.add(GraficoLinha, 2, 10);
			}
		});
		
		/* Mostrando Tela */
		stage.setScene(scn);
		stage.show();
		
	}

}
