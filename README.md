# 🎓 College Management System

A Java-based console application for managing a college's academic staff, departments, and committees.

This project was developed as part of the **Object-Oriented Programming** course at **Afeka College of Engineering**. It demonstrates fundamental OOP principles, exception handling, interfaces, file serialization, and data management.

---

## 📋 Features

- 👨‍🏫 Add and remove lecturers
- 🏛️ Create and manage departments
- 👥 Create academic committees
- 👑 Assign qualified lecturers as committee chairpersons
- 📚 Manage lecturer academic degrees
- 🔍 Search and display college information
- ⚠️ Validate user input using custom exceptions
- 💾 Save and load the entire system using Java serialization

---

## 🏗️ Project Structure

```
src/
├── College.java
├── Lecturer.java
├── Department.java
├── Committee.java
├── CommitteeHeadable.java
├── Exceptions.java
├── Main.java
└── ...
```

---

## 🧠 Concepts Demonstrated

- Object-Oriented Programming (OOP)
- Encapsulation
- Inheritance
- Polymorphism
- Interfaces
- Abstract Classes
- Custom Exceptions
- Java Collections (`ArrayList`)
- File I/O
- Object Serialization
- Console-Based User Interface

---

## 🛠️ Technologies

- Java
- Eclipse IDE
- Git & GitHub

---

## ▶️ Getting Started

### Prerequisites

- Java Development Kit (JDK 17 or later)
- Eclipse IDE (recommended) or IntelliJ IDEA

### Clone the Repository

```bash
git clone https://github.com/MuffinCat1/College-Management-System.git
```

### Run the Project

1. Open the project in your preferred Java IDE.
2. Build the project.
3. Run the `Main` class.
4. Follow the console menu.

---

## 💾 Data Persistence

The application supports saving and loading the college data using Java object serialization.

Stored data includes:

- Lecturers
- Departments
- Committees
- Relationships between objects

---

## 📂 Main Classes

| Class | Description |
|-------|-------------|
| `College` | Central class that manages the entire system |
| `Lecturer` | Represents a lecturer and their academic information |
| `Department` | Represents an academic department |
| `Committee` | Represents a college committee |
| `CommitteeHeadable` | Interface implemented by lecturers eligible to chair committees |
| `Exceptions` | Collection of custom exception classes |
| `Main` | Console application entry point |

---

## 📖 What I Learned

Through this project I gained practical experience with:

- Designing object-oriented software
- Building relationships between multiple classes
- Exception handling and validation
- Serialization and persistent storage
- Writing maintainable Java code
- Applying software engineering principles

---

## 🚀 Future Improvements

- Graphical User Interface (JavaFX or Swing)
- Database integration (MySQL/PostgreSQL)
- Search and filtering capabilities
- User authentication
- REST API implementation
- Unit testing with JUnit

---

## 👨‍💻 Authors

**Matan Shemaya & Shelly Roit**

Computer Engineering Students  
Afeka College of Engineering

- GitHub: https://github.com/MuffinCat1, https://github.com/ShellyRoit
- LinkedIn: https://www.linkedin.com/in/matan-shemaya-5b4498413/

---

## 📄 License

This project was created for educational purposes as part of coursework at Afeka College of Engineering.
