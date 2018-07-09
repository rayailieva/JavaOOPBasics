package app.interfaces;

public interface Arena {
    String getArenaName();

    boolean isArenaFull();

    void addHero(ComicCharacter hero);

    void addAntiHero(ComicCharacter antihero);

    boolean fightHeroes();

    boolean hasHero(ComicCharacter currHero);

    boolean hasAntiHero(ComicCharacter currHero);

    boolean hasParticipants();
}
