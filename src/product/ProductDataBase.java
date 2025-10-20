package product;
import abstractClasses.DataBase;


public class ProductDataBase extends DataBase<Product> {

    // CLASS CONSTRUCTOR
    public ProductDataBase(String fileName){
        super(fileName);}

    //IMPLEMENTATION OF ABSTRACT METHOD FROM DATABASE
    @Override
    public Product createRecordFrom(String line) {
        String[] productDataArray = line.split(",");
        String productId = productDataArray[0];
        String productName = productDataArray[1];
        String productManufacturer = productDataArray[2];
        String productSupplier = productDataArray[3];
        int productQuantity= Integer.parseInt(productDataArray[4]);
        float productPrice = Float.parseFloat(productDataArray[5]);
        return new Product(productId, productName, productManufacturer,productSupplier, productQuantity,productPrice);}
}
