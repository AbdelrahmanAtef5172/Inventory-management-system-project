package employees;

import java.util.*;

public class AdminRole {
    private EmployeeUserDatabase db;

    public AdminRole(){
        db=new EmployeeUserDatabase("data/employees.txt");
        db.readFromFile();
    }

    public void addEmployee(String id,String name,String email,String address,String phone){
        EmployeeUser e=new EmployeeUser(id,name,email,address,phone);
        db.add(e);
    }

    public void removeEmployee(String key){
        db.delete(key);
    }

    public EmployeeUser[] getList(){
        ArrayList all=db.getAll();
        EmployeeUser[] arr=new EmployeeUser[all.size()];
        for(int i=0;i<all.size();i++){
            arr[i]=(EmployeeUser)all.get(i);
        }
        return arr;
    }

    public void logout(){
        db.saveToFile();
    }
}
