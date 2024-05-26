

insert into username_stor values('admin1');


insert into grade values('A', 30000, 50000, 200);
insert into grade values('B', 20000, 29999, 150);
insert into grade values('C', 10000, 19999, 100);



insert into department values('STRUCTURE', 'Does Structuring', 0);
insert into department values('FINANCE', 'Does financing', 0);
insert into department values('SPONSORS', 'Does Sponsoring', 0);
insert into department values('MEDIA', 'Does Media', 0);
insert into department values('MARKETING', 'Does MARKETING', 0);



insert into position values('HR');
insert into position values('MANAGER');
insert into position values('ACCOUNTANT');
insert into position values('ADMINISTRATOR');
insert into position values('CLERK');




insert into employee 
values('Faseeh', sysdate, 100, 33000, 'A', 'M', 
        TO_DATE('01-JAN-2002','DD-MON-YYYY'), 1, 1000, 'HR', 'FINANCE');

insert into employee 
values('Haris', sysdate, 100, 25000, 'B', 'M', 
        TO_DATE('01-JAN-2001','DD-MON-YYYY'), 2, 2000, 'HR', 'STRUCTURE');
        
insert into employee 
values('Muhsen', sysdate, 100, 14000, 'C', 'M', 
        TO_DATE('01-JAN-2000','DD-MON-YYYY'), 3, 3000, 'ACCOUNTANT', 'SPONSORS');
        
insert into employee 
values('Asad', sysdate, 0, 42000, 'A', 'M', 
        TO_DATE('01-JAN-1994','DD-MON-YYYY'), 4, 4000, 'CLERK', 'FINANCE');

insert into employee 
values('Ronaldo', sysdate, 100, 47000, 'A', 'M', 
        TO_DATE('13-SEP-1999','DD-MON-YYYY'), 5, 5000, 'MANAGER', 'SPONSORS');




insert into log_in values('admin1','admin1');
insert into log_in values('admin2','admin2');



insert into vehicle values('TOYOTA','Supra',TO_DATE('11-JUN-2023','DD-MON-YYYY'), 1, 1);
insert into vehicle values('PORCHE','GT3RS',TO_DATE('12-JUL-2023','DD-MON-YYYY'), 2, 1);
insert into vehicle values('TOYOTA','Land Cruiser',TO_DATE('30-JUN-2023','DD-MON-YYYY'), 3, 2);
insert into vehicle values('NISSAN','GTR',TO_DATE('01-JUL-2023','DD-MON-YYYY'), 4, 3);
insert into vehicle values('LAMBORGHINI','Gallardo',TO_DATE('03-AUG-2023','DD-MON-YYYY'), 5, 5);
insert into vehicle values('LEXUS','IS300',TO_DATE('01-AUG-2023','DD-MON-YYYY'), 6, 4);



insert into projects values('Project 1',1,'This is Project 1','STRUCTURE');
insert into projects values('Project 4',4,'This is Project 4','STRUCTURE');
insert into projects values('Project 2',2,'This is Project 2','SPONSORS');
insert into projects values('Project 3',3,'This is Project 3','FINANCE');
insert into projects values('Project 5',5,'This is Project 5','MARKETING');



insert into allowance values(750, 'SOCIAL', 'HR');
insert into allowance values(200, 'FUEL', 'MANAGER');
insert into allowance values(1200, 'HOUSE', 'MANAGER');
insert into allowance values(750, 'SOCIAL', 'MANAGER');
insert into allowance values(500, 'MANAGER', 'MANAGER');
insert into allowance values(200, 'UNIFORM', 'HR');
insert into allowance values(1200, 'HOUSE', 'ADMINISTRATOR');
insert into allowance values(300, 'UNIFORM', 'CLERK');



commit;



