package fxTableView;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Vehicle;
import controller.EvaDB;
 
public class FXTable extends Application {
 
   
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void init(){
    /*
     * ini vor dem stageing nich nicht verwendet.
     * 	
     */
    }
    
    
    @SuppressWarnings("unchecked") //untypisierst Liste?? Warum
    /*
     * Alle in einer Methode - grobes konzept.
     * (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
	public void start(Stage stage) {
    	
    	TableView<Vehicle> table = new TableView<Vehicle>();
    	final ObservableList<Vehicle> data= FXCollections.observableArrayList(EvaDB.getCars());
        
    	/*
    	 * Tableview aufbauen 
    	 */
        table.setEditable(false);
 
       
        TableColumn<Vehicle, String> orderNo = new TableColumn<Vehicle, String>("VIN");
        orderNo.setMinWidth(80);
        orderNo.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("chassisno"));
        
        TableColumn<Vehicle, String> gwNo = new TableColumn<Vehicle, String>("GW-ID");
        gwNo.setMinWidth(80);
        gwNo.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("orderNo"));
        
        TableColumn<Vehicle, String> text1 = new TableColumn<Vehicle, String>("Marke");
        text1.setMinWidth(80);
        text1.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("text1"));
        
        TableColumn<Vehicle, String> text2 = new TableColumn<Vehicle, String>("Model");
        text2.setMinWidth(80);
        text2.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("text2"));
        
        
        FilteredList<Vehicle> fData = new FilteredList<Vehicle>(data, p-> true);
        
        /*
         * Textfeld f�r das Anzeigen der FZG Ausstattung
         */
        TextArea fzview = new TextArea();
            
        
        table.setItems(data);
         
        table.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				fzview.clear();
				fzview.appendText(table.getSelectionModel().getSelectedItem().toString());
			}
        	
        });
         
        table.getColumns().addAll(orderNo,gwNo, text1, text2);
        
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(40);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(50);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(20);
        
        BorderPane pb = new BorderPane();
        pb.setPrefWidth(1000);
        HBox sb = new HBox();
        sb.setPadding(new Insets(10, 0,0, 10));
        sb.getChildren().addAll(slider);
        pb.setBottom(sb);
   
        
      TextField filterField = new TextField();
        
      filterField.textProperty().addListener((observable, oldValue, newValue) -> {
    	  fData.setPredicate(vehicle -> {
    		  if (newValue == null || newValue.isEmpty()) {
                  return true;
              }
    		  String lowerCaseFilter = newValue.toLowerCase();
    		  
    		   if (vehicle.getOrderNo().toLowerCase().contains(lowerCaseFilter)) {
                   return true; // Filter matches first name.
               } else if (vehicle.getChassisno().toLowerCase().contains(lowerCaseFilter)) {
                   return true; // Filter matches last name.
               }
               return false; // Does not match.
           });
       });
      
      SortedList<Vehicle> sData = new SortedList<>(fData);
      sData.comparatorProperty().bind(table.comparatorProperty());
      table.setItems(sData);
      
      Scene scene = new Scene(new Group());
      stage.setTitle("EVA-View");
      
     
      
        HBox fb = new HBox();
        fb.setPadding(new Insets(10, 0,0, 10));
        fb.getChildren().addAll(filterField);
        pb.setTop(fb);
   
        table.setPrefWidth(440);
        HBox hb = new HBox();
        hb.setPadding(new Insets(10, 0,0, 10));
        hb.getChildren().addAll(table);
        pb.setLeft(hb);
        HBox vb = new HBox();
        vb.setPadding(new Insets(10, 0,0, 10));
        vb.getChildren().addAll(fzview);
        pb.setCenter(vb);
        ((Group) scene.getRoot()).getChildren().addAll(pb);
 
        stage.setScene(scene);
        stage.show();
    }
}