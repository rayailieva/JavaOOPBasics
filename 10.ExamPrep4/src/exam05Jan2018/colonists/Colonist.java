package exam05Jan2018.colonists;

public abstract class Colonist {
    private String id;
    private String familyId;
    private int talent;
    private int age;

    private int classBonus;
    private int ageBonus;

    public Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
        this.classBonus = 0;
        this.ageBonus = 0;
    }

    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    private void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public int getTalent() {
        return this.talent;
    }

    private void setTalent(int talent) {
        this.talent = talent;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassBonus() {
        return this.classBonus;
    }

    private void setClassBonus(int classBonus) {
        this.classBonus = classBonus;
    }

    public int getAgeBonus() {
        return this.ageBonus;
    }

    private void setAgeBonus(int ageBonus) {
        this.ageBonus = ageBonus;
    }

    protected int getPotential(){
        return this.talent + this.classBonus + this.ageBonus;
    }

    public void grow(int years){
        return;
    }
}
