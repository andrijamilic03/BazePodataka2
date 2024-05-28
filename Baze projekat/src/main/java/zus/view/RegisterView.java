package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterView extends Stage {
    private TextField nameTf;
    private TextField prezimeTf;
    private TextField usernameTf;
    private TextField passwordTf;
    private TextField starostTf;
    private TextField provedenoVremeTf;
    private Button prijava;
    private VBox vBox;
    private GridPane gridPane;


    public RegisterView(){
        super.setTitle("Register form");
        nameTf = new TextField();
        prezimeTf = new TextField();
        usernameTf = new TextField();
        passwordTf = new TextField();
        starostTf = new TextField();
        provedenoVremeTf = new TextField();
        prijava = new Button("Potvrdi");
        vBox = new VBox();

        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(40));

        gridPane.add(new Label("Ime:"),0,0);
        gridPane.add(nameTf,1,0);
        gridPane.add(new Label("Prezime:"),0,1);
        gridPane.add(prezimeTf,1,1);
        gridPane.add(new Label("Username:"),0,2);
        gridPane.add(usernameTf,1,2);
        gridPane.add(new Label("Password:"),0,3);
        gridPane.add(passwordTf,1,3);
        gridPane.add(new Label("Starost:"),0,4);
        gridPane.add(starostTf,1,4);
        gridPane.add(new Label("Provedeno vreme:"),0,5);
        gridPane.add(provedenoVremeTf,1,5);

        vBox.getChildren().addAll(gridPane, prijava);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));

        super.setScene(new Scene(this.vBox));

    }


}
