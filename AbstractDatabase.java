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

public abstract class AbstractDatabase<T extends Recordable>{
    protected String fileName;
    protected ArrayList<T> records;

    public AbstractDatabase(String fileName){
        this.fileName=fileName;
        this.records=new ArrayList<>();
    }

    public void readFromFile() throws IOException{
        records.clear();
        File f=new File(fileName);
        if(!f.exists())return;
        Scanner in=new Scanner(f);
        while(in.hasNextLine()){
            String line=in.nextLine().trim();
            if(line.isEmpty())continue;
            T record=createRecordFrom(line);
            records.add(record);
        }
        in.close();
    }

    public void saveToFile() throws IOException{
        FileWriter out=new FileWriter(fileName);
        for(T r:records)out.write(r.lineRepresentation());
        out.close();
    }

    public void insertRecord(T r){
        if(!contains(r.getSearchKey()))records.add(r);
    }

    public void deleteRecord(String key){
        T r=getRecord(key);
        if(r!=null)records.remove(r);
    }

    public boolean contains(String key){
        for(T r:records)if(r.getSearchKey().equals(key))return true;
        return false;
    }

    public T getRecord(String key){
        for(T r:records)if(r.getSearchKey().equals(key))return r;
        return null;
    }

    public ArrayList<T> returnAllRecords(){
        return records;
    }

    public abstract T createRecordFrom(String line);
}
