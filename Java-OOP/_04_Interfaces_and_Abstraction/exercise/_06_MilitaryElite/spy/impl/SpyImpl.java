package _06_MilitaryElite.spy.impl;

import _06_MilitaryElite.soldier.impl.SoldierImpl;
import _06_MilitaryElite.spy.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    private int codeNumber;

    public SpyImpl(int id,
                   String firstName,
                   String lastName,
                   int codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public int getCodeNumber() {
        return this.codeNumber;
    }
}
