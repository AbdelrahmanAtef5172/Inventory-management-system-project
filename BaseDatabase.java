/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employees;

/**
 *
 * @author ahmme
 */
import java.io.*;
import java.util.*;

public abstract class BaseDatabase {
    protected String file;
    protected ArrayList list;

    public BaseDatabase(String file){
        this.file=file;
        this.list=new ArrayList();
    }

    public void saveToFile(){
        try{
            FileWriter w=new FileWriter(file);
            for(int i=0;i<list.size();i++){
                Recordable r=(Recordable)list.get(i);
                w.write(r.lineRepresentation());
            }
            w.close();
        }catch(Exception e){
            System.out.println("Error saving "+file);
        }
    }

    public boolean contains(String key){
        for(int i=0;i<list.size();i++){
            Recordable r=(Recordable)list.get(i);
            if(r.getSearchKey().equals(key))return true;
        }
        return false;
    }

    public ArrayList getAll(){
        return list;
    }

    public abstract void readFromFile();
    public abstract Recordable get(String key);
    public abstract void add(Recordable r);
    public abstract void delete(String key);
}
