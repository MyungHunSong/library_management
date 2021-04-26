select user(), database();

select bookKind,kindTitle from book_kind;

select kindTitle from book_kind where bookKind = 1;

select bookKind,kindTitle from book_kind;

select bookKind,kindTitle from book_kind where bookKind = 1;
-- 인서트
insert into book_kind values (5, '과학');


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





 