--테이블 생성
create table member(
    id varchar(20) primary key,
    name varchar(20)
);

--데이터 입력
insert into member values('hkd','홍길동');
insert into member values('lss','이순신');
--조회
select * from member;

--commit
commit;

select table_name
from user_tables;