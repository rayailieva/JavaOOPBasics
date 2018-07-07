package pawInc.animals;

public abstract class Animal {
    private String name;
    private int age;
    private String cleansingStatus;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.setCleansingStatus("uncleansed");
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getCleansingStatus() {
        return this.cleansingStatus;
    }

    public void setCleansingStatus(String cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }
}
