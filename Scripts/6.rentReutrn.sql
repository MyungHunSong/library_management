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

update rent_return set bookReturn = now() where rentNo = 8 and bookReturn is null;

delete from rent_return where rentNo = 7;

select * from rent_return;
select * from book_info;

-- 멤버 테이블 , 도서 테이블 또한 안뜨게해야한다.
select m.memberNo, m.name, m.homeNo, m.phoneNo from
				member_info m join rent_return r on m.memberNo = r.memberNo 
				join book_info b on b.bookNum = r.bookNum1
				where bookCan = '대출불가';
			
-- 
