package mood3.implementation;

import mood3.interfaces.Demon;

public class DemonImpl extends HeroImpl implements Demon {
    private static final String TYPE = "Demon";
    private double energy;
    private double num;

    public DemonImpl(String username, double energy, int level) {
        super(username, level);
        super.hashedPassword = hashing(username);
        super.type = TYPE;
        this.energy = energy;
        this.num =energy * level;
    }

    private String hashing(String name) {
        int pass = name.length() * 217;
        return String.valueOf(pass);
    }

    @Override
    public String toString() {
        StringBuilder demon = new StringBuilder(super.toString());
        demon.append(this.type);
        demon.append(System.lineSeparator());
        demon.append(String.format("%.1f", this.num));

        return demon.toString();
    }
}
