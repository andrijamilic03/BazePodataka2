package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogInView extends Stage {
    private TextField usernameTf;
    private TextField passwordTf;
    private Button prijava;
    private VBox vBox;
    private GridPane gridPane;

    public LogInView(){
        super.setTitle("Log in form");
        usernameTf = new TextField();
        passwordTf = new TextField();
        prijava = new Button("Potvrdi");
        vBox = new VBox();

        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(40));

        gridPane.add(new Label("Username:"),0,0);
        gridPane.add(usernameTf,1,0);
        gridPane.add(new Label("Password:"),0,1);
        gridPane.add(passwordTf,1,1);

        vBox.getChildren().addAll(gridPane, prijava);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));
        super.setScene(new Scene(this.vBox));
    }
}
