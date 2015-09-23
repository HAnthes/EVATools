package fxTableView;
import java.util.Observable;

import controller.EvaDB;
import model.Vehicle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class FXTable extends Application {
 
    private TableView<Vehicle> table = new TableView<Vehicle>();
    private final ObservableList<Vehicle> data= FXCollections.observableArrayList(EvaDB.getCars());
    
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(300);
        stage.setHeight(500);
 
        final Label label = new Label("FZG");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(false);
 
       
        TableColumn<Vehicle, String> orderNo = new TableColumn<Vehicle, String>("EVA-ID");
        orderNo.setMinWidth(80);
        orderNo.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("vehicleNo"));
        
        TableColumn<Vehicle, String> text1 = new TableColumn<Vehicle, String>("Marke");
        text1.setMinWidth(50);
        text1.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("text1"));
        
        TableColumn<Vehicle, String> text2 = new TableColumn<Vehicle, String>("Model");
        text2.setMinWidth(50);
        text2.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("text2"));
        
        table.setItems(data);
        
        
        table.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				  ObservableList<TablePosition> pos = table.getSelectionModel().getSelectedCells();
				  for(TablePosition<Vehicle, String> cell : pos){
						System.out.println(cell.getTableColumn().getClass());				  
				  }
			}
        	
        });
        
        
        table.getColumns().addAll(orderNo, text1, text2);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
}