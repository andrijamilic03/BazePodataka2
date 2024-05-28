package zus.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zus.model.StambeniObjekat;
import zus.model.base.Server;
import zus.model.Planeta;
import zus.model.utility.JDBCUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MainView extends Stage {
    private Button button1;
    private Button button2;
    private HBox hBox;
    private HBox hBox2;
    private VBox vBox;
    private ComboBox<Planeta> comboBox;
    private ComboBox<StambeniObjekat> comboBox2;

    private final DatePicker date = new DatePicker(LocalDate.now());

    public MainView(){
        this.setTitle("ZUS");
        button1 = new Button("Log in");
        button1.setOnAction(e->{
            LogInView l1 = new LogInView();
            l1.show();
        });
        button2 = new Button("Register");
        button2.setOnAction(e->{
            RegisterView l1 = new RegisterView();
            l1.show();
        });

        comboBox = new ComboBox();
        comboBox.setItems(FXCollections.observableList(Server.SERVER.getPlanete()));

        comboBox2 = new ComboBox<>();
        comboBox2.setItems(FXCollections.observableList(Server.SERVER.getStambeniObjekati()));

        hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(40));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(button1, button2);

        hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(comboBox, comboBox2, date);
        hBox2.setAlignment(Pos.CENTER);

        vBox = new VBox();
        vBox.getChildren().addAll(hBox, hBox2);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(40));
        vBox.setAlignment(Pos.CENTER);


        super.setScene(new Scene(this.vBox, 550,350));

    }
}
