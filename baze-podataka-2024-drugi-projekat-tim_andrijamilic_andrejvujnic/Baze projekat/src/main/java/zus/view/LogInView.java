package zus.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zus.model.Osoba;
import zus.model.base.Server;

import java.util.ArrayList;
import java.util.List;

import static zus.model.utility.JDBCUtils.provera;

public class LogInView extends Stage {
    private TextField usernameTf;
    private TextField passwordTf;
    private Button prijava;
    private Button registracija;
    private VBox vBox;
    private GridPane gridPane;

    public LogInView(){
        super.setTitle("Log in form");
        usernameTf = new TextField();
        passwordTf = new TextField();
        prijava = new Button("Potvrdi");
        registracija = new Button("Registracija");
        vBox = new VBox();

        registracija.setOnAction(actionEvent -> {
            RegisterView rw = new RegisterView();
            rw.show();
            close();
        });

        prijava.setOnAction(actionEvent -> {
            String name1 = usernameTf.getText();
            String sifra1 = passwordTf.getText();
            if(provera(name1, sifra1)){
                MainView mw = new MainView(name1);
                mw.show();
                close();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Username ili password nisu ispravno uneti");
                alert.show();
            }
        });

        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(40));

        gridPane.add(new Label("Username:"),0,0);
        gridPane.add(usernameTf,1,0);
        gridPane.add(new Label("Password:"),0,1);
        gridPane.add(passwordTf,1,1);

        vBox.getChildren().addAll(gridPane, prijava, new Label("Nemate nalog?"), registracija);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(10);
        super.setScene(new Scene(this.vBox));
    }
}
