select * from book_info;
select * from member_info;
select * from rent_return;

desc member_info;

delete from member_info where memberNo =0;

update book_info set bookCan = '대출가능' where bookNum = 40004;
-- 대출
insert into rent_return(memberNo, bookNum1, bookRent, bookReturn, bookOver) values(12004,40004, now(), null,0);
update book_info set bookCan ='대출불가' where bookNum = 40004;

-- 반납
update book_info set bookCan = '대출가능' where bookNum = 40004;
delete from rent_return where rentNo = 6;

update rent_return set bookreturn = now() where rentNo= 6 and bookreturn is null;
