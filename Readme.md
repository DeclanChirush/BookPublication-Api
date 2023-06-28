# Getting Started

## How to Run the Project

To run the project, follow these steps:

1. Open the project using your preferred IDE. For example, IntelliJ IDEA was used in this case.
2. Create a MySQL database using a tool like MySQL Workbench.
3. Locate the 'application.properties' file in the project.
4. Update the 'spring.datasource.url' property in the 'application.properties' file to include the name of the created database. For example:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/database_name?useSSL=false&serverTimezone=UTC
   ```
   Replace `database_name` with the name of your created database.
5. Provide your MySQL username and password by updating the 'spring.datasource.username' and 'spring.datasource.password' properties in the 'application.properties' file. For example:
   ```
   spring.datasource.username=root
   spring.datasource.password=root
   ```
   Replace `root` with your actual MySQL username and password.
6. Run the 'BookPublicationApplication' class in your IDE. This class serves as the entry point of the application.

Following these steps will allow you to successfully run the project. Make sure you have the necessary dependencies and configurations in place for a smooth execution.


## Assumptions 

The following assumptions are made for the purpose of this project:

1. Each book is assigned to a single category.
2. A book is written by one author.
3. An author may have multiple books.
4. The available categories include, but are not limited to:
    - Romance
    - Art
    - History
    - and more.
5. Author attributes and Books attributes fields should be validated to ensure that they are not empty. (Assume front-end validation is in place.)

These assumptions serve as the foundational principles guiding the organization and structure of the project. They establish that each book is categorized into one specific category, each book is authored by a single individual, authors can have multiple books attributed to them, and a range of categories is available for classification, including romance, art, history, and additional options.

## API Documentation - Postman
- https://elements.getpostman.com/redirect?entityId=13228835-9a536197-f862-4c49-8c28-f085d8210bfc&entityType=collection
- Find the postman collection in the root directory of the project if the link does not work.