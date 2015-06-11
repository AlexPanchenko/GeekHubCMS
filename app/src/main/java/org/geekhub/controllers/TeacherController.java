package org.geekhub.controllers;

import org.geekhub.hibernate.bean.*;
import org.geekhub.hibernate.dao.TestConfigDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.Role;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.ClassroomService;
import org.geekhub.service.CourseService;
import org.geekhub.service.TestAssignmentService;
import org.geekhub.service.UserService;
import org.geekhub.util.CommonUtil;
import org.geekhub.wrapper.UserTestResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 21.05.2015.
 */
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    TestConfigDao testConfigDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    TestAssignmentService testAssignmentService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "teacherPage/teacherPage";
    }

    @RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
    public ModelAndView getEditUserPage(@PathVariable("userId") Integer userId, ModelMap model){
        ModelAndView modelAndView = new ModelAndView("teacherPage/teacher-edit");
        User user = userService.getUserById(userId);
        modelAndView.addObject("roleList", Role.values());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/teacherEdit",method = RequestMethod.POST)
    public String teacherEditPost(@RequestParam("id") int id,
                                  @RequestParam("first-name") String firstName,
                                  @RequestParam("last-name") String lastName,
                                  @RequestParam("email") String email,
                                  @RequestParam("skype") String skype,
                                  @RequestParam("phone") String phone,
                                  @RequestParam("birthday") String birthday,
                                  ModelMap model) {
        try {
            Date date = CommonUtil.getFormattedDate(birthday);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserBean userBean = new UserBean();
        userBean.setId(id);
        userBean.setFirstName(firstName);
        userBean.setLastName(lastName);
        userBean.setEmail(email);
        userBean.setSkype(skype);
        userBean.setPhoneNumber(phone);
        userService.updateUserByUserBean(userBean);
        return "redirect:/teacher/teacherProfile";
    }

    @RequestMapping(value ="/teacherPage", method = RequestMethod.GET)
    public ModelAndView userProfile(Principal principal){
        ModelAndView model = new ModelAndView("teacherPage/teacherProfile");
        model.addObject("user", userService.getUserBeanByEmail(principal.getName()));
        return model;
    }

    @RequestMapping(value = "/userTestResult", method = RequestMethod.GET)
    public String getUserTestResult(Map<String, Object> model) throws Exception {
        //model.put("coursesList", courseService.getAllBeans());
        return "teacherpanel/userTestResult";
    }

    @RequestMapping(value = "/userTestResult/{course}", method = RequestMethod.GET)
    public String getUserTestResultWithCourse(@RequestParam(value = "p",required = true,defaultValue = "1")Integer p,
                                              @RequestParam(value = "results",defaultValue = "4",required = false) Integer recPerPage,
                                              @PathVariable String course, Map<String, Object> model) throws Exception {
        model.put("courseName", course);
        model.put("coursesList", courseService.getAllBeans());
        Page<UserTestResultWrapper> page = userService.getPageUserTestResultWrapperListByCourseName(course, p, recPerPage);
        model.put("page", page);
        return "teacherpanel/userTestResult";
    }

    @RequestMapping(value = "/checkUserAnswers/{testConfigId}/{userId}", method = RequestMethod.GET)
    public String checkUserAnswers(@PathVariable int testConfigId, @PathVariable int userId, Map<String, Object> model) throws Exception {
        User user = userService.getUserById(userId);
        TestConfig testConfig = (TestConfig)testConfigDao.read(testConfigId, TestConfig.class);
        model.put("testConfig", testConfig);
        model.put("testAssignment", testAssignmentService.getTestAssignmentByTestConfigAdnUser(testConfig, user));
        model.put("user", user);
        return "teacherpanel/checkUserAnswers";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String students(ModelMap model, Principal principal) {
        int courseId = userDao.getUserByEmail(principal.getName()).getClassroom().getCourseId().getId();
        List<UserBean> userBeans = courseService.getUsersByCourse(courseId);
        model.addAttribute("users", userBeans);
        List<ClassRoomBean> classroomBeans = classroomService.getBeansByCourseId(courseId);
        model.addAttribute("classRooms", classroomBeans);
        return "teacherPage/studentByClassroom";
    }


    @RequestMapping(value = "/students/classroom", method = RequestMethod.GET)
    public String studentClassroom(ModelMap model,
                                   @RequestParam int classroomId,
                                   Principal principal) {
        List<UserBean> userBeans = classroomService.getUserByClassroomId(classroomId);
        model.addAttribute("users", userBeans);
        UserBean userBean = userService.getUserBeanByEmail(principal.getName());
        model.addAttribute("logedUser", userBean);
        model.addAttribute("teacher", classroomService.getTeacherByClassroomId(classroomId));
        return "teacherPage/students";
    }

    @RequestMapping(value = "/leavenote/{userid}")
    public void createFeedback(@PathVariable("userid") int userid,
                               Principal principal,
                               @RequestParam("feedback") String feedback,
                               HttpServletResponse response) throws IOException {

        UserBean userBean = userService.getUserBeanByEmail(principal.getName());
        NoteBean noteBean = new NoteBean();
        noteBean.setNoteText(feedback);
        noteBean.setReceiver(userService.getUserById(userid));
        noteBean.setSender(userService.getUserById(userBean.getId()));
        noteBean.setDate(new Date());
        userService.saveNote(noteBean);
        response.getWriter().write("OK");
    }

    @RequestMapping(value = "/showfeedbacks/{userid}")
    public ModelAndView showFeedbacks(@PathVariable("userid") int userid) throws IOException {
        ModelAndView mav = new ModelAndView("shared/showFeedbacks");
        User user = userService.getUserById(userid);
        List<NoteBean> noteBeansList = userService.getNotesListByReceiver(user);
        mav.addObject("noteBeansList",noteBeansList);
        return mav;
    }
}
