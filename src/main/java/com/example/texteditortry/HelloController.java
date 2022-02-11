package com.example.texteditortry;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    @FXML
    public void openFile(){

        Stage stage = new Stage();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        File selectedFile = fileChooser.showOpenDialog(stage);

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
}