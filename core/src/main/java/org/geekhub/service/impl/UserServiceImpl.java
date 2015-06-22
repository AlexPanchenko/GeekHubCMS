package org.geekhub.service.impl;


import org.apache.commons.codec.digest.DigestUtils;
import org.geekhub.hibernate.bean.NoteBean;
import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.bean.RegistrationResponseBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.NoteDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.*;
import org.geekhub.service.BeanService;
import org.geekhub.service.TestAssignmentService;
import org.geekhub.service.UserService;
import org.geekhub.wrapper.UserTestResultWrapper;
import org.geekhub.wrapper.UserWrapper;
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
import java.util.stream.Collectors;


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
    private TestAssignmentService testAssignmentService;

    @Autowired
    private BeanService beanService;

    @Autowired
    private NoteDao noteDao;


    public User getUserById(int userId) {
        return (User) userDao.read(userId, User.class);
    }


    public User getUserByEmail(String email) throws UsernameNotFoundException {
        return userDao.getUserByEmail(email);
    }

    @Override
    public UserBean getUserBeanById(int userId) {
        User user = userDao.getUserById(userId);
        return beanService.toUserBean(user);
    }

    @Override
    public boolean removeUserById(int userId) {
        User user = userDao.getUserById(userId);
        if (isRemovable(user)){
            userDao.delete(user);
            return true;
        } else {
            return false;
        }
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
    public List<UserBean> getUsersOnOnePage(int page, int limit){
        List<User> users = userDao.usersOnPage(page, limit);
        return users.stream().map(user -> beanService.toUserBean(user)).collect(Collectors.toList());
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

    private boolean findMyAnswer(TestConfig tc){
        for (Question question: tc.getTestType().getQuestionList()){
            if (question.getMyAnswer()){
                return true;
            }
        }
        return false;
    }

    public List<UserTestResultWrapper> getUserTestResultWrapperListByCourseName(String courseName) {
        List<UserTestResultWrapper> userTestResultWrapperList = new ArrayList<>();
        Course course = courseDao.getCourseByName(courseName);
        List<User> userList = usersCoursesDao.getAllUsersByCourse(course);

        for (User user : userList) {
            List<TestAssignment> list = user.getTestAssignments();
            for(TestAssignment tA: list){
                if(tA.getTestConfig().getTestType().getCourse().equals(course)) {
                    UserTestResultWrapper us=new UserTestResultWrapper(user, course, tA, tA.getTestConfig());
                    us.setReview(tA.isStatusReview());
                    us.setScore(testAssignmentService.countRightAnswer(tA).getCountTrueAnswers());
                    userTestResultWrapperList.add(us);
                }
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
        Page<UserTestResultWrapper> resultPage = new Page<>(list, begin, current, size, maxPages, recordsPerPage, end);

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
    public List<User> getAllUsersByCourse(Course course) {
        System.out.println(course.getId());
        System.out.println("List = " + usersCoursesDao.getAllUsersByCourse(course));
        return usersCoursesDao.getAllUsersByCourse(course);
    }

    @Override
    public User getLogInUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDao.loadUserByUsername(principal.getUsername());
    }

    @Override
    public List<UserBean> getUser() {
        List<UserBean> userBeans = new ArrayList<>();
        for (User user : userDao.readAllUsers()) {
            userBeans.add(beanService.toUserBean(user));
        }

        return userBeans;
    }
    public List<UserWrapper> getUserWrapperListByCourse(Course course, TestConfig testConfig) {
        List<User> userList = getAllUsersByCourse(course);
        System.out.println("List = " + userList);
        List<UserWrapper> userWrapperList = new ArrayList<>();
        for(User user: userList){
            UserWrapper userWrapper = new UserWrapper();
            userWrapper.setUser(user);
            userWrapper.setIsRegistered(false);
            for(TestAssignment testAssignment: user.getTestAssignments()){
                if(testAssignment.getTestConfig().equals(testConfig)){
                    userWrapper.setIsRegistered(true);
                }
            }
            userWrapperList.add(userWrapper);
        }
        return userWrapperList;
    }

    @Override
    public Page<UserWrapper> getPageUserByCourse(Course course, int page, int recordsPerPage, TestConfig testConfig) {

        int size = usersCoursesDao.getAllUsersByCourse(course).size();
        int maxPages = (size % recordsPerPage == 0) ? (size / recordsPerPage) : (size / recordsPerPage) + 1;
        page = (page > maxPages) ? maxPages : page;
        int current = page;
        int begin = Math.max(1, current - recordsPerPage);
        int end = maxPages;
        int firstRecordOnPage = page==1 ? 1 : page * recordsPerPage - recordsPerPage +1;
        List<UserWrapper> list = convertToUserWrapperListByTestConfig(usersCoursesDao.getAllUsersByCourse(course, firstRecordOnPage, recordsPerPage), testConfig);
        Page<UserWrapper> resultPage = new Page<>(list, begin, current, size, maxPages, recordsPerPage, end);


        return resultPage;
    }

    @Override
    public List<UserWrapper> convertToUserWrapperListByTestConfig(List<User> userList, TestConfig testConfig) {
        List<UserWrapper> userWrapperList = new ArrayList<>();
        for(User user: userList){
            UserWrapper userWrapper = new UserWrapper();
            userWrapper.setUser(user);
            userWrapper.setIsRegistered(false);
            for(TestAssignment testAssignment: user.getTestAssignments()){
                if(testAssignment.getTestConfig().equals(testConfig)){
                    userWrapper.setIsRegistered(true);
                }
            }
            userWrapperList.add(userWrapper);
        }
        System.out.println("List 2 = "+ userWrapperList);
        return userWrapperList;
    }

    @Override
    public boolean isRemovable(User user) {
        return user.getTestAssignments().isEmpty();
    }

    @Override
    public List<NoteBean> getNotesListBySender(User user) {
        List<Note> senderNotesList = noteDao.getNotesListBySender(user);
        return senderNotesList.stream().map(note -> beanService.toNoteBean(note)).collect(Collectors.toList());
    }

    @Override
    public List<NoteBean> getNotesListByReceiver(User user) {
        List<Note> receiverNotesList = noteDao.getNotesListByReceiver(user);
        return receiverNotesList.stream().map(note -> beanService.toNoteBean(note)).collect(Collectors.toList());
    }

    @Override
    public void saveNote(NoteBean noteBean) {
        Note note = new Note();
        note.setSender(noteBean.getSender());
        note.setReceiver(noteBean.getReceiver());
        note.setNoteText(noteBean.getNoteText());
        note.setDate(noteBean.getDate());
        noteDao.create(note);
    }
}
