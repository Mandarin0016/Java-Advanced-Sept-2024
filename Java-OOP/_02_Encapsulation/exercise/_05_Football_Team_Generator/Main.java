package _05_Football_Team_Generator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Team> teams = new LinkedHashMap<>();

        while (!"END".equals(line)) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            String teamName = tokens[1];

            switch (command) {
                case "Team":
                    teams.putIfAbsent(teamName, new Team(teamName));
                    break;
                case "Add":
                    try {
                        // If you receive a command to add a player to a missing team, print:
                        // "Team {team name} does not exist."
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                            break;
                        }

                        Team team = teams.get(teamName);
                        String playerName = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);

                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);

                        team.addPlayer(player);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Remove":
                    try {
                        String playerName = tokens[2];
                        teams.get(teamName).removePlayer(playerName);
                    } catch (NoSuchElementException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Rating":
                    // "Rating;{TeamName}" – print the team rating, rounded to the closest integer
                    if (!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                        break;
                    }

                    System.out.printf("%s - %.0f\n", teamName, teams.get(teamName).getRating());

                    break;
            }

            line = scanner.nextLine();
        }

    }
}
