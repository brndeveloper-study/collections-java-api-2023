package main.java.set.Pesquisa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CounterStrikeVetoSystem {
    private final Team team1;
    private final Team team2;
    private final Set<String> maps = new HashSet<>(
        Arrays.asList("Ancient", "Anubis", "Dust2", "Inferno", "Mirage", "Nuke", "Vertigo")
    );
    private final Set<String> chosenMaps;

    // TODO: each team must take its turn.

    public CounterStrikeVetoSystem(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.chosenMaps = new HashSet<>();
    }

    public void startVeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(team1.getName() + " bans: ");
        team1.addMapBan(scanner.nextLine());

        System.out.println(team2.getName() + " bans: ");
        team2.addMapBan(scanner.nextLine());

        System.out.println(team1.getName() + " picks: ");
        team1.addMapPick(scanner.nextLine());

        System.out.println(team2.getName() + " picks: ");
        team2.addMapPick(scanner.nextLine());
    }

    public void addMapPick(Team team, String map) {
        String mapPick = formatWord(map);

        if (!maps.contains(mapPick)) {
            System.out.println(mapPick + " is an invalid map.");
            return;
        } else if (chosenMaps.size() < 2) {
            System.out.println("Maps need to be removed first.");
            return;
        } else if (chosenMaps.size() >= 4) {
            System.out.println("Maps can no longer be picked.");
            return;
        } else if (isMapUsed(mapPick)) {
            System.out.println(mapPick + " has already been chosen.");
            return;
        }

        team.addMapPick(mapPick);
        chosenMaps.add(mapPick);

        System.out.println(team.getName() + " picked " + mapPick);

    }

    public void addMapBan(Team team, String map) {
        String mapBan = formatWord(map);

        if (!maps.contains(mapBan)) {
            System.out.println(mapBan + " is an invalid map.");
            return;
        } else if (chosenMaps.size() >= 2 && chosenMaps.size() < 4) {
            System.out.println("Maps need to be picked.");
            return;
        } else if (isMapUsed(mapBan)) {
            System.out.println(mapBan + " has already been chosen.");
            return;
        } else if (chosenMaps.size() == 7) {
            System.out.println("Map pool has already been determined.");
            return;
        }

        team.addMapBan(mapBan);
        chosenMaps.add(mapBan);

        System.out.println(team.getName() + " banned " + mapBan);

        if (chosenMaps.size() == 6) {
            for (String remainingMap : maps) {
                if (!chosenMaps.contains(remainingMap)) {
                    chosenMaps.add(remainingMap);
                    System.out.println(remainingMap + " was left over");
                    return;
                }
            }
        }
    }

    public void showTeamVetos(Team team) {
        if (team.getMapsBans().isEmpty()) {
            System.out.println(team.getName() + " has no banned maps yet.");
            return;
        }
        System.out.println(team.getName() + " has banned so far: ");
        for (String map : team.getMapsBans()) {
            System.out.println(map);
        }
    }

    public void removeTeamVeto(Team team, String map) {
        if (team.getMapsBans().isEmpty()) {
            System.out.println(team.getName() + " has no banned maps yet.");
            return;
        }
        for (String mapBan : team.getMapsBans()) {
            if (mapBan.equalsIgnoreCase(map)) {
                team.removeMapBan(map);
                return;
            }
        }
        System.out.println(team.getName() + " did not pick the map " + map + ".");
    }

    public void showTeamPicks(Team team) {
        if (team.getMapsPicks().isEmpty()) {
            System.out.println(team.getName() + " has no picked maps yet.");
            return;
        }
        System.out.println(team.getName() + " has picked so far: ");
        for (String map : team.getMapsPicks()) {
            System.out.println(map);
        }
    }

    public void removeTeamPicks(Team team, String map) {
        if (team.getMapsPicks().isEmpty()) {
            System.out.println(team.getName() + " has no picked maps yet.");
            return;
        }
        for (String mapBan : team.getMapsPicks()) {
            if (mapBan.equalsIgnoreCase(map)) {
                team.removeMapPick(map);
                return;
            }
        }
        System.out.println(team.getName() + " did not pick the map " + map + ".");
    }

    public void showRemainingMaps() {
        if (chosenMaps.isEmpty()) {
            System.out.println("\nRemaining maps: ");
            for (String map : maps) {
                System.out.println(map);
            }
            System.out.println("\n");
            return;
        }

        Set<String> remainingMaps = new HashSet<>(maps);
        System.out.println("\nRemaining maps: ");
        for (String map : chosenMaps) {
            remainingMaps.remove(map);
        }

        for (String map : remainingMaps) {
            System.out.println(map);
        }
        System.out.println("\n");
    }

    private String formatWord(String word) {
        String firstLetter = word.substring(0, 1).toUpperCase();
        String restOfWord = word.substring(1).toLowerCase();
        return firstLetter + restOfWord;
    }

    private boolean isMapUsed(String mapa) {
        return this.chosenMaps.contains(mapa);
    }

    public static void main(String[] args) {
        Team furia = new Team("Furia");
        Team fnatic = new Team("Fnatic");
        CounterStrikeVetoSystem vetoFuriaFnatic = new CounterStrikeVetoSystem(furia, fnatic);
        vetoFuriaFnatic.addMapBan(fnatic, "Nuke");
        vetoFuriaFnatic.addMapBan(furia, "Anubis");

        vetoFuriaFnatic.addMapPick(fnatic, "Inferno");
        vetoFuriaFnatic.addMapPick(furia, "Mirage");

        vetoFuriaFnatic.showRemainingMaps();

        vetoFuriaFnatic.addMapBan(fnatic, "Vertigo");
        vetoFuriaFnatic.addMapBan(furia, "Dust2");
    }

}




