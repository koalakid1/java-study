--���̺� ���� �� ������ �ֱ�
create table userTable(
    id varchar2(20) PRIMARY key,
    pw VARCHAR2(20) not null,
    name VARCHAR2(50) not null,
    email VARCHAR2(50) not null,
    address VARCHAR2(100),
    phone varchar2(20)
);

insert into usertable(id,pw,name,email,address,phone)
values(
    'www','1234','��','www@www.com','����','010-2222-7777'
);

insert into usertable(id,pw,name,email,address,phone)
values(
    'abc','1234','�հ�','www@www.com',null,null
);

insert into usertable(id,pw,name,email)
values(
    'sjdw','1234','�������','sjdw@sjdw.com'
);

select * from usertable;

insert into userTable 
VALUES('hkd','1234','ȫ�浿','hkd@hkd.com','����','010-1234-5678');
insert into userTable 
VALUES('hkd','1234','ȫ�海','hkd@hkd.com','����','010-5678-1234');

create table goodsTable(
    gCode CHAR(8) not null,
    gName varchar(50) not null,
    price number not null,
    CONSTRAINT pk_goodsTable primary key(gCode)
);

insert into goodsTable 
values('20200403','������',2000);
insert into goodsTable 
values('20200403','�����',2000);

select * from goodstable;

drop table ordertable;

create table orderTable(
    oNo CHAR(12) primary key,
    id VARCHAR2(20) not null,
    gCode char(8) not null,
    oDate date not null,
    CONSTRAINT fk_orderTable FOREIGN key(id)
    REFERENCES usertable(id) ON DELETE CASCADE
);

insert into orderTable values('202004030001','hkd','20200403',sysdate);
select * from ordertable;
select * from usertable;

-- constraint ����

create table ex2_9(
    num1 NUMBER 
    constraint check1 check(num1 between 1 and 9),
    gender varchar2(10) 
    constraint check2 check(gender in ('MALE','FEMALE'))
);

--�÷��� �ٲٱ�

alter table ex2_9 rename column num1 to num;

desc ex2_9

--�����ϱ�

create table ex2_9_copy
as
select * from ex2_9;

select * from ex2_9_copy; 


insert into ex2_9 values(10,'MALE');
insert into ex2_9 values(5,'MALE');

-- ����

delete from usertable where id='hkd';

--������ �����ϱ�

create table boardtable(
    no number primary key,
    title varchar2(1000) not null
);

create sequence seq_boardtable;

insert into boardtable values(seq_boardtable.nextval, 'sql�̶�?');

select * from boardtable;

-- ���ǹ�? where / order by ����

select employee_id, emp_name, manager_id
from employees
where salary>20000;

select emp_name, salary
from employees
order by salary desc;

select emp_name, department_id, salary
from employees
order by department_id asc, salary desc;

select * from boardtable;
select *
from employees
where salary>5000 and salary<10000
order by salary;

select *
from employees
where salary<5000 or salary>10000
order by salary;

select *
from employees
where department_id=50 and salary>7000
order by salary;

-- insert ~ select ���� ����
create table employeesCopy
as
select * from employees;   --������ ���� �ٿ��ֱ� �ߴ� ��� create as select
select * from employeesCopy;

--insert select 
create table employeesCopy2
as
select * from employees where salary > 10000;
select * from employeesCopy2; --������ ���� �ٿ��ֱ� �ߴ� ��� create as select

insert into employeesCopy2
select * from employees where salary>=7000 and salary<=10000; --insert�� ������ ���̺� ���ο� �����͸� �߰��ϴ� ��


--������ ���� ������ ����
create table employeesCopy3
as
select * from employees where 1!=1; -- <> �� ���� �ʴٴ� �� 
select * from employeescopy3;

--update��
select * from userTable;

--1���� �ٲٱ�
update userTable set
name = '�հ�2'
where id = 'abc';

--2���� �ٲٱ�
update userTable set
name = '�հ�3', address = '���ѹα�'
where id = 'abc';