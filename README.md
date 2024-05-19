# Nebulon-backend

Nebulon-backend is a Spring Boot application that serves as the backend for Nebulon, a modern content management system (CMS).

## Table of Contents
- [Features](#features)

## Features

- User authentication and authorization
- Articles realated functions incliding article creation, editing, viewing and deletion

## Prerequisites

Before you begin, ensure you have the following installed on your local machine:

- **Java Development Kit (JDK) 17 or later**
- **Maven 3.9.6 or later**
- **Git**

## Getting Started

### Clone the Repository

First, clone the repository to your local machine using Git:

```bash
git clone https://github.com/RavinduLa/nebulon-backend.git
cd nebulon-backend
```

### Setup Database

Nebulon-backend uses a hosted MongoDB instance as its database. The connection URI and the database name are contained in a separate `secrets.properties` file. For security reasons this file is not version controlled and can be provided upon request.

1. **Request `secrets.properties` File**:
   Contact the project maintainer at `ms23466944@my.sliit.lk` to obtain the `secrets.properties` file.

2. **Place `secrets.properties` File**:
   Once you have received the `secrets.properties` file, place it in the `src/main/resources` directory of the project.

3. **Verify Database Configuration**:
   Ensure that the `secrets.properties` file contains the correct MongoDB connection URI and database name, similar to the following:

   ```properties
   spring.data.mongodb.uri=<your-mongodb-uri>
   spring.data.mongodb.database=<database-name>
   ```

### Build and Run the Application

1. **Build the Application**:
   Navigate to the project directory and run:

   ```bash
   mvn clean install
   ```

2. **Run the Application**:
   After building the project, start the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

### Access the Application

Once the application is running, you can access it at:

```
http://localhost:8080
```

### Frontend Setup

The frontend for this system is in a separate repository. To access the system, you need to run the frontend application as well. Instructions for setting up and running the frontend can be found in the frontend repository.

## Troubleshooting

If you encounter any issues while setting up or running the application, consider the following steps:

- Ensure your JDK and Maven installations are correctly configured.
- Verify your database configuration in `secrets.properties`.
- Check the application logs for any error messages.

## Contact

If you have any questions or need further assistance, please contact the project maintainer at `ms23466944@my.sliit.lk`.

---

## Thank you!
