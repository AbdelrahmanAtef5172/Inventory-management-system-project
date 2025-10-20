package product;
import abstractClasses.Common;

public class Product extends Common {

    //CLASS ATTRIBUTES
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;

    //CLASS CONSTRUCTOR USING SETTER FOR CONSTRAINS AND VALIDATION
    public Product(String productID, String productName, String manufacturerName,
                   String supplierName, int quantity, float price){
        this.setPrice(price);
        this.setProductID(productID);
        this.setQuantity(quantity);
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;}

    @Override
    //GETTER AND SETTER FOR THE EMPLOYEE ID
    public String getSearchKey(){
        return this.productID;}
    public void setProductID(String id){
        id = id.trim();
        boolean exists = !id.isBlank();                        //constrain 1
        boolean validLength = id.length() >4 ;                 // constrain 2
        boolean validStart = Character.isLetter(id.charAt(0)); // constrain 3
        boolean validEnd = true;                               // constrain 4
        for(int i=1;i<id.length();i++){
            if(!Character.isDigit(id.charAt(i))){
                validEnd = false;
                break;}}
        if(exists && validLength && validStart && validEnd){
            this.productID =  id;
        }else{ throw new IllegalArgumentException("INVALID ID IS ENTERED ");}}

    //GETTER AND SETTER FOR THE QUANTITY
    public void setQuantity(int quantity){
        if(quantity>=0){
            this.quantity = quantity;
        }else{ throw new IllegalArgumentException("NUMBER CANT BE NEGATIVE ");}}
    public int getQuantity(){
        return  this.quantity;}

    //GETTER AND SETTER FOR THE PRICE
    public void setPrice(float price){
        if(price>=0){
            this.price = price;
        }else{ throw new IllegalArgumentException("NUMBER CANT BE NEGATIVE ");}}
    public float getPrice(){
        return  this.price;}

    //GETTER AND SETTER FOR PRODUCT NAME
    public String getProductName() {
        return productName;}
    public void setProductName(String productName) {
        this.productName = productName;}

    //GETTER AND SETTER FOR MANUFACTURER NAME
    public String getManufacturerName() {
        return manufacturerName;}
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;}

    //GETTER AND SETTER FOR THE SUPPLIER NAME
    public String getSupplierName() {
        return supplierName;}
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;}

    @Override
    public String lineRepresentation() {
        return  String.join(",",productID,productName,manufacturerName,supplierName,
                                   String.valueOf(quantity), price+"\n");}
}
