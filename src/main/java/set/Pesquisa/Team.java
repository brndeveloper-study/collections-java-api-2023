package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Team {
    private String name;
    private final Set<String> mapsPicks;
    private final Set<String> mapsBans;

    public Team(String name) {
        this.name = name;
        this.mapsPicks = new HashSet<>();
        this.mapsBans = new HashSet<>();
    }

    public Team() {
        this.mapsPicks = new HashSet<>();
        this.mapsBans = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getMapsPicks() {
        return mapsPicks;
    }

    public void addMapPick(String map) {
        this.mapsPicks.add(map);
    }

    public void addMapBan(String map) {
        this.mapsBans.add(map);
    }

    public void removeMapBan(String map) {
        this.mapsBans.remove(map);
    }

    public void removeMapPick(String map) {
        this.mapsPicks.remove(map);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team team)) return false;
        return Objects.equals(getMapsPicks(), team.getMapsPicks()) && Objects.equals(getMapsBans(), team.getMapsBans());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMapsPicks(), getMapsBans());
    }

    public Set<String> getMapsBans() {
        return mapsBans;
    }

}
