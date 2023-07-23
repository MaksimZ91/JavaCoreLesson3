package ru.gb.Employee;

public class Employee {
    private String surName, firstName, patronymic, position, phone;
    private int age, salary;

    public Employee(String surName, String firstName, String patronymic, String position, String phone, int age, int salary) {
        this.surName = surName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.position = position;
        this.phone = phone;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  String.format("Employee{ surName='%s', firstName='%s', patronymic='%s', " +
                "position='%s', phone='%s', age='%d',salary='%d' }",
                surName, firstName, patronymic, position, phone, age, salary);
    }

    public static void salaryIncrease(Employee[] employees,int limitAge, int raise){
        for (Employee employee: employees) {
            if (employee.getAge() >= limitAge){
                employee.setSalary(employee.getSalary() + raise);
            }
        }
    }

    public void increaseSal(int sum){
        this.salary += sum;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
