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
    AnchorPane familyAnchorPane;
    @FXML
    AnchorPane exSysAnchorPane;

    @FXML
    void initialize() {

    }

    @FXML
    void tabFireClicked() throws IOException {
        fireAnchorPane.getChildren().setAll((Node) FXMLLoader.load(getClass().getClassLoader().getResource("fireTab.fxml")));
    }

    @FXML
    void tabFamilyClicked() throws IOException {
        familyAnchorPane.getChildren().setAll((Node) FXMLLoader.load(getClass().getClassLoader().getResource("familyTab.fxml")));
    }

    @FXML
    void tabExSysClicked() throws IOException {
        exSysAnchorPane.getChildren().setAll((Node) FXMLLoader.load(getClass().getClassLoader().getResource("exSysTab.fxml")));
    }

}
