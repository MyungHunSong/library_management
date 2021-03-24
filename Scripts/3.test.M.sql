select user(), database();

use library_managemant;

select *
	from member_info;
	
desc rent_return;

alter table rent_return change column memberNo memberNo1 int(11);

alter table rent_return change column rentNo rentNo1 int(11);  

drop table rent_return;


alter table member_info change column memberNo memberNo char(5);

desc book_info;
alter table book_info change column bookNum bookNum char(5);

select bookNum from book_info;

select memberNo, name, homeNo, phoneNo from member_info; 







-- 1.
-- 회원 검색
select memberNo, name, homeNo, phoneNo
	from member_info;

-- 이름으로 검색시 동명이인도 출력
select memberNo, name, homeNo, phoneNo, count(*),(case count(*) when 1 then 'NO' else 'Yes' end) as 'same_name'
	from member_info
	group by name;
-- *
select  memberNo,name, homeNo, phoneNo 
	from member_info 
	where name = '김동수';

select name
	from member_info
	where name in(select name
					from member_info
					group by name
					having count(*)>1);
				
-- 2.
-- 도서 검색
select bookNum, bookName, bookCan, bookkind
	from book_info;




-- 4 연체일자
select bookto_days(now()) - to_days('20210315') then > 3; 
	from rent_return;

select date_format(now(), '%H:%i:%s'); 

select * from rent_return;



	






