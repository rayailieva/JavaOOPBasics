package exam05Jan2018;

import exam05Jan2018.colonists.Colonist;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;

    //       family id, Colonist
    private Map<String, Family> colonists;
    private Map<String, Colonist> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.colonists = new LinkedHashMap<>();
        this.families = new LinkedHashMap<>();
    }

    public Map<String, Family> getColonists() {
        return this.colonists;
    }

    public void setColonists(Map<String, Family> colonists) {
        this.colonists = colonists;
    }

    public Map<String, Colonist> getFamilies() {
        return this.families;
    }

    public void setFamilies(Map<String, Colonist> families) {
        this.families = families;
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    private void setMaxFamilyCount(int maxFamilyCount) {
        this.maxFamilyCount = maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    private void setMaxFamilyCapacity(int maxFamilyCapacity) {
        this.maxFamilyCapacity = maxFamilyCapacity;
    }

    public void addColonist(Colonist colonist){
        String familyId = colonist.getFamilyId();
        String colonistId = colonist.getId();

        Family family = null;
        if(!this.families.containsKey(familyId)) {
            family = new Family(this.maxFamilyCount, this.maxFamilyCapacity, familyId);
        }
        else{
            family = families.get(familyId);
        }
        if(family != null) {
            families.put(familyId, family);
            colonists.put()
        }



    }
    public void removeColonist(String familyId, String memberId){

    }
    public void removeFamily(String id){
        families.remove(id);
    }
    public List<Colonist> getColonistsByFamilyId(String familyId){
        return new ArrayList<>();
    }
    public void grow(int years){

    }
    public int getPotential(){
        return 0;
    }

    public String getCapacity(){
        return "";
    }

    public boolean isFull(){
       return true;
    }

}

