
CREATE OR REPLACE TRIGGER emp_trg_check_dates
  BEFORE INSERT OR UPDATE ON EMPLOYEE
  FOR EACH ROW
BEGIN
  IF( MONTHS_BETWEEN(SYSDATE,:new.DateOfBirth) < 216)
  THEN
    RAISE_APPLICATION_ERROR( -20010, 
          'Invalid Date OF Birth: Must be in between Age 18 and 60' );
  END IF;
  IF( MONTHS_BETWEEN(SYSDATE,:new.DateOfBirth) > 720)
  THEN
    RAISE_APPLICATION_ERROR( -20010, 
          '
          Invalid Date OF Birth: Must be in between Age 18 and 60
          ' );
  END IF;
END;
/




CREATE OR REPLACE TRIGGER veh_trg_check_dates
  BEFORE INSERT ON VEHICLE
  FOR EACH ROW
BEGIN
  IF( MONTHS_BETWEEN(:new.next_maintenance_date,sysdate) > 3)
  THEN
    RAISE_APPLICATION_ERROR( -20010, 
          'Next Maintenance date must be within 3 months of current date' );
  END IF;
END;
/




CREATE OR REPLACE TRIGGER add_emp_dept
  AFTER INSERT ON EMPLOYEE
  FOR EACH ROW
BEGIN
    
    UPDATE DEPARTMENT
    SET TOTAL_EMPLOYEE_NUMBER = TOTAL_EMPLOYEE_NUMBER + 1
    WHERE DNAME = :new.dname;
  
END;
/




CREATE OR REPLACE TRIGGER remove_emp_dept
  AFTER DELETE ON EMPLOYEE
  FOR EACH ROW
BEGIN
    
    UPDATE DEPARTMENT
    SET TOTAL_EMPLOYEE_NUMBER = TOTAL_EMPLOYEE_NUMBER - 1
    WHERE DNAME = :old.dname;
  
END;
/       



CREATE OR REPLACE TRIGGER all_chk
  BEFORE INSERT ON allowance
  FOR EACH ROW
BEGIN

    IF( :new.positionname IN ('HR','CLERK') and :new.allowancename NOT IN ('SOCIAL','UNIFORM') )
     THEN
    RAISE_APPLICATION_ERROR( -20010, 
          'Allowance Is Not Available For The Inputted Position' );
  END IF;
  
  IF( :new.positionname IN ('MANAGER') and :new.allowancename NOT IN ('FUEL','HOUSE','SOCIAL','MANAGER') )
     THEN
    RAISE_APPLICATION_ERROR( -20010, 
          'The Allowance Is Not Available For This Position' );
  END IF;
  
  IF( :new.positionname IN ('ADMINISTRATOR') and :new.allowancename NOT IN ('HOUSE','SOCIAL') )
     THEN
    RAISE_APPLICATION_ERROR( -20010, 
          'The Allowance Is Not Available For This Position' );
  END IF;
  
END;
/  




CREATE OR REPLACE TRIGGER emp_sal_in_grade
  AFTER INSERT OR UPDATE ON EMPLOYEE
  FOR EACH ROW
BEGIN
    IF( :new.SALGRADE = 'A' AND :new.SALARY NOT BETWEEN 30000 and 50000)
        THEN
        RAISE_APPLICATION_ERROR( -20010, 
          '
          Salary range incorrect for Grade A.
          Salary has to be within the Range: 
           A = 50,000 - 30,000
           B = 30,000 - 20,000
           C = 20,000 - 10,000
           ' );
    END IF;
    
    IF( :new.SALGRADE = 'B' AND :new.SALARY NOT BETWEEN 20000 and 29999)
        THEN
        RAISE_APPLICATION_ERROR( -20010, 
          '
          Salary range incorrect for Grade B.
          Salary has to be within the Range: 
           A = 50,000 - 30,000
           B = 30,000 - 20,000
           C = 20,000 - 10,000
           ' );
    END IF;
    IF( :new.SALGRADE = 'C' AND :new.SALARY NOT BETWEEN 10000 and 19999)
        THEN
        RAISE_APPLICATION_ERROR( -20010, 
          '
          Salary range incorrect for Grade C.
          Salary has to be within the Range: 
           A = 50,000 - 30,000
           B = 30,000 - 20,000
           C = 20,000 - 10,000
           ' );
    END IF;
    IF( :new.SALARY < 10000)
        THEN
        RAISE_APPLICATION_ERROR( -20010, 
          '
          Salary entered too low.
          Salary has to be within the Range: 
           A = 50,000 - 30,000
           B = 30,000 - 20,000
           C = 20,000 - 10,000
           ' );
    END IF;
END;
/


CREATE OR REPLACE PROCEDURE overtime_calc(dn CHAR, empnum INT, hourly_pay INT, workh INT)
AS
BEGIN
    IF( dn = 'D')
        THEN
        update overtime 
        set overtime_amm = working_hours*hourly_pay
        where empnum = empno and dn = daynight and workh = working_hours;
    END IF;
    
    IF( dn = 'N')
        THEN
        update overtime 
        set overtime_amm = working_hours*hourly_pay*2
        where empnum = empno and dn = daynight and workh = working_hours;
    END IF;
END;
/



CREATE OR REPLACE TRIGGER transaction_adder1
  AFTER INSERT OR UPDATE ON Employee
  FOR EACH ROW
BEGIN

    insert into transaction
    values(sysdate, (select username from username_stor), :new.position, :new.empno);
  
END;
/


    
CREATE OR REPLACE TRIGGER transaction_adder2
  AFTER DELETE ON Employee
  FOR EACH ROW
BEGIN

    insert into transaction
    values(sysdate, (select username from username_stor), :old.position, :old.empno);
  
END;
/













