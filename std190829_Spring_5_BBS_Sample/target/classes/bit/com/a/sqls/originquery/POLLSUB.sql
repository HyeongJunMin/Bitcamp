--DROP TABLE POLLSUB CASCADE CONSTRAINTS;
--DROP SEQUENCE SEQ_POLLSUB;

CREATE TABLE POLLSUB(
    POLLSUBID NUMBER(10) NOT NULL,
    POLLID NUMBER(10) NOT NULL,
    ANSWER VARCHAR2(1000) NOT NULL,
    ACOUNT NUMBER(10) NOT NULL,
    CONSTRAINT POLLSUB_PK PRIMARY KEY(POLLSUBID)
);

CREATE SEQUENCE SEQ_POLLSUB START WITH 1 INCREMENT BY 1;

ALTER TABLE POLLSUB ADD CONSTRAINT POLLSUB_FK FOREIGN KEY(POLLID) REFERENCES POLL(POLLID);