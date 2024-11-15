package harpoonDiver.models.diving;

import java.util.Collection;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

public class DivingImpl implements Diving {

    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {

        for (Diver diver : divers) {
            while (diver.canDive()) {
                Collection<String> seaCreatures = divingSite.getSeaCreatures();
                if (seaCreatures.isEmpty()) {
                    break;
                }
                // TODO fix me!!!
                for (String seaCreature : seaCreatures) {
                    diver.shoot();
                    divingSite.getSeaCreatures().remove(seaCreature);
                    diver.getSeaCatch().getSeaCreatures().add(seaCreature);
                    if (!diver.canDive()) {
                        break;
                    }
                }
            }
        }
    }
}
