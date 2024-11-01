package _06_MilitaryElite.engineer;

import java.util.Collection;

import _06_MilitaryElite.repair.Repair;

public interface Engineer {

    Collection<Repair> getRepairs();

    void addRepair(Repair repair);
}
