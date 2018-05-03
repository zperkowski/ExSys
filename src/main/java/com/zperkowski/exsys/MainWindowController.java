package com.zperkowski.exsys;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainWindowController {
    @FXML
    AnchorPane fireAnchorPane;
    @FXML
    AnchorPane exSysAnchorPane;

    @FXML
    void initialize() {

    }

    @FXML
    void tabFireClicked() {
        try {
            fireAnchorPane.getChildren().setAll((Node) FXMLLoader.load(getClass().getClassLoader().getResource("fireTab.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void tabExSysClicked() {

    }

}
