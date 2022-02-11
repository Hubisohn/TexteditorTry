module com.example.texteditortry {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.texteditortry to javafx.fxml;
    exports com.example.texteditortry;
}