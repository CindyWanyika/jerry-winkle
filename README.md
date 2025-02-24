
# **CharityKonekt 💙✨**
*A platform connecting generous hearts with those in need.*

## **Overview**
CharityKonekt is a **donation management platform** designed to connect donors with charitable organizations in their local area. Many individuals want to give back but struggle to find organizations that align with their causes. This platform makes it **easy to locate charities, understand their needs, and donate efficiently**.

### **The Problem**
Many potential donors face challenges such as:
- **Limited access to information** about nearby charities.
- **Uncertainty about specific needs** of organizations.
- **Lack of a structured donation process**, leading to misallocation of resources.

### **Our Solution**
CharityKonekt addresses these issues by:  
✅ **Providing a centralized platform** to find and support local charities.  
✅ **Using a MySQL database** to store and manage donation records.  
✅ **Allowing search and filtering**, enabling donors to contribute to causes they care about.  
✅ **Simplifying the donation process**, ensuring aid reaches those who need it.

### **Impact**
By streamlining connections between donors and organizations, CharityKonekt:  
🌍 **Encourages more people to give** by making the process simple and accessible.  
💙 **Ensures charities receive exactly what they need** at the right time.  
🚀 **Empowers communities** by fostering collaboration between individuals and aid organizations.

---

## **Features**
✔️ **Find Charities** – Locate organizations that need donations.  
✔️ **Easy Donations** – Connect with charities and contribute effortlessly.  
✔️ **Search & Filter** – Browse charities by category, location, and type of support needed.  
✔️ **Track Donations** – View and manage past donations.  
✔️ **User-Friendly Interface** – Simple and intuitive design for seamless navigation.

---

## **Tech Stack**
- **Backend:** Java (Object-Oriented Programming, JDBC, File Handling)
- **Frontend:** JavaFX (Interactive GUI), Scene Builder
- **Database:** MySQL (for storing users, charities, and donation records)
- **Version Control:** Git & GitHub

---

## **Setup Instructions**

### **Prerequisites**
Ensure you have the following installed:  
🔹 **Java Development Kit (JDK) 11+**  
🔹 **JavaFX SDK**  
🔹 **MySQL Server**  
🔹 **Git**

### **Installation Steps**
1. **Clone the Repository**
   ```bash
   git clone  https://github.com/CindyWanyika/jerry-winkle.git
   cd CharityKonekt
   ```
2. **Set Up the MySQL Database**
    - Open MySQL and create a database:
      ```sql
      CREATE DATABASE CharityKonektDB;
      ```
    - Import the provided SQL script (`charitykonekt.sql`) to set up tables for **users, charities, and donations**.

3. **Configure Database Connection**
    - Open `DatabaseConfig.java` and update the credentials:
      ```java
      public class DatabaseConfig {
          static final String URL = "jdbc:mysql://localhost:3306/CharityKonektDB";
          static final String USER = "your_username";
          static final String PASSWORD = "your_password";
      }
      ```

4. **Run the Application**
    - Open the project in your **IDE (IntelliJ/Eclipse)**.
    - Ensure **JavaFX** is correctly set up.
    - Run the main Java class (`Sample.java`) to launch CharityKonekt.

---

## **Usage Guide**
1. **Register/Login as a Donor**
    - Create an account or sign in to access donation options.
2. **Browse Charities**
    - Use search and filters to find organizations by category.
3. **Donate to a Cause**
    - Select a charity and contribute resources or funds.
4. **Track Your Donations**
    - View past contributions and updates from charities.

---

## **Contributing**
We welcome contributions! To contribute:
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-branch`).
3. Commit changes (`git commit -m "Added a new feature"`).
4. Push to your branch and open a **pull request**.

---



