package employees;

import product.Product;
import product.ProductDataBase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import customer.CustomerProduct;
import customer.CustomerProductDatabase;
import employees.EmployeeUser;
import java.io.FileNotFoundException;

public class EmployeeRole {

    private ProductDataBase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() throws FileNotFoundException {
        productsDatabase = new ProductDataBase("data/Products.txt");
        productsDatabase.readFromFile();

        customerProductDatabase = new CustomerProductDatabase("data/CustomersProducts.txt");
        customerProductDatabase.readFromFile();

    }

    public void addProduct(String productID, String productName, String manufacturerName,String supplierName, int quantity) {
        Product newProduct = new Product(productID, productName, manufacturerName, supplierName, quantity);
        productsDatabase.insertRecord(newProduct);
    }

    public Product[] getListOfProducts() throws FileNotFoundException {
        //cast array list to array and return
        return productsDatabase.returnAllRecords().toArray(Product[]::new);
    }

    public CustomerProduct[] getListOfPurchasingOperations() throws FileNotFoundException {
        return customerProductDatabase.returnAllRecords().toArray(CustomerProduct[]::new);
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        Product product = productsDatabase.getRecord(productID);
        if (product == null || product.getQuantity() <= 0) {
            return false;
        }

        // Decrease quantity and insert product
        product.setQuantity(product.getQuantity() - 1);
        productsDatabase.insertRecord(product);

        // Create new purchase record
        CustomerProduct purchase = new CustomerProduct(customerSSN, productID, purchaseDate);
        customerProductDatabase.insertRecord(purchase);

        return true;
    }

    public double returnProduct(String customerSSN, String productID,
                                LocalDate purchaseDate, LocalDate returnDate) {
        // Validate return conditions
        if (returnDate.isBefore(purchaseDate)) {
            return -1;
        }

        Product product = productsDatabase.getRecord(productID);
        if (product == null) {
            return -1;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String searchKey = customerSSN + "," + productID + "," + purchaseDate.format(formatter);
        CustomerProduct purchase = customerProductDatabase.getRecord(searchKey);
        if (purchase == null) {
            return -1;
        }

        long daysBetween = ChronoUnit.DAYS.between(purchaseDate, returnDate);
        if (daysBetween > 14) {
            return -1;
        }

        // Process return
        product.setQuantity(product.getQuantity() + 1);
        customerProductDatabase.deleteRecord(searchKey);
        productsDatabase.deleteRecord(searchKey);
        productsDatabase.insertRecord(product);
        try {
            productsDatabase.saveToFile();
            customerProductDatabase.saveToFile();
        } catch (Exception e) {
            System.err.println("File not found: " + e.getMessage());
        }

        return product.getPrice();
    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) throws FileNotFoundException {
        CustomerProduct[] purchases = getListOfPurchasingOperations();
        for (CustomerProduct purchase : purchases) {//easier to read
            if (purchase.getCustomerSSN().equals(customerSSN) && purchase.getPurchaseDate().equals(purchaseDate)) {
                if (!purchase.isPaid()) {
                    purchase.setPaid(true);
                    customerProductDatabase.deleteRecord(purchase.getSearchKey());
                    customerProductDatabase.insertRecord(purchase);
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public void logout() {
        try {
            productsDatabase.saveToFile();
            customerProductDatabase.saveToFile();
        } catch (Exception e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }

}
