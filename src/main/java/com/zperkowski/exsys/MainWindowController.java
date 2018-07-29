package com.zperkowski.exsys;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainWindowController {
    @FXML
    AnchorPane mainAnchor;

    @FXML
    void initialize() throws IOException {
        mainAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getClassLoader().getResource("exSysTab.fxml")));
    }
}
