package zus.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zus.model.Prevoz;
import zus.model.StambeniObjekat;
import zus.model.base.Server;
import zus.model.Planeta;
import zus.model.utility.JDBCUtils;
import zus.view.table.PlaneteTable;
import zus.view.table.PrevozTable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MainView extends Stage {
    private HBox hBox1;
    private HBox hBox2;
    private VBox vBox;
    private ComboBox<Planeta> comboBox;
    private ComboBox<StambeniObjekat> comboBox2;
    private TableView<Prevoz> prevozi = new PrevozTable(Server.SERVER.getPrevozi());
    private TableView<Planeta> planete = new PlaneteTable(Server.SERVER.getPlanete());

    private final DatePicker date = new DatePicker(LocalDate.now());

    public MainView(String username){
        this.setTitle("ZUS");

        comboBox = new ComboBox<>();
        comboBox.setItems(FXCollections.observableList(Server.SERVER.getPlanete()));

        comboBox2 = new ComboBox<>();
        comboBox2.setItems(FXCollections.observableList(Server.SERVER.getStambeniObjekati()));

        hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(comboBox, comboBox2, date);
        hBox2.setAlignment(Pos.CENTER);

        vBox = new VBox();
        vBox.getChildren().addAll(hBox2, prevozi, planete);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(40));
        vBox.setAlignment(Pos.CENTER);


        super.setScene(new Scene(this.vBox, 550,350));

    }
}
