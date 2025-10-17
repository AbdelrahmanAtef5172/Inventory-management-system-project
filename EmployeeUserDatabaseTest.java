package employees;

import java.util.*;

public class EmployeeUserDatabaseTest {
    public static void main(String[] args) {
        EmployeeUserDatabase db = new EmployeeUserDatabase("data/employees.txt");
        db.readFromFile();

        ArrayList list = db.getAll();
        for(int i=0;i<list.size();i++){
            EmployeeUser e=(EmployeeUser)list.get(i);
            System.out.print(e.lineRepresentation());
        }

        System.out.println("----- After changes -----");
        db.add(new EmployeeUser("E9999","New User","new@gmail.com","City","0110000000"));
        db.delete("E1200");
        db.saveToFile();

        db.readFromFile();
        list=db.getAll();
        for(int i=0;i<list.size();i++){
            EmployeeUser e=(EmployeeUser)list.get(i);
            System.out.print(e.lineRepresentation());
        }
    }
}
