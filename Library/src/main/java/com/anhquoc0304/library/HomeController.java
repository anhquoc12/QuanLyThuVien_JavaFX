/*
 * Click nbfs:/nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs:/nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.anhquoc0304.library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class HomeController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void BookClick(ActionEvent event) throws IOException {
        App.setRoot("Book");
    }

    @FXML
    public void ReaderClick(ActionEvent event) throws IOException {
        App.setRoot("Reader");
    }

    @FXML
    public void RentBookClick(ActionEvent event) throws IOException {
        App.setRoot("RentBook");
    }

    @FXML
    public void Click(ActionEvent event) throws IOException {
        App.setRoot("Book");
    }

    @FXML
    public void StatClick(ActionEvent event) throws IOException {
        App.setRoot("Book");
    }

    @FXML
    public void ExitClick(ActionEvent event) throws IOException {
        Platform.exit();
    }
}
