# 🏪 Inventory Management System

## 📘 Overview
This Java-based **Inventory Management System** is developed as part of the **Programming II (CC272)** course at **Alexandria University – Faculty of Engineering**.  
It demonstrates **Object-Oriented Programming (OOP)** principles such as **abstraction, inheritance, and polymorphism**.

The system manages two main user roles:
- **Admin** – manages employee records.
- **Employee** – manages products, customer purchases, and returns.

All data is stored in text files and handled through generic, reusable abstract classes for file operations.

---

## 🧱 Project Structure

```
src/
 ├── abstractClasses/
 │    ├── Common.java
 │    └── DataBase.java
 │
 ├── employees/
 │    ├── EmployeeUser.java
 │    ├── EmployeeUserDatabase.java
 │    └── AdminRole.java
 │
 ├── product/
 │    ├── Product.java
 │    └── ProductDataBase.java
 │
 └── customer/
      ├── CustomerProduct.java
      └── CustomerProductDatabase.java
```

---

## ⚙️ Abstract Classes

### **Common.java**
Defines the base behavior shared by all record entities.
```java
public abstract class Common {
    public abstract String lineRepresentation();
    public abstract String getSearchKey();
}
```
All data entities (`EmployeeUser`, `Product`, `CustomerProduct`) inherit from this class.

---

### **DataBase.java**
A generic abstract class (`T extends Common`) that provides reusable file-handling operations:
- Read and write records.
- Insert, delete, and search for records by key.
- Create objects from text file lines (via an abstract `createRecordFrom()` method).

All databases (`EmployeeUserDatabase`, `ProductDataBase`, `CustomerProductDatabase`) extend this class.

---

## 👥 Employees Package

### **EmployeeUser.java**
Represents an employee’s personal information.

#### Attributes & Constraints
| Attribute | Type | Description | Constraints |
|------------|------|--------------|--------------|
| `employeeId` | `String` | Unique ID for each employee | Must start with a letter, followed by digits (e.g., `E1200`), length > 4 |
| `employeeName` | `String` | Employee’s full name | Cannot be blank; must contain only letters and spaces |
| `employeeEmail` | `String` | Employee’s email address | Must end with `@gmail.com`, not blank, max length < 320 |
| `employeeAddress` | `String` | Employee’s address | Cannot be blank; length > 3 |
| `employeePhoneNumber` | `String` | Employee’s phone number | Must start with `01`; third digit ∈ {0,1,2,5}; length = 11; digits only |

#### Methods
- `lineRepresentation()` → comma-separated string for file storage.
- `getSearchKey()` → returns employee ID.

---

### **EmployeeUserDatabase.java**
Handles file I/O for employee records by extending `DataBase<EmployeeUser>`.

### **AdminRole.java**
Implements admin functionalities:
- Add and remove employees.
- View all employees.
- Save changes to file (`logout()`).

---

## 📦 Product Package

### **Product.java**
Represents product information in the store.

#### Attributes & Constraints
| Attribute | Type | Description | Constraints |
|------------|------|--------------|--------------|
| `productID` | `String` | Unique identifier for each product | Must start with a letter followed by digits (e.g., `P2394`), length > 4 |
| `productName` | `String` | Name of the product | Cannot be blank |
| `manufacturerName` | `String` | Manufacturer of the product | Cannot be blank |
| `supplierName` | `String` | Supplier providing the product | Cannot be blank |
| `quantity` | `int` | Available stock quantity | Must be ≥ 0 |
| `price` | `float` | Product price | Must be ≥ 0 |

#### Methods
- `lineRepresentation()` → formatted string for saving to file.
- `getSearchKey()` → returns product ID.

---

### **ProductDataBase.java**
Manages file reading/writing and record manipulation for products.  
Extends `DataBase<Product>` and implements `createRecordFrom(String line)`.

---

## 🧾 Customer Package

### **CustomerProduct.java**
Represents a purchase operation by a customer.

#### Attributes & Constraints
| Attribute | Type | Description | Constraints |
|------------|------|--------------|--------------|
| `customerSSN` | `String` | Unique customer identifier | Cannot be blank |
| `productID` | `String` | Purchased product ID | Cannot be blank |
| `purchaseDate` | `LocalDate` | Date of purchase | Stored in `dd-MM-yyyy` format |
| `paid` | `boolean` | Payment status | Default `false`; updated when payment is completed |

#### Methods
- `lineRepresentation()` → `"customerSSN,productID,DD-MM-YYYY,paid"`  
- `getSearchKey()` → `"customerSSN,productID,DD-MM-YYYY"`

---

### **CustomerProductDatabase.java**
Handles file reading, writing, and object creation for customer purchase records.  
Extends `DataBase<CustomerProduct>`.

---

## 🧠 OOP Principles Used
- **Abstraction:** via `Common` and `DataBase` abstract classes.  
- **Encapsulation:** private fields + public setters/getters with validation.  
- **Inheritance:** all record entities inherit from `Common`.  
- **Polymorphism:** generic file-handling through `DataBase<T>`.

---

## 💾 Data Storage Format
Data is saved in text files under the `/data` directory:

- **Employees.txt**
  ```
  E1200,Ahmed,ahmed_1999@gmail.com,Alexandria,01088877345
  ```
- **Products.txt**
  ```
  P2394,Laptop,Apple,TechSupplier,10,1500
  ```
- **CustomersProducts.txt**
  ```
  7845345678,P2568,12-02-2022,true
  ```


---

## 👨‍💻 Authors
**Abdelrahman Atef**  
**Galal Mohamed**
**Ahmed Hossam**
Programming II – Lab 4  
Fall 2025 / 2026  
Alexandria University – Faculty of Engineering  
