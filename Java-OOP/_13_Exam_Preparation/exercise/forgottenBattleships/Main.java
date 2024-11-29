package forgottenBattleships;

import forgottenBattleships.core.Engine;
import forgottenBattleships.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}