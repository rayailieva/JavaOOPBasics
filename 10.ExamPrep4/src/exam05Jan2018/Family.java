package exam05Jan2018;

public class Family extends Colony{
    private String id;

    public Family(int maxFamilyCount, int maxFamilyCapacity, String id) {
        super(maxFamilyCount, maxFamilyCapacity);
        this.id = id;
    }


    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }
}
