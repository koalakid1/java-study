--self join
select e1.emp_name, e2.emp_name
from employees e1, employees e2
where e1.manager_id = e2.employee_id;

create table category(
    no char(4) primary key,
    name varchar(20) not null,
    pNo char(4) null
);

insert into category values('0001', '��ǰ', null);
insert into category values('0002', '����������', null);

insert into category values('0003', '��ǻ��', '0002');
insert into category values('0004', '�޴���', '0002');

insert into category values('0005', '��Ʈ��', '0003');
insert into category values('0006', '�º�pc', '0003');

select no, name from category where pNo is null;
select no, name from category where pno = '0002';
select no, name from category where pno = '0003';

SELECT c1.name roots, c2.name parents
from category c1, category c2
where c1.pNo = c2.no;

--outer join
--�Ϲ����� join
select a.department_id, a.department_name, b.job_id, b.department_id
from departments a, job_history b
where a.department_id = b.department_id;

--right outer join
select a.department_id, a.department_name, b.job_id, b.department_id
from departments a, job_history b
where a.department_id(+) = b.department_id;

--left outer join
select a.department_id, a.department_name, b.job_id, b.department_id
from departments a, job_history b
where a.department_id = b.department_id(+);

-- ansi sql outer join
select a.department_id, a.department_name, b.job_id, b.department_id
from departments a left outer join job_history b
on a.department_id = b.department_id;

select a.employee_id,b.emp_name, a.job_id, a.department_id
from job_history a right outer join employees b
on a.employee_id = b.employee_id;

-- p.189 full outer join
create table hong_a(emp_id int);
create table hong_b(emp_id int);

insert into hong_a values(10);
insert into hong_a values(20);
insert into hong_a values(40);

insert into hong_b values(10);
insert into hong_b values(20);
insert into hong_b values(30);

select a.emp_id, b.emp_id
from hong_a a full outer join hong_b b
on a.emp_id = b.emp_id;

select a.emp_id, b.emp_id
from hong_a a, hong_b b;

--cross join
select a.emp_id, b.emp_id
from hong_a a cross join hong_b b;

--sub query
select count(*)
from employees
where salary >= (select avg(salary) from employees);

select count(*)
from employees
where department_id in (select department_id from departments where parent_id is null);

select employee_id, emp_name, job_id
from employees
where (employee_id, job_id) in (select employee_id, job_id from job_history);

--update ����Ŀ�� Ȱ��
update employees
set salary = (select avg(salary) from employees);

--delete �������� Ȱ��
delete employees
where salary >= (select avg(salary) from employees);

--�������� ��������
SELECT a.department_id, a.department_name
FROM departments a
where exists (select 1 from job_history b where a.department_id = b.department_id);

--join���� �Ѱ�쿡�� �ߺ��� ��찡 ���� �׷��Ƿ� distinct�� �ٿ��ָ��
select distinct a.department_id, a.department_name
from departments a join job_history b on a.department_id = b.department_id
order by a.department_id;

select max(salary), min(salary) from employees;

--pivot
select
(select max(salary) from employees where department_id = 10) max_10,
(select max(salary) from employees where department_id = 20) max_20
from dual;

select department_id, max(salary)
from employees
where department_id is not null
group by department_id
ORDER by department_id asc;

select a.emp_name, d.department_name
from (select * from employees where salary>10000) a join departments d on a.department_id = d.department_id;

--������ ����
select department_id, LPAD(' ', 3*(level - 1)) || department_name, level 
from departments
start with parent_id is null
connect by prior department_id = parent_id;

select to_char(hire_date,'YYYY') years, count(*) 
from employees
group by to_char(hire_date,'YYYY')
order by years;

--PIVOTING PIVOT �����ϴ¹�
select (select count(*) from employees where to_char(hire_date,'YYYY') = '1998') AS "1998",
(select count(*) from employees where to_char(hire_date,'YYYY') = '1999') AS "1999",
(select count(*) from employees where to_char(hire_date,'YYYY') = '2000') AS "2000"
FROM DUAL;

--���� LISTAGG(A,B) WITHIN GROUP
CREATE TABLE ex7_2 AS
  SELECT department_id,
         listagg(emp_name, ',') WITHIN GROUP (ORDER BY emp_name) as empnames
  FROM employees
 WHERE department_id IS NOT NULL
  GROUP BY department_id;
  
--WITH�� - ���������� ���ϰ� �������ؼ�

--ROW_NUMBER
