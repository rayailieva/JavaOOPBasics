package app.entities;

import app.interfaces.Arena;
import app.interfaces.ComicCharacter;

import java.util.ArrayList;
import java.util.List;

public class ArenaImpl implements Arena {
    private String arenaName;
    private List<ComicCharacter> heroes;
    private List<ComicCharacter> antiHeroes;
    private int capacity;

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.heroes = new ArrayList<>();
        this.antiHeroes = new ArrayList<>();
        this.capacity = capacity;
    }

    public String getArenaName() {
        return this.arenaName;
    }

    @Override
    public boolean isArenaFull() {
       if(this.heroes.size() + this.antiHeroes.size() >= capacity){
           return true;
       }
       return false;
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add(hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antihero) {
        this.antiHeroes.add(antihero);
    }

    @Override
    public boolean fightHeroes() {
      return true;
    }

    @Override
    public boolean hasHero(ComicCharacter hero) {
        if(this.getHeroes().contains(hero)){
            return true;
        }
        return false;
    }

    @Override
    public boolean hasAntiHero(ComicCharacter currHero) {
        if(this.getAntiHeroes().contains(currHero)){
            return true;
        }
        return false;
    }

    @Override
    public boolean hasParticipants() {
        if(this.getAntiHeroes().isEmpty() && this.getHeroes().isEmpty()){
            return false;
        }
        return true;
    }


    private void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public List<ComicCharacter> getHeroes() {
        return this.heroes;
    }

    public void setHeroes(List<ComicCharacter> heroes) {
        this.heroes = heroes;
    }

    public List<ComicCharacter> getAntiHeroes() {
        return this.antiHeroes;
    }

    public void setAntiHeroes(List<ComicCharacter> antiHeroes) {
        this.antiHeroes = antiHeroes;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
