# Классы и объекты
## Задание 1.  
– Создать класс ”Сотрудник”с полями: ФИО, должность, телефон, зарплата, возраст;  
– Написать метод выводящую всю доступную информацию об объекте с использованием форматирования строк.  
– Создать массив из 5 сотрудников
– Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000. Возраст и размер повышения должны быть параметрами метода.   
– Написать тот же метод повышения в качестве статического в классе сотрудника. Метод должен принимать в качестве параметра массив сотрудников.  
– Написать методы (принимающие на вход массив сотрудников), вычисляющие средний возраст и среднюю зарплату сотрудников, вывести результаты работы в консоль.   
### Class Employee
```java
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
```
## Задание 2.
Опишите класс руководителя, наследник от сотрудника. Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей.
В основной программе создайте руководителя и поместите его в общий массив сотрудников. Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
### Class Manager
```java
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
```
### Class Main
```java
package ru.gb.mrd;
import ru.gb.Employee.Employee;
import ru.gb.Manager.Manager;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //  Создать массив из 5 сотрудников (+ менеждер из задания 2)
        Employee[] workers = new Employee[6];
        workers[0] = new Employee("Петров", "Петр", "Петрович", "Инженер",
                "+79647891451", 23, 35000);
        workers[1] = new Employee("Иванов", "Иван", "Иванович", "Сторож",
                "+79268789794", 65, 15000);
        workers[2] = new Employee("Бегемотов", "Кот", "Котович", "Мастер",
                "+79984545422", 33, 37000);
        workers[3] = new Employee("Шариков", "Полиграф", "Полиграфович", "Инженер",
                "+79647891451", 23, 39000);
        workers[4] = new Employee("Преображе́нский", "Филип", "Филипович", "Инженер",
                "+79647891451", 45, 35000);
        // В основной программе создайте руководителя и поместите его в общий массив сотрудников. Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
        workers[5] = new Manager("Синицы", "Филип", "Антонович", "Менеджер",
                "+79648764545", 46, 60000);

        System.out.println("----------------------------------------------------------");
        IntStream.range(0, workers.length).forEach(index -> System.out.println(workers[index]));
        //Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000. Возраст и размер повышения должны быть параметрами метода.
        System.out.println("----------------------------------------------------------");
        increaseSalary(workers, 45, 5000);
        IntStream.range(0, workers.length).forEach(index -> System.out.println(workers[index]));
        System.out.println("----------------------------------------------------------");
        //Написать тот же метод повышения в качестве статического в классе сотрудника. Метод должен принимать в качестве параметра массив сотрудников.
        Employee.salaryIncrease(workers, 45, 5000);
        IntStream.range(0, workers.length).forEach(index -> System.out.println(workers[index]));
        System.out.println("----------------------------------------------------------");
        // Написать методы (принимающие на вход массив сотрудников), вычисляющие средний возраст и среднюю зарплату сотрудников, вывести результаты работы в консоль.
        System.out.println(avgSalaryAndAge(workers));
        // В основной программе создайте руководителя и поместите его в общий массив сотрудников. Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
        System.out.println("----------------------------------------------------------");
        Manager.salaryIncrease(workers, 45, 5000);
        IntStream.range(0, workers.length).forEach(index -> System.out.println(workers[index]));
    }

    //Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000. Возраст и размер повышения должны быть параметрами метода.
    public static void increaseSalary(Employee[] employees, int age, int sum) {
        for (Employee employee : employees) {
            if (employee.getAge() >= age) {
                employee.increaseSal(sum);
            }
        }
    }

    // Написать методы (принимающие на вход массив сотрудников), вычисляющие средний возраст и среднюю зарплату сотрудников, вывести результаты работы в консоль.
    public static HashMap<String, Float> avgSalaryAndAge(Employee[] employees) {
        HashMap<String, Float> avgSalaryAndAge = new HashMap<String, Float>();
        float avgOutSalary = 0;
        float avgOutAge = 0;
        for (Employee employee : employees) {
            avgOutSalary += employee.getSalary();
            avgOutAge += employee.getAge();
        }
        avgSalaryAndAge.put("avgSalary", avgOutSalary / employees.length);
        avgSalaryAndAge.put("avgAge", avgOutAge / employees.length);
        return avgSalaryAndAge;
    }
}
```
![task3](https://github.com/MaksimZ91/JavaCoreLesson3/assets/72209139/d0c5a190-4a0b-4f83-ba3c-ef1b7abfd322)
![task3_result](https://github.com/MaksimZ91/JavaCoreLesson3/assets/72209139/fc65555d-c6a0-440b-ab6a-5f81bee6aaf3)
