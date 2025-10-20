package customer;
import abstractClasses.DataBase;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProductDatabase extends DataBase<CustomerProduct> {

    // CLASS CONSTRUCTOR
    public CustomerProductDatabase(String fileName) {
        super(fileName);}

    // IMPLEMENTATION OF ABSTRACT METHOD FROM DATABASE
    @Override
    public CustomerProduct createRecordFrom(String line) {
        String[] dataCustomerProduct = line.split(",");
        String customerSSN = dataCustomerProduct[0];
        String productID = dataCustomerProduct[1];
        String dateString = dataCustomerProduct[2];
        boolean paid = Boolean.parseBoolean(dataCustomerProduct[3]);
        //SPECIFYING THE PATTERN
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate purchaseDate = LocalDate.parse(dateString, date);
        //CREATING NEW OBJECT
        CustomerProduct record = new CustomerProduct(customerSSN, productID, purchaseDate);
        record.setPaid(paid);
        return record;}
}