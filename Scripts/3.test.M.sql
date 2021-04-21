select user(), database();

use library_managemant;

desc rent_return;
desc member_info;
desc book_info;
desc rent_return;

select *
	from member_info;

alter table book_info change column bookNum bookNum int;

desc rent_return;

alter table rent_return change column memberNo1 memberNo1 int(11);

alter table rent_return change column rentNo rentNo1 int(11);  

alter table member_info change column member_info.year births date;
drop table rent_return;


alter table member_info change column memberNo memberNo char(5);

desc book_info;
alter table book_info change column bookNum bookNum char(5);

select bookNum from book_info;

select memberNo, name, homeNo, phoneNo from member_info; 



alter table member_info change column memberNo memberNo int(8);



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
select bookto_days(now()) - now(date) then > 3; 
	from rent_return;

select date_format(now(), '%H:%i:%s'); 

select * from rent_return;


-- sql 하는 친구
select rentNo, bookNum, bookName, bookCan, bookKind from book_info;

select * from book_kind;
select * from member_info;
select * from rent_return;
select * from book_info;

-- 검색 조인


select memberNo, name, homeNo, phoneNo from member_info where memberNo like 12001 or name like '홍길동';


-- 이름선택시 도서번호 도서제목 도서연체일 도서대여일 이 나오게 하쇼.
select b.bookNum,
		b.bookName,
		r.bookRent,
		r.bookOver 
	from rent_return r join member_info m on r.memberNo1 = m.memberNo
	join book_info b on b.rentNo =r.rentNo1
	where m.memberNo = 12001;

select bookNum,bookName 
	from book_info
	where bookCan = '대출가능';

desc rent_return


;

select r.memberNo1,b.bookNum,b.bookName, r.bookRent, r.bookOver from rent_return r join member_info m on r.memberNo1 = m.memberNo join book_info b on b.rentNo =r.rentNo1 where m.memberNo = 12005;


select * from vm_fk_easy;
drop view vm_fk_easy;
select * from book_info;

delete 
from book_info 
where bookNum = 40011;

insert into book_info values
		(11, 40011, 'easyWay', '불가',4);

create view vm_fk_easy
as
select m.memberNo
		,b.bookNum
		,b.bookName
		, r.bookRent
		, r.bookOver
from rent_return r join member_info m on r.memberNo1 = m.memberNo
join book_info b on b.rentNo =r.rentNo1;

select memberNo1,rentNo1,bookRent,bookReturn,bookOver,memberNo,name,births,homeNo,phoneNo,adress,rentNo,bookNum,bookName,b.bookCan,b.bookKind,bk.bookKind,kindTitle
from rent_return r join member_info m on r.memberNo1 = m.memberNo
join book_info b on b.rentNo =r.rentNo1
join book_kind bk on b.bookKind = bk.bookKind;
