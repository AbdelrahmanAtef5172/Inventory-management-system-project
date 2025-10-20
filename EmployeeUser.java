package employees;

import abstracts.Recordable;

public class EmployeeUser implements Recordable {
    private String id;
    private String name;
    private String email;
    private String address;
    private String phone;

    public EmployeeUser(String id,String name,String email,String address,String phone){
        this.id=id;
        this.name=name;
        this.email=email;
        this.address=address;
        this.phone=phone;
    }

    @Override
    public String getSearchKey(){
        return id;
    }

    @Override
    public String lineRepresentation(){
        return id+","+name+","+email+","+address+","+phone+"\n";
    }

    public String getId(){return id;}
    public String getName(){return name;}
    public String getEmail(){return email;}
    public String getAddress(){return address;}
    public String getPhone(){return phone;}
}
