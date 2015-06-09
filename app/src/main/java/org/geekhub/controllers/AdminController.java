package org.geekhub.controllers;

import org.geekhub.hibernate.bean.*;
import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.entity.*;
import org.geekhub.hibernate.exceptions.CourseNotFoundException;
import org.geekhub.service.*;
import org.geekhub.util.CommonUtil;
import org.geekhub.wrapper.UserTestResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping(value = "/admin")
public class AdminController extends MasterController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TestConfigService testConfigService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private UserService userService;

    @Autowired
    private TestTypeService testTypeService;

    @Autowired
    private TestAssignmentService testAssignmentService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "adminpanel/index";
    }

    @RequestMapping(value = "/createUser",method = RequestMethod.GET)
    public String createUser(ModelMap modelMap){
        return "adminpanel/createUser";
    }

    @RequestMapping(value = "/createUser",method = RequestMethod.POST)
    public String createUserPost(@RequestParam("first-name") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 String skype,String phone,
                                 @RequestParam("birthday") String birthDay,
                                 @RequestParam("role") String role,
                                 ModelMap modelMap) throws ParseException {

        /* create bean that transmit to service*/
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
        Date dateB = new Date();
        if (!birthDay.equals("")) {
            dateB = dt.parse(birthDay);
        }
        UserBean userBean = new UserBean();
        userBean.setFirstName(firstName);
        userBean.setLastName(lastName);
        userBean.setConfirmPassword(password);
        userBean.setEmail(email);
        userBean.setPhoneNumber(phone);
        userBean.setSkype(skype);
        userBean.setRegistrationDate(new Date());
        userBean.setBirthDay(dateB);
        userBean.setEnable(Byte.parseByte("1"));
        userBean.setPassword(password);
        userBean.setRole(Role.valueOf(role));
        /*send userBean to save in database*/
        userService.saveUser(userBean);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ModelAndView users(){
        ModelAndView mav=new ModelAndView("adminpanel/users");
        Long usersCount = userService.getUsersCount();
        Long pagesCount = usersCount / org.geekhub.hibernate.entity.Page.USERS_ON_PAGE;
        if (usersCount % org.geekhub.hibernate.entity.Page.USERS_ON_PAGE>0)
            pagesCount++;
        List<Integer> pageNumbers = new ArrayList<Integer>();
        int k = org.geekhub.hibernate.entity.Page.PAGES_NUMBER_ON_PAGE;
        if(pagesCount < k)
            k = pagesCount.intValue();
        for(int i = 1; i<=k; i++)
            pageNumbers.add(i);
        mav.addObject("pageNumbers",pageNumbers);
        return mav;
    }


    @RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
    public ModelAndView getEditUserPage(@PathVariable("userId") Integer userId, ModelMap model){
        ModelAndView modelAndView = new ModelAndView("adminpanel/user-edit");
        User user = userService.getUserById(userId);
        modelAndView.addObject("roleList",Role.values());
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/users/{userId}/remove", method = RequestMethod.GET)
    public ModelAndView removeUser(@PathVariable("userId") Integer userId, ModelMap model){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/users");
        userService.removeUserById(userId);
        return modelAndView;
    }

    @RequestMapping(value ="/adminPage", method = RequestMethod.GET)
    public ModelAndView userProfile(Principal principal){
        ModelAndView model = new ModelAndView("adminpanel/userProfile");
        model.addObject("user",userService.getUserBeanByEmail(principal.getName()));
        return model;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String editUser(@RequestParam("id") int id,
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
        return "redirect:/admin/users/" + id + "/edit";
    }


    @RequestMapping(value = "/course/list", method = RequestMethod.GET)
    public String coursesList(@RequestParam(value = "p", required = true, defaultValue = "1") Integer p,
                              @RequestParam(value = "results", defaultValue = "5", required = false) Integer recPerPage,
                              ModelMap modelMap) {

        List<Course> coursesList = courseService.getAllCourses();
        modelMap.addAttribute("courses", coursesList);
        return "adminpanel/courses";
    }

    @RequestMapping(value = "/course/create", method = RequestMethod.GET)
    public ModelAndView createPage() throws CourseNotFoundException {
        ModelAndView model = new ModelAndView("adminpanel/course-create");
        //  model.addObject("enumStatus", TestStatus.values());
        return model;
    }

    @RequestMapping(value = "/course/{courseId}/edit", method = RequestMethod.GET)
    public ModelAndView editCourses(@PathVariable("courseId") Integer courseId) throws Exception {
        ModelAndView model = new ModelAndView("adminpanel/course-edit");
        try {

            CourseBean course = courseService.getById(courseId);
            model.addObject("course", course);
            model.addObject("enumStatus", TestStatus.values());
            return model;
        } catch (CourseNotFoundException ex) {

        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return model;
    }

    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.POST)
    public String editCourses(@PathVariable("courseId") Integer courseId,
                              @RequestParam("name") String name,
                              @RequestParam("description") String description) throws Exception {

        CourseBean courseBean = new CourseBean(courseId, name, description);
        courseService.update(courseBean);
//        return "redirect:/admin/course/" + courseId + "/edit";
        return "redirect:/admin/course/list";

    }

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public String createCourse(@RequestParam("name") String name,
                               @RequestParam("description") String description
    ) throws Exception {
        CourseBean courseBean = new CourseBean(name, description);
        courseService.createCourse(courseBean);

        return "redirect:/admin/course/list";
    }

    @RequestMapping(value = "/course-remove/{courseId}", method = RequestMethod.GET)
    public String createCourse(@PathVariable("courseId") Integer courseId) throws Exception {

        try {
            courseService.deleteCourse(courseId);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return "redirect:/admin/course/list";
    }


    @RequestMapping(value = "/userTestResult", method = RequestMethod.GET)
    public String getUserTestResult(Map<String, Object> model) throws Exception {
        model.put("coursesList", courseService.getAllBeans());
        return "adminpanel/userTestResult";
    }

    @RequestMapping(value = "/userTestResult/{course}", method = RequestMethod.GET)
    public String getUserTestResultWithCourse(@RequestParam(value = "p", required = true, defaultValue = "1") Integer p,
                                              @RequestParam(value = "results", defaultValue = "4", required = false) Integer recPerPage,
                                              @PathVariable String course, Map<String, Object> model) throws Exception {
        model.put("coursesList", courseService.getAllBeans());
        model.put("courseName", course);
        Page<UserTestResultWrapper> page = userService.getPageUserTestResultWrapperListByCourseName(course, p, recPerPage);
        model.put("page", page);
        return "adminpanel/userTestResult";
    }

    @RequestMapping(value = "/testtypedetails/{courseId}", method = RequestMethod.GET)
    public
        //@ResponseBody
    String TestTypeByCourse(@PathVariable int courseId,
                            ModelMap model) {
        List<TestType> list = testTypeService.getListByCourseId(courseId);
        model.addAttribute("testTypeList", list);

        return "adminpanel/questions";
    }

    // START QUESTION CONTROLLER
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String questions(ModelMap model) {

        List<Question> list = questionService.getAll();
        model.addAttribute("questions", list);
        List<CourseBean> listCourse = courseService.getAllBeans();
        model.addAttribute("courses", listCourse);
        List<TestType> testTypeList = testTypeService.getList();
        model.addAttribute("testTypeList", testTypeList);
        model.addAttribute("currentCourse",0);
        return "adminpanel/questions";
    }

    @RequestMapping(value = "/course/{courseId}/questions/", method = RequestMethod.GET)
    public String questionsByCourse(@PathVariable("courseId") int courseId, ModelMap model) throws CourseNotFoundException {

        List<Question> list = questionService.getQuestionsByCourse(courseService.getById(courseId));
        model.addAttribute("questions", list);

        List<CourseBean> listCourse = courseService.getAllBeans();
        model.addAttribute("courses", listCourse);

        List<TestType> testTypeList = testTypeService.getListByCourseId(courseId);
        model.addAttribute("testTypeList", testTypeList);

        model.addAttribute("currentCourse", courseId);
        return "adminpanel/questions";
    }

    @RequestMapping(value = "/course/{courseId}/testType/{testTypeId}/questions/", method = RequestMethod.GET)
    public String questionsByTestType(@PathVariable("courseId") int courseId,
                                      @PathVariable("testTypeId") int testTypeId,
                                      ModelMap model) throws CourseNotFoundException {

        if (testTypeId == 0){
            List<Question> list = questionService.getQuestionsByCourseWithoutTestType(courseService.getById(courseId));
            model.addAttribute("questions", list);
        } else {
            List<Question> list = questionService.getQuestionsByTestType(testTypeService.getTestTypeById(testTypeId));
            model.addAttribute("questions", list);
        }

        List<CourseBean> listCourse = courseService.getAllBeans();
        model.addAttribute("courses", listCourse);

//        TestType testType = testTypeService.getTestTypeById(testTypeId);
//        List<TestType> testTypeList = new ArrayList<>();
//        testTypeList.add(testType);
//        model.addAttribute("testTypeList", testTypeList);

        List<TestType> testTypeList = testTypeService.getListByCourseId(courseId);
        model.addAttribute("testTypeList", testTypeList);

        model.addAttribute("currentCourse", courseId);
        model.addAttribute("currentTestType", testTypeId);

        return "adminpanel/questionsByTestType";
    }

    @RequestMapping(value = "/course/{courseId}/testType/{testTypeId}/question/{questionId}/edit", method = RequestMethod.GET)
    public String editQuestionByTestType(@PathVariable("questionId") int questionId,
                               @PathVariable("courseId") int courseId,
                               @PathVariable("testTypeId") int testTypeId,
                               ModelMap model) throws CourseNotFoundException {


        model.addAttribute("question", questionService.read(questionId));
        model.addAttribute("courseId", courseId);
        model.addAttribute("courseName", courseService.getById(courseId).getName());
        model.addAttribute("listTestType", testTypeService.getListByCourseId(courseId));
        if ((questionService.read(questionId)).getTestType() == null) {
            model.addAttribute("curentTestTypeId", 0);
        } else
            model.addAttribute("curentTestTypeId",(questionService.read(questionId)).getTestType().getId());

        return "adminpanel/question-editTestType";
    }

    @RequestMapping(value = "/course/{courseId}/testType/question/{questionId}/edit", method = RequestMethod.POST)
    public String editQuestionByTestTyp(@PathVariable("questionId") int questionId,
                               @PathVariable("courseId") int courseId,
                               @RequestParam("questionText") String questionText,
//                               @RequestParam("questionCode") String questionCode,
//                               @RequestParam("questionWeight") byte questionWeight,
                               //@RequestParam("questionStatus") boolean questionStatus,
//                               @RequestParam("myAnswer") boolean myAnswer,
                               @RequestParam("oldTestTypeId") int oldTestTypeId,
                               @RequestParam("testTypeIdUpdate") int testTypeId
                               ) {
        Question question = questionService.read(questionId);
        QuestionBean questionBean = new QuestionBean(questionId, questionText, question.getQuestionWeight(), true, question.getMyAnswer(), courseId, question.getQuestionCode());
        questionBean.setTestType(testTypeService.getTestTypeById(testTypeId));
        questionBean.setQuestionText(questionText);
        questionService.update(questionBean);
        return "redirect:/admin/course/" + courseId + "/testType/" + oldTestTypeId +"/questions/";
    }

    //////////////////////////////////////////////////////////////////
//    @RequestMapping(value = "/questions/{courseId}", method = RequestMethod.GET)
//    public String questionsByCourse(@PathVariable("courseId") int courseId,ModelMap model) throws CourseNotFoundException {
//        CourseBean courseBean = courseService.getById(courseId);
//        List<Question> list = questionService.getByCourse(courseBean);
////        model.addAttribute("questions", list);
//
//        List<CourseBean> listCourse = courseService.getAllBeans();
//        model.addAttribute("courses", listCourse);
//        return "adminpanel/questions";
//}
///////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/question/create", method = RequestMethod.GET)
    public String createQuestionPage(ModelMap model) {
        model.addAttribute("action", "create");
        model.addAttribute("question", new Question());
        return "adminpanel/question-edit";
    }

    //////////////////////////////////////////////////////////////
    @RequestMapping(value = "/course/{courseId}/question/create", method = RequestMethod.GET)
    public String createQuestionPageByCourse(@PathVariable("courseId") int courseId, ModelMap model) {
        model.addAttribute("action", "create");
        //  model.addAttribute("question", new Question());
        model.addAttribute("courseId", courseId);
        model.addAttribute("listTestType", testTypeService.getListByCourseId(courseId));
        try {
            model.addAttribute("courseName", courseService.getById(courseId).getName());
        } catch (CourseNotFoundException ex) {
        }
        return "adminpanel/question-edit";
    }

    ////////////////////////////////////////////////////////////
    @RequestMapping(value = "/course/{courseId}/question/create", method = RequestMethod.POST)
    public String createQuestion(@RequestParam("questionText") String questionText,
                                 @RequestParam("questionCode") String questionCode,
                                 @RequestParam("questionWeight") byte questionWeight,
                                 @RequestParam("questionStatusManyAnswers") boolean questionStatusManyAnswers,
                                 @RequestParam("myAnswer") boolean myAnswer,
                                 @RequestParam("testTypeId") int testTypeId,
                                 @PathVariable("courseId") int courseId) {
        QuestionBean questionBean = new QuestionBean(questionText, questionWeight, true, myAnswer, courseId);
        if (testTypeId != 0) {
            questionBean.setTestType(testTypeService.getTestTypeById(testTypeId));
        } else {
            questionBean.setTestType(null);
        }
        questionBean.setQuestionCode(questionCode);
        questionBean.setManyAnswers(questionStatusManyAnswers);
        int questionId = questionService.create(questionBean);


        System.out.println("Question text " + questionText + "   Question Weight " + questionWeight);
        return "redirect:/admin/course/" + courseId + "/question/" + questionId + "/edit";
    }


    @RequestMapping(value = "/course/{courseId}/question/{questionId}/edit", method = RequestMethod.GET)
    public String editQuestion(@PathVariable("questionId") int questionId,
                               @PathVariable("courseId") int courseId,
                               ModelMap model) throws CourseNotFoundException {
        model.addAttribute("question", questionService.read(questionId));
        model.addAttribute("answers", answerService.getAnswersByQuestion(questionId));
        model.addAttribute("courseId", courseId);
        model.addAttribute("courseName", courseService.getById(courseId).getName());
        model.addAttribute("listTestType", testTypeService.getListByCourseId(courseId));
        if ((questionService.read(questionId)).getTestType() == null) {
            model.addAttribute("curentTestTypeId", 0);
        } else
        model.addAttribute("curentTestTypeId",(questionService.read(questionId)).getTestType().getId());

        return "adminpanel/question-edit";
    }

    @RequestMapping(value = "/course/{courseId}/question/{questionId}/delete", method = RequestMethod.GET)
    public String deleteQuestion(@PathVariable("questionId") int questionId) {
        questionService.delete(questionId);
        return "redirect:/admin/questions";
    }

    @RequestMapping(value = "/course/{courseId}/question/{questionId}/edit", method = RequestMethod.POST)
    public String editQuestion(@PathVariable("questionId") int questionId,
                               @RequestParam("questionText") String questionText,
                               @RequestParam("questionCode") String questionCode,
                               @RequestParam("questionWeight") byte questionWeight,
                               //@RequestParam("questionStatus") boolean questionStatus,
                               @RequestParam("myAnswer") boolean myAnswer,
                               @RequestParam("manyAnswers") boolean manyAnswers,
                               @RequestParam("testTypeIdUpdate") int testTypeId,
                               @PathVariable("courseId") int courseId) {
        QuestionBean questionBean = new QuestionBean(questionId, questionText, questionWeight, true, myAnswer, courseId, questionCode);
        questionBean.setTestType(testTypeService.getTestTypeById(testTypeId));
        questionBean.setManyAnswers(manyAnswers);
        questionService.update(questionBean);
        return "redirect:/admin/course/" + questionBean.getCourse() + "/question/" + questionBean.getId() + "/edit";
    }

    // END QUESTION CONTROLLER

    //START ANSWER CONTROLLER
    @RequestMapping(value = "/course/{courseId}/question/{questionId}/answer/{answerId}", method = RequestMethod.POST)
    public String editAnswer(@PathVariable("questionId") int questionId,
                             @RequestParam("answerId") int answerId,
                             @PathVariable("courseId") int courseId,
                             @RequestParam("answerText") String answerText,
                             @RequestParam("answerRight") boolean answerRight) {

        answerService.update(answerId, answerText, answerRight);
        return "redirect:/admin/course/" + courseId + "/question/" + questionId + "/answer/" + answerId + "/edit";
    }

    @RequestMapping(value = "/course/{courseId}/question/{questionId}/answer/{answerId}/edit", method = RequestMethod.GET)
    public String editAnswer(@PathVariable("questionId") int questionId,
                             @PathVariable("courseId") int courseId,
                             @PathVariable("answerId") int answerId,
                             ModelMap model) {
        model.addAttribute("question", questionService.read(questionId));
        model.addAttribute("answers", answerService.getAnswersByQuestion(questionId));
        model.addAttribute("answerSelect", answerService.read(answerId));
        model.addAttribute("listTestType", testTypeService.getListByCourseId(courseId));
        if (((Question)questionService.read(questionId)).getTestType() == null) {
            model.addAttribute("curentTestTypeId", 0);
        } else
            model.addAttribute("curentTestTypeId",((Question)questionService.read(questionId)).getTestType().getId());
        return "adminpanel/answer-edit";
    }

    @RequestMapping(value = "/course/{courseId}/question/{questionId}/answer/create", method = RequestMethod.POST)
    public String createAnswer(@PathVariable("questionId") int questionId,
                               @PathVariable("courseId") int courseId,
                               @RequestParam("answerText") String answerText,
                               @RequestParam("answerRight") boolean answerRight) {

        answerService.create(questionId, answerText, answerRight);
        return "redirect:/admin/course/" + courseId + "/question/" + questionId + "/edit";
    }

    @RequestMapping(value = "/course/{courseId}/question/{questionId}/answer/{answerId}/delete", method = RequestMethod.GET)
    public String deleteAnswer(@PathVariable("questionId") int questionId,
                               @PathVariable("courseId") int courseId,
                               @PathVariable("answerId") int answerId,
                               ModelMap model) {
        answerService.delete(answerId);
        model.addAttribute("question", questionService.read(questionId));
        return "redirect:/admin/course/" + courseId + "/question/" + questionId + "/edit";
    }
////////////////////////////////////////////////////////
    @RequestMapping(value = "/course/{courseId}/question/{questionId}/answer/{answerId}/update", method = RequestMethod.POST)
    public String updateAnswer(@PathVariable("questionId") int questionId,
                               @PathVariable("courseId") int courseId,
                               @PathVariable("answerId") int answerId,
                               @RequestParam("answerText") String answerText,
                               @RequestParam("answerRight") boolean answerRight) {

        answerService.update(answerId, answerText, answerRight);
        return "redirect:/admin/course/" + courseId + "/question/" + questionId + "/edit";
    }


//
//    public String updateAnswer(@PathVariable("questionId") int questionId,
//                               @PathVariable("courseId") int courseId,
//                               @PathVariable("answerId") int answerId,
//                               ModelMap model) {
//        model.addAttribute("question", questionService.read(questionId));
//        model.addAttribute("answers", answerService.getAnswersByQuestion(questionId));
//        model.addAttribute("answerSelect", answerService.read(answerId));
//        model.addAttribute("listTestType", testTypeService.getListByCourseId(courseId));
//        model.addAttribute("curentTestTypeId", ((Question) questionService.read(questionId)).getTestType().getId());
//        return "adminpanel/answer-edit";
//    }

    // END ANSWER CONTROLLER


    @RequestMapping(value = "/testConfig/{courseId}/create", method = RequestMethod.GET)
    public ModelAndView createTestConfig(@PathVariable int courseId) {
        ModelAndView model = new ModelAndView("adminpanel/testConfigCreate");
        model.addObject("enumStatus", TestStatus.values());
        model.addObject("courseId", courseId);
        return model;
    }

    @RequestMapping(value = "/testConfig/{courseId}/create", method = RequestMethod.POST)
    public ModelAndView createTestConfig(@PathVariable int courseId,
                                         @RequestParam("title") String title,
                                         @RequestParam("questionCount") int questionCount,
                                         @RequestParam("dateStart") String dateStart,
                                         @RequestParam("dateFinish") String dateFinish,
                                         @RequestParam("timeToTest") int timeToTest,
                                         @RequestParam("status") TestStatus status) throws Exception {
        ModelAndView model = new ModelAndView("redirect:/admin/course/" + courseId + "/edit");
        try {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = new Date();
            if (!startDate.equals("")) {
                startDate = dt.parse(dateStart);
            }
            Date finishDate = new Date();
            if (!finishDate.equals("")) {
                finishDate = dt.parse(dateFinish);
                CourseBean courseBean = courseService.getById(courseId);
                TestConfigBeen testConfigBeen = new TestConfigBeen(title, questionCount, startDate, finishDate, timeToTest, status, courseBean);
                testConfigService.createTestConfig(testConfigBeen);
            }
        } catch (CourseNotFoundException ex) {

        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return model;
    }

    @RequestMapping(value = "/testConfig/{courseId}/{testConfigId}/edit", method = RequestMethod.GET)
    public ModelAndView editTestConfig(@PathVariable int testConfigId,
                                       @PathVariable int courseId) {
        ModelAndView model = new ModelAndView("adminpanel/testConfig-edit");
        model.addObject("courseId", courseId);
        TestConfigBeen testConfigBeen = testConfigService.getTestConfigById(testConfigId);
        model.addObject("testConfigBeen", testConfigBeen);
        model.addObject("enumStatus", TestStatus.values());
        return model;
    }

    @RequestMapping(value = "/testConfig/{courseId}/{testConfigId}/delete")
    public ModelAndView deleteTestConfig(@PathVariable int testConfigId,
                                         @PathVariable int courseId) {
        ModelAndView model = new ModelAndView("redirect:/admin/course/" + courseId + "/edit");
        TestConfigBeen testConfigBeen = (TestConfigBeen) testConfigService.getTestConfigById(testConfigId);
        testConfigService.delete(testConfigBeen);
        return model;
    }

    @RequestMapping(value = "/testConfig/{courseId}/{testConfigId}/edit", method = RequestMethod.POST)
    public ModelAndView editTestConfig(@PathVariable int testConfigId,
                                       @PathVariable int courseId,
                                       @RequestParam("title") String title,
                                       @RequestParam("questionCount") int questionCount,
                                       @RequestParam("dateStart") String dateStart,
                                       @RequestParam("dateFinish") String dateFinish,
                                       @RequestParam("timeToTest") int timeToTest,
                                       @RequestParam("status") TestStatus status) {

        ModelAndView model = new ModelAndView("redirect:/admin/course/" + courseId + "/edit");
        Date startDate = new Date();
        Date finishDate = new Date();
        try {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            if (!startDate.equals("")) {
                startDate = dt.parse(dateStart);
            }
            if (!finishDate.equals("")) {
                finishDate = dt.parse(dateFinish);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TestConfigBeen testConfigBeen = new TestConfigBeen(testConfigId, title, questionCount, startDate, finishDate, timeToTest, status);
        testConfigService.update(testConfigBeen);
        return model;
    }

  /* @RequestMapping(value = "/createFeedback/{userid}", method = RequestMethod.GET)
    public void createFeedback(@PathVariable("userid") int userid,
                                 Principal principal,
                                 @RequestParam("feedback") String feedback,
                                 HttpServletResponse response) throws IOException {
        NoteBean noteBean = new NoteBean();
        noteBean.setNoteText(feedback);
        noteBean.setReceiver(userService.getUserById(userid));
        UserBean userBean = userService.getUserBeanByEmail(principal.getName());
        noteBean.setSender(userService.getUserById(userBean.getId()));
        noteBean.setDate(new Date());
        userService.saveNote(noteBean);
        response.getWriter().write("OK");
    }*/

    /*classRoom controllers*/
    @RequestMapping("/ajax/countUsers")
    public
    @ResponseBody
    Long usersCount() {
        return userService.getUsersCount();
    }

    @RequestMapping("/ajax/usersShow")
    public ModelAndView usersOnPage(@RequestParam int page) {
        ModelAndView mav = new ModelAndView("adminpanel/usersShow");
        List<UserBean> users = userService.getUsersOnOnePage(page);
        mav.addObject("users", users);
        return mav;
    }

    @RequestMapping("/createClassrom")

    public ModelAndView coursesDropDown(){
        ModelAndView mav=new ModelAndView("adminpanel/createClassroom");
        List<CourseBean> courses = courseService.getAllBeans();
        List<UserBean> teachers = userService.getAllTeachers();
        mav.addObject("courses", courses);
        mav.addObject("teachers", teachers);
        return mav;
    }

    @RequestMapping("/ajax/usersOnCourse")
    public ModelAndView usersOnCourse(@RequestParam("course") int course) {
        ModelAndView mav = new ModelAndView("adminpanel/usersOnCourse");
        List<User> users = courseService.getUserFromCourse(course);
        mav.addObject("users", users);
        return mav;
    }

/*<<<<<<< HEAD
    @RequestMapping("/ajax/createClassroom")
    public String saveClassroom(@RequestParam("UsersId") Integer[] usersId,
                                @RequestParam("CourseId") int courseId,
                                @RequestParam("TeacherId") int teacherId) {
        classroomService.createClassroom(usersId, courseId, teacherId);
        return "redirect: /admin/classRoomList";
        ======
    }*/
    @RequestMapping(value = "/ajax/createClassroom", method = RequestMethod.POST)
    @ResponseBody
    public String saveClassroom(@RequestParam(value = "usersId[]", required = false) Integer[] usersId,
                                @RequestParam(value = "courseId") int courseId,
                                @RequestParam(value = "teacherId") int teacherId,
                                @RequestParam(value = "className") String className,
                                @RequestParam(value = "classDescription") String classDescription){

        classroomService.createClassroom(usersId,courseId,teacherId,className,classDescription);
        return "/admin/classRoomList";
//>>>>>>> 966e4e7125cd139192af0bba44c4cfb1b9dcdbe5
    }

    @RequestMapping(value = "/classRoomList", method = RequestMethod.GET)
    public String classroomList(ModelMap model) {
        List<ClassRoomBean> classRooms = classroomService.getBeans();
        model.addAttribute("classRoomBeans", classRooms);
        return "adminpanel/classRoom";
    }

/*<<<<<<< HEAD

    @RequestMapping(value = "/admin/classroom/{classroomId}/edit", method = RequestMethod.GET)
    public String classroomListEdit(ModelMap model, @PathVariable("classroomId") int classroomId) {
        model.addAttribute("classroomId", classroomId);
        return "adminpanel/editClassRoom";
    }


    @RequestMapping(value = "/admin/classroom/{classroomId}/edit", method = RequestMethod.POST)
    public String classroomListEditPost(ModelMap model, @PathVariable("classroomId") int classroomId) {

        return "adminpanel/classRoom";
    }

    @RequestMapping(value = "/admin/classroom-remove/{classroomId}", method = RequestMethod.GET)
    public String classroomRemove(ModelMap model, @PathVariable("classroomId") int classroomId) {

    }
=======*/
    @RequestMapping(value = "/classroom/{classroomId}/edit")
    public ModelAndView classroomListEdit(@PathVariable("classroomId") int classroomId){
        ModelAndView mav=new ModelAndView("adminpanel/classroom-edit");
        List<CourseBean> courses = courseService.getAllBeans();
        List<UserBean> teachers = userService.getAllTeachers();
        ClassRoomBean classroom = classroomService.getClassroom(classroomId);
        mav.addObject("courses",courses);
        mav.addObject("teachers",teachers);
        mav.addObject("classroom", classroom);
        return mav;
    }

    @RequestMapping(value = "/classroom/edit", method = RequestMethod.POST)
    @ResponseBody
    public String classroomListEditPost(@RequestParam(value = "usersId[]", required = false) Integer[] usersId,
                                        @RequestParam(value = "courseId") int courseId,
                                        @RequestParam(value = "teacherId") int teacherId,
                                        @RequestParam(value = "className") String className,
                                        @RequestParam(value = "classDescription") String classDescription,
                                        @RequestParam(value = "classId") int classroomId){
        classroomService.updateClassroom(usersId,courseId,teacherId,className,classDescription,classroomId);
        return "/admin/classRoomList";
    }

    @RequestMapping(value = "/classroom-remove/{classroomId}", method = RequestMethod.GET)
    public String classroomRemove(@PathVariable("classroomId") int classroomId){
//>>>>>>> 966e4e7125cd139192af0bba44c4cfb1b9dcdbe5
        classroomService.removeClassroomById(classroomId);
        return "redirect:/admin/classRoomList";
    }


    @RequestMapping(value = "/testType", method = RequestMethod.GET)
    public String testType(ModelMap model) {
        model.put("testTypeList", testTypeService.getList());
        return "adminpanel/testType";
    }

    @RequestMapping(value = "/testType/create", method = RequestMethod.GET)
    public String testTypeCreate(ModelMap model) {
        model.put("courseList", courseService.getAllCourses());
        return "adminpanel/testTypeCreate";
    }

    @RequestMapping(value = "/testType/create", method = RequestMethod.POST)
    public String testTypeCreateAction(ModelMap model,
                                       @RequestParam("name") String name,
                                       @RequestParam("courseId") int courseId) {
        testTypeService.create(name, courseId);
        return "redirect:/admin/testType";
    }

    @RequestMapping(value = "/testType/delete/{id}", method = RequestMethod.GET)
    public String testTypeDelete(ModelMap model,
                                 @PathVariable("id") int id) {
        testTypeService.deleteById(id);
        return "redirect:/admin/testType";
    }

    @RequestMapping(value = "/testType/change/{id}", method = RequestMethod.GET)
    public String testTypeChange(ModelMap model,
                                 @PathVariable("id") int id) {
        model.put("id", testTypeService.getTestTypeById(id).getId());
        model.put("name", testTypeService.getTestTypeById(id).getName());
        model.put("courseId", testTypeService.getTestTypeById(id).getCourse().getId());
        model.put("courseList", courseService.getAllCourses());
        return "adminpanel/TestTypeChange";
    }

    @RequestMapping(value = "/testType/change/{id}", method = RequestMethod.POST)
    public String testTypeChangeAction(ModelMap model,
                                       @PathVariable("id") int id,
                                       @RequestParam("name") String name,
                                       @RequestParam("courseId") int courseId) {
        testTypeService.changeTestType(id, name, courseId);
        return "redirect:/admin/testType/change/" + id;
    }

    @RequestMapping(value = "/testConfig", method = RequestMethod.GET)
    public String testConfig(Map<String, Object> model) {
        model.put("testConfigList", testConfigService.getAll());
        model.put("tmp", 12);
        return "adminpanel/testConfig";
    }

    @RequestMapping(value = "/testConfig/create", method = RequestMethod.GET)
    public String testConfigCreate(Map<String, Object> model) {
        model.put("testTypeList", testTypeService.getList());
        model.put("status", TestStatus.values());
        return "adminpanel/testConfigCreate";
    }

    @RequestMapping(value = "/testConfig/create", method = RequestMethod.POST)
    public String testConfigCreateAction(Map<String, Object> model,
                                         @RequestParam("title") String title,
                                         @RequestParam("questionCount") int questionCount,
                                         @RequestParam("dateStart") String dateStart,
                                         @RequestParam("dateFinish") String dateFinish,
                                         @RequestParam("timeToTest") int timeToTest,
                                         @RequestParam("status") TestStatus status,
                                         @RequestParam("testType") int testTypeId) throws Exception {
        try {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = new Date();
            if (!startDate.equals("")) {
                startDate = dt.parse(dateStart);
            }
            Date finishDate = new Date();
            if (!finishDate.equals("")) {
                finishDate = dt.parse(dateFinish);
                testConfigService.createTestConfig(new TestConfig(title, questionCount, startDate, finishDate, timeToTest, status, testTypeService.getTestTypeById(testTypeId).getCourse(), testTypeService.getTestTypeById(testTypeId)));
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return "redirect:/admin/testConfig";
    }

    @RequestMapping(value = "/testConfig/delete/{id}", method = RequestMethod.GET)
    public String testConfigDelete(Map<String, Object> model,
                                   @PathVariable("id") int id) {
        testConfigService.deleteById(id);
        return "redirect:/admin/testConfig";
    }

    @RequestMapping(value = "/testConfig/edit/{id}", method = RequestMethod.GET)
    public String testConfigEdit(Map<String, Object> model,
                                 @PathVariable("id") int id) {
        model.put("status", TestStatus.values());
        model.put("testTypeList", testTypeService.getList());
        model.put("testConfig", testConfigService.getTestConfigByID(id));
        return "adminpanel/testConfigEdit";
    }

    @RequestMapping(value = "/testConfig/edit/{id}", method = RequestMethod.POST)
    public String testConfigEditAction(Map<String, Object> model,
                                       @PathVariable("id") int id,
                                       @RequestParam("title") String title,
                                       @RequestParam("questionCount") int questionCount,
                                       @RequestParam("dateStart") String dateStart,
                                       @RequestParam("dateFinish") String dateFinish,
                                       @RequestParam("timeToTest") int timeToTest,
                                       @RequestParam("status") TestStatus status,
                                       @RequestParam("testType") int testTypeId) throws Exception {
        try {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = new Date();
            if (!startDate.equals("")) {
                startDate = dt.parse(dateStart);
            }
            Date finishDate = new Date();
            if (!finishDate.equals("")) {
                finishDate = dt.parse(dateFinish);
                testConfigService.updateByParams(id, title, questionCount, startDate, finishDate, timeToTest, status, testTypeService.getTestTypeById(testTypeId));
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }

        return "redirect:/admin/testConfig/edit/" + id;
    }

    @RequestMapping(value = "/assignTest", method = RequestMethod.GET)
    public String assignTest(Map<String, Object> model) {
        model.put("courseList", courseService.getAllCourses());
        model.put("testTypeList", testTypeService.getList());
        model.put("testConfigList", testConfigService.getAll());
        model.put("currentTestConfig", null);
        return "adminpanel/assignTest";
    }

    @RequestMapping(value = "/assignTest/{testConfigId}", method = RequestMethod.GET)
    public String assignTestByCourse(Map<String, Object> model,
                                     @PathVariable("testConfigId") int testConfigId) throws CourseNotFoundException {
        model.put("courseList", courseService.getAllCourses());
        model.put("testTypeList", testTypeService.getList());
        model.put("userWrapperList", userService.getUserWrapperListByCourse(testConfigService.getTestConfigByID(testConfigId).getTestType().getCourse(), testConfigService.getTestConfigByID(testConfigId)));
        model.put("testConfigList", testConfigService.getAll());
        model.put("currentTestConfig", testConfigService.getTestConfigByID(testConfigId));
        return "adminpanel/assignTest";
    }

    @RequestMapping(value = "/assignTest/save", method = RequestMethod.POST)
    public String assignTestByCourseSave(Map<String, Object> model,
                                         @RequestParam("testConfigId") int testConfigId,
                                         @RequestParam(required = false, value = "userId") List<Integer> listId) throws CourseNotFoundException {
        if (listId != null) {
            testAssignmentService.assignTestByUserListId(listId, testConfigService.getTestConfigByID(testConfigId));
        }
        return "redirect:/admin/assignTest/" + testConfigId;
    }

    @RequestMapping(value = "/assignTest/delete/{testConfigId}/{userId}", method = RequestMethod.GET)
    public String assignTestByCourseSave(Map<String, Object> model,
                                         @PathVariable("testConfigId") int testConfigId,
                                         @PathVariable("userId") int userId) {
        testAssignmentService.deleteTestAssignByUserAndTestConfig(userService.getUserById(userId), testConfigService.getTestConfigByID(testConfigId));
        return "redirect:/admin/assignTest/" + testConfigId;
    }

    @Override
    @RequestMapping(value = "/leavenote/{userid}")
    public void createFeedback
            (@PathVariable("userid") int userid, Principal principal,
             @RequestParam("feedback") String feedback, HttpServletResponse response) throws IOException {
        super.createFeedback(userid, principal, feedback, response);
    }

/*    *//*Pagination for classroom*//*
    @RequestMapping(value = "/classroom/list", method = RequestMethod.GET)
    public String classromList(@RequestParam(value = "p", required = true, defaultValue = "1") Integer p,
                               @RequestParam(value = "results", defaultValue = "5", required = false) Integer recPerPage,
                               ModelMap modelMap) {

//        Page<Classroom> page =  courseService.getAll(p, recPerPage);
//        modelMap.addAttribute("page", page);
        return "adminpanel/courses";
    }*/


}
