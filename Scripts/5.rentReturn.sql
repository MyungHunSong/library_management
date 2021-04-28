-- 반납 테이블. 사람번호 검색 이 결과값을 detail에 넣어준다.
select b.bookNum, b.bookName, bk.kindTitle, b.bookCan 
from book_info b join rent_return r on b.bookNum = r.bookNum1 
join member_info m on r.memberNo = m.memberNo join book_kind bk on bk.bookKind = b.bookKind 
where m.memberNo= 12001;

-- 회원 검색시 그사람이 빌린 도서 목록만 나오게 하라. 
select b.bookNum, b.bookName, r.bookOver, r.bookRent 
from book_info b join rent_return r on b.bookNum =r.bookNum1
join member_info m on r.memberNo = m.memberNo
where m.memberNo = 12001; 

select * from rent_return;

-- 날짜 
select datediff('returndate','rentdate') from rent_return;

-- 날짜 비교 오늘날짜와 렌트한날짜를 비교한다 -> 거기서 연체일자가 나올것이고.
select * from rent_return where (to_days(now()) - to_days(bookRent))<3;

-- 반납 북인포 테이블에 넣어줄것(검색해서).
select r.bookNum1, b.bookName, r.bookRent,r.bookOver 
from rent_return r join book_info b on r.bookNum1 = b.bookNum
join member_info m on r.memberNo = m.memberNo 
where r.memberNo = 12001;

select r.memberNo,r.bookNum1,b.bookName, r.bookRent, r.bookOver
			from rent_return r join member_info m on r.memberNo = m.memberNo 
			join book_info b on r.bookNum1 =b.bookNum 
			where m.memberNo = 12001;