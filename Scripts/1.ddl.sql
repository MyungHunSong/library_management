-- 도서관리
DROP SCHEMA IF EXISTS `library_management`;

-- 도서관리
CREATE SCHEMA `library_management`;

-- 회원정보
CREATE TABLE `library_management`.`member_info` (
	`memberNo` INT         NOT NULL COMMENT '회원번호', -- 회원번호
	`name`     varchar(15) NULL     COMMENT '이름', -- 이름
	`year`     DATE        NULL     COMMENT '생년월일', -- 생년월일
	`homeNo`   char(13)    NULL     COMMENT '전화번호', -- 전화번호
	`phoneNo`  char(13)    NULL     COMMENT '휴대전화', -- 휴대전화
	`adress`   varchar(30) NULL     COMMENT '주소' -- 주소
)
COMMENT '회원정보';

-- 회원정보
ALTER TABLE `library_management`.`member_info`
	ADD CONSTRAINT `PK_member_info` -- 회원정보 기본키
		PRIMARY KEY (
			`memberNo` -- 회원번호
		);

-- 도서정보
CREATE TABLE `library_management`.`book_info` (
	`rentNo`   INT         NOT NULL COMMENT '대여번호', -- 대여번호
	`bookNum`  INT         NOT NULL COMMENT '도서번호', -- 도서번호
	`bookName` VARCHAR(20) NULL     COMMENT '도서제목', -- 도서제목
	`bookRent` char(4)     NULL     COMMENT '대출여부', -- 대출여부
	`bookKind` INT         NULL     COMMENT '도서구분' -- 도서구분
)
COMMENT '도서정보';

-- 도서정보
ALTER TABLE `library_management`.`book_info`
	ADD CONSTRAINT `PK_book_info` -- 도서정보 기본키
		PRIMARY KEY (
			`rentNo` -- 대여번호
		);

-- 대출/반납
CREATE TABLE `library_management`.`return` (
	`memberNo` INT      NOT NULL COMMENT '회원번호', -- 회원번호
	`bookRent` DATE     NULL     COMMENT '도서대여일', -- 도서대여일
	`bookOver` DATETIME NULL     COMMENT '도서연체일', -- 도서연체일
	`rentNo`   INT      NULL     COMMENT '대여번호' -- 대여번호
)
COMMENT '대출/반납';

-- 대출/반납
ALTER TABLE `library_management`.`return`
	ADD CONSTRAINT `PK_return` -- 대출/반납 기본키
		PRIMARY KEY (
			`memberNo` -- 회원번호
		);

-- 도서구분 
CREATE TABLE `library_management`.`book_kind` (
	`bookKind`  INT         NOT NULL COMMENT '도서구분', -- 도서구분
	`kindTitle` varchar(20) NULL     COMMENT '도서종류제목' -- 도서종류제목
)
COMMENT '도서구분 ';

-- 도서구분 
ALTER TABLE `library_management`.`book_kind`
	ADD CONSTRAINT `PK_book_kind` -- 도서구분  기본키
		PRIMARY KEY (
			`bookKind` -- 도서구분
		);

-- 도서정보
ALTER TABLE `library_management`.`book_info`
	ADD CONSTRAINT `FK_book_kind_TO_book_info` -- 도서구분  -> 도서정보
		FOREIGN KEY (
			`bookKind` -- 도서구분
		)
		REFERENCES `library_management`.`book_kind` ( -- 도서구분 
			`bookKind` -- 도서구분
		);

-- 대출/반납
ALTER TABLE `library_management`.`return`
	ADD CONSTRAINT `FK_member_info_TO_return` -- 회원정보 -> 대출/반납
		FOREIGN KEY (
			`memberNo` -- 회원번호
		)
		REFERENCES `library_management`.`member_info` ( -- 회원정보
			`memberNo` -- 회원번호
		);

-- 대출/반납
ALTER TABLE `library_management`.`return`
	ADD CONSTRAINT `FK_book_info_TO_return` -- 도서정보 -> 대출/반납
		FOREIGN KEY (
			`rentNo` -- 대여번호
		)
		REFERENCES `library_management`.`book_info` ( -- 도서정보
			`rentNo` -- 대여번호
		);

grant all on library_management.* to 'user_native_jdbc'@'localhost' identified by 'rootroot';

desc library_manegement;
