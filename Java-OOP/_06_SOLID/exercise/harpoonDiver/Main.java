package harpoonDiver;

import harpoonDiver.core.Controller;
import harpoonDiver.core.Engine;
import harpoonDiver.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = null; //TODO new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
