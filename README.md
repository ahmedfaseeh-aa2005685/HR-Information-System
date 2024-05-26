## Database Application for HR Recruiting Firm

### Project Overview
This project involves developing a database application for a small recruiting firm to manage employee information, department details, vehicle maintenance, allowances, projects, credentials, transactions, grades, and overtime calculations. The application must enforce various constraints and provide functionalities for employee management, reporting, and login authentication.

### Database Design and Schema
1. **Database Design**: Design a relational database schema to store employee, department, vehicle, allowance, project, credential, transaction, and grade information.
2. **Database Implementation**: Implement the database schema using SQL and ensure the inclusion of primary and foreign keys as well as other necessary constraints.
3. **Data Population**: Populate the database with sample data to test functionality and generate reports.

### Functionalities and User Interface
1. **Login Screen**:
   - Implement a login screen for the admin with username and password authentication from the Login table.

2. **Employee Management**:
   - Add new employees to the database.
   - Remove employees from the database.
   - Update an employee's salary.

3. **Search Functionality**:
   - Search by Employee number to retrieve information about allowances.

4. **SQL Trigger**:
   - Implement SQL triggers for adding, removing, and updating employees to store transaction details.

5. **Reports (Based on Views)**:
   - Employee History: Employee Name, Department Name, Hiredate.
   - Vehicle History: Employee Name, Vehicle Model, Next_Maintenance.
   - Project History: Project Name, Project Description, Department Name.
   - Overtime Report: Employee Name, Overtime payment.

6. **User Interface**:
   - Create user interface screens using Java Swing Windows Builder or Java FX to interact with the database application.

### Instructions for Running the Project
1. Clone the repository to your local machine.
2. Set up an Oracle Database Server to host the database.
3. Run the SQL scripts to create tables and insert sample data.
4. Compile and run the Java application to access the functionalities and reports provided by the database application.

Ensure that you have the necessary Java libraries and database connectivity drivers configured to run the application smoothly.
