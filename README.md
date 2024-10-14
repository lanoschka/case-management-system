# Case Management System

## Description

The "Case Management System" application is a simple system designed to facilitate the tracking and management of various cases. It allows users to add new cases, edit them, and update their statuses.

## Features

- **Add New Cases**: Users can create new cases by providing a title, description, creation date, severity level, and status.
- **Edit Cases**: Users can edit the details of existing cases.
- **Manage Statuses**: Users can change the statuses of cases (e.g., new, in progress, done).

## Technologies

- **Java 17**: The programming language used to build the application.
- **Spring Boot**: A framework for building Java applications that simplifies configuration and startup processes.
- **H2 Database**: A lightweight database used to store cases.
- **Lombok**: A library that simplifies code by automatically generating getters, setters, and other methods.

## How to Run the Application

To run the application, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/repository-name.git
   cd repository-name

2. **Run the Application**:Ensure you have JDK 17 and Maven installed. Then run the following command:
   ```bash
   mvn spring-boot:run
2. **Access the Application**:After starting the application, you can access the H2 Console by entering the following URL in your browser:
   ```bash
   http://localhost:8080/h2-console