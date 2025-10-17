package employees;

import java.io.*;
import java.util.*;

public class EmployeeUserDatabase extends BaseDatabase {

    public EmployeeUserDatabase(String file){
        super(file);
    }

    @Override
    public void readFromFile(){
        try{
            list.clear();
            Scanner s=new Scanner(new File(file));
            while(s.hasNextLine()){
                String line=s.nextLine();
                String[] p=line.split(",");
                if(p.length<5)continue;
                EmployeeUser e=new EmployeeUser(p[0],p[1],p[2],p[3],p[4]);
                list.add(e);
            }
            s.close();
        }catch(Exception e){
            System.out.println("Error reading "+file);
        }
    }

    @Override
    public Recordable get(String key){
        for(int i=0;i<list.size();i++){
            EmployeeUser e=(EmployeeUser)list.get(i);
            if(e.getSearchKey().equals(key))return e;
        }
        return null;
    }

    @Override
    public void add(Recordable r){
        if(!contains(r.getSearchKey()))list.add(r);
    }

    @Override
    public void delete(String key){
        Recordable x=get(key);
        if(x!=null)list.remove(x);
    }
}
