package ru.gb.Manager;
import ru.gb.Employee.Employee;

public class Manager extends Employee {
    public Manager(String surName, String firstName, String patronymic, String position, String phone, int age, int salary) {
        super(surName, firstName, patronymic, position, phone, age, salary);
    }


    public static void salaryIncrease(Employee[] employees,int limitAge, int raise){
        for (Employee employee: employees) {
            if (employee.getAge() >= limitAge){
                if(!(employee instanceof Manager))
                    employee.setSalary(employee.getSalary() + raise);
            }
        }
    }

}
