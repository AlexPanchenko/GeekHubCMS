package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class ClassRoom extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "CLASSROOM_ID")
    private int id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "classroomTeacher")
    private List<User> teachers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private int courseId;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "classroomStudents")
    private List<User> students = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<User> teachers) {
        this.teachers = teachers;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }
}
