package fire;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.Collection;
import java.util.HashSet;

public class FireTabController {

    private Collection<FactHandle> factsHandles;
    private KieSession session;
    private Measurement measurement;

    @FXML
    CheckBox checkBoxSmoke;
    @FXML
    Slider sliderTemperature;

    @FXML
    void initialize() {
        KieServices ks = KieServices.Factory.get();
        BasicConfigurator.configure();
        Logger.getLogger(FireTabController.class).setLevel(Level.OFF);
        KieContainer kContainer = ks.getKieClasspathContainer();
        session = kContainer.newKieSession("fire-rules");
        factsHandles = new HashSet<>();
        measurement = new Measurement();
    }

    @FXML
    void buttonRun() {
        insertObjects();
        session.fireAllRules();
        factsHandles = session.getFactHandles();
        for (FactHandle handle :
                factsHandles) {
            session.delete(handle);
        }
    }

    @FXML
    void checkBoxSmokeClicked() {
        System.out.println("checkBoxSmokeClicked(): " + checkBoxSmoke.isSelected());
        if (checkBoxSmoke.isSelected())
            measurement.setSmoke(true);
        else
            measurement.setSmoke(false);
        System.out.println("measurement.isSmoke(): " + measurement.isSmoke());
    }

    @FXML
    void sliderTemperatureChanged() {
        System.out.println("sliderTemperatureChanged(): " + sliderTemperature.getValue());
        measurement.setTemp((int) sliderTemperature.getValue());
        System.out.println("measurement.getTemp(): " + measurement.getTemp());
    }

    void insertObjects() {
        session.insert(measurement);
    }
}
