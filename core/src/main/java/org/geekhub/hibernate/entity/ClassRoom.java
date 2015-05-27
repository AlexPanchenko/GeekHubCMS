package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CLASSROOM")
public class ClassRoom extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "CLASSROOM_ID")
    private int id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "classroom")
    private List<User> users = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course courseId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }
}
