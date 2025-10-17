/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employees;

/**
 *
 * @author ahmme
 */
import java.util.*;

public class ProductDatabaseTest {
    public static void main(String[] args) {
        ProductDatabase pdb = new ProductDatabase("data/Products.txt");
        pdb.readFromFile();

        System.out.println("--- All Products ---");
        ArrayList list = pdb.returnAllRecords();
        for (int i = 0; i < list.size(); i++) {
            Product p = (Product) list.get(i);
            System.out.print(p.lineRepresentation());
        }

        System.out.println("--- After Changes ---");
        pdb.insertRecord(new Product("P9999","Tablet","Apple","TechSupplier",5,3000));
        pdb.deleteRecord("P1001");
        pdb.saveToFile();

        pdb.readFromFile();
        list = pdb.returnAllRecords();
        for (int i = 0; i < list.size(); i++) {
            Product p = (Product) list.get(i);
            System.out.print(p.lineRepresentation());
        }
    }
}

