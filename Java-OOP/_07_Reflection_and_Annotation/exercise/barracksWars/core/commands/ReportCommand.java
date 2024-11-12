package barracksWars.core.commands;

import barracksWars.core.Inject;
import barracksWars.interfaces.Repository;

public class ReportCommand extends Command {

    @Inject
    private Repository repository;

    protected ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
