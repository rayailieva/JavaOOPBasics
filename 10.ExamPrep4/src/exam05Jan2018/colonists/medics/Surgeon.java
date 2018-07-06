package exam05Jan2018.colonists.medics;

public class Surgeon extends Medic {
    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    protected int getPotential() {
        int bonus = 0;
        if(super.getAge() > 25 && super.getAge() < 35){
               bonus = 2;

            if(super.getSign().equals("butcher")){
                bonus = -1;
            }

            if(super.getSign().equals("precise")){
                bonus = 5;
            }
        }
        return super.getTalent() + bonus;
    }
}
