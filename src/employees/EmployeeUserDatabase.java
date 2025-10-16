package employees;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class EmployeeUserDatabase {

    //CLASS ATTRIBUTES
    private final String fileName;
    private ArrayList<EmployeeUser> records;

    //CLASS CONSTRUCTOR
    public EmployeeUserDatabase(String fileName) {
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

    //METHOD TO CREATE INSTANCE FROM A FILE LINE
    public EmployeeUser createRecordFrom(String line) {
        String[] employeeDataArray = line.split(",");
        String employeeId = employeeDataArray[0];
        String employeeName = employeeDataArray[1];
        String employeeEmail = employeeDataArray[2];
        String employeeAddress = employeeDataArray[3];
        String employeePhoneNumber = employeeDataArray[4];
        return new EmployeeUser(employeeId, employeeName, employeeEmail, employeeAddress, employeePhoneNumber);}

    //METHOD TO RETURN ARRAYLIST OF ALL RECORDS
    public ArrayList<EmployeeUser> returnAllRecords() {
        return this.records;}

    //METHOD TO CHECK IF THE EMPLOYEE IS IN DATABASE USING THE ID
    public boolean contains(String key) {
        key = key.trim();
        for (int i = 0; i < this.records.size(); i++) {
            if (key.equals(records.get(i).getSearchKey())) {
                return true;}}
        return false;}

    //METHOD TO RETURN THE INSTANCE BY THE EMPLOYEE ID
    public EmployeeUser getRecord(String key) {
        key = key.trim();
        for (int i = 0; i < this.records.size(); i++) {
            if (key.equals(records.get(i).getSearchKey())) {
                return records.get(i);}}
        return null;}

    //METHOD TO INSERT NEW OBJECT IN THE ARRAY LIST
    public void insertRecord(EmployeeUser record) {
        if (!contains(record.getSearchKey())) {
            this.records.add(record);}}

    //METHOD TO REMOVE RECORD USING EMPLOYEE ID
    public void deleteRecord(String key) {
        EmployeeUser employ = getRecord(key);
        if (employ != null) {
            this.records.remove(employ);}}

    // METHOD TO WRITE IN THE FILE
    public void saveToFile() throws FileNotFoundException ,IOException {
        FileWriter fileWriter = new FileWriter(this.fileName);
        if (this.records.isEmpty()) {
            System.out.println("Warning: No records to save.");
            return; }
        for (int i = 0; i < this.records.size(); i++) {
            fileWriter.write(this.records.get(i).lineRepresentation());}
        fileWriter.close();}
}

