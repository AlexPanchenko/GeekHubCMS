package org.geekhub.service.impl;


import org.apache.commons.codec.digest.DigestUtils;
import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.bean.RegistrationResponseBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Role;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.BeanService;
import org.geekhub.service.UserService;
import org.geekhub.wrapper.UserTestResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    UsersCoursesDao usersCoursesDao;

    @Autowired
    private BeanService beanService;


    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }


    public User getUserByEmail(String email) throws UsernameNotFoundException {
        return userDao.getUserByEmail(email);
    }

    @Override
    public void removeUserById(int userId) {
        userDao.delete(userDao.getUserById(userId));
    }

    @Override
    public void saveUser(UserBean userBean) {
        User user = beanService.toUserEntity(userBean);
        RegistrationResponseBean registrationResponseBean = validateForm(userBean);

        if (registrationResponseBean.isSuccess()) {
            userDao.create(user);
        }
    }

    @Override
    public UserBean getUserBeanByEmail(String email) {
        User user = userDao.getUserByEmail(email);
        return beanService.toUserBean(user);
    }

    @Override
    public void updateUserByUserBean(UserBean userBean) {
        User user = userDao.getUserById(userBean.getId());
        user.setFirstName(userBean.getFirstName());
        user.setLastName(userBean.getLastName());
        user.setPhoneNumber(userBean.getPhoneNumber());
        user.setEmail(userBean.getEmail());
        user.setSkype(userBean.getSkype());
        userDao.update(user);
    }

    @Override
    public List<UserBean> getUsersOnOnePage(int page){
        List<User> users = userDao.usersOnPage(page);
        System.out.println(users.size());
        List<UserBean> userBeans = new ArrayList<UserBean>();
        for(User u: users){
            userBeans.add(beanService.toUserBean(u));
        }
        return userBeans;
    }
    public Long getUsersCount(){
        return userDao.usersCount();
    }

    @Override
    public List<UserBean> getAllTeachers() {
        List<UserBean> allTeachers = new ArrayList<UserBean>();
        List<User> users = userDao.readAllUsers();
        for (User u : users) {
            if (u.getRole().equals(Role.ROLE_TEACHER)&&u.getClassroom()==null) {
                allTeachers.add(beanService.toUserBean(u));
            }
        }
        return allTeachers;
    }

    /*Get user and set new feedback*/
    @Override
    public void setFeedback(int Id, String feedBack) {
        User user = userDao.getUserById(Id);
        user.setFeedback(feedBack);
        userDao.update(user);
    }

    public static final SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");

    @Override
    public RegistrationResponseBean addUser(UserBean userBean) throws ParseException {

        RegistrationResponseBean registrationResponseBean = validateForm(userBean);

        if (registrationResponseBean.isSuccess()) {
            User user = new User();
            user.setPassword(DigestUtils.md5Hex(userBean.getPassword()));
            user.setFirstName(userBean.getFirstName());
            user.setLastName(userBean.getLastName());

            user.setEmail(userBean.getEmail());
            user.setSkype(userBean.getSkype());
            user.setPhoneNumber(userBean.getPhoneNumber());
            user.setRole(Role.ROLE_STUDENT);
            user.setBirthDay(userBean.getBirthDay());
            user.setRegistrationDate(new Date());
            userDao.create(user);
        }
        return registrationResponseBean;
    }

    public RegistrationResponseBean validateForm(UserBean userBean) {
        RegistrationResponseBean registrationResponseBean = new RegistrationResponseBean();

        System.out.println(userBean.getEmail());
        if (userDao.getUserByEmail(userBean.getEmail()) != null) {
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Email already in use");
            return registrationResponseBean;

        } else if (userBean.getEmail().equals("")) {
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Email is empty");
            return registrationResponseBean;
        } else if (userBean.getFirstName().equals("")) {
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("First name is empty");
            return registrationResponseBean;
        } else if (userBean.getLastName().equals("")) {
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Last name is empty");
            return registrationResponseBean;
        } else if (userBean.getPassword().length() < 6) {
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Password length should be more than 6 characters");
            return registrationResponseBean;
        } else if (!userBean.getPassword().equals(userBean.getConfirmPassword())) {
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Password doesn't match");
            return registrationResponseBean;
        } else {
            registrationResponseBean.setSuccess(true);
            return registrationResponseBean;
        }
    }

    public List<UserTestResultWrapper> getUserTestResultWrapperListByCourseName(String courseName) {
        List<UserTestResultWrapper> userTestResultWrapperList = new ArrayList<>();
        Course course = courseDao.getCourseByName(courseName);
        List<User> userList = usersCoursesDao.getAllUsersByCourse(course);

        for (User user : userList) {
            List<TestAssignment> list = user.getTestAssignments();
            for(TestAssignment tA: list){
                userTestResultWrapperList.add(new UserTestResultWrapper(user, course, tA, tA.getTestConfig()));
            }
        }
        return userTestResultWrapperList;
    }

    @Override
    public Page<UserTestResultWrapper> getPageUserTestResultWrapperListByCourseName(String courseName, int page, int recordsPerPage) {

        List<UserTestResultWrapper> list = getUserTestResultWrapperListByCourseName(courseName);
        int firstRecord;
        int lastRecord;
        int size = list.size();
        int maxPages = (size % recordsPerPage == 0) ? (size / recordsPerPage) : (size / recordsPerPage) + 1;
        page = (page > maxPages) ? maxPages : page;
        int current = page;
        int begin = Math.max(1, current - recordsPerPage);
        int end = maxPages;

        firstRecord = page * recordsPerPage - recordsPerPage;
        if (page == maxPages) {
            lastRecord = page * recordsPerPage - (page * recordsPerPage - size);
        } else {
            lastRecord = page * recordsPerPage;
        }
        if (recordsPerPage < size) {
            list = list.subList(firstRecord, lastRecord);
        }
        Page<UserTestResultWrapper> resultPage = new Page<UserTestResultWrapper>(list, begin, current, size, maxPages, recordsPerPage, end);

        List<UserTestResultWrapper> userTestResultWrapperList = new ArrayList<>();
        Course course = courseDao.getCourseByName(courseName);
        List<User> userList = usersCoursesDao.getAllUsersByCourse(course);

        for (User user : userList) {
            userTestResultWrapperList.add(new UserTestResultWrapper(user, course));
        }
        return resultPage;
    }

    @Override
    public List<Course> getAllCoursesByUser(User user) {
        return usersCoursesDao.getAllCoursesByUser(user);
    }

    @Override
    public User getLogInUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDao.loadUserByUsername(principal.getUsername());
    }


}
