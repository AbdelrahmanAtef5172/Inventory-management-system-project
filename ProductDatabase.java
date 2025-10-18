package employees;

import java.io.*;
import java.util.*;

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
            if (!f.exists()) {
                System.out.println("File not found: " + file);
                return;
            }

            Scanner in = new Scanner(f);
            while (in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (line.isEmpty()) continue;

                Product p = createRecordFrom(line);
                list.add(p);
            }

            in.close();
            System.out.println("Products loaded successfully from " + file);
        } catch (Exception e) {
            System.out.println("Error reading product file: " + e.getMessage());
        }
    }

    public Product createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length < 6) return null;

        String productID = parts[0];
        String productName = parts[1];
        String manufacturerName = parts[2];
        String supplierName = parts[3];
        int quantity = Integer.parseInt(parts[4]);
        double price = Double.parseDouble(parts[5]);

        return new Product(productID, productName, manufacturerName, supplierName, quantity, price);
    }

    public ArrayList<Product> returnAllRecords() {
    return list;
}


    public boolean contains(String key) {
        for (int i = 0; i < list.size(); i++) {
            Product p = (Product) list.get(i);
            String productKey = p.getSearchKey();

            if (productKey.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Product getRecord(String key) {
        for (int i = 0; i < list.size(); i++) {
            Product p = (Product) list.get(i);
            String productKey = p.getSearchKey();

            if (productKey.equals(key)) {
                return p; // found
            }
        }

        // not found
        return null;
    }

    public void insertRecord(Product record) {
        String key = record.getSearchKey();

        if (contains(key)) {
            System.out.println("Product with ID " + key + " already exists.");
        } else {
            list.add(record);
            System.out.println("Product added: " + key);
        }
    }

    public void deleteRecord(String key) {
        Product p = getRecord(key);

        if (p != null) {
            list.remove(p);
            System.out.println("Product deleted: " + key);
        } else {
            System.out.println("Product not found: " + key);
        }
    }

    @Override
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(file);

            for (int i = 0; i < list.size(); i++) {
                Product p = (Product) list.get(i);
                writer.write(p.lineRepresentation());
            }

            writer.close();
            System.out.println("Products saved successfully to " + file);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
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
