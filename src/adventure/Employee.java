package adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {

    //Variabler for employees
    String employeeName;
    String employeeNumber;

    //Konstruktører til employees
    public Employee() {
    }

    public Employee(String employeeName, String employeeNumber) {
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
    }

    //Getters og setters
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
