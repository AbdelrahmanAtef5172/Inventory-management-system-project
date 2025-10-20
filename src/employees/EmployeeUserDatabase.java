package employees;
import abstractClasses.DataBase;

public class EmployeeUserDatabase extends DataBase<EmployeeUser> {

    // CLASS CONSTRUCTOR
    public EmployeeUserDatabase(String fileName) {
        super(fileName);}

    //IMPLEMENTATION OF ABSTRACT METHOD FROM DATABASE
    @Override
    public EmployeeUser createRecordFrom(String line) {
        String[] employeeDataArray = line.split(",");
        String employeeId = employeeDataArray[0];
        String employeeName = employeeDataArray[1];
        String employeeEmail = employeeDataArray[2];
        String employeeAddress = employeeDataArray[3];
        String employeePhoneNumber = employeeDataArray[4];
        return new EmployeeUser(employeeId, employeeName, employeeEmail, employeeAddress, employeePhoneNumber);}
}

