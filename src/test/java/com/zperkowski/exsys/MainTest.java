package com.zperkowski.exsys;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class MainTest extends Application {

    public static void main(String[] args) throws DroolsParserException, IOException {
        MainTest helloWorldTest = new MainTest();
        helloWorldTest.executeHelloWorldRules();
        launch(args);
    }

    void executeHelloWorldRules() throws IOException, DroolsParserException {
        KieServices ks = KieServices.Factory.get();
        BasicConfigurator.configure();
        Logger.getLogger(MainTest.class).setLevel(Level.OFF);
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession session = kContainer.newKieSession("exsys-rules");
        Main main = new Main();
        main.setPrintMessage("Hello!");
        session.insert(main);
        System.out.println("Firing all rules!");
        session.fireAllRules();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent mainWindow = FXMLLoader.load(getClass().getClassLoader().getResource("mainWindow.fxml"));
        primaryStage.setTitle("ExSys");
        primaryStage.setScene(new Scene(mainWindow));
        primaryStage.show();
    }
}
