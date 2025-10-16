package employees;
public class EmployeeUserTest {
    public static void main(String[] args) {
        EmployeeUser employee1 = new EmployeeUser("E1000" , "Abdelrahman Atef","abdelrahmanatef426@gmail.com"
                                             ,"Alexandria","01000715531");
        EmployeeUser employee2 = new EmployeeUser("E2000" , "Nour Alaa","NourAlaa.m@gmail.com"
                                              ,"cairo","01000918861");
        System.out.print(employee2.lineRepresentation());
        System.out.print(employee1.lineRepresentation());
        System.out.println("---------------------------------");
        employee2.setEmployeeId("3456");  // doesn't start with letter
        employee2.setEmployeePhoneNumber("12345678910"); // not proper format
        employee2.setEmployeeEmail("Nouralla@gmail"); // not proper format
        employee2.setEmployeeName(""); // empty name
        // all of them should throw illegal argument exception
        }
}
