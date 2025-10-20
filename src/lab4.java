import customer.CustomerProduct;
import customer.CustomerProductDatabase;
import employees.EmployeeUser;
import employees.EmployeeUserDatabase;
import employees.AdminRole;
import product.Product;
import product.ProductDataBase;

import java.io.IOException;
import javax.swing.JOptionPane;


public class lab4 {
    public static void main(String[] args) throws IOException {
        String[] options = { "Admin", "Employee" };
        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Choose required role to test:",
                "role Selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0] // default selection
        );

        if (choice != null) {
            switch (choice) {
                case "Admin" -> {
                    employees.AdminRoleTest.main(args);
                }
                case "Employee" -> {
                    employees.EmployeeRoleTest.main(args);
                }

            }
        }

    }

}