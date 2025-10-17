package employees;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductDatabase extends BaseDatabase {

    public ProductDatabase(String file) {
        super(file);
        this.list = new ArrayList();
    }

    @Override
    public void readFromFile() {
        try {
            list.clear();
            File f = new File(file);
            if (!f.exists()) return;
            Scanner in = new Scanner(f);
            while (in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (line.isEmpty()) continue;
                Product p = createRecordFrom(line);
                list.add(p);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error reading product file");
        }
    }

    public Product createRecordFrom(String line) {
        String[] parts = line.split(",");
        String productID = parts[0];
        String productName = parts[1];
        String manufacturerName = parts[2];
        String supplierName = parts[3];
        int quantity = Integer.parseInt(parts[4]);
        float price = Float.parseFloat(parts[5]);
        return new Product(productID, productName, manufacturerName, supplierName, quantity, price);
    }

    public ArrayList returnAllRecords() {
        return list;
    }

    public boolean contains(String key) {
        for (int i = 0; i < list.size(); i++) {
            Product p = (Product) list.get(i);
            if (p.getSearchKey().equals(key)) return true;
        }
        return false;
    }

    public Product getRecord(String key) {
        for (int i = 0; i < list.size(); i++) {
            Product p = (Product) list.get(i);
            if (p.getSearchKey().equals(key)) return p;
        }
        return null;
    }

    public void insertRecord(Product record) {
        if (!contains(record.getSearchKey())) list.add(record);
    }

    public void deleteRecord(String key) {
        Product p = getRecord(key);
        if (p != null) list.remove(p);
    }

    @Override
    public void saveToFile() {
        try {
            FileWriter out = new FileWriter(file);
            for (int i = 0; i < list.size(); i++) {
                Product p = (Product) list.get(i);
                out.write(p.lineRepresentation());
            }
            out.close();
        } catch (Exception e) {
            System.out.println("Error saving product file");
        }
    }

    @Override
    public Recordable get(String key) {
        return getRecord(key);
    }

    @Override
    public void add(Recordable r) {
        insertRecord((Product) r);
    }

    @Override
    public void delete(String key) {
        deleteRecord(key);
    }
}
