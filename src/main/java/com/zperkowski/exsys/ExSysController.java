package com.zperkowski.exsys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Arrays;
import java.util.HashMap;

public class ExSysController {

    HashMap<String, String> questions = new HashMap<>();

    private KieSession session;
    private QA currentQA;

    @FXML
    Label ex_label_question;
    @FXML
    ComboBox ex_combo_answer;

    @FXML
    void initialize() {
        KieServices ks = KieServices.Factory.get();
        BasicConfigurator.configure();
        Logger.getLogger(ExSysController.class).setLevel(Level.OFF);
        KieContainer kContainer = ks.getKieClasspathContainer();
        session = kContainer.newKieSession("exsys-rules");

        QA qa = new QA(QA.q_hoay, Arrays.asList(QA.a_05, QA.a_612, QA.a_13));
        initQuestion(qa);
    }

    @FXML
    public void ex_button_next_clicked() {
        String answer = ex_combo_answer.getSelectionModel().getSelectedItem().toString();
        System.out.println(currentQA.getAnswerd().equals(answer));
        currentQA.setAnswerd(answer);
        System.out.println(currentQA.getAnswerd());
    }

    private void initQuestion(QA qa) {
        ex_label_question.setText(qa.getQuestion());
        ObservableList<String> answers = FXCollections.observableArrayList(qa.getAnswers());
        ex_combo_answer.setItems(answers);
        ex_combo_answer.getSelectionModel().select(0);
        currentQA = qa;
    }
}
