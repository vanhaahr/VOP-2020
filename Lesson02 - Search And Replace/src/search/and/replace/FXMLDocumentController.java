 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.and.replace;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
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
    private JFileChooser fileChooser;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//Sets Filechoser directory to project folder
        fileChooser = new JFileChooser(".");
//Makes Txt filter available in filechooser
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
//Sets search field label
        label1.setText("Søg");
//Sets Replace field label
        label2.setText("Erstat");
//Set TextArea to standard Text file
        try {
            setTextArea();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void handleFileButtonAction(ActionEvent event) throws FileNotFoundException {
        chooseFile();
    }
    @FXML
    private void handleSaveButtonAction(ActionEvent event) throws IOException {
        saveAsFile();
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
//Method to display HelloWorld text file in text area
    public void setTextArea() throws FileNotFoundException {
        File file = new File("src/HelloWorld.txt");
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                area.appendText(input.nextLine() + "\n");
            }
            input.close();
        } catch (FileNotFoundException e) {
            area.setText("HelloWorld.txt not found! \n\nPlease select another file by clicking \"vælg fil\", or try out with this text.\n\nKenneth Haahr.");
        }
    }

//Method to chose file and replace text in text area with text in file
    public void chooseFile() throws FileNotFoundException {
        int returnVal = fileChooser.showOpenDialog(fileChooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f1 = new File(fileChooser.getSelectedFile().getPath());
            area.clear();
            Scanner in = new Scanner(f1);
            while (in.hasNext()) {
                area.appendText(in.nextLine() + "\n");
            }
            in.close();
        } else if (returnVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("No file was chosen");
            return;
        }
    }
//Method to Save file with current content of text area
    public void saveAsFile() throws IOException {
        int returnVal = fileChooser.showSaveDialog(fileChooser);
        File fileName = new File(fileChooser.getSelectedFile() + ".txt");
        try {
            if (fileName == null) {
                return;
            }
            BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
            outFile.write(area.getText());
            outFile.close();
        } catch (IOException ex) {
        }
    }

}
