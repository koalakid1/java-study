--DB ����
create tablespace mysample datafile
'C:\app\USER28\oradata\mysample.dbf' size 100m AUTOEXTEND on NEXT 5m;

--���� ����
CREATE USER user1 IDENTIFIED by hong
DEFAULT TABLESPACE mysample
TEMPORARY TABLESPACE temp;

grant dba to user1;
