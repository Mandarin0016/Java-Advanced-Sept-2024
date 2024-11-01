package _06_MilitaryElite.engineer.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import _06_MilitaryElite.engineer.Engineer;
import _06_MilitaryElite.repair.Repair;
import _06_MilitaryElite.soldier.impl.SpecialisedSoldierImpl;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private Collection<Repair> repairs;

    public EngineerImpl(int id,
                        String firstName,
                        String lastName,
                        double salary,
                        String corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairs = new ArrayList<>();
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(repairs);
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }
}
