package mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    public double getWeekSalary() {
        return this.weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        if(weekSalary <= 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    public double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    public void setWorkHoursPerDay(double workHoursPerDay) {
        if(workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public void setLastName(String lastName) {
        if(!Character.isUpperCase(lastName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if(lastName.length() < 4){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: " + this.firstName);
        sb.append(System.lineSeparator());
        sb.append("Last Name: " + this.lastName);
        sb.append(System.lineSeparator());
        sb.append(String.format("Week Salary: %.2f", this.weekSalary));
        sb.append(System.lineSeparator());
        sb.append(String.format("Hours per day: %.2f", this.workHoursPerDay));
        sb.append(System.lineSeparator());
        sb.append(String.format("Salary per hour: %.2f", (this.weekSalary / (this.workHoursPerDay * 7))));

        return sb.toString();
    }

    public double claculateSalaryPerHour(){
        return this.weekSalary / (this.workHoursPerDay * 7);
    }
}
