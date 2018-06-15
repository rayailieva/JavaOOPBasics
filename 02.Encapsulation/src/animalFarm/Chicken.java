package animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.equals(" ") || name.equals("")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public int getProductPerDay(){
        int productPerDay = 0;
        if(this.age <= 5){
            productPerDay = 2;
        }
        if(this.age > 5 ){
            productPerDay = 1;
        }
        return productPerDay;
    }


}
