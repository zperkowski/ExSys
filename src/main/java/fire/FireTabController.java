package fire;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.HashSet;
import java.util.Set;

public class FireTabController {

    private Set<FactHandle> factsHandles;
    private KieSession session;
    private String smoke = "";

    @FXML
    CheckBox checkBoxSmoke;
    @FXML
    Button buttonRun;

    @FXML
    void initialize() {
        KieServices ks = KieServices.Factory.get();
        BasicConfigurator.configure();
        Logger.getLogger(FireTabController.class).setLevel(Level.OFF);
        KieContainer kContainer = ks.getKieClasspathContainer();
        session = kContainer.newKieSession("fire-rules");
        factsHandles = new HashSet<>();
    }

    @FXML
    void buttonRun() {
        session.fireAllRules();
        for (FactHandle handle :
                factsHandles) {
            session.delete(handle);
        }
    }

    @FXML
    void checkBoxSmokeClicked() {
        System.out.println("checkBoxSmokeClicked: " + checkBoxSmoke.isSelected());
        if (checkBoxSmoke.isSelected())
            smoke = "Smoke";
        else
            smoke = "";

        insertObjects();
    }

    void insertObjects() {
        factsHandles.add(session.insert(smoke));
    }
}
