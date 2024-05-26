-- Dropping constraints and tables
ALTER TABLE Overtime DROP CONSTRAINT overtime_fk2;
ALTER TABLE Overtime DROP CONSTRAINT overtime_chk;
ALTER TABLE Overtime DROP CONSTRAINT overtime_daynight;

DROP TABLE Overtime;

ALTER TABLE Transaction DROP CONSTRAINT transaction_fk2;

DROP TABLE Transaction;

ALTER TABLE VEHICLE DROP CONSTRAINT vehicle_pk;
ALTER TABLE VEHICLE DROP CONSTRAINT vehicle_fk;

DROP TABLE VEHICLE;

ALTER TABLE Log_In DROP CONSTRAINT login_pk;

DROP TABLE Log_In;

ALTER TABLE EMPLOYEE DROP CONSTRAINT employee_pk;
ALTER TABLE EMPLOYEE DROP CONSTRAINT employee_fk;
ALTER TABLE EMPLOYEE DROP CONSTRAINT employee_phone_un;
ALTER TABLE EMPLOYEE DROP CONSTRAINT employee_ck;

DROP TABLE EMPLOYEE;


ALTER TABLE Allowance DROP CONSTRAINT allowance_pk;
ALTER TABLE Allowance DROP CONSTRAINT allowance_fk;

DROP TABLE Allowance;

ALTER TABLE Grade DROP CONSTRAINT grade_pk;

DROP TABLE Grade;

ALTER TABLE Position DROP CONSTRAINT position_pk;

DROP TABLE Position;

ALTER TABLE Projects DROP CONSTRAINT project_pk;
ALTER TABLE Projects DROP CONSTRAINT project_fk;

DROP TABLE Projects;

ALTER TABLE DEPARTMENT DROP CONSTRAINT department_pk;

DROP TABLE DEPARTMENT;

DROP TABLE username_stor;

CREATE TABLE DEPARTMENT
(
  Dname VARCHAR(50) NOT NULL,
  Description VARCHAR(255) NOT NULL,
  Total_Employee_Number INT NOT NULL,
  CONSTRAINT department_pk PRIMARY KEY (Dname)
);

CREATE TABLE Projects
(
  Pname VARCHAR(50) NOT NULL,
  PID INT NOT NULL,
  Proj_Desc VARCHAR(50),
  Dname VARCHAR(50) NOT NULL,
  CONSTRAINT project_pk PRIMARY KEY (PID),
  CONSTRAINT project_fk FOREIGN KEY (Dname) REFERENCES DEPARTMENT(Dname)
);

CREATE TABLE Position
(
  PositionName VARCHAR(50) NOT NULL,
  CONSTRAINT position_pk PRIMARY KEY (PositionName)
);


CREATE TABLE Grade
(
  GradeName VARCHAR(50) NOT NULL,
  Min_Salary DECIMAL(10,2) NOT NULL,
  Max_Salary DECIMAL(10,2) NOT NULL,
  HourlyPay DECIMAL(10, 2) NOT NULL,
  CONSTRAINT grade_pk PRIMARY KEY (GradeName),
  CONSTRAINT grade_salary_range_ck CHECK (Min_Salary < Max_Salary)
);

CREATE TABLE Allowance
(
  Amount DECIMAL(10,2) NOT NULL,
  AllowanceName VARCHAR(50) NOT NULL,
  PositionName VARCHAR(50) NOT NULL,
  CONSTRAINT allowance_pk PRIMARY KEY (AllowanceName, PositionName),
  CONSTRAINT allowance_fk FOREIGN KEY (PositionName) REFERENCES Position(PositionName)
);


CREATE TABLE EMPLOYEE
(
  Name VARCHAR(50) NOT NULL,
  hiredate DATE NOT NULL,
  Commission DECIMAL(10,2),
  Salary DECIMAL(10,2) NOT NULL,
  SalGrade CHAR(1),
  Gender CHAR(1) NOT NULL,
  DateOfBirth DATE NOT NULL,
  EmpNo INT,
  phoneNo VARCHAR(20) NOT NULL,
  position VARCHAR2(20),
  Dname VARCHAR(50) NOT NULL,
  CONSTRAINT employee_pk PRIMARY KEY (EmpNo),
  CONSTRAINT employee_fk FOREIGN KEY (Dname) REFERENCES DEPARTMENT(Dname),
  CONSTRAINT employee_fk2 FOREIGN KEY (position) REFERENCES POSITION(POSITIONNAME),
  CONSTRAINT employee_phone_un UNIQUE (phoneNo),
  CONSTRAINT employee_ck CHECK (gender = 'M' or gender = 'F')
);


CREATE TABLE Log_In
(
  Username VARCHAR(50) NOT NULL,
  Password VARCHAR(255) NOT NULL,
  CONSTRAINT login_pk PRIMARY KEY (Username)
);


CREATE TABLE VEHICLE
(
  make VARCHAR(50) NOT NULL,
  model VARCHAR(50) NOT NULL,
  next_maintenance_date DATE NOT NULL,
  VID INT NOT NULL,
  EmpNo INT NOT NULL,
  CONSTRAINT vehicle_pk PRIMARY KEY (VID),
  CONSTRAINT vehicle_fk FOREIGN KEY (EmpNo) REFERENCES EMPLOYEE(EmpNo)
);

CREATE TABLE Transaction
(
  TransactionDateTime DATE NOT NULL,
  Username VARCHAR(50) NOT NULL,
  PositionName VARCHAR(50) NOT NULL,
  EmpNo INT NOT NULL,
  CONSTRAINT transaction_fk2 FOREIGN KEY (PositionName) REFERENCES Position(PositionName)
);

CREATE TABLE Overtime
(
  DayNight CHAR(1) NOT NULL,
  Working_Hours INT NOT NULL,
  EmpNo INT NOT NULL,
  overtime_amm NUMBER,
  CONSTRAINT overtime_fk2 FOREIGN KEY (EmpNo) REFERENCES EMPLOYEE(EmpNo),
  CONSTRAINT overtime_chk CHECK (Working_Hours <= 8),
  CONSTRAINT overtime_daynight CHECK (DayNight in ('D','N'))
);

CREATE TABLE username_stor
(
    username VARCHAR(50)
);




