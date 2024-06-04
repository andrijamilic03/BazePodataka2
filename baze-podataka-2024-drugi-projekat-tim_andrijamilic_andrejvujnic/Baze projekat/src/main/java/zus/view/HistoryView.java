package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zus.model.Prevoz;
import zus.model.Prostori;
import zus.model.base.Server;
import zus.model.utility.JDBCUtils;
import zus.view.table.PrevozTable;
import zus.view.table.ProstoriTable;

public class HistoryView extends Stage {
    //private TableView<Prevoz> prevozi = new PrevozTable(Server.SERVER.getPrevoziHistory(username));
    private TableView<Prostori> prostori = new ProstoriTable(Server.SERVER.getProstori());

    public static int idOsobe = 0;
    public HistoryView(String username) {
        idOsobe = JDBCUtils.proveraOsobeId(username);
        TableView<Prevoz> prevozi = new PrevozTable(Server.SERVER.getPrevoziHistory());
        TableView<Prostori> prostori = new ProstoriTable(Server.SERVER.getProstoriHistory());

        VBox vBox = new VBox();
        vBox.getChildren().addAll(prevozi, prostori);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(40));
        vBox.setAlignment(Pos.CENTER);
        super.setScene(new Scene(vBox, 700,500));
    }
}
