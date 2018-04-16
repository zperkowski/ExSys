package com.zperkowski.exsys;

import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class MainTest {

    public static void main(String[] args) throws DroolsParserException, IOException {
        MainTest helloWorldTest = new MainTest();
        helloWorldTest.executeHelloWorldRules();
    }

    private void executeHelloWorldRules() throws IOException, DroolsParserException {
        KieServices ks = KieServices.Factory.get();
        BasicConfigurator.configure();
        Logger.getLogger(MainTest.class).setLevel(Level.OFF);
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession session = kContainer.newKieSession("ksession-rules");
        Main main = new Main();
        main.setPrintMessage("Hello!");
        session.insert(main);
        System.out.println("Firing all rules!");
        session.fireAllRules();
    }
}
