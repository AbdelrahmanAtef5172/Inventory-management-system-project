package customer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import abstractClasses.Common;


public class CustomerProduct extends Common {
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private Boolean paid;

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
    }

    public String getCustomerSSN() {
        return customerSSN;
    }
    public String getProductID() {
        return productID;
    }
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    public Boolean isPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public  String lineRepresentation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return customerSSN + "," + productID + "," + purchaseDate.format(formatter) + "," + paid.toString();
    }

    public  String getSearchKey() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return customerSSN + "," + productID + "," + purchaseDate.format(formatter);
    }
    
}
