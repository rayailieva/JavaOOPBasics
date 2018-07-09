package app.engine;

import app.interfaces.Arena;
import app.interfaces.ComicCharacter;
import app.interfaces.Manager;
import app.interfaces.SuperPower;

import java.util.LinkedHashMap;
import java.util.Map;

public class WarManager implements Manager {
    private Map<String, ComicCharacter> characters;
    private Map<String, Arena> arenas;
    private Map<String, SuperPower> superPowers;


    public WarManager() {
        this.characters = new LinkedHashMap<>();
        this.arenas = new LinkedHashMap<>();
        this.superPowers = new LinkedHashMap<>();
    }

    @Override
    public String checkComicCharacter(String characterName) {
        if(this.characters.containsKey(characterName)){
            if(this.characters.get(characterName).getHealth() <= 0){
                return String.format("%s has fallen in battle!", characterName);
            }
            return this.characters.get(characterName).toString();
        }
        return String.format("Sorry, fans! %s doesn't exist in our comics!%n", characterName);
    }

    @Override
    public String addHero(ComicCharacter hero) {
        if(this.characters.containsKey(hero)){
           this.characters.put(hero.getName(), hero);
            return String.format("%s evolved!", hero);
        }
        this.characters.put(hero.getName(), hero);
        return String.format("%s is ready for battle!%n", hero.getName());
    }

    @Override
    public String addAntiHero(ComicCharacter antiHero) {
       if(this.characters.containsKey(antiHero)){
           this.characters.put(antiHero.getName(), antiHero);
           return String.format("%s is getting stronger!%n", antiHero.getName());
       }
       this.characters.put(antiHero.getName(), antiHero);
       return String.format("%s is ready for destruction!%n", antiHero.getName());
    }

    @Override
    public String addArena(Arena arena) {
       if(this.arenas.containsKey(arena.getArenaName())){
           return String.format("A battle is about to start there!%n");
       }
       this.arenas.put(arena.getArenaName(), arena);
       return String.format("%s is becoming a fighting ground!%n", arena.getArenaName());
    }

    @Override
    public String addHeroToArena(String arena, String hero) {
       Arena currArena = this.arenas.get(arena);
       ComicCharacter currHero = this.characters.get(hero);

       if(currArena.hasHero(currHero)){
           return String.format("%s is fighting!%n", hero);
       }
       if(currHero.getHealth() <= 0){
           return String.format("%s is dead!%n", hero);
       }
       if(currArena.isArenaFull()){
           return String.format("Arena is full!%n");
       }
       else {
           currArena.addHero(currHero);
           return String.format("%s is fighting for your freedom in %s!%n", hero, arena);
       }
    }

    @Override
    public String addAntiHeroToArena(String arena, String antiHero) {
        Arena currArena = this.arenas.get(arena);
        ComicCharacter currHero = this.characters.get(antiHero);

        if(currArena.hasAntiHero(currHero)){
            return String.format("%s is fighting!%n", antiHero);
        }
        if(currHero.getHealth() <= 0){
            return String.format("%s is dead!%n", antiHero);
        }
        if(currArena.isArenaFull()){
            return String.format("Arena is full!%n");
        }
        else {
            currArena.addHero(currHero);
            return String.format("%s and his colleagues are trying to take over %s!%n", antiHero, arena);
        }
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        if(this.superPowers.containsKey(superPower.getName())){
            return String.format("This super power already exists!%n", superPower.getName());
        }
        this.superPowers.put(superPower.getName(), superPower);
        return String.format("%s added to pool!%n", superPower.getName());
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
            SuperPower currSuperPower = this.superPowers.get(superPower);
            ComicCharacter currCharacter = this.characters.get(comicCharacter);

            if(currCharacter.getSuperPowers().contains(currSuperPower)){
                return String.format("%s already assigned!%n", currSuperPower.getName());
            }

            currCharacter.addSuperPower(currSuperPower);
            return String.format("%s has a new super power!%n", currCharacter.getName());
    }

    @Override
    public String usePowers(String characterName) {
        if(this.characters.containsKey(characterName)) {
            ComicCharacter currCharacter = this.characters.get(characterName);
            return currCharacter.useSuperPowers();
        }
        return "";
    }

    @Override
    public String startBattle(String arena) {
          Arena currArena = this.arenas.get(arena);
          if(!currArena.hasParticipants()){
              return String.format("SAFE ZONE!%n");
         }
        return "";
    }

    @Override
    public String endWar() {
        return null;
    }
}
