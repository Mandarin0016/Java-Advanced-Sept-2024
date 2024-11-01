package _06_MilitaryElite.mission.impl;

import _06_MilitaryElite.enumm.State;
import _06_MilitaryElite.mission.Mission;

public class MissionImpl implements Mission {

    private String codeName;
    private State state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.state = State.finished;
    }

    public void setState(String state) {
        this.state = State.valueOf(state);
    }
}
