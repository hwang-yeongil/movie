--CREATE TABLE MEMBER(
--	id NUMBER NOT NULL PRIMARY key,
--	username varchar2(50) NOT NULL,
--	userpw varchar2(100) NOT NULL,
--	role varchar2(50) NOT NULL,
--	secession char(4) NOT NULL
--);

CREATE TABLE MEMBER(
	id varchar2(50) NOT NULL PRIMARY key,
	userpw varchar2(100) NOT NULL,
	role varchar2(50) NOT NULL,
	secession char(4) NOT NULL
);

CREATE TABLE movie(
	movie_pk NUMBER NOT NULL PRIMARY key,
	movie_name varchar2(50) NOT NULL
);

CREATE TABLE theater(
	theater_pk NUMBER NOT NULL PRIMARY KEY
);

CREATE TABLE seat(
	seat_pk NUMBER NOT NULL PRIMARY key,
	theater_pk NUMBER NOT NULL,
	seat_name varchar2(1000) NOT NULL,
	CONSTRAINT seat_theater_fk foreign key(theater_pk) references theater (theater_pk)
);

CREATE TABLE screen(
	scr_pk NUMBER NOT NULL PRIMARY key,
	theater_pk NUMBER NOT NULL,
	movie_pk NUMBER NOT NULL,
	scr_date date NOT NULL,
	CONSTRAINT scr_theater_fk foreign key(theater_pk) references theater (theater_pk),
	CONSTRAINT scr_movie_fk foreign key(movie_pk) references movie (movie_pk)
);

CREATE TABLE review(
	review_pk NUMBER NOT NULL PRIMARY key,
	movie_pk NUMBER NOT NULL,
	member_id varchar2(50) NOT NULL,
  	rv_star NUMBER NOT NULL,
	rv_date DATE NOT NULL,
	rv_content varchar2(1000) NOT NULL,
	rv_title varchar2(50) NOT NULL,
	CONSTRAINT rv_userid_fk foreign key(member_id) references member (id),
	CONSTRAINT rv_movie_fk foreign key(movie_pk) references movie (movie_pk)
);

CREATE TABLE reservation(
	reservation_pk NUMBER NOT NULL PRIMARY key,
	member_id varchar2(50) NOT NULL,
	scr_pk NUMBER NOT NULL,
	seat_pk NUMBER NOT NULL,
	reserv_date date NOT NULL,
	CONSTRAINT res_seat_fk foreign key(seat_pk) references seat (seat_pk),
	CONSTRAINT res_member_id_fk foreign key(member_id) references member (id),
	CONSTRAINT res_scr_fk foreign key(scr_pk) references screen (scr_pk)
);


INSERT INTO "MEMBER" VALUES('admin','admin','ADMIN','0');
INSERT INTO "MEMBER" VALUES('tester1','1234','User','0');
INSERT INTO "MEMBER" VALUES('tester2','1234','User','0');
INSERT INTO "MEMBER" VALUES('tester3','1234','User','0');
INSERT INTO "MEMBER" VALUES('tester4','1234','User','0');
INSERT INTO "MEMBER" VALUES('tester5','1234','User','0');
INSERT INTO "MEMBER" VALUES('tester6','1234','User','0');

INSERT INTO MOVIE VALUES (1,'오펜하이머');
INSERT INTO MOVIE VALUES (2,'천박사 퇴마 연구소');
--INSERT INTO MOVIE VALUES (3,'더 넌 2');
--INSERT INTO MOVIE VALUES (4,'크리에이터');
--INSERT INTO MOVIE VALUES (5,'30일');
--INSERT INTO MOVIE VALUES (6,'거미집');

INSERT INTO theater VALUES(1);
INSERT INTO theater VALUES(2);
INSERT INTO theater VALUES(3);

INSERT INTO SEAT values(1, 1, 'A1');
INSERT INTO SEAT values(2, 1, 'A2');
INSERT INTO SEAT values(3, 1, 'A3');
INSERT INTO SEAT values(4, 1, 'A4');
INSERT INTO SEAT values(5, 1, 'A5');
INSERT INTO SEAT values(6, 1, 'A6');
INSERT INTO SEAT values(7, 1, 'A7');
INSERT INTO SEAT values(8, 1, 'A8');
INSERT INTO SEAT values(9, 1, 'A9');
INSERT INTO SEAT values(10, 1, 'A10');
INSERT INTO SEAT values(11, 1, 'B1');
INSERT INTO SEAT values(12, 1, 'B2');
INSERT INTO SEAT values(13, 1, 'B3');
INSERT INTO SEAT values(14, 1, 'B4');
INSERT INTO SEAT values(15, 1, 'B5');
INSERT INTO SEAT values(16, 1, 'B6');
INSERT INTO SEAT values(17, 1, 'B7');
INSERT INTO SEAT values(18, 1, 'B8');
INSERT INTO SEAT values(19, 1, 'B9');
INSERT INTO SEAT values(20, 1, 'B10');
INSERT INTO SEAT values(21, 2, 'A1');
INSERT INTO SEAT values(22, 2, 'A2');
INSERT INTO SEAT values(23, 2, 'A3');
INSERT INTO SEAT values(24, 2, 'A4');
INSERT INTO SEAT values(25, 2, 'A5');
INSERT INTO SEAT values(26, 2, 'A6');
INSERT INTO SEAT values(27, 2, 'A7');
INSERT INTO SEAT values(28, 2, 'A8');
INSERT INTO SEAT values(29, 2, 'A9');
INSERT INTO SEAT values(30, 2, 'A10');
INSERT INTO SEAT values(31, 2, 'B1');
INSERT INTO SEAT values(32, 2, 'B2');
INSERT INTO SEAT values(33, 2, 'B3');
INSERT INTO SEAT values(34, 2, 'B4');
INSERT INTO SEAT values(35, 2, 'B5');
INSERT INTO SEAT values(36, 2, 'B6');
INSERT INTO SEAT values(37, 2, 'B7');
INSERT INTO SEAT values(38, 2, 'B8');
INSERT INTO SEAT values(39, 2, 'B9');
INSERT INTO SEAT values(40, 2, 'B10');


INSERT INTO SCREEN VALUES (1,1,1,TO_DATE('23/12/01 07:00', 'YY/MM/DD HH24:MI'));
INSERT INTO SCREEN VALUES (2,1,2,TO_DATE('23/12/01 10:00', 'YY/MM/DD HH24:MI'));
INSERT INTO SCREEN VALUES (3,2,1,TO_DATE('23/12/03 08:00', 'YY/MM/DD HH24:MI'));
INSERT INTO SCREEN VALUES (4,2,1,TO_DATE('23/12/03 12:00', 'YY/MM/DD HH24:MI'));
INSERT INTO SCREEN VALUES (5,1,3,TO_DATE('23/12/03 12:00', 'YY/MM/DD HH24:MI'));

select* from reservation;

INSERT INTO RESERVATION values(1,'tester1',1,10,to_date(sysdate,'YY/MM/DD HH24:MI'));
INSERT INTO RESERVATION values(2,'tester1',1,9,to_date(sysdate,'YY/MM/DD HH24:MI'));

commit;

DROP TABLE reservation;
DROP TABLE review;
DROP TABLE screen;
DROP TABLE seat;
-- 0926 테이블 추가
DROP TABLE theater;
DROP TABLE movie;
DROP TABLE MEMBER;

------------------------------- 필요한 쿼리들 ------------------
/* 보여줘야할거
 1. 예매 화면 : 영화 이름(리스트) / 선택한 영화의 상영일 및 시간 / 해당 시간의 상영관 / 상영관읜 남은 좌석 (총 좌석- 예매한 죄석)   
 2. 내가 예매한 영화 : 예매한 영화 화면 / 영화 이름 / 예약일 / 상영일 및 시간 / 상영관 / 좌석 번호 / 
 3. 
 
 , s2.SEAT_NAME  
*/
--영화 이름(리스트)
SELECT m.MOVIE_NAME 
FROM SCREEN s  , MOVIE m 
WHERE s.MOVIE_PK = m.MOVIE_PK 
AND s.SCR_DATE >SYSDATE
;
--영화 이름 / 선택한 영화의 상영일 및 시간 / 해당 시간의 상영관 (리스트)
SELECT m.MOVIE_NAME , s.SCR_DATE ,s.THEATER_PK 
FROM SCREEN s  , MOVIE m 
WHERE s.MOVIE_PK = m.MOVIE_PK
AND s.MOVIE_PK = 1
AND s.SCR_DATE >SYSDATE
;
--영화 이름 / 선택한 영화의 상영일 및 시간 / 해당 시간의 상영관 / 총 좌석 (리스트)
SELECT m.MOVIE_NAME , s.SCR_DATE, s.THEATER_PK, s2.SEAT_NAME 
FROM SCREEN s  , MOVIE m , SEAT s2 
WHERE s.MOVIE_PK = m.MOVIE_PK
AND s.MOVIE_PK = 1
AND s.SCR_DATE >SYSDATE
AND s.THEATER_PK =1
AND s.THEATER_PK = s2.THEATER_PK 
;

--예매된 좌석
SELECT s2.SEAT_NAME  
FROM MOVIE m2 ,RESERVATION r ,SCREEN s,THEATER t ,SEAT s2 
WHERE r.SCR_PK = s.SCR_PK
AND s.MOVIE_PK = m2.MOVIE_PK
AND s.THEATER_PK = t.THEATER_PK
AND s.THEATER_PK =s2.THEATER_PK 
AND r.SEAT_PK = s2.SEAT_PK 
;
7              11
SELECT * FROM RESERVATION;

-- 예매 정보
SELECT m.username ,pk.RESERVATION_PK, s.scr_pk, m.movie_name 
FROM RESERVATION pk, SCREEN s, MOVIE m,MEMBER m
WHERE pk.SCR_PK = s.scr_pk
AND s.movie_pk = m.movie_pk
AND pk.USERID =m.id
	;	
	

SELECT * FROM MEMBER;
SELECT * FROM review;