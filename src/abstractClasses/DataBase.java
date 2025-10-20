package abstractClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class DataBase<T extends Common>{

    //CLASS ATTRIBUTES
    private  String fileName;
    private ArrayList<T> records;

    //CLASS CONSTRUCTOR
    public DataBase(String fileName) {
        this.fileName = fileName.trim();
        this.records = new ArrayList<>();}

    //METHOD TO READ THE DATA FROM THE FILE
    public void readFromFile() throws FileNotFoundException {
        this.records.clear();  //clears the previous records in arraylist
        File file = new File(this.fileName);
        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNextLine()) {
            this.records.add(createRecordFrom(fileReader.nextLine())); }
        //now the array list contains all the records in the file
        fileReader.close();}

    //ABSTRACT METHOD TO CREATE RECORD FROM STRING LINE
    public abstract T createRecordFrom(String line);

    //METHOD TO RETURN ARRAYLIST OF ALL RECORDS
    public ArrayList<T> returnAllRecords() {
        return this.records;}

    //METHOD TO CHECK IF THE KEY IS IN DATABASE OR NOT
    public boolean contains(String key) {
        key = key.trim();
        for (int i = 0; i < this.records.size(); i++) {
            if (key.equals(records.get(i).getSearchKey())) {
                return true;}}
        return false;}

    //METHOD TO RETURN THE INSTANCE BY THE KEY
    public T getRecord(String key) {
        key = key.trim();
        for (int i = 0; i < this.records.size(); i++) {
            if (key.equals(records.get(i).getSearchKey())) {
                return records.get(i);}}
        return null;}

    //METHOD TO INSERT NEW RECORD IN THE ARRAY LIST
    public void insertRecord(T record) {
        if (!contains(record.getSearchKey())) {
            this.records.add(record);}}

    //METHOD TO REMOVE RECORD USING EMPLOYEE ID
    public void deleteRecord(String key) {
        T employ = getRecord(key);
        if (employ != null) {
            this.records.remove(employ);}}

    // METHOD TO WRITE IN THE FILE
    public void saveToFile() throws FileNotFoundException , IOException {
        FileWriter fileWriter = new FileWriter(this.fileName);
        if (this.records.isEmpty()) {
            System.out.println("No records to save.");
            return; }
        for (int i = 0; i < this.records.size(); i++) {
            fileWriter.write(this.records.get(i).lineRepresentation());}
        fileWriter.close();}
}
