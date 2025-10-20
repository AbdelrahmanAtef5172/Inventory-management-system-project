package employees;

import abstracts.Recordable;

public class Product implements Recordable {
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private double price;

    public Product(String productID, String productName, String manufacturerName,
                   String supplierName, int quantity, double price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void sellOne() {
        if (quantity > 0) {
            quantity--;
        } else {
            System.out.println("No more units available to sell for product " + productID);
        }
    }

    public void returnOne() {
        quantity++;
    }

    @Override
    public String lineRepresentation() {
        return productID + "," + productName + "," + manufacturerName + "," +
               supplierName + "," + quantity + "," + price + "\n";
    }

    @Override
    public String getSearchKey() {
        return productID;
    }

    public String getProductID() { return productID; }
    public String getProductName() { return productName; }
    public String getManufacturerName() { return manufacturerName; }
    public String getSupplierName() { return supplierName; }
    public double getPrice() { return price; }
}
