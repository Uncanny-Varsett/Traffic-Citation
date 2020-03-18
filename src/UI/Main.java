package UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.IOException;


public class Main extends Application {

   private Button btnShowCitations = new Button("View All Citations");
   private Button btnShowDrivers = new Button("View All Drivers");
   private Button btnShowVehicles = new Button("View All Vehicles");


   private Button btnCreateNewCitation = new Button("Create New Citation");
   private Button btnCreateNewDriver = new Button("Create New Driver");
   private Button btnCreateNewVehicle = new Button("Create New Vehicle");


    private TextField newCitationDate = new TextField();
    private TextField newCitationFine = new TextField();
    private CheckBox isPaid = new CheckBox("Paid? (Check if yes.)");
    private HBox isPaidHBox = new HBox(isPaid);
    private TextField newCitationOfficerID = new TextField();
    private TextField newCitaionVehicleID = new TextField();



    @Override
    public void start(Stage primaryStage) throws Exception{

        //Create the environment itself.
        GridPane panel = new GridPane();
        panel.setHgap(5);
        panel.setVgap(5);

        //Display all the buttons, and make a lable above those buttons.
        panel.add(new Label("Sault Ste. Marie Traffic Citations"), 2, 0);
        panel.add(btnShowCitations, 0, 1);
        panel.add(btnShowDrivers, 0, 2);
        panel.add(btnShowVehicles, 0 ,3);

        panel.add(btnCreateNewCitation, 3, 1);
        panel.add(btnCreateNewDriver, 3, 2);
        panel.add(btnCreateNewVehicle, 3, 3);

        btnShowCitations.setPrefWidth(150);
        btnShowDrivers.setPrefWidth(150);
        btnShowVehicles.setPrefWidth(150);
        btnCreateNewCitation.setPrefWidth(150);
        btnCreateNewDriver.setPrefWidth(150);
        btnCreateNewVehicle.setPrefWidth(150);



        //Event handlers for when the buttons are pushed:
        //These are event handlers for viewing data from the database.
        btnShowCitations.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane showCitationsPane = new GridPane();
                Stage stage = new Stage();
                stage.setTitle("Traffic Citations");
                stage.setScene(new Scene(showCitationsPane, 450, 300));
                stage.show();
            }
        });


        btnShowVehicles.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane showVehiclesPane = new GridPane();
                Stage stage = new Stage();
                stage.setTitle("All Vehicles");
                stage.setScene(new Scene(showVehiclesPane, 450, 300));
                stage.show();
            }
        });

        btnShowDrivers.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane showDriversPane = new GridPane();
                Stage stage = new Stage();
                stage.setTitle("Show Drivers");
                stage.setScene(new Scene(showDriversPane, 450, 300));
                stage.show();
            }
        });

        //These event handlers are for adding new entities to the DB.
        btnCreateNewCitation.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane showNewCitationsPane = new GridPane();
                Stage stage = new Stage();

                showNewCitationsPane.add(new Label("Create New Citation: "), 0, 0);
                showNewCitationsPane.add(new Label("Date of Offense: "), 0, 2);
                showNewCitationsPane.add(newCitationDate, 1 , 2);
                newCitationDate.setPrefWidth(150);

                showNewCitationsPane.add(new Label("Fine Amount: "), 1, 2);
                showNewCitationsPane.add(newCitationFine, 2, 2);
                newCitationFine.setPrefWidth(150);



                stage.setTitle("Create New Citation");
                stage.setScene(new Scene(showNewCitationsPane, 275, 450));
                stage.show();
            }
        });



        panel.setAlignment(Pos.TOP_CENTER);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Traffic Citations - Sault Ste. Marie");
        primaryStage.setScene(new Scene(panel, 500, 300));
        primaryStage.setResizable(false);

        primaryStage.show();


    }


    public static void main(String[] args) {
        Application.launch();
    }


}