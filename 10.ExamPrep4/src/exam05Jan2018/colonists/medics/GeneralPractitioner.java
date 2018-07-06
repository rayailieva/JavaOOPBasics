package exam05Jan2018.colonists.medics;

public class GeneralPractitioner extends Medic {
    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    protected int getPotential() {
        int bonus = 0;
        if(super.getAge() > 15){
            bonus = 1;
        }
        if(super.getSign().equals("caring")){
            bonus = 1;
        }
        if(super.getSign().equals("careless")){
            bonus = - 2;
        }

        return super.getTalent() + bonus;
    }
}
