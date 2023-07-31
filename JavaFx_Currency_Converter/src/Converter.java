import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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

        Scene scene = new Scene(grid, 300, 275);
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

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 5);
        
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
