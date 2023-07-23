package ru.gb.mrd;
import ru.gb.Employee.Employee;
import ru.gb.Manager.Manager;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //  Создать массив из 5 сотрудников
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

    public static void increaseSalary(Employee[] employees, int age, int sum) {
        for (Employee employee : employees) {
            if (employee.getAge() >= age) {
                employee.increaseSal(sum);
            }
        }
    }

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