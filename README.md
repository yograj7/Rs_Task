# Java JDBC Projects – Student, Employee & Product Management (Oracle DB)

## 📌 Overview
This repository contains multiple **Java console-based applications** developed using **JDBC (Java Database Connectivity)** to interact with an **Oracle Database**.  
The projects demonstrate **secure and modular database operations**, covering the complete lifecycle from database connection to CRUD (Create, Read, Update, Delete) operations.

All applications use:
- **Oracle JDBC Driver**
- **SYSTEM user**
- **PreparedStatement (Parameterized Queries)**
- **Menu-driven switch-case programs**

This repository is suitable for **academic practicals and JDBC fundamentals**.


## 🛠️ Prerequisites
- Java Development Kit (JDK)
- Oracle Database (10g / 11g / XE)
- Oracle JDBC Driver (`ojdbc14.jar` or compatible)
- Username: `system`
- IDE: IntelliJ IDEA / Eclipse (optional)



## 🧩 Project 1: Student Management System

### 🔎 Description
The Student Management System consists of multiple Java applications designed to manage a `student` table in Oracle Database.  
It demonstrates JDBC operations such as inserting, fetching, updating, and deleting student records using **PreparedStatement**.



### 📂 Modules & Files

#### 1️⃣ Database Connection
- **File:** `DBConnection.java`
- **Purpose:** Establishes a connection to the Oracle Database using the SYSTEM user.
- **Output:** Displays *“Database connection successful”*.



#### 2️⃣ Fetch Student Records (Read)
- **File:** `Student.java`
- **Function:** Retrieves and displays all records from the `student` table.
- **Fields:** ID, Name, Age



#### 3️⃣ Insert Student (Create)
- **File:** `Input.java`
- **Function:** Accepts student details from the user using `Scanner` and inserts them into the table.
- **Security:** Uses parameterized queries (`PreparedStatement`).



#### 4️⃣ Update Student (Update)
- **File:** `Update.java`
- **Function:** Updates student marks using Student ID.
- **Query:** UPDATE student SET marks = ? WHERE id = ?;



#### 5️⃣ Delete Student (Delete)
- **File:** `Delete.java`
- **Function:** Deletes a student record permanently based on Student ID.
- **Query:** UPDATE student SET marks = ? WHERE id = ?;




## 🧩 Project 2: Employee Management System
### 🔎 Description

The Employee Management System manages employee records such as name, city, and contact number using Oracle Database.
It uses menu-driven switch-case logic and separates database operations from the main application.

### 📂 Features

Insert employee details

Update employee contact number

Display employees by city

Secure operations using PreparedStatement

#### 🗃️ Employee Table Fields

Employee ID

Employee Name

City

Contact Number



## 🧩 Project 3: Product Management System
📌 Description

The Product Management System handles product inventory operations using Oracle Database.
It allows administrators to create, insert, update, and delete product records.

### 📂 Features

Create product table

Insert product details

Update product quantity

Delete product by ID

### 🗃️ Product Table Fields

Product ID

Product Name

Price

Quantity



## 💻 Technical Highlights
### 🛡️ PreparedStatement (Parameterized Queries)

All database operations use PreparedStatement.

Benefits:

Prevents SQL Injection

Improves performance

Ensures secure input handling


## 👨‍💻 Author
####   Yograj Patil
