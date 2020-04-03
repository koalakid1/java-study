--테이블 생성 및 데이터 넣기
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
    'www','1234','웹','www@www.com','서울','010-2222-7777'
);

insert into usertable(id,pw,name,email,address,phone)
values(
    'abc','1234','왕건','www@www.com',null,null
);

insert into usertable(id,pw,name,email)
values(
    'sjdw','1234','세종대왕','sjdw@sjdw.com'
);

select * from usertable;

insert into userTable 
VALUES('hkd','1234','홍길동','hkd@hkd.com','서울','010-1234-5678');
insert into userTable 
VALUES('hkd','1234','홍길돈','hkd@hkd.com','서울','010-5678-1234');

create table goodsTable(
    gCode CHAR(8) not null,
    gName varchar(50) not null,
    price number not null,
    CONSTRAINT pk_goodsTable primary key(gCode)
);

insert into goodsTable 
values('20200403','맛동산',2000);
insert into goodsTable 
values('20200403','새우깡',2000);

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

-- constraint 연습

create table ex2_9(
    num1 NUMBER 
    constraint check1 check(num1 between 1 and 9),
    gender varchar2(10) 
    constraint check2 check(gender in ('MALE','FEMALE'))
);

--컬럼명 바꾸기

alter table ex2_9 rename column num1 to num;

desc ex2_9

--복사하기

create table ex2_9_copy
as
select * from ex2_9;

select * from ex2_9_copy; 


insert into ex2_9 values(10,'MALE');
insert into ex2_9 values(5,'MALE');

-- 삭제

delete from usertable where id='hkd';

--시퀀스 공부하기

create table boardtable(
    no number primary key,
    title varchar2(1000) not null
);

create sequence seq_boardtable;

insert into boardtable values(seq_boardtable.nextval, 'sql이란?');

select * from boardtable;

-- 조건문? where / order by 연습

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

-- insert ~ select 구문 연습
create table employeesCopy
as
select * from employees;   --기존에 복사 붙여넣기 했던 방법 create as select
select * from employeesCopy;

--insert select 
create table employeesCopy2
as
select * from employees where salary > 10000;
select * from employeesCopy2; --기존에 복사 붙여넣기 했던 방법 create as select

insert into employeesCopy2
select * from employees where salary>=7000 and salary<=10000; --insert는 생성된 테이블에 새로운 데이터를 추가하는 법


--데이터 없이 구조만 복사
create table employeesCopy3
as
select * from employees where 1!=1; -- <> 는 같지 않다는 뜻 
select * from employeescopy3;

--update문
select * from userTable;

--1가지 바꾸기
update userTable set
name = '왕건2'
where id = 'abc';

--2가지 바꾸기
update userTable set
name = '왕건3', address = '대한민국'
where id = 'abc';