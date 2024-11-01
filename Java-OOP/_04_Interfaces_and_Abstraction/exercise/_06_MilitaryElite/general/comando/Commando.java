package _06_MilitaryElite.general.comando;

import java.util.Collection;

import _06_MilitaryElite.mission.Mission;

public interface Commando {

    Collection<Mission> getMissions();

    void addMission(Mission mission);
}
