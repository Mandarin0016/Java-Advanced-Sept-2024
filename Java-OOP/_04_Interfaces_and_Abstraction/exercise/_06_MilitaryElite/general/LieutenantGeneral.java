package _06_MilitaryElite.general;

import java.util.Collection;

import _06_MilitaryElite.privvate.Private;

public interface LieutenantGeneral {

    Collection<Private> getPrivates();

    void addPrivate(Private priv);
}
