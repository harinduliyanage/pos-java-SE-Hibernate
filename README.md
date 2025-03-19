# POS Application - Local Setup Guide

## Prerequisites

Before setting up and running the application, ensure you have the following installed on your system:

### 1. Install Oracle JDK 8

This project requires **Oracle JDK 8**. You can install it using the following steps:

- **Windows:** Download and install Java from [Oracle JDK 8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html).
- **Mac (Homebrew):**
  ```sh
  brew install --cask oracle-jdk
  ```
- **Linux (Ubuntu/Debian-based):**
  ```sh
  sudo apt update && sudo apt install openjdk-8-jdk
  ```
- **Verify Installation:**
  ```sh
  java -version
  ```

### 2. Install Apache Maven

Maven is required to manage dependencies and build the project.

- **Windows:** Download Maven from [Maven Downloads](https://maven.apache.org/download.cgi) and add it to your system PATH.
- **Mac (Homebrew):**
  ```sh
  brew install maven
  ```
- **Linux:**
  ```sh
  sudo apt update && sudo apt install maven
  ```
- **Verify Installation:**
  ```sh
  mvn -version
  ```

### 3. Install MySQL Database

The application requires MySQL to store data.

- **Windows/Mac:** Download and install MySQL from [MySQL Downloads](https://dev.mysql.com/downloads/installer/).
- **Linux:**
  ```sh
  sudo apt update && sudo apt install mysql-server
  ```
- **Start MySQL Service:**
  ```sh
  sudo systemctl start mysql
  ```
- **Create Database and User:**
  ```sql
  CREATE DATABASE pos_db;
  CREATE USER 'pos_user'@'localhost' IDENTIFIED BY 'password';
  GRANT ALL PRIVILEGES ON pos_db.* TO 'pos_user'@'localhost';
  FLUSH PRIVILEGES;
  ```

### 4. Clone the Repository

```sh
git clone https://github.com/your-repository/pos1.git
cd pos1
```

## Configuration

Edit the `application.properties` file in `src/main/resources/` to match your database settings:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pos_db
spring.datasource.username=pos_user
spring.datasource.password=password
```

## Build and Run the Application

1. **Build the Project**
   ```sh
   mvn clean install
   ```
2. **Run the Application**
   ```sh
   java -jar target/Pos1-1.0-SNAPSHOT-jar-with-dependencies.jar
   ```

## Common Issues & Troubleshooting

- **Port Conflict:** Ensure MySQL and the application are not running on the same port as other services.
- **Database Connection Issues:** Verify MySQL service is running and credentials match.
- **Dependency Issues:** Run `mvn clean install -U` to force update dependencies.


For additional help, please raise an issue in the repository.



# pos-java-SE-Hibernate
<img src="https://github.com/harinduliyanage/pos-java-SE-Hibernate/blob/master/src/main/resources/image/1234.png" />
<img src="https://github.com/harinduliyanage/pos-java-SE-Hibernate/blob/master/src/main/resources/image/12345.png" />
<img src="https://github.com/harinduliyanage/pos-java-SE-Hibernate/blob/master/src/main/resources/image/123456.png" />
<img src="https://github.com/harinduliyanage/pos-java-SE-Hibernate/blob/master/src/main/resources/image/123.png" />
