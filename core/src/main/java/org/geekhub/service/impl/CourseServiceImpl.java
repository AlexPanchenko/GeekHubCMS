package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.TestConfigDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.*;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.UsersCourses;
import org.geekhub.hibernate.exceptions.CourseNotFoundException;
import org.geekhub.service.CourseService;
import org.geekhub.service.TestAssignmentService;
import org.geekhub.service.TestConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private UsersCoursesDao usersCoursesDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TestConfigDao testConfigDao;

    @Autowired
    private TestConfigService testConfigService;

    @Autowired
    private TestAssignmentService testAssignmentService;

    @Override
    public List<User> getUserFromCourse(int id){
        Course course = (Course) courseDao.read(id, Course.class);
        List<UsersCourses> usersCourses = course.getUsersCourses();
        List<User> allUsers = new ArrayList<User>();
        List<User> users = new ArrayList<User>();
        for(UsersCourses u: usersCourses)
            allUsers.add(u.getUser());
        List<TestAssignment> testAssignments = new ArrayList<TestAssignment>();
        for(User user: allUsers) {
            testAssignments = user.getTestAssignments();
            for(TestAssignment t: testAssignments){
                if(t.isPassed()){
                    users.add(user);
                }
            }
        }
        return users;
    }
    @Override
    public Page<CourseBean> getAll(int page, int recordsPerPage) {
        List<CourseBean> courses = convertToCourseBean(courseDao.getAll(page, recordsPerPage));
        int size = getAllBeans().size();
        int maxPages = (size % recordsPerPage == 0) ? (size / recordsPerPage) : (size / recordsPerPage) + 1;
        page = (page > maxPages) ? maxPages : page;
        int current = page;
        int begin = Math.max(1, current - recordsPerPage);
        int end = maxPages;
        Page<CourseBean> resultPage = new Page<>(courses, begin, current, size, maxPages, recordsPerPage, end);
        return resultPage;
    }

    @Override
    public List<CourseBean> getAllBeans() {
        List<Course> courses = courseDao.getAll();
        return convertToCourseBean(courses);
    }

    public void createCourse(String courseName, String courseDescription) {
        Course course = new Course();
        course.setName(courseName);
        course.setDescription(courseDescription);
        courseDao.create(course);

    }

    private List<CourseBean> convertToCourseBean(List<Course> courses) {
        List<CourseBean> courseBeans = new ArrayList<>(Collections.emptyList());
        courseBeans.addAll(courses.stream().map(course -> toBean(course)).collect(Collectors.toList()));
        return courseBeans;
    }

    /**
     * Convert {@link org.geekhub.hibernate.entity.Course} to {@link org.geekhub.hibernate.bean.CourseBean}
     *
     * @param course object to convert
     * @return {@link }dsd
     */
    @Override
    public CourseBean toBean(Course course) {

        CourseBean courseBean = new CourseBean(course.getId(), course.getName(), course.getDescription());

        return courseBean;
    }

    private Course toEntity(CourseBean courseBean) {
        Course course = new Course();
        course.setId(courseBean.getId());
        course.setName(courseBean.getName());
        course.setDescription(courseBean.getDescription());
        return course;
    }

    @Override
    public void create(CourseBean courseBean, TestConfigBeen testConfigBeen) {
        Course course = new Course();
        TestConfig testConfig = new TestConfig();
        course.setName(courseBean.getName());
        course.setDescription(courseBean.getDescription());
        course.getTestConfig();
        testConfig.setTitle(testConfigBeen.getTittle());
        testConfig.setDateStart(testConfigBeen.getDateStart());
        testConfig.setDateFinish(testConfigBeen.getDateFinish());
        testConfig.setTimeToTest(testConfigBeen.getTimeToTest());
        testConfig.setQuestionCount(testConfigBeen.getQuestionCount());
        testConfig.setStatus(testConfigBeen.getStatus());
        testConfig.setCourse(course);
        courseDao.create(course);
        testConfigDao.create(testConfig);
    }


    @Override
    public CourseBean getById(int id) throws CourseNotFoundException {
        Course course = (Course) courseDao.read(id, Course.class);
        if (null == course) throw new CourseNotFoundException();
        return toBean(course);
    }

    @Override
    public void update(CourseBean courseBean) throws CourseNotFoundException {

        Course course = (Course)courseDao.read(courseBean.getId(),Course.class);
        course.setName(courseBean.getName());
        course.setDescription(courseBean.getDescription());
        courseDao.update(course);
    }

    @Override
    public void delete(int courseId) throws CourseNotFoundException {

    }

    @Override
    public void deleteCourse(int courseId) throws CourseNotFoundException {
        courseDao.deleteCourseById(courseId);
    }



    public void unRegisterCourse (int id) {
           Course course = (Course) courseDao.read(id, Course.class);
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(principal.getUsername());
        List<UsersCourses> usersCoursesList = user.getUsersCourses();
        for (UsersCourses usersCourses : usersCoursesList) {
            if(usersCourses.getUser().equals(user) && usersCourses.getCourse().equals(course)) {
                usersCoursesDao.delete(usersCourses);
                TestConfig testConfig= testConfigService.getTestConfigByCource(course);
                TestAssignment testAssignment = testAssignmentService.getTestAssignmentByTestConfigAdnUser(testConfig, user);
                testAssignmentService.delete(testAssignment.getId());
            }
        }

    }

    @Override
    public List<CourseBean> getCourseBeenByUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(principal.getUsername());
        List<UsersCourses> usersCoursesList = user.getUsersCourses();
        List<CourseBean> courseBeanList = new ArrayList<>();
        for (UsersCourses usersCourses : usersCoursesList) {
//           if(usersCourses.getCourse().getTestConfig().size() == 0 ) {
//                continue;
//            }
               Course course = usersCourses.getCourse();
               courseBeanList.add(toBean(course));
        }
        return courseBeanList;
    }

    @Override
    public void createCourse(CourseBean courseBean) {
        Course course = new Course();
        course.setName(courseBean.getName());
        course.setDescription(courseBean.getDescription());
        courseDao.create(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAll();
    }
}

