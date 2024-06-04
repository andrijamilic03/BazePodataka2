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
import zus.model.Prostori;
import zus.model.StambeniObjekat;
import zus.model.base.Server;
import zus.model.Planeta;
import zus.model.utility.JDBCUtils;
import zus.view.table.PlaneteTable;
import zus.view.table.PrevozTable;
import zus.view.table.ProstoriTable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MainView extends Stage {
    private VBox vBox;
    private Button b1;
    private Button b2;
    private Button b3;
    private TableView<Prevoz> prevozi = new PrevozTable(Server.SERVER.getPrevozi());
    private TableView<Prostori> prostori = new ProstoriTable(Server.SERVER.getProstori());

    public static int idOSOBE;

    public MainView(String username){
        this.setTitle("ZUS");
        b1 = new Button("Kupi kartu");
        b2 = new Button("Kupi objekat");
        b3 = new Button("Istorija");



        int id = JDBCUtils.proveraOsobeId(username);
        b1.setOnAction(actionEvent -> {
            if(prevozi.getSelectionModel().getSelectedItem() != null) {
                Prevoz prevoz = prevozi.getSelectionModel().getSelectedItem();
                int prevozID = prevoz.getPrevoz_id();
                JDBCUtils.insertIntoPrevozOsoba(id, prevozID);
            }
        });

        b2.setOnAction(actionEvent -> {
            if(prostori.getSelectionModel().getSelectedItem() != null) {
                Prostori prostor = prostori.getSelectionModel().getSelectedItem();
                int prostorId = prostor.getProstor_id();
                JDBCUtils.changeProstora(id, prostorId);
                List<Prostori> pro = JDBCUtils.selectAllFromProstori();
                Server.SERVER.setProstori(pro);
                prostori.setItems(FXCollections.observableList(pro));
            }
        });

        b3.setOnAction(actionEvent -> {
            idOSOBE = JDBCUtils.proveraOsobeId(username);
            HistoryView hw = new HistoryView(username);
            hw.show();
        });

        vBox = new VBox();
        vBox.getChildren().addAll(prevozi, b1, prostori, b2, b3);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(40));
        vBox.setAlignment(Pos.CENTER);

        super.setScene(new Scene(this.vBox, 700,500));
    }
}
