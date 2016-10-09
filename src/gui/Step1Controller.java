package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.DataSource;
import sources.FileInFileSystem;
import sources.Source;

import java.net.URL;
import java.util.ResourceBundle;

public class Step1Controller implements Initializable{

    private static Stage prevStage;
    private static Stage primaryStage;

    @FXML
    private AnchorPane step1_pane;

    @FXML
    private TextField name;

    @FXML
    private ChoiceBox ds_type;

    @FXML
    private Button previous_button;

    @FXML
    private Button next_button;

    @FXML
    private Button exit_button;

    public void setPrevStage(Stage stage){
        this.prevStage = stage;
    }

    //TODO: step1 over previous pane
    public Step1Controller(){}


    public void onNextButton(ActionEvent event) throws Exception{
        String sv = (String)ds_type.getValue();

        primaryStage = new Stage();
        primaryStage.setTitle("Step 2");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("step2.fxml"));
        Pane pane = (Pane) loader.load();
        Step2Controller sc = (Step2Controller) loader.getController();
        sc.setPrevStage(primaryStage);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        Stage st = (Stage)step1_pane.getScene().getWindow();
        st.close();

        sc.setSv(sv);
        sc.setName(name.getText());
        sc.nameOfSource.setText(name.getText());
        primaryStage.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){}

}
