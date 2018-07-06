package exam05Jan2018.colonists.engineers;

import exam05Jan2018.colonists.Colonist;

public abstract class Engineer extends Colonist {
    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotential() {
        if(super.getAge() > 30){
            return super.getTalent() + 5;
        }
        return super.getTalent() + 3;
    }
}
