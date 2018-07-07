package pawInc.animals;

public class Dog extends Animal {
    private String cleansingStatus;
    private int commandsLearned;


    public Dog(String name, int age, int commandsLearned) {
        super(name, age);
        this.setCleansingStatus("uncleansed");
        this.commandsLearned = commandsLearned;
    }

    public int getCommandsLearned() {
        return this.commandsLearned;
    }

    private void setCommandsLearned(int commandsLearned) {
        this.commandsLearned = commandsLearned;
    }


    public String getCleansingStatus() {
        return this.cleansingStatus;
    }

    public void setCleansingStatus(String cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }


}
