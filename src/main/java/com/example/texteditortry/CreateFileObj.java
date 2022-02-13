package com.example.texteditortry;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CreateFileObj {

    Stage stage = new Stage();

    @FXML
    TextField pathField;

    @FXML
    TextField nameField;

    @FXML
    Button Create;

    String path = "";
    String filePath = "";


    public void choosePath(){
        DirectoryChooser dc = new DirectoryChooser();
        File f = dc.showDialog(stage);
        path = f.getAbsolutePath();
        path = path + (char) 92;
        pathField.setText(path);
    }

    HelloController helloController = new HelloController();
    public void createFile() throws IOException {
        if(path.length() == 0){
            System.out.println("You need to choose a path!");
            return;
        }else if(nameField.getText().length() == 0){
            System.out.println("You need a File name!");
            return;
        }

        filePath = path + nameField.getText();
        File file = new File(filePath);

        try {
            if(!file.isFile()) {
                file.createNewFile();
            }else{
                errorFileCreate();
            }
        } catch (IOException e) {
            System.out.println("Interner Fehler");
        }
        helloController.sceneCloser();

    }

    Stage err = new Stage();
    private void errorFileCreate() throws IOException {
        FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplication.class.getResource("errorWindow.fxml"));
        Scene closeScene = new Scene(fxmlLoader3.load());
        err.setScene(closeScene);
        err.show();
    }

    @FXML
    private void closeWindow(){
        System.out.println("UFF");
        err.close();
    }

}
