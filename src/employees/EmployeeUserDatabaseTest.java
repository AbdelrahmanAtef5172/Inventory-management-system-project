package employees;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeUserDatabaseTest {
   public static void main(String[] args) throws IOException {
       EmployeeUserDatabase db = new EmployeeUserDatabase("data/employees.txt");
       //READING THE DATA FROM THE FILE
       db.readFromFile();
       // RETURNING ALL THE RECORDS IN ARRAYLIST FORM
       ArrayList<EmployeeUser> employees = db.returnAllRecords();
       // ITERATING OVER THE ARRAYLIST TO PRINT RECORDS
       for (int i=0;i<employees.size();i++){
           System.out.print(employees.get(i).lineRepresentation());}
       System.out.println("----------------------------------");
       // ADDING AN EMPLOYEE TO THE ARRAYLIST
       db.insertRecord(new EmployeeUser("E5613","mona ahmed" , "monaa@gmail.com","menia","01201996641"));
       //DELETING THE FIRST RECORD IN THE FILE
       db.deleteRecord("E1201");
       //SAVING THE CHANGED DATA TO THE FILE
       db.saveToFile();
       //READ THE DATA FROM THE FILE AGAIN
       db.readFromFile();
       //RETURN ALL RECORDS IN ARRAYLIST FORM
       employees =  db.returnAllRecords();
       // ITERATING OVER THE ARRAYLIST TO PRINT RECORDS
       for(int i=0;i<employees.size();i++){
           System.out.print(employees.get(i).lineRepresentation());}
   }


}
