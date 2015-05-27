package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 27.05.2015.
 */
@Entity
@Table(name = "TEST_TYPE")
public class TestType {

    @Id
    @GeneratedValue
    @Column(name = "TEST_TYPE_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "TEST_TYPE_NAME", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "testType")
    List<TestConfig> testConfigList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "testType")
    List<Question> questionList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestConfig> getTestConfigList() {
        return testConfigList;
    }

    public void setTestConfigList(List<TestConfig> testConfigList) {
        this.testConfigList = testConfigList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
