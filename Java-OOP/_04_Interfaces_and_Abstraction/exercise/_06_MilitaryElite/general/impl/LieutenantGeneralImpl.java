package _06_MilitaryElite.general.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import _06_MilitaryElite.general.LieutenantGeneral;
import _06_MilitaryElite.privvate.Private;
import _06_MilitaryElite.privvate.PrivateImpl;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private Collection<Private> privates;

    public LieutenantGeneralImpl(int id,
                                 String firstName,
                                 String lastName,
                                 double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public Collection<Private> getPrivates() {
        return Collections.unmodifiableCollection(this.privates);
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }
}
