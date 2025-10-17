package employees;

public class AdminRoleTest {
    public static void main(String[] args) {
        AdminRole admin=new AdminRole();
        admin.addEmployee("A5555","Test Name","test@gmail.com","City","0100000000");
        admin.removeEmployee("E1200");
        EmployeeUser[] arr=admin.getList();
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i].lineRepresentation());
        }
        admin.logout();
    }
}
