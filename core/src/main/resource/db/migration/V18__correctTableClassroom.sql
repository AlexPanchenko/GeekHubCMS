DROP TABLE CLASSROOM;
CREATE TABLE CLASSROOM(
   CLASSROOM_ID INT NOT NULL AUTO_INCREMENT,
   NAME VARCHAR(25) NOT NULL,
   DESCRIPTION VARCHAR(255) NOT NULL,
   COURSE_ID INT NOT NULL,
   TEACHER_ID INT,
   PRIMARY KEY (CLASSROOM_ID)
);