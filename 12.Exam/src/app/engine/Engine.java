package app.engine;

import app.entities.ArenaImpl;
import app.entities.ComicCharacterImpl;
import app.entities.Power;
import app.entities.antiHeroes.Titan;
import app.entities.antiHeroes.Villain;
import app.entities.heroes.DCHero;
import app.entities.heroes.Hero;
import app.entities.heroes.MarvelHero;
import app.interfaces.Arena;
import app.interfaces.ComicCharacter;
import app.interfaces.SuperPower;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;

public class Engine {

    private ConsoleReader reader;
    private ConsoleWriter writer;
    private WarManager WarManager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.WarManager = new WarManager();
    }

    public void run() throws IOException {

        String input = this.reader.readLine();

        while (!input.equals("WAR_IS_OVER")) {
            String[] tokens = input.split(" ");
            String commandResult = null;

            switch (tokens[0]) {
                case "CHECK_CHARACTER":
                    try {
                    commandResult = this.WarManager.checkComicCharacter(tokens[1]);
                    this.writer.writeLine(commandResult);
                    }catch (IllegalArgumentException e){
                        this.writer.writeLine(e.getMessage() + "\n");
                    }
                    break;

                case "REGISTER_HERO":
                    String name = tokens[1];
                    int energy = Integer.parseInt(tokens[3]);
                    double health = Double.parseDouble(tokens[4]);
                    double intelligence = Double.parseDouble(tokens[5]);
                    double heroism = Double.parseDouble(tokens[6]);

                        if(tokens[2].equals("DCHero")) {
                            try {

                                ComicCharacter dcHero = new DCHero(name, energy, health, intelligence, heroism);
                                this.WarManager.addHero(dcHero);
                                commandResult = this.WarManager.addHero(dcHero);
                                this.writer.writeLine(commandResult);
                            }catch (IllegalArgumentException e){
                                this.writer.writeLine(e.getMessage() + "\n");
                            }

                        }else if(tokens[2].equals("MarvelHero")) {
                            try {
                                ComicCharacter marvelHero = new MarvelHero(name, energy, health, intelligence, heroism);
                                commandResult = this.WarManager.addHero(marvelHero);
                                this.writer.writeLine(commandResult);
                            }catch (IllegalArgumentException e){
                                this.writer.writeLine(e.getMessage() + "\n");
                            }
                        }

                        break;

                case "REGISTER_ANTI_HERO":

                    if(tokens[2].equals("Villain")){
                        try {

                            ComicCharacter villain = new Villain(tokens[1], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]), Double.parseDouble(tokens[6]));
                            commandResult = this.WarManager.addAntiHero(villain);
                            this.writer.writeLine(commandResult);
                        }catch (IllegalArgumentException e){
                            this.writer.writeLine(e.getMessage() + "\n");
                        }
                    }else if(tokens[2].equals("Titan")){
                        try {

                        ComicCharacter titan = new Titan(tokens[1],Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]),Double.parseDouble(tokens[6]));
                        commandResult = this.WarManager.addAntiHero(titan);
                        this.writer.writeLine(commandResult);
                        }catch (IllegalArgumentException e){
                            this.writer.writeLine(e.getMessage() + "\n");
                        }
                    }
                    break;

                case "BUILD_ARENA":
                    try {
                        Arena arena = new ArenaImpl(tokens[1], Integer.parseInt(tokens[2]));
                        commandResult = this.WarManager.addArena(arena);
                        this.writer.writeLine(commandResult);
                    }catch (IllegalArgumentException e){
                        this.writer.writeLine(e.getMessage() + "\n");
                    }
                    break;

                case "SEND_HERO":
                    try {
                        commandResult = this.WarManager.addHeroToArena(tokens[1], tokens[2]);
                        this.writer.writeLine(commandResult);
                    }catch (IllegalArgumentException e){
                        this.writer.writeLine(e.getMessage() + "\n");
                    }
                    break;

                case "SEND_ANTI_HERO":
                    try {
                        commandResult = this.WarManager.addAntiHeroToArena(tokens[1], tokens[2]);
                        this.writer.writeLine(commandResult);
                    }catch (IllegalArgumentException e){
                        this.writer.writeLine(e.getMessage() + "\n");
                    }
                    break;
                case "SUPER_POWER":
                    try {
                        SuperPower superPower = new Power(tokens[1], Double.parseDouble(tokens[2]));
                        commandResult = this.WarManager.loadSuperPowerToPool(superPower);
                        this.writer.writeLine(commandResult);
                    }
                    catch (IllegalArgumentException e){
                        this.writer.writeLine(e.getMessage() + "\n");
                    }
                    break;
                case "ASSIGN_POWER":
                    try {
                        commandResult = this.WarManager.assignSuperPowerToComicCharacter(tokens[1], tokens[2]);
                        this.writer.writeLine(commandResult);
                    }catch (IllegalArgumentException e){
                        this.writer.writeLine(e.getMessage() + "\n");
                    }
                    break;
                case "UNLEASH":
                    try {
                        commandResult = this.WarManager.usePowers(tokens[1]);
                        this.writer.writeLine(commandResult);
                    }catch (IllegalArgumentException e){
                        this.writer.writeLine(e.getMessage() + "\n");
                    }
                    break;
                case "COMICS_WAR":
                    try {
                        commandResult = this.WarManager.startBattle(tokens[1]);
                        this.writer.writeLine(commandResult);
                    }catch (IllegalArgumentException e){
                        this.writer.writeLine(e.getMessage() + "\n");
                    }
                    break;
            }

            input = this.reader.readLine();
        }

    }
}
