package family;

import fire.FireTabController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.Collection;

public class FamilyTabController {

    private KieSession session;
    private Collection<FactHandle> factsHandles;

    @FXML
    TextArea textArea_status;

    @FXML
    void initialize() {
        KieServices ks = KieServices.Factory.get();
        BasicConfigurator.configure();
        Logger.getLogger(FireTabController.class).setLevel(Level.OFF);
        KieContainer kContainer = ks.getKieClasspathContainer();
        session = kContainer.newKieSession("family-rules");
        factsHandles = session.getFactHandles();
    }

    @FXML
    void button_update_clicked() {
        for (FactHandle fact :
                factsHandles) {
            //TODO: Show all inserted objects
            textArea_status.setText(textArea_status.getText() + fact.toExternalForm() + "\n");
        }
    }
}
