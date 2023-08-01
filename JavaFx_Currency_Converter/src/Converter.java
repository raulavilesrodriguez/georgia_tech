import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Text;

public class Converter extends Application{
    
    @Override
    public void start(Stage stage){
        stage.setTitle("Dollars to Pounds");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 400, 350);
        stage.setScene(scene);

        Text scenetitle = new Text("Currency Converter");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        Label inputLabel = new Label("Input value: $");
        grid.add(inputLabel, 0, 1); // column 0, row 1
        TextField inputField = new TextField();
        grid.add(inputField, 1, 1);

        Button btn = new Button("Exchange");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4); // column 1, row 4

        final Text result = new Text();
        grid.add(result, 1, 5);

        btn.setOnAction(event -> {
            String valueUsdString = inputField.getCharacters().toString();
            try {
                double valueUsd = Double.parseDouble(valueUsdString);
                double conversionResult = convert(valueUsd);
                result.setText(String.format("%.2f", conversionResult));

            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Invalid Dollar Amount");
                a.setContentText("Please only use digits");
                a.showAndWait();
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private double convert(double value){
        return value * 0.78;
    }

}
