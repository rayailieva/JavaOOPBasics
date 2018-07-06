package exam05Jan2018.colonists.medics;

import exam05Jan2018.colonists.Colonist;

public abstract class Medic extends Colonist {
    private String sign;

    public Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    private void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    protected int getPotential() {
        return super.getTalent() + 2;
    }
}
