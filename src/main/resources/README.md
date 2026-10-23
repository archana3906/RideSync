# RideSync 🚗

**A ride-booking application built with Java, Spring Boot, and MySQL.**

RideSync is a web-based ride-booking project designed to connect passengers and drivers through a simple interface. It provides user registration, ride management, driver and vehicle information, and payment-related data management.

## ✨ Features

- **User Registration:** Register as a passenger or driver.
- **Passenger Management:** Store and manage passenger information.
- **Driver Management:** Maintain driver details, availability, and vehicle associations.
- **Ride Management:** Manage ride information, pickup and drop-off locations, fares, and ride statuses.
- **Vehicle Management:** Store vehicle types, registration numbers, and capacity.
- **Payment Management:** Maintain payment amounts, payment modes, and payment statuses.
- **Database Persistence:** Store application data in MySQL using Spring Data JPA and Hibernate.

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend programming |
| Spring Boot | Application framework |
| Spring Web MVC | Web and REST endpoints |
| Spring Data JPA | Database access |
| Hibernate | Object-relational mapping |
| MySQL 8 | Relational database |
| HTML, CSS, JavaScript | Frontend interface |
| Maven | Dependency management and build |

## 📁 Project Structure

```text
ridesync/
├── src/
│   ├── main/
│   │   ├── java/ridesync/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── RidesyncApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │           └── index.html
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## ⚙️ Prerequisites

Before running RideSync, install:

- JDK 21 or a compatible newer JDK
- MySQL Server 8.0 or compatible version
- Git
- Visual Studio Code or another Java IDE

## 🚀 Installation and Setup

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/RideSync.git
cd RideSync
```

Replace `YOUR_USERNAME` with the GitHub account that owns the repository.

### 2. Create the MySQL database

Log in to MySQL and execute:

```sql
CREATE DATABASE ridesync_db;
```

Hibernate can create the application's tables when it starts.

### 3. Configure database credentials

The application uses these environment variables:

- `DB_URL` — JDBC connection URL
- `DB_USERNAME` — MySQL username
- `DB_PASSWORD` — MySQL password

For a local PowerShell session, configure them as follows:

```powershell
$env:DB_URL = "jdbc:mysql://localhost:3306/ridesync_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = "YOUR_MYSQL_PASSWORD"
```

Replace the password placeholder with your local MySQL password. Do not commit database credentials to GitHub.

### 4. Run the application

Make sure the configured application port is available. For the default port `8081`, run:

```powershell
.\mvnw.cmd spring-boot:run
```

Open the application in your browser:

[http://localhost:8081](http://localhost:8081)

## 🗄️ Database Design

RideSync uses relational entities to represent its core data:

- **User:** Basic user information and account details.
- **Passenger:** Passenger-specific information.
- **Driver:** Driver details, availability, and vehicle association.
- **Vehicle:** Vehicle type, number, and capacity.
- **Ride:** Passenger, driver, locations, fare, and ride status.
- **Payment:** Payment amount, mode, and status.

Hibernate manages entity-to-table mapping. The configured schema update mode creates missing tables and updates the schema when the application starts.

## 🔒 Security Notes

- Keep database passwords and other credentials out of source control.
- Use appropriate password hashing and authentication protections before deploying the application publicly.
- Configure production database credentials using secure environment variables or a secrets manager.

## 🎯 Project Objective

The objective of RideSync is to develop a structured ride-booking application using a layered Java backend, a relational database, and a web-based user interface.

## 👩‍💻 Future Enhancements

Potential improvements include live GPS tracking, map integration, fare estimation, online payment gateway integration, stronger authentication, and automated testing.

## 📄 License

A license has not yet been specified. Add a license file if you intend to distribute this project under an open-source license.
