package adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {

    String employeeName;
    String employeeNumber;

    public Employee() {
    }

    public Employee(String employeeName, String employeeNumber) {
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
    }

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
