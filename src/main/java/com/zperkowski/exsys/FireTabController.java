package com.zperkowski.exsys;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class FireTabController {

    @FXML
    CheckBox checkBoxSmoke;

    @FXML
    void checkBoxSmokeClicked() {
        System.out.println("checkBoxSmokeClicked: " + checkBoxSmoke.isSelected());
    }
}
