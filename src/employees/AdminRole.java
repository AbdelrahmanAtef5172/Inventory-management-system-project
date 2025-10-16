package employees;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AdminRole {

    //CLASS ATTRIBUTES
    private EmployeeUserDatabase db;

    //CLASS CONSTRUCTOR
    public AdminRole() throws FileNotFoundException{
        this.db = new EmployeeUserDatabase("data/employees.txt");
        db.readFromFile();}

    //METHOD THAT ADD NEW EMPLOYEE TO THE FILE
    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber)
            throws FileNotFoundException , IOException{
        EmployeeUser employ = new EmployeeUser(employeeId, name, email, address, phoneNumber);
        db.insertRecord(employ);}

    //METHOD TO RETURN ALL EMPLOYEES IN ARRAY FORM
    public EmployeeUser[] getListOfEmployees(){
        ArrayList<EmployeeUser> allEmployees = db.returnAllRecords();
        EmployeeUser[] employeeArray = new EmployeeUser[allEmployees.size()];
        return allEmployees.toArray(employeeArray);}

    //METHOD TO REMOVE EMPLOYEE  IN THE FILE
    public void removeEmployee(String key){
        ArrayList<EmployeeUser> employees = db.returnAllRecords();
        EmployeeUser employee = db.getRecord(key);
        if(employee!=null){
            db.deleteRecord(key);}}

    //Method to save all unsaved data before logging out
    public void logout() throws IOException{
        db.saveToFile();}
}

