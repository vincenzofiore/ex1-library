-- AUTHENTICATION & AUTHORIZATION MODEL
CREATE TABLE PRIVILEGE (ID SERIAL PRIMARY KEY, NAME VARCHAR(20) UNIQUE);
CREATE TABLE ROLE (ID SERIAL PRIMARY KEY, NAME VARCHAR(20) UNIQUE);
CREATE TABLE APPLICATION_USER (
	ID SERIAL PRIMARY KEY,
	FIRST_NAME VARCHAR(50) NOT NULL,
	LAST_NAME VARCHAR(50) NOT NULL,
	USERNAME VARCHAR(20) NOT NULL UNIQUE,
	PASSWORD VARCHAR(100) NOT NULL,
	EMAIL VARCHAR(320) NOT NULL UNIQUE,
	ENABLED BOOLEAN DEFAULT FALSE NOT NULL,
	TOKEN_EXPIRED BOOLEAN DEFAULT FALSE NOT NULL,
	MEMBER_ID INTEGER);
CREATE TABLE USER_ROLE (USER_ID INTEGER NOT NULL REFERENCES APPLICATION_USER(ID), ROLE_ID INTEGER NOT NULL REFERENCES ROLE(ID), PRIMARY KEY(USER_ID, ROLE_ID));
CREATE TABLE ROLE_PRIVILEGE (ROLE_ID INTEGER NOT NULL REFERENCES ROLE(ID), PRIVILEGE_ID INTEGER NOT NULL REFERENCES PRIVILEGE(ID), PRIMARY KEY(ROLE_ID, PRIVILEGE_ID));
-- CONFIG PRIVILEGES
INSERT INTO PRIVILEGE (NAME) VALUES	('INSERT_PRIVILEGE'), ('DELETE_PRIVILEGE'),	('UPDATE_PRIVILEGE');
-- CONFIG ROLES
INSERT INTO ROLE (NAME) VALUES ('USER_ROLE');
INSERT INTO ROLE_PRIVILEGE VALUES (1, 1), (1, 2), (1, 3);
INSERT INTO ROLE (NAME) VALUES ('ADMIN_ROLE');
INSERT INTO ROLE_PRIVILEGE VALUES (2, 1), (2, 2), (2, 3);
-- APPLICATION MODEL
CREATE TABLE MEMBER (ID SERIAL PRIMARY KEY, APPLICATION_USER_ID INTEGER NOT NULL REFERENCES APPLICATION_USER(ID), NAME VARCHAR(50), SURNAME VARCHAR(50), INS_DATE DATE, TEL_NUMBER VARCHAR(12), EMAIL VARCHAR(100), ADDRESS TEXT, NOTES TEXT);
CREATE TABLE AUTHOR (ID SERIAL PRIMARY KEY, NAME VARCHAR(50), SURNAME VARCHAR(50), BIRTH_DATE DATE, BIRTH_PLACE VARCHAR(50), DEATH_DATE DATE, DEATH_PLACE VARCHAR(50), NOTES TEXT);
CREATE TABLE BOOK (ISBN VARCHAR(13) PRIMARY KEY, TITLE VARCHAR(50), AUTHOR VARCHAR(100), PUBLISHER VARCHAR(50), PUBLICATION_DATE DATE, LANGUAGE VARCHAR(50), ORIGINAL_LANGUAGE BOOLEAN, NOTES TEXT);
CREATE TABLE VOLUME (ID SERIAL PRIMARY KEY, BOOK VARCHAR(13) NOT NULL REFERENCES BOOK(ISBN), FORMAT VARCHAR(50), OWNER INTEGER NOT NULL REFERENCES MEMBER(ID), INSER_DATE DATE, LOAN_STATE VARCHAR(20), AVAILABLE_FOR_LOAN BOOLEAN, AVAILABLE_FOR_CONSULTATION BOOLEAN, NOTES TEXT);
CREATE TABLE LOAN (ID SERIAL PRIMARY KEY, VOLUME INTEGER NOT NULL REFERENCES VOLUME(ID), LOAN_DATE DATE, RETURN_DATE DATE, OWNER INTEGER REFERENCES MEMBER(ID), BORROWER INTEGER NOT NULL REFERENCES MEMBER(ID), NOTES TEXT);
CREATE TABLE BOOK_AUTHOR (BOOK_ID VARCHAR(13) NOT NULL REFERENCES BOOK(ISBN), AUTHOR_ID INTEGER NOT NULL REFERENCES AUTHOR(ID), PRIMARY KEY(BOOK_ID, AUTHOR_ID));
-- CONSTRIANTS
ALTER TABLE APPLICATION_USER ADD CONSTRAINT FK_APPLICATION_USER_MEMBER FOREIGN KEY(MEMBER_ID) REFERENCES MEMBER(ID);