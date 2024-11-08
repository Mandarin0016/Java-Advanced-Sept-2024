package harpoonDiver.models.seaCatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BaseSeaCatch implements SeaCatch {

    private Collection<String> seaCreatures;

    public BaseSeaCatch() {
        this.seaCreatures = new ArrayList<>();
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return this.seaCreatures;
    }
}
