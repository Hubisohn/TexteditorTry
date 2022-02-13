package com.example.texteditortry;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextArea textArea;

    File selectedFile;

    @FXML
    private Label hboxLabel;

    Stage stage = new Stage();

    /*
    This function will open a file and display it in the Textarea
     */
    @FXML
    public void openFile(){


        chooseFile();

        hboxLabel.setText("Geöffnete Datei: " + selectedFile.getName());

        Reader fileReader = null;

        try {
            fileReader = new FileReader(selectedFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String databuffer = "";
        int data = 0;

        try {
            while(data != -1) {
                data = fileReader.read();
                databuffer += (char)data;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        textArea.setText(databuffer.substring(0, databuffer.length()-1));

        }

        /*
        This function is needed to open the Explorer and choose a file path
         */

    protected File chooseFile() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        selectedFile = fileChooser.showOpenDialog(stage);

        return selectedFile;
    }

    /*
    In this function the File can get saved
     */
        @FXML
        public void saveFile(){

            String databuffer = "";
            databuffer = textArea.getText();

            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(String.valueOf(selectedFile)));
                writer.write(databuffer);
                writer.close();
                System.out.println("Datei wurde gespeichert!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*
        With this Menu you can create a File. USES createFile.fxml
         */
        public static Stage stageCreate;
        @FXML
        public void createFile(){

            Scene createScene = null;
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("createFile.fxml"));
            try {
                createScene = new Scene(fxmlLoader2.load());
            } catch (IOException e) {
                e.printStackTrace();
            }

            stageCreate = new Stage();
            stageCreate.setScene(createScene);
            stageCreate.show();
        }

        public void sceneCloser(){
            stageCreate.close();
        }
}