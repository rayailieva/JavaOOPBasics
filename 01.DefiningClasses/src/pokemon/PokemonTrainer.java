package pokemon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PokemonTrainer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input;

        while (true) {
            if ("Tournament".equals(input = reader.readLine()))
                break;

            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (trainers.containsKey(trainerName)) {
                Trainer trainer = trainers.get(trainerName);
                trainer.getPokemons().add(pokemon);
                trainers.put(trainerName, trainer);
            } else {
                List<Pokemon> pokemons = new ArrayList<>();
                pokemons.add(pokemon);
                Trainer trainer = new Trainer(trainerName, 0, pokemons);
                trainers.put(trainerName, trainer);
            }

        }

        while (true) {
            if ("End".equals(input = reader.readLine()))
                break;

            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {

                List<Pokemon> pokemonList = trainer.getValue().getPokemons();
                if (containsElement(pokemonList, input)) {
                    trainer.getValue().addBatc();
                } else {
                    for (Iterator<Pokemon> iterator = pokemonList.iterator();iterator.hasNext(); ) {
                        Pokemon pokemon = iterator.next();
                        pokemon.decreaseHealth();
                        if (pokemon.getHealth() <= 0)
                            iterator.remove();
                    }


                }
            }
        }

        trainers = trainers.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue().getBadges(), a.getValue().getBadges()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
            System.out.println(trainer.getValue().toString());
        };

    }

    private static boolean containsElement(List<Pokemon> pokemons, String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element))
                return true;

        }
        return false;
    }
}

class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer() {
    }

    public Trainer(String name, int badges, List<Pokemon> pokemons) {
        this.name = name;
        this.badges = badges;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void addBatc() {
        this.badges++;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }
}

class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon() {
    }

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void decreaseHealth() {
        this.health -= 10;
    }
}