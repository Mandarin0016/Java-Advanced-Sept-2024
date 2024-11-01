package _06_MilitaryElite.general.comando.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import _06_MilitaryElite.general.comando.Commando;
import _06_MilitaryElite.mission.Mission;
import _06_MilitaryElite.soldier.impl.SpecialisedSoldierImpl;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Collection<Mission> missions;

    public CommandoImpl(int id,
                        String firstName,
                        String lastName,
                        double salary,
                        String corp) {
        super(id, firstName, lastName, salary, corp);
        this.missions = new ArrayList<>();
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(missions);
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }
}
