package mood3.implementation;

public abstract class HeroImpl {
    protected String username;
    protected String hashedPassword;
    protected int level;
    protected String type;

    public HeroImpl(String username, int level) {
        this.username = username;
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> ", this.username, this.hashedPassword);
    }
}
