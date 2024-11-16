package harpoonDiver.core;

import java.util.List;
import java.util.stream.Collectors;

import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.diving.Diving;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;
import harpoonDiver.repositories.Repository;

import static harpoonDiver.common.ConstantMessages.*;
import static harpoonDiver.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Diver> diverRepository;
    private Repository<DivingSite> divingSiteRepository;
    private Diving diving;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
        this.diving = new DivingImpl();
    }

    @Override
    public String addDiver(String kind, String diverName) {

        Diver diver = switch (kind) {
            case "OpenWaterDiver" -> new OpenWaterDiver(diverName);
            case "DeepWaterDiver" -> new DeepWaterDiver(diverName);
            case "WreckDiver" -> new WreckDiver(diverName);
            default -> throw new IllegalArgumentException(DIVER_INVALID_KIND);
        };

        this.diverRepository.add(diver);

        return String.format(DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {

        DivingSiteImpl divingSite = new DivingSiteImpl(siteName);
        divingSite.getSeaCreatures().addAll(List.of(seaCreatures));

        this.divingSiteRepository.add(divingSite);

        return DIVING_SITE_ADDED.formatted(siteName);
    }

    @Override
    public String removeDiver(String diverName) {

        Diver diver = this.diverRepository.getCollection()
                                          .stream()
                                          .filter(d -> d.getName().equals(diverName))
                                          .findFirst()
                                          .orElseThrow(
                                          () -> new IllegalArgumentException(DIVER_DOES_NOT_EXIST.formatted(diverName))
                                                      );
        //                                          .orElse(null);

        //        if (diver == null) {
        //            throw new IllegalArgumentException(DIVER_DOES_NOT_EXIST.formatted(diverName));
        //        }

        this.diverRepository.remove(diver);

        return DIVER_REMOVE.formatted(diverName);
    }

    @Override
    public String startDiving(String siteName) {

        List<Diver> divers = this.diverRepository.getCollection()
                                                 .stream()
                                                 .filter(diver -> diver.getOxygen() >= 30)
                                                 .toList();

        if (divers.isEmpty()) {
            throw new IllegalArgumentException(SITE_DIVERS_DOES_NOT_EXISTS);
        }

        DivingSite divingSite = this.divingSiteRepository.byName(siteName);

        diving.searching(divingSite, divers);

        long removedDivers = divers.stream()
                                   .filter(diver -> !diver.canDive())
                                   .count();

        return SITE_DIVING.formatted(siteName, removedDivers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(FINAL_DIVING_SITES.formatted(this.divingSiteRepository.getCollection().size()));
        sb.append(System.lineSeparator());
        sb.append(FINAL_DIVERS_STATISTICS);

        this.diverRepository.getCollection()
                            .forEach(diver -> {
                                sb.append(System.lineSeparator());

                                sb.append(FINAL_DIVER_NAME.formatted(diver.getName()));

                                sb.append(System.lineSeparator());

                                sb.append(FINAL_DIVER_OXYGEN.formatted(diver.getOxygen()));

                                sb.append(System.lineSeparator());

                                sb.append(FINAL_DIVER_CATCH.formatted(

                                diver.getSeaCatch().getSeaCreatures().isEmpty() ? "None" :
                                String.join(FINAL_DIVER_CATCH_DELIMITER, diver.getSeaCatch().getSeaCreatures())

                                                                     ));
                            });

        return sb.toString();
    }
}
