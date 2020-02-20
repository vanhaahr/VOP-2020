/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.and.replace;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import searchandreplaceclean.FileHandler;

/**
 * FXML Controller class
 *
 * @author Kenneth Haahr
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextArea area;
    @FXML
    private Button replaceButton;
    @FXML
    private Label label2;
    @FXML
    private Label label1;
    @FXML
    private Button fileButton;
    @FXML
    private Button saveFile;

    private FileChooser fileChooser;
    private FileHandler fileHandler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//Sets search field label
        label1.setText("Søg");
//Sets Replace field label
        label2.setText("Erstat");
//Sets Filechoser directory to project folder
        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
//Makes Txt filter available in filechooser
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
//Sets Standard text in text area if no file loaded
        area.setText("No file has been Choosen. \nPlease select file by clicking \"Vælg Fil\" \nEnter the word you want to search for in the searchfield \nEnter the word to replace the word searched for \nin the replacefield \nclick \"erstat alle\" to replace all occurences\n\nThank you \nKenneth Haahr");
    }

    @FXML
    private void handleReplaceButtonAction(ActionEvent event) {
        String searchString = field1.getText();
        String replaceString = field2.getText();
        String textToSearch = area.getText();
        if (textToSearch.contains(searchString)) {
            area.setText(textToSearch.replaceAll(searchString, replaceString));
        }
    }

    @FXML
    private void handleFileButtonAction(ActionEvent event) {
        File inFile = fileChooser.showSaveDialog(null);
        if (inFile == null) {
            return;
        }
        area.clear();
        String txt = fileHandler.readFile(inFile);
        area.setText(txt);
    }

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        File outFile = fileChooser.showSaveDialog(null);
        if(outFile!=null){
            fileHandler.writeFile(area.getText(), outFile);
        }
        else{
            return;
        }
    }

}
