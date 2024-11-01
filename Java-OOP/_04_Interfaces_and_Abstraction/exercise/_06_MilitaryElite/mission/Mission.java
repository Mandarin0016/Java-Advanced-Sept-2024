package _06_MilitaryElite.mission;

import _06_MilitaryElite.enumm.State;

public interface Mission {

    String getCodeName();

    State getState();

    void completeMission();
}
