package employees;

import java.io.IOException;

public class AdminRoleTest {
    public static void main(String[] args) throws IOException {
        AdminRole admin = new AdminRole();
        admin.addEmployee("A1234","Atef Nasreldin","atef.nasr@gmail.com",
                           "Alexandria","01000716601");
        admin.removeEmployee("E1200");
        EmployeeUser[] allEmployees = admin.getListOfEmployees();
        for(int i=0; i<allEmployees.length ;i++){
            System.out.print(allEmployees[i].lineRepresentation());}
        admin.logout();}
}
