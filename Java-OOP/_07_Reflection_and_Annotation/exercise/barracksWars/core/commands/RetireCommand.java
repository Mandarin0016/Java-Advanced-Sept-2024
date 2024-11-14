package barracksWars.core.commands;

import barracksWars.core.Inject;
import barracksWars.interfaces.Repository;

public class RetireCommand extends Command {

    @Inject
    private Repository repository;

    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];

        repository.removeUnit(unitType);

        return unitType + " retired!";
    }
}
