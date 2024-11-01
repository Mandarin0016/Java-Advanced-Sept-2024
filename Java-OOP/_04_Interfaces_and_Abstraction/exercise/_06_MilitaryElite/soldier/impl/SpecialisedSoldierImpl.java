package _06_MilitaryElite.soldier.impl;

import _06_MilitaryElite.enumm.Corp;
import _06_MilitaryElite.privvate.PrivateImpl;
import _06_MilitaryElite.soldier.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corp corp;

    public SpecialisedSoldierImpl(int id,
                                  String firstName,
                                  String lastName,
                                  double salary,
                                  String corp) {
        super(id, firstName, lastName, salary);
        this.setCorp(corp);
    }

    @Override
    public Corp getCorps() {
        return this.corp;
    }

    public void setCorp(String corp) {
        this.corp = Corp.valueOf(corp);
    }
}
