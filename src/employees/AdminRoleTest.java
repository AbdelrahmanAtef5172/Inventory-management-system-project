package employees;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AdminRoleTest {
    public static void main(String[] args) throws IOException {
        AdminRole admin = new AdminRole();
        while (true) {
            String[] options = { "addEmployee", "getListOfEmployees", "removeEmployee", "logout" };
            String choice = (String) JOptionPane.showInputDialog(
                    null,
                    "Choose functionality:",
                    "functionality Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0] // default selection
            );

            if (choice != null) {
                switch (choice) {
                    case "addEmployee" -> {
                        Scanner sc = new Scanner(System.in);
                        System.out.print("Enter Employee ID: ");
                        String employeeId = sc.nextLine();
                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Employee Email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter Employee Address: ");
                        String address = sc.nextLine();
                        System.out.print("Enter Employee Phone Number: ");
                        String phoneNumber = sc.nextLine();
                        try {
                            admin.addEmployee(employeeId, name, email, address, phoneNumber);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Try Again!!");
                            break;
                        }
                    }
                    case "getListOfEmployees" -> {
                        EmployeeUser[] employees = admin.getListOfEmployees();
                        for (int i = 0; i < employees.length; i++) {
                            System.out.print(employees[i].lineRepresentation());
                        }
                    }
                    case "removeEmployee" -> {
                        Scanner sc = new Scanner(System.in);
                        System.out.print("Enter Employee ID to remove: ");
                        String key = sc.nextLine();
                        try {
                            admin.removeEmployee(key);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Try Again!!");
                            break;
                        }
                    }
                    case "logout" -> {
                        admin.logout();
                        return;
                    }

                }
            }
        }
    }
}
