--���̺� ����
create table member(
    id varchar(20) primary key,
    name varchar(20)
);

--������ �Է�
insert into member values('hkd','ȫ�浿');
insert into member values('lss','�̼���');
--��ȸ
select * from member;

--commit
commit;

select table_name
from user_tables;