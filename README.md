# 🏋️ GymPro Manager

## 👨‍🎓 Student Details

| Name                 | Student ID |
| -------------------- | ---------- |
| Kessoonath Surakshit | 2504_28537 |
| Sungkur Lagnesh      | 2504_01292 |

---

## 📜 Copyright & Academic Declaration

This project was developed as a partial fulfillment of the academic requirements for the module **BCNS2101C – Programming Techniques 2**, under the guidance of **Mr. GOPEE Ajit Kumar**.

© 2026 Kessoonath Surakshit & Sungkur Lagnesh. All rights reserved.

No part of this project, including its source code, documentation, reports, diagrams, or other materials, may be reproduced, stored in a retrieval system, or transmitted in any form or by any means, whether electronic, mechanical, photocopying, recording, or otherwise, without the prior written permission of the authors.

This project is intended solely for academic and educational purposes.

---

## 📌 Project Description

**GymPro Manager** is a Java console-based gym management system developed using **Object-Oriented Programming (OOP)** concepts.

The system enables gym administrators to efficiently manage gym operations including member registration, trainer management, attendance tracking, BMI calculation, payment processing, receipt generation, and report generation.

All records are stored permanently using **text file handling**, ensuring data persistence between program executions.

---

## ⚙️ Features

* Member Management (Add, View, Update, Delete)
* Premium Member Management
* Trainer Management
* Attendance Tracking
* BMI Calculation and Classification
* Payment Processing
* Receipt Generation
* Monthly Report Generation
* File-Based Data Persistence
* Input Validation
* Error Handling

---

## 💻 Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Java Collections Framework
* File Handling
* VS Code
* IntelliJ IDEA

---

## 🧠 OOP Concepts Used

| Concept               | Implementation in GymPro Manager                                                                                                                |
| --------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- |
| Inheritance           | `Member` and `Trainer` inherit common attributes and methods from `Person`. `PremiumMember` extends `Member`.                                   |
| Polymorphism          | Different member types can be treated as objects of the same parent class while performing specialized behaviors.                               |
| Encapsulation         | Class data is protected using private attributes with getters and setters.                                                                      |
| Abstraction           | Complex operations such as BMI calculation, validation, payment processing, and file handling are separated into dedicated classes.             |
| Composition           | `GymService` uses objects such as `Member`, `Trainer`, `Payment`, and `FileManager` to perform system operations.                               |
| Collections Framework | `ArrayList` is used to store and manage members, trainers, attendance records, and payments dynamically.                                        |
| Utility Classes       | `BMIUtil` and `ValidationUtil` provide reusable methods throughout the system.                                                                  |
| File Handling         | Data is stored and retrieved from text files such as `members.txt`, `PremiumMembers.txt`, `trainers.txt`, `payments.txt`, and `attendance.txt`. |

---

## 📁 Project Structure

```text
Java-Assignment/
│
├── src/
│   ├── Main.java
│   ├── GymService.java
│   ├── Person.java
│   ├── Member.java
│   ├── PremiumMember.java
│   ├── Trainer.java
│   ├── Attendance.java
│   ├── Payment.java
│   ├── MembershipPlan.java
│   ├── FileManager.java
│   ├── ReportGenerator.java
│   ├── BMIUtil.java
│   └── ValidationUtil.java
│
├── data/
│   ├── members.txt
│   ├── PremiumMembers.txt
│   ├── trainers.txt
│   ├── attendance.txt
│   ├── payments.txt
│   ├── receipts.txt
│   └── reports.txt
│
├── code_and_terminal_output.txt
└── README.md
```

---

## 📦 Class Description

### Main.java

The entry point of the application. It displays the main menu and invokes methods from `GymService`.

### GymService.java

Contains the core business logic of the system, including member management, trainer management, attendance tracking, payment processing, and report generation.

### Person.java

A parent class that stores common attributes such as ID, name, age, and phone number.

### Member.java

Represents a standard gym member. It inherits from `Person` and stores membership information, weight, height, and BMI details.

### PremiumMember.java

Extends `Member` and provides premium membership features, additional benefits, and discounts.

### Trainer.java

Represents gym trainers and stores trainer-specific information such as specialization and salary.

### Attendance.java

Stores and manages member attendance records.

### MembershipPlan.java

Handles membership plans, fee calculations, discounts, and final payment amounts.

### Payment.java

Stores payment information including payment ID, amount, payment method, and payment date.

### FileManager.java

Handles all file reading and writing operations for data persistence.

### ReportGenerator.java

Generates system reports such as monthly income reports and BMI reports.

### BMIUtil.java

Provides methods for BMI calculation and BMI category determination.

### ValidationUtil.java

Validates user input such as age, phone number, empty fields, and positive numeric values.

---

## 📂 Data Storage

| File               | Purpose                        |
| ------------------ | ------------------------------ |
| members.txt        | Stores standard member records |
| PremiumMembers.txt | Stores premium member records  |
| trainers.txt       | Stores trainer records         |
| attendance.txt     | Stores attendance records      |
| payments.txt       | Stores payment records         |
| receipts.txt       | Stores generated receipts      |
| reports.txt        | Stores generated reports       |

---

## ▶️ How to Run

### Compile the Project

```bash
javac src/*.java
```

### Run the Application

```bash
java -cp src Main
```

---

## 🎯 Learning Outcomes

This project demonstrates:

* Object-Oriented Programming Principles
* Inheritance and Polymorphism
* Encapsulation and Abstraction
* Java Collections Framework
* File Handling Techniques
* Input Validation
* Exception Handling
* Console-Based Application Development

---

## ✅ Conclusion

GymPro Manager is a practical Java-based gym management application that demonstrates the implementation of core Object-Oriented Programming concepts while providing real-world functionality through member management, trainer management, attendance tracking, payment processing, report generation, and persistent data storage using text files.

The project successfully integrates OOP principles, Java collections, file handling, validation techniques, and modular programming practices to create a maintainable and user-friendly management system.

---

## 👨‍💻 Developers

* Kessoonath Surakshit
* Sungkur Lagnesh

---

⭐ **Programming Techniques 2 (BCNS2101C) – Assignment Project**
