select user(), database();

select bookKind,kindTitle from book_kind;

select kindTitle from book_kind where bookKind = 1;

select bookKind,kindTitle from book_kind;

select bookKind,kindTitle from book_kind where bookKind = 1;

-- update 업데이타
update book_kind 
	set bookKind = 6
	where bookKind = 5;

delete from book_kind where bookKind =5;

select bookNum, bookName, r1.bookRent, r1.bookOver from book_info b1 join rent_return r1 on b1.rentNo =r1.rentNo1;

select * from member_info;

alter table member_info change column `year` births datetime;
-- 수정한 테이블들 

select * from rent_return r join book_info b on r.rentNo1 = b.bookNum;

--  대여도서상세정보.
select bi.bookName, bi.bookNum, bk.kindTitle, bi.bookCan from book_info bi join book_kind bk on bi.bookKind =bk.bookKind where bookNum=40001; 

-- 도서 대출가능여부
select bookNum, bookName, bookCan from book_info where bookCan='대출가능';

-- 도서 대출가능 여부
select bookNum, bookName, bookCan=
case when bookCan = '대출가능' then 1
	when bookCan = '대출불가' then 0
	else '도서목록없음'
	end
from book_info;

-- 1.
-- Return(반납)의 메인 기능중하나.

select
	rentNo, memberNo, bookNum1 , book
from rent_return where rentNo;

-- 전체를 멤버번호로 검색하는법
select m.memberNo, name,births, homeNo, phoneNo,adress 
from member_info m join rent_return r on m.memberNo =r.memberNo
where m.memberNo= 12001;

select m.memberNo,name,births, homeNo, phoneNo,adress 
from member_info m join rent_return r on m.memberNo =r.memberNo
where rentNo = 1;

select *
from member_info m join rent_return r on m.memberNo =r.memberNo;

-- 그냥 반납하기 들어가면 나오는 선택창
select m.memberNo, m.name, m.homeNo, m.memberNo from
member_info m join rent_return r on m.memberNo = r.memberNo;

-- 하단 패널에서 대여자를 클릭해서 들어가면 나오는 반납창
select * from member_info m join rent_return r on m.memberNo = r.memberNo where m.memberNo = 12001;




