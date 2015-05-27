package org.geekhub.hibernate.bean;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;


public class TestConfigBeen {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private int id;
    private String tittle;
    private int questionCount;
    private Date dateStart;
    private Date dateFinish;
    private String dateStartStr;
    private String dateFinishStr;
    private int timeToTest;
    private TestStatus status;
    private CourseBean courseBean;


    public TestConfigBeen() {
    }

    public TestConfigBeen(int id, String tittle, int questionCount, Date dateStart, Date dateFinish, int timeToTest,
                          TestStatus status, CourseBean courseBean) {
        this(tittle, questionCount, dateStart, dateFinish, timeToTest, status);
        this.id = id;
        this.courseBean = courseBean;
    }

    public TestConfigBeen(String tittle, int questionCount, Date dateStart, Date dateFinish, int timeToTest, TestStatus status,
                          CourseBean courseBean) {
        this(tittle, questionCount, dateStart, dateFinish, timeToTest, status);
        this.courseBean = courseBean;
    }

    public TestConfigBeen(int id, String tittle, int questionCount, Date dateStart, Date dateFinish, int timeToTest, TestStatus status) {
        this(tittle, questionCount, dateStart, dateFinish, timeToTest, status);
        this.id = id;
    }
    public TestConfigBeen(String tittle, int questionCount, Date dateStart, Date dateFinish, int timeToTest, TestStatus status) {
        this.tittle = tittle;
        this.questionCount = questionCount;
        this.dateStartStr = formatter.format(dateStart);
        this.dateFinishStr = formatter.format(dateFinish);
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.timeToTest = timeToTest;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public int getTimeToTest() {
        return timeToTest;
    }

    public void setTimeToTest(int timeToTest) {
        this.timeToTest = timeToTest;
    }

    public TestStatus getStatus() {
        return status;
    }

    public void setStatus(TestStatus status) {
        this.status = status;
    }

    public CourseBean getCourseBean() {
        return courseBean;
    }

    public void setCourseBean(CourseBean courseBean) {
        this.courseBean = courseBean;
    }

    public String getDateStartStr() {
        return dateStartStr;
    }

    public void setDateStartStr(String dateStartStr) {
        this.dateStartStr = dateStartStr;
    }

    public String getDateFinishStr() {
        return dateFinishStr;
    }

    public void setDateFinishStr(String dateFinishStr) {
        this.dateFinishStr = dateFinishStr;
    }
}
