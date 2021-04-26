SELECT USER(), database();

use library_management;



insert into member_info values 
	(12001, '홍길동', 19070405, '042-421-1739', '010-9741-5821', '대전'),
	(12002, '김연수', 19850301, '064-446-8695' , '010-4568-5581', '제주'),
	(12003, '김지원', 19860708, '053-548-7898', '010-9111-5556', '대구'),
	(12004, '문희원', 19800108, '052-221-1231', '010-7777-7777', '울산'),
	(12005, '유일한', 19790205, '051-111-2222', '010-4566-8886', '부산'),
	(12006, '김동수', 19811123, '02-668-8887', '010-1231-1211', '서울'),
	(12007, '배진태', 19820707, '044-500-7333', '010-7877-7777', '세종'),
	(12008, '류은수', 19830301, '062-233-1122', '010-7444-1474', '광주'),
	(12009, '김동철', 19870426, '061-887-4454', '010-8525-1235', '순천'),
	(12010, '최홍석', 19900405, '054-555-7897', '010-3214-6547', '포항'),
	(12011, '김동수', 19830108, '043-529-8457', '010-9566-4228', '제천');
	
	

-- 도서정보  => 1.대여번호 2.도서번호 3.도서제목 4.대출여부 5.도서 구분(수학 1, 컴퓨터 2, 전자 3, 통계 4)
drop table rent_return;
drop table book_info;
drop table book_kind;
insert into book_info values
	(40001, 'the elements of statistical learning','대출불가', 1),
	(40002, 'Computer vision : a modern approach','대출불가', 2),
	(40003, 'MATLAB for engineers','대출불가', 3),
	(40004, 'CUDA by example','대출가능',  1),
	(40005, 'An introduction to 3D computer vision','대출가능', 2),
	(40006, 'Numerical methods','대출가능',  1),
	(40007, 'Image-based modeling','대출가능',  2),
	(40008, 'Machine learning','대출가능', 2),
	(40009, 'Probabilistic robotics','대출가능',  4),
	(40010, 'Pattern recognition and machine learning','대출가능', 2);
	
-- 
drop table book_info;
drop table book_kind;
drop table rent_return;

select * from rent_return;



	

-- 검색
select * from rent_return;
-- 삭제 
drop table rent_return;
	
--

-- 도서구분
insert into book_kind values
	(1,'수학'),
	(2,'컴퓨터'),
	(3,'전자'),
	(4,'통계');

-- 북네임을 바꾼것
alter table book_info change column bookName bookName varchar(50);

-- bookOver 을 멀로 할꺼냐? int 타입이냐 date 타입이냐
alter table `return` change column bookOver bookOver int;

desc book_info;

select `return`, 

select sysdate - to_date(20200716, 2020729);

alter table book_info change column bookCan bookCan int(2);
--  권한 부여




                                                                                    

