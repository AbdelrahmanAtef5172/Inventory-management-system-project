package customer;


import java.time.LocalDate;

public class CustomerProduct implements Recordable {
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

    public  lineRepresentation() {
        return customerSSN + "," + productID + "," + purchaseDate.toString() + "," + paid.toString();
    }

    public  getSearchKey() {
        return customerSSN + "," + productID + "," + purchaseDate.toString();
    }
    
}
