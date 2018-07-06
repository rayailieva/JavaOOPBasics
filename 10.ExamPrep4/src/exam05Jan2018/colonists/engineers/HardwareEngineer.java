package exam05Jan2018.colonists.engineers;

public class HardwareEngineer extends Engineer {
    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotential() {
        if(super.getAge() < 18){
            return super.getTalent() + 2;
        }
        return super.getTalent();
    }
}
