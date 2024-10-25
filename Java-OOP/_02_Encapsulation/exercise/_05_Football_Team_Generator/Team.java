package _05_Football_Team_Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    // A name cannot be null, empty, or white space.
    // If not, print: "A name should not be empty."
    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    // If you receive a command to remove a missing player, print:
    // "Player {Player name} is not in {Team name} team."
    public void removePlayer(String name) {
        boolean isRemoved = this.players.removeIf(player -> player.getName().equals(name));

        if (!isRemoved) {
            throw new NoSuchElementException(
            String.format("Player %s is not in %s team.", name, this.name));
        }
    }

    // calculated by the average skill level of all players in the team
    public double getRating() {
        return this.players.stream()
                           .mapToDouble(Player::overallSkillLevel)
                           .average()
                           .orElse(0);
    }
}
