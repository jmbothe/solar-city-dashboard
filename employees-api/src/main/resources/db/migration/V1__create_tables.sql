CREATE TABLE POSITIONS (
    ID serial,
    POSITION varchar(100) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE EMPLOYEES (
    ID serial,
    FIRST_NAME varchar(100) NOT NULL,
    LAST_NAME varchar(100) NOT NULL,
    POSITION long NOT NULL REFERENCES POSITIONS(ID),
    PRIMARY KEY (ID)
);

--SELECT FIRST_NAME, LAST_NAME, POSITIONS.POSITION FROM EMPLOYEES
--LEFT JOIN POSITIONS ON EMPLOYEES.POSITION = POSITIONS.ID
--WHERE POSITIONS.ID = 1;