package task3;

import java.util.Scanner;

interface Taxable {
    double salesTax = 7.0;
    double incomeTax = 10.5;

    double calcTax();
}

class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calcTax() {
        return salary * incomeTax / 100;
    }
}

class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;

    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calcTax() {
        return price * quantity * salesTax / 100; // Sales tax for total quantity
    }
}

public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter product ID: ");
        int pid = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();

        Employee employee = new Employee(empId, name, salary);
        Product product = new Product(pid, price, quantity);

        System.out.println("Income tax for employee: " + employee.calcTax());
        System.out.println("Sales tax for product: " + product.calcTax());

        scanner.close();
    }
}
