package employees;

import customer.CustomerProduct;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import product.Product;


public class EmployeeRoleTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        EmployeeRole employee = new EmployeeRole();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true) {
            System.out.println("\n======= EMPLOYEE ROLE MENU =======");
            System.out.println("1. Add new product");
            System.out.println("2. View all products");
            System.out.println("3. View all purchase records");
            System.out.println("4. Purchase a product");
            System.out.println("5. Return a product");
            System.out.println("6. Apply payment");
            System.out.println("7. Logout and save");
            System.out.print("Enter your choice (1-7): ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {

                // Add new product
                case 1:
                    System.out.println("\nEnter product details:");
                    System.out.print("Product ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Product Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Manufacturer: ");
                    String manufacturer = sc.nextLine().trim();
                    System.out.print("Supplier: ");
                    String supplier = sc.nextLine().trim();

                    int quantity;
                    try {
                        System.out.print("Quantity: ");
                        quantity = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number entered. Please try again.");
                        break;
                    }

                    employee.addProduct(id, name, manufacturer, supplier, quantity);
                    System.out.println("Product added successfully!");
                    break;

                // View all products
                case 2:
                    Product[] products = employee.getListOfProducts();
                    if (products.length == 0) {
                        System.out.println("No products found.");
                    } else {
                        System.out.println("\n--- All Products ---");
                        for (int i = 0; i < products.length; i++) {
                            Product p = products[i];
                            System.out.println((i + 1) + ". " + p.lineRepresentation());
                        }
                    }
                    break;


                // View all purchase records
                case 3:
                    CustomerProduct[] purchases = employee.getListOfPurchasingOperations();
                    if (purchases.length == 0) {
                        System.out.println("No purchases found.");
                    } else {
                        System.out.println("\n--- All Purchase Records ---");
                        for (int i = 0; i < purchases.length; i++) {
                            CustomerProduct cp = purchases[i];
                            System.out.println((i + 1) + ". " + cp.lineRepresentation());
                        }
                    }
                    break;

                // Purchase a product
                case 4:
                    System.out.print("Enter Customer SSN: ");
                    String ssn = sc.nextLine();
                    System.out.print("Enter Product ID: ");
                    String productID = sc.nextLine();
                    System.out.print("Enter Purchase Date (dd-MM-yyyy): ");
                    LocalDate purchaseDate = LocalDate.parse(sc.nextLine(), formatter);

                    boolean success = employee.purchaseProduct(ssn, productID, purchaseDate);
                    if (success)
                        System.out.println("Purchase recorded successfully!");
                    else
                        System.out.println("Purchase failed (product not found or out of stock).");
                    break;

                // Return a product
                case 5:
                    System.out.print("Enter Customer SSN: ");
                    String rssn = sc.nextLine();
                    System.out.print("Enter Product ID: ");
                    String rProductID = sc.nextLine();
                    System.out.print("Enter Purchase Date (dd-MM-yyyy): ");
                    LocalDate purDate = LocalDate.parse(sc.nextLine(), formatter);
                    System.out.print("Enter Return Date (dd-MM-yyyy): ");
                    LocalDate retDate = LocalDate.parse(sc.nextLine(), formatter);

                    double refund = employee.returnProduct(rssn, rProductID, purDate, retDate);
                    if (refund > 0)
                        System.out.println("Product returned successfully! Refund = " + refund);
                    else
                        System.out.println("Return failed (invalid date, product, or time limit).");
                    break;

                // Apply payment
                case 6:
                    System.out.print("Enter Customer SSN: ");
                    String pssn = sc.nextLine();
                    System.out.print("Enter Purchase Date (dd-MM-yyyy): ");
                    LocalDate payDate = LocalDate.parse(sc.nextLine(), formatter);

                    boolean paid = employee.applyPayment(pssn, payDate);
                    if (paid)
                        System.out.println("Payment marked as PAID!");
                    else
                        System.out.println("Payment failed (record not found or already paid).");
                    break;

                // Logout and save
                case 7:
                    System.out.println("Saving data and exiting...");
                    employee.logout();
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
                    break;
            }
        }
    }
}
