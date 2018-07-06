package exam05Jan2018.colonists;

public class Soldier extends Colonist {
    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotential() {
        return super.getTalent() + (super.getClassBonus() + 3) + (super.getAgeBonus() + 3);
    }
}
