package employees;

public class EmployeeUserTest {
    public static void main(String[] args) {
        EmployeeUser e1=new EmployeeUser("E1000","Ahmed Ali","ahmed@gmail.com","Alex","0100000000");
        EmployeeUser e2=new EmployeeUser("E2000","Sara Mostafa","sara@gmail.com","Cairo","0111111111");

        System.out.print(e1.lineRepresentation());
        System.out.print(e2.lineRepresentation());
    }
}
