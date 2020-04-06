--any�� ���
select employee_id, salary
from employees
where salary = any(2000,3000,4000)
order by employee_id;

--or�� �ٲ��� ��
select employee_id, salary
from employees
where salary = 2000 or salary = 3000 or salary = 4000
order by employee_id;

--in
select employee_id, salary
from employees
where salary in (2000,3000,4000)
order by employee_id;

--some
select employee_id, salary
from employees
where salary = some(2000,3000,4000)
order by employee_id;

--all
select employee_id, salary
from employees
where salary = all(2000,3000,4000)
order by employee_id;

--not �̿� ���� ����� ����. 
select employee_id, salary
from employees
where not (salary>=2500)
order by employee_id;

--between
select employee_id, salary
from employees
where salary between 2000 and 2500
order by employee_id;

--and�� �ٲ��� ��
select employee_id, salary
from employees
where salary >= 2000 and salary <= 2500
order by employee_id;

--like
select emp_name
from employees
where emp_name like 'A%' --������ a�̰� �������� �������.
ORDER BY emp_name;

--concat ���ڿ��� �����Ҷ� ��� ||�� �� ����
select concat(emp_name, email)
from employees;

--ltrim
select ltrim('ABCDEFGABC','ABC')
FROM DUAL; --�������̺�

select sysdate from dual;

--substr, substrb
select substr('ABCDEFG',1,4), SUBSTR('�����ͺ��̽�',1,3)
FROM DUAL;

select substrb('ABCDEFG',1,4), SUBSTRb('�����ͺ��̽�',1,3)
FROM DUAL;

select substrb('ABCDEFG',-2,2)
FROM DUAL;

--add_month
select emp_name, hire_date, add_months(hire_date,12)
from employees;

select emp_name,hire_date
from employees
where hire_date > add_months(sysdate,-200);

--months_between �� �ð� ���� ���� ����
select emp_name, months_between(sysdate,hire_date)
from employees;

--to_char
select to_char(123456789,'999,999,999') AS NUM from dual;

select to_char(sysdate,'YYYY-MM-DD') AS NOW FROM DUAL;

SELECT TO_CHAR(SYSDATE,'DAY') AS NOW_DAY FROM DUAL;

SELECT TO_CHAR(SYSDATE,'q') AS q FROM DUAL;

--to_date
select to_char(TO_DATE('20140101'),'yyyy-mm-dd') from dual;

--nvl ù��°�� null�̸� �ι�°�� �Է��Ѵ�.
select emp_name, nvl(manager_id,0)
from employees;

--5��
--count
select count(*)
from employees;

--distinct
select distinct department_id
from employees;

--sum,avg,min,max
select sum(salary) from employees;
select avg(salary) from employees;
select min(salary) from employees;
select max(salary) from employees;

-- is null( null�� = ��� is�� ����ؾ���!)
SELECT
    *
FROM employees
where salary is null;


--null�� ���Ե� ���� count,avg
create table sample1(
    korean number,
    english number
)

insert into sample1 values(100,100);
insert into sample1 values(100,100);
insert into sample1 values(100,null);

select count(english) from sample1; --������ �����ʾƼ� 2���� �ν�
select avg(english) from sample1; -- ���������� ������ ġ���ʾƼ� 100��

--group by - group�� ���õ� �ֵ鸸 ���ؼ� ǥ��
select department_id, sum(salary)
from employees
group by department_id;

--group by + having
select department_id, count(*) 
from employees
where department_id > 50
group by department_id
having count(*) > 10
order by department_id;

--group by ���� �� ���
select period, sum(loan_jan_amt) total_jan
from kor_loan_status
where period like '2013%'
group by period;

select period,region,sum(loan_jan_amt) total_jan
from kor_loan_status
where period like '2013%'
group by period,region;

--rollup - region���� ���� total�� ���� �����ְ� �������� ��ü region ���� total�� ������
select period,region,sum(loan_jan_amt) total_jan
from kor_loan_status
where period like '2013%'
group by rollup(period,region);

select period,gubun,sum(loan_jan_amt) total_jan
from kor_loan_status
where period like '2013%'
group by rollup(period),gubun;

select period,gubun,sum(loan_jan_amt) total_jan
from kor_loan_status
where period like '2013%'
group by rollup(gubun),period;

--cube rollup�� ù��° ���ڿ� ���õȰ͸� ���������� cube�� ��� ���ڿ� ���õ� ���� ������
select period,gubun,sum(loan_jan_amt) total_jan
from kor_loan_status
where period like '2013%'
group by cube(period,gubun);

select period,gubun,sum(loan_jan_amt) total_jan
from kor_loan_status
where period like '2013%'
group by cube(gubun,period);

--union - �ߺ��� ���� �ȳ����� �� / union all - �ߺ��� ������� ���� ���
select 'a','b','c' from dual
union 
select 'x','y','z' from dual;

create table sales_asia(
  code number primary key,
  name varchar(20) not null,
  wdate date
);

insert into sales_asia VALUES('0001','�ҳ�Ÿ',sysdate);
insert into sales_asia VALUES('0002','�׷���',sysdate);

create table sales_europe(
  code number primary key,
  name varchar(20) not null,
  wdate date
);

insert into sales_europe VALUES('0003','i3',sysdate);
insert into sales_europe VALUES('0004','i4',sysdate);
insert into sales_europe VALUES('0001','�ҳ�Ÿ',sysdate);

select * from sales_asia
union
SELECT * FROM sales_europe;

select * from sales_asia
union all
SELECT * FROM sales_europe;

create table sales_usa(
  code number primary key,
  name varchar(20) not null,
  wdate date
);

insert into sales_usa VALUES('0003','i3',sysdate);
insert into sales_usa VALUES('0004','i4',sysdate);
insert into sales_usa VALUES('0001','�ҳ�Ÿ',sysdate);

select * from sales_asia
union
SELECT * FROM sales_europe
union
select * from sales_usa;

select code, name from sales_asia
union
SELECT code, name FROM sales_europe
union
select code, name from sales_usa
order by name;

--intersect, minus�� ���� ������ ������ ���� ����

--join
SELECT a.employee_id, a.emp_name, a.department_id, b.department_name
  FROM employees a,
       departments b
 WHERE a.department_id = b.department_id;
 
 --semi join
 SELECT department_id, department_name
  FROM departments a
 WHERE EXISTS ( SELECT * 
                 FROM employees b
                WHERE a.department_id = b.department_id
                  AND b.salary > 3000)
ORDER BY a.department_name;


SELECT department_id, department_name
  FROM departments a
 WHERE a.department_id  IN ( SELECT b.department_id
                               FROM employees b
                              WHERE b.salary > 3000)
ORDER BY department_name;


SELECT a.department_id, a.department_name
  FROM departments a, employees b
 WHERE a.department_id = b.department_id
   AND b.salary > 3000
ORDER BY a.department_name;

select e.employee_id, e.emp_name, j.job_title
from employees e, jobs j
where e.job_id = j.job_id;

--ansi join
select e.employee_id, e.emp_name, j.job_title
from employees e inner join jobs j
on e.job_id = j.job_id
where e.salary > 5000;

select e.emp_name, d.department_name, j.job_title
from employees e,departments d, jobs j
where e.department_id = d.department_id
and e.job_id = j.job_id;

select e.emp_name, d.department_name, j.job_title
from employees e join departments d
on e.department_id = d.department_id
join jobs j --�̹� �տ� ���� �ִ� join�� ����
on e.job_id = e.job_id;

--view
create or replace view v1
as
select e.emp_name, d.department_name, j.job_title
from employees e join departments d
on e.department_id = d.department_id
join jobs j 
on e.job_id = e.job_id;


select * from v1;