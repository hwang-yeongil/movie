CREATE TABLE MEMBER(
	id NUMBER NOT NULL PRIMARY key,
	username varchar2(50) NOT NULL,
	userpw varchar2(50) NOT NULL,
	address varchar2(50) NOT NULL,
	admin char(4) NOT NULL,
	secession char(4) NOT NULL
);

CREATE TABLE movie(
	movie_pk NUMBER NOT NULL PRIMARY key,
	movie_name varchar2(50) NOT NULL
);

CREATE TABLE seat(
	seat_pk NUMBER NOT NULL PRIMARY key,
	seat_num NUMBER NOT NULL
);

CREATE TABLE screen(
	scr_pk NUMBER NOT NULL PRIMARY key,
	seat_pk NUMBER NOT NULL,
	movie_pk NUMBER NOT NULL,
	scr_date date NOT NULL,
	CONSTRAINT scr_seat_fk foreign key(seat_pk) references seat (seat_pk),
	CONSTRAINT scr_movie_fk foreign key(movie_pk) references movie (movie_pk)
);

CREATE TABLE review(
	review_pk NUMBER NOT NULL PRIMARY key,
	movie_pk NUMBER NOT NULL,
	userid NUMBER NOT NULL,
	rv_date DATE NOT NULL,
	rv_content varchar2(1000) NOT NULL,
	rv_title varchar2(50) NOT NULL,
	CONSTRAINT rv_userid_fk foreign key(userid) references member (id),
	CONSTRAINT rv_movie_fk foreign key(movie_pk) references movie (movie_pk)
);

CREATE TABLE reservation(
	reservation_pk NUMBER NOT NULL PRIMARY key,
	userid NUMBER NOT NULL,
	scr_pk NUMBER NOT NULL,
	reserv_date date NOT NULL,
	CONSTRAINT res_userid_fk foreign key(userid) references member (id),
	CONSTRAINT res_scr_fk foreign key(scr_pk) references screen (scr_pk)
);
DROP TABLE reservation;
DROP TABLE review;
DROP TABLE screen;
DROP TABLE seat;
DROP TABLE movie;
DROP TABLE MEMBER;




SELECT * FROM MEMBER;	