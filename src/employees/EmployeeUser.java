package employees;
public class EmployeeUser {

    //CLASS ATTRIBUTES
    private String employeeId ;
    private String employeeName ;
    private String employeeEmail ;
    private String employeePhoneNumber ;
    private String employeeAddress ;


    //CLASS CONSTRUCTOR USING SETTERS FOR CONSTRAINS AND VALIDATION
    public EmployeeUser(String id , String name , String email ,String address , String phoneNumber ){
        this.setEmployeeId(id);
        this.setEmployeeName(name);
        this.setEmployeeEmail(email);
        this.setEmployeeAddress(address);
        this.setEmployeePhoneNumber(phoneNumber);}


    //GETTER AND SETTERS FOR THE EMPLOYEE NAME
    public String getEmployeeName(){
        return this.employeeName;}
    public void setEmployeeName(String name){
        name = name.trim();
        boolean exists = !name.isBlank();   // constrain 1
        boolean allLetters = true ;         // constrain 2
        for(int i=0 ; i<name.length();i++){
            if(! Character.isLetter(name.charAt(i)) && !Character.isWhitespace(name.charAt(i)) ){
                allLetters = false;
                break;}}
        if(exists && allLetters){
            this.employeeName = name;
        }else{ throw new IllegalArgumentException("INVALID NAME IS ENTERED ");}}


    //GETTER AND SETTER FOR THE EMPLOYEE EMAIL
    public String getEmployeeEmail (){
        return this.employeeEmail;}
    public void setEmployeeEmail(String email){
        email =email.trim();
        boolean exists = !email.isBlank();                                                // constrain 1
        boolean endsCorrectly = email.endsWith("@gmail.com");                             // constrain 2
        boolean validLength = email.length()<320 ;                                        // constrain 3
        boolean validLocalLength = endsCorrectly && !email.split("@")[0].isEmpty(); // constrain 4
        if(exists && endsCorrectly && validLength && validLocalLength){
            this.employeeEmail = email;
        }else{ throw new IllegalArgumentException("INVALID EMAIL IS ENTERED "); }}


    //GETTER AND SETTER FOR THE EMPLOYEE ADDRESS
    public String getEmployeeAddress(){
        return this.employeeAddress;}
    public void setEmployeeAddress(String address){
        address = address.trim();
        boolean exists = !address.isBlank() ;     // constrain 1
        boolean validLength = address.length()>4; // constrain 2
        if(exists && validLength){
            this.employeeAddress = address;
        }else{ throw new IllegalArgumentException("Invalid address is entered");}}


    //GETTER AND SETTER FOR THE EMPLOYEE PHONE NUMBER
    public String getEmployeePhoneNumber(){
        return this.employeePhoneNumber;}
    public void setEmployeePhoneNumber(String phoneNumber){
        phoneNumber = phoneNumber.trim();
        boolean exists = !phoneNumber.isBlank();                // constrain 1
        boolean startsCorrectly = phoneNumber.startsWith("01"); // constrain 2
        boolean hasValidThirdDigit = phoneNumber.charAt(2) == '1' || phoneNumber.charAt(2) == '2'||
                phoneNumber.charAt(2) == '5' || phoneNumber.charAt(2) == '0'; //constrain 3
        boolean validLength = phoneNumber.length()==11;                       //constrain 4
        boolean allDigits= true ;                                             // constrain 5
        for (int i = 0;i< phoneNumber.length();i++){
            if(!Character.isDigit(phoneNumber.charAt(i))){
                allDigits = false;
                break;}}
        if(exists && startsCorrectly && hasValidThirdDigit && validLength && allDigits){
            this.employeePhoneNumber = phoneNumber;
        }else{ throw new IllegalArgumentException("INVALID PHONE NUMBER IS ENTERED ");}}


    //GETTER AND SETTER FOR THE EMPLOYEE ID
    public String getSearchKey(){
        return this.employeeId;}
    public void setEmployeeId(String id){
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
            this.employeeId =  id;
        }else{ throw new IllegalArgumentException("INVALID ID IS ENTERED ");}}


    //METHOD TO RETURN THE EMPLOYEE DATA IN STRING LINE REPRESENTATION
    public String lineRepresentation(){
        return String.join(",",this.employeeId , this.employeeName ,
                this.employeeEmail , this.employeeAddress , this.employeePhoneNumber+"\n");}
}
