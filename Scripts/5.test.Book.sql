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

