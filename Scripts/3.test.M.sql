
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

select * from member_info;

-- 회원 상세 출력
select memberNo1,rentNo1,bookRent,bookReturn,bookOver,memberNo,name,births,homeNo,phoneNo,adress,rentNo,bookNum,bookName
from rent_return r join member_info m on r.memberNo1 = m.memberNo
join book_info b on b.rentNo =r.rentNo1
where b.bookCan ='대출가능';

-- 대여회원 상세정보
 
select memberNo
	   ,name
	   ,births 
	   ,homeNo
	   ,phoneNo
	   ,adress
from member_info
where memberNo=12001;

-- 날짜
select date_format(births,'%Y-%m-%d') as a, date_format(now(), '%Y-%m-%d') as b, datediff(now(), births) from member_info;



SELECT *
FROM member_info
WHERE YEAR(births) = YEAR(DATE_SUB(CURDATE(), INTERVAL -1 MONTH))
AND MONTH(births) = MONTH(DATE_SUB(CURDATE(), INTERVAL -1 MONTH))



select * from rent_return;
 --  대출 중(불가)인것은 rentNo 가 1 
 -- 대출 가능한것은 rentNo가 2


update book_info set rentNo = 1 where bookNum = 40006; 

select * from rent_return;
select * from book_info;
select * from member_info;



-- rentreturn 인곳에 인원 추가하는 방법
insert into rent_return(rentNo, memberNo, bookNum1, bookRent, bookReturn, bookOver) values (3, 12003, 40003, now(), null, 0);
insert into rent_return(rentNo, memberNo, bookNum1, bookRent, bookReturn, bookOver) values (2, 12002, 40002, now(), null, 0);

update book_info set bookCan = '대출불가' where bookNum = 40003;

-- main 좌측 리스트
select memberNo,name,homeNo,phoneNo from member_info;
-- main 좌측 검색
select memberNo,name,homeNo,phoneNo from member_info where memberNo like '%01%' or name like'%김%';

select * from rent_return;

-- rentReturn멤
select r.memberNo, r.bookNum1, b.bookName, r.bookRent, r.bookOver 
from rent_return r join member_info m on r.memberNo = m.memberNo
join book_info b on r.bookNum1 =b.bookNum
where m.memberNo = ifnull(12001,0);

insert into member_info values(0, '정보없음','00000000','000-000-0000','000-0000-0000','없음');

select * from rent_return;
select * from member_info;

-- 맞춰서 뜨게 해주기
select m.memberNo, m.name,m.births, m.homeNo,m.phoneNo, m.adress
from member_info m join rent_return r on m.memberNo = r.memberNo
where m.memberNo like '%12%' and r.bookNum1 like '%40%';

-- 날짜 비교.
select bookReturn 
from rent_return
where rentNo = 1;

select datediff(dd, bookRent , now()) as '날짜차이' from rent_return;

-- 메인화면 하단 (clickTablePanel) 
select memberNo
	   ,name
	   ,births 
	   ,homeNo
	   ,phoneNo
	   ,adress
from member_info
where memberNo=12001;
-- 그대로 쓰면 대겟는데?
where memberNo,name,birth,homeNo,phoneNo,adress 
from member_info
where memberNo = 12001;

select * from member_info m;
-- 회원번호 기준으로 클릭시 테이블이 뜨 게한후 그사람이 대여중인 정보만 보여주는 창이다.
select m.memberNo,name,homeNo,phoneNo from member_info m join rent_return r on m.memberNo = r.memberNo where m.memberNo = 12003;

-- 5가지만 상세정보에 뜨게 하는것
select m.memberNo, name, births, phoneNo, adress 
from member_info m join rent_return r on m.memberNo = r.memberNo 
where m.memberNo =12003;

