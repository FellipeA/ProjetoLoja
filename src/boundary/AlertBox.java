package boundary;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message) {
        Stage stage = new Stage();
        stage.getIcons().add(new Image(AlertBox.class.getResourceAsStream("icon5.jpg")));

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        label.setStyle("-fx-font-size:20px; -fx-text-fill: red");
        Button btnFechar = new Button("Fechar");
        btnFechar.setOnAction(e -> stage.close());

        VBox layout = new VBox(15);
        layout.getChildren().addAll(label,btnFechar);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color:white"); 

        //Display stage and wait for it to be closed before returning
        Scene scene = new Scene(layout, 350, 100);
        stage.setScene(scene);
        stage.showAndWait();
    }


}
