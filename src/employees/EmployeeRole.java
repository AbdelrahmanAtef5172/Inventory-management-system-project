package employees;

import product.Product;
import product.ProductDataBase;
import customer.CustomerProduct;
import customer.CustomerProductDatabase;

public class EmployeeRole {

    private ProductDataBase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() {
        productsDatabase = new ProductDatabase("Products.txt");
        customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
    }

    public void addProduct(String productID, String productName, String manufacturerName,
            String supplierName, int quantity) {
        Product newProduct = new Product(productID, productName, manufacturerName,
                supplierName, quantity);
        productsDatabase.insertRecord(newProduct);
    }

    public Product[] getListOfProducts() {
        return productsDatabase.returnAllRecords().toArray(new Product[0]);
    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        return customerProductDatabase.returnAllRecords().toArray(new CustomerProduct[0]);
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        Product product = productsDatabase.getRecord(productID);
        if (product == null || product.getQuantity() <= 0) {
            return false;
        }

        // Decrease quantity and update product
        product.setQuantity(product.getQuantity() - 1);
        productsDatabase.updateRecord(product);

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

        String searchKey = customerSSN + "," + productID + "," + purchaseDate;
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
        productsDatabase.updateRecord(product);
        customerProductDatabase.deleteRecord(searchKey);

        return product.getPrice();
    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) {
        CustomerProduct[] purchases = getListOfPurchasingOperations();
        for (CustomerProduct purchase : purchases) {
            if (purchase.getCustomerSSN().equals(customerSSN) &&
                    purchase.getPurchaseDate().equals(purchaseDate)) {
                if (!purchase.isPaid()) {
                    purchase.setPaid(true);
                    customerProductDatabase.updateRecord(purchase);
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public void logout() {
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }

}
