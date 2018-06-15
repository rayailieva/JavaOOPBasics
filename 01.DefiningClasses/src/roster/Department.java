package roster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
    private String department;
    private List<Employee> employees;

    Department(String department){
        if(this.employees == null){
            this.employees = new ArrayList<>();
        }

        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    void addEmployees(Employee emp) {
        this.employees.add(emp);
    }

    List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
