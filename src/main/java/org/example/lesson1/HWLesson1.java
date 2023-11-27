package org.example.lesson1;

import org.example.lesson1.exceptions.NumberNotFoundException;
import org.example.lesson1.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
 * 1.1 Найти максимальное
 * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
 * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 * <p>
 * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
 * 2.1 Создать список из 10-20 сотрудников
 * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
 * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
 * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
 * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
 */

public class HWLesson1 {
    public static void main(String[] args) {
//        randomNumbers();
        tasksWithEmployee();
    }

    public static void randomNumbers() {
        List<Integer> numbers = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            numbers.add(random.nextInt(1000000));
        }

        //Найти максимальное
        int maxNumber = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() ->
                        new NumberNotFoundException("Max number not found"));

        //Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        int upgradeMaxNumber = numbers
                .stream()
                .filter(c -> c > 500000)
                .map(num -> (num * 5))
                .map(num -> (num - 150))
                .reduce(0, Integer::sum);

        //Найти количество чисел, квадрат которых меньше, чем 100_000
        long countNumbersSqrt = numbers
                .stream()
                .filter(c -> (c * c) < 100000)
                .count();

        System.out.println("Найти максимальное: " + maxNumber);
        System.out.println("Все числа, большие, чем 500_000, умножить на 5," +
                " отнять от них 150 и просуммировать" + upgradeMaxNumber);
        System.out.println("Найти количество чисел, квадрат которых меньше," +
                " чем 100_000: " + countNumbersSqrt);
    }

    public static void tasksWithEmployee() {
        //Создать список из 10-20 сотрудников
        List<Employee> employees = generateList();

        //Вывести список всех различных отделов (department) по списку сотрудников
        Set<String> allDeps = employees
                .stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
        System.out.println("Cписок всех различных отделов (department) по списку сотрудников\n"
            + allDeps);

        //Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        System.out.println("Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%");
        employees
                .stream()
                .filter(c -> c.getSalary() < 10000)
                .map(c -> (c.getSalary() * 1.2))
                .forEach(System.out::println);
        System.out.println("-".repeat(10));

        //Из списка сотрудников с помощью стрима создать Map<String,
        // List<Employee>> с отделами и сотрудниками внутри отдела
        Map<String, List<Employee>> employeesMap =
                employees
                        .stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.toList()));
        System.out.println("Map<String, List<Employee>> с отделами и сотрудниками внутри отдела\n"
                + employeesMap);

        //Из списка сотрудников с помощью стрима создать Map<String,
        // Double> с отделами и средней зарплатой внутри отдела
        Map<String, Double> avgSalary =
                employees
                        .stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Средняя зарплата по отделам:\n" + avgSalary);
    }

    public static List<Employee> generateList() {
        List<Employee> employees = new ArrayList<>();
        List<String> deps = List.of("IT", "HR", "Manager");
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            employees.add(new Employee(
                    "Name #" + i,
                    (20 + random.nextInt(20)),
                    (random.nextInt(15000) + (i * 0.01)),
                    deps.get(random.nextInt(3))));
        }
        return employees;
    }
}
