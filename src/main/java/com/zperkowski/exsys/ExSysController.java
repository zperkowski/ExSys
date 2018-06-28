package com.zperkowski.exsys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class ExSysController implements Observer {

    HashMap<String, String> questions = new HashMap<>();

    private KieSession session;
    private Collection<FactHandle> factsHandles;
    private QA qa;

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

        qa = new QA();
        qa.addObserver(this);
        session.insert(qa);
        session.fireAllRules();
    }

    @FXML
    public void ex_button_next_clicked() {
        if (ex_combo_answer.getItems().size() > 0) {

            String answer = ex_combo_answer.getSelectionModel().getSelectedItem().toString();
            qa.setAnswerd(answer);
            System.out.println("GUI:\t\t\t" + qa.getAnswerd());
            qa = new QA(qa, answer);
            session.insert(qa);
            session.fireAllRules();
        }
    }

    private void initQuestion() {
        ex_label_question.setText(qa.getQuestion());
        ObservableList<String> answers = FXCollections.observableArrayList(qa.getAnswers());
        ex_combo_answer.setItems(answers);
        ex_combo_answer.getSelectionModel().select(0);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observer\t\t\t\t" + o.toString() + " was triggered - GUI updated");
        if (arg instanceof String)
            dialog((String) arg);
        qa = (QA) o;
        initQuestion();
    }

    private void dialog(String info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("An instrument for you");
        alert.setHeaderText(null);
        alert.setContentText(info);

        alert.showAndWait();
    }
}
