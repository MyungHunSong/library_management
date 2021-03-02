SELECT USER(), database();

use library_manegement;

insert into library_management.member_info values
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



select * from library_management.member_info;

-- 도서정보  => 1.대여번호 2.도서번호 3.도서제목 4.대출여부 5.도서 구분(수학 1, 컴퓨터 2, 전자 3, 통계 4)
insert into library_management.book_info values
	(1, 40001, 'the elements of statistical learning','대출가능', 1),
	(2, 40002, 'Computer vision : a modern approach','대출가능',  2),
	(3, 40003, 'MATLAB for engineers','대출가능',  3),
	(4, 40004, 'CUDA by example','대출가능',  1),
	(5, 40005, 'An introduction to 3D computer vision','대출가능',  2),
	(6, 40006, 'Numerical methods','대출불가',  1),
	(7, 40007, 'Image-based modeling','대출불가',  2),
	(8, 40008, 'Machine learning','대출불가',  2),
	(9, 40009, 'Probabilistic robotics','대출불가',  4),
	(10,40010, 'Pattern recognition and machine learning','대출불가',  2);

-- 대출 반납.
insert into library_management.`return` values
	(12001, 20200807, yyyy-mm-dd HH:MM:SS, 1),
	(12002, 20200807, yyyy-mm-dd HH:MM:SS, 2),
	(12003, 20200807, yyyy-mm-dd HH:MM:SS, 3),
	(12004, 20200807, yyyy-mm-dd HH:MM:SS, 4),
	(12005, 20200807, yyyy-mm-dd HH:MM:SS, 5),
	(12006, 20200408, yyyy-mm-dd HH:MM:SS, 6),
	(12007, 20200308, yyyy-mm-dd HH:MM:SS, 7),
	(12008, 20200109, yyyy-mm-dd HH:MM:SS, 8),
	(12009, 20200120, yyyy-mm-dd HH:MM:SS, 9),
	(12010, 2020710, yyyy-mm-dd HH:MM:SS, 10),
	(12011, null, yyyy-mm-dd HH:MM:SS, 10);

	
-- 도서구분
insert into library_management.book_kind values
	(1,'수학'),
	(2,'컴퓨터'),
	(3,'전자'),
	(4,'통계');
	
alter table book_info change column bookName bookName varchar(50);

desc book_info;