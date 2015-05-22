package org.geekhub.controllers;

import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.exceptions.CourseNotFoundException;
import org.geekhub.service.AnswerService;
import org.geekhub.service.CourseService;
import org.geekhub.service.UserService;
import org.geekhub.service.QuestionService;
import org.geekhub.util.CommonUtil;
import org.geekhub.util.JavaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;
import java.util.jar.JarEntry;


@Controller
@RequestMapping(value = "/admin")
public class    AdminController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private JavaSender javaSender;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "adminpanel/index";
    }

	@RequestMapping("/users")
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

    @RequestMapping("/ajax/countUsers")
	public @ResponseBody
    Long usersCount() {
        return userService.getUsersCount();
	}

    @RequestMapping("/ajax/usersShow")
    public ModelAndView usersOnPage(@RequestParam int page){
        ModelAndView mav=new ModelAndView("adminpanel/usersShow");
        List<UserBean> users = userService.getUsersOnOnePage(page);
        mav.addObject("users",users);
        return mav;
    }
    @RequestMapping("/createClassrom")
    public ModelAndView coursesDropDown(){
        ModelAndView mav=new ModelAndView("adminpanel/createClassroom");
        List<CourseBean> courses = courseService.getAllBeans();
        List<UserBean> teachers = userService.getAllTeachers();
        mav.addObject("courses",courses);
        mav.addObject("teachers",teachers);
        return mav;
    }

    @RequestMapping("/ajax/usersOnCourse")
    public ModelAndView usersOnCourse(@RequestParam("course") int course){
        ModelAndView mav=new ModelAndView("adminpanel/usersOnCourse");
        List<User> users= courseService.getUserFromCourse(course);
        mav.addObject("users", users);
        return mav;
    }


    @RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
    public String getEditUserPage(@PathVariable("userId")Integer userId, ModelMap model) throws Exception {
        try {
            Course cour = new Course();
            cour.setId(1);
            cour.setName("PHP");

            Course c2 = new Course();
            c2.setId(2);
            c2.setName("Java Script");

            Set<Course> courses = new HashSet<>();
            courses.add(c2);
            courses.add(cour);

            User u = new User();

            u.setBirthDay(new Date());
            u.setId(userId);
            u.setFirstName("Test1");
            u.setEmail("Ivan@mail.ru");
//            u.setIcq("4118377166");
            u.setLastName("Test");
            u.setPatronymic("Test");
            u.setLogin("Ivan123");
            u.setPassword("1234512");
            u.setRegistrationDate(new Date());
          //  u.setCourses(courses);
            u.setPhoneNumber("931451514");

            model.addAttribute("roles", org.geekhub.hibernate.entity.Role.values());
            model.addAttribute("courseList", courses);
            model.addAttribute("user", u);

            return "adminpanel/user-edit";
        }catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String editUser(@RequestParam("id")String id,
                           @RequestParam("login")String login,
                           @RequestParam("first-name")String firstName,
                           @RequestParam("patronymic")String patronymic,
                           @RequestParam("last-name")String lastName,
                           @RequestParam("email")String email,
                           @RequestParam("skype")String skype,
                           @RequestParam("phone")String phone,
                           @RequestParam("birthday")String birthday,
                           @RequestParam("role")String role,
                           @RequestParam("courses[]")String[] courses,
                           @RequestParam(value = "avatar", required = false)MultipartFile avatar,
                           ModelMap model) {
        try {
            Date date = CommonUtil.getFormattedDate(birthday);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/users/"+id+"/edit";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String coursesList( @RequestParam(value = "p",required = true,defaultValue = "1")Integer p,
                               @RequestParam(value = "results",defaultValue = "5",required = false) Integer recPerPage,
                               ModelMap modelMap) {

        Page<CourseBean> page = courseService.getAll(p, recPerPage);
        modelMap.addAttribute("page", page);
        return "adminpanel/courses";
    }

    @RequestMapping(value = "/courses/create", method = RequestMethod.GET)
    public String createPage(ModelMap model) {
        model.addAttribute("action", "create");
        model.addAttribute("course", new Course());
        return "adminpanel/course-edit";
    }

    @RequestMapping(value = "/courses/{courseId}/edit", method = RequestMethod.GET)
    public String editCourses(@PathVariable("courseId") Integer courseId, ModelMap model) throws Exception {
        try {
            CourseBean course = courseService.getById(courseId);
            model.addAttribute("course",course);
        }catch (CourseNotFoundException ex){

        }catch (Exception ex) {
            throw new Exception(ex);
        }
        return "adminpanel/course-edit";
    }

    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.POST)
    public String editCourses(@PathVariable("courseId") Integer courseId,
                              @RequestParam("name") String name, @RequestParam("description") String description) throws Exception {
        try {
            courseService.update(
                    new CourseBean(courseId, name, description)
            );
        }catch (CourseNotFoundException ex){

        }catch (Exception ex) {
            throw new Exception(ex);
        }

        return "redirect:/admin/courses/" + courseId + "/edit";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public String createCourse(@RequestParam("name") String name,
                               @RequestParam("description") String description) throws Exception {

        try {
            courseService.create(name, description);
        } catch (Exception ex) {
            throw new Exception(ex);
        }

        return "redirect:/admin/courses";
    }

    //change method type after activate put methods in project.
    @RequestMapping(value = "/course-remove/{courseId}", method = RequestMethod.GET)
    public String createCourse(@PathVariable("courseId") Integer courseId) throws Exception {

        try {
            courseService.delete(courseId);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return "redirect:/admin/course/list";
    }

    // START QUESTION CONTROLLER
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String questions(ModelMap model) {
        List<Question> list = questionService.getAll();
        model.addAttribute("questions", list);
        return "adminpanel/questions";
    }

    @RequestMapping(value = "/question/create", method = RequestMethod.GET)
    public String createQuestionPage(ModelMap model) {
        model.addAttribute("action", "create");
        model.addAttribute("question", new Question());
        return "adminpanel/question-edit";
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public String createQuestion(@RequestParam("questionText") String questionText,
                                 @RequestParam("questionWeight") byte questionWeight,
                                 @RequestParam("course") int courseId)  {

        Question question = questionService.create(questionText, questionWeight, courseId);
        int questionId = question.getId();
        System.out.println("Question text " + questionText + "   Question Weight " + questionWeight);
        return "redirect:/admin/question/" + questionId + "/edit";
    }

    @RequestMapping(value = "/question/{questionId}/edit", method = RequestMethod.GET)
    public String editQuestion(@PathVariable("questionId") int questionId, ModelMap model) {
        model.addAttribute("question", questionService.read(questionId));
        model.addAttribute("answers", answerService.getAnswersByQuestion(questionId));
        return "adminpanel/question-edit";
    }

    @RequestMapping(value = "/question/{questionId}/delete", method = RequestMethod.GET)
    public String deleteQuestion(@PathVariable("questionId") int questionId) {
        questionService.delete(questionId);
        return "redirect:/admin/questions";
    }

    @RequestMapping(value = "/question/{questionId}", method = RequestMethod.POST)
    public String editQuestion(@PathVariable("questionId") int questionId,
                               @RequestParam("questionText") String questionText,
                               @RequestParam("questionWeight") byte questionWeight) {
        questionService.update(questionId, questionText, questionWeight);
        return "redirect:/admin/question/" + questionId + "/edit";
    }

    // END QUESTION CONTROLLER

    //START ANSWER CONTROLLER
    @RequestMapping(value = "/question/{questionId}/answer/{answerId}", method = RequestMethod.POST)
    public String editAnswer(@PathVariable("questionId") int questionId,
                             @RequestParam("answerId") String answerId,
                             @RequestParam("answerText") String answerText,
                             @RequestParam("answerRight") String answerRight) {
        return "redirect:/admin/question/" + questionId + "/answer/" + answerId+ "/edit";
    }

    @RequestMapping(value = "/question/{questionId}/answer/{answerId}/edit", method = RequestMethod.GET)
    public String editAnswer(@PathVariable("questionId") int questionId,
                             @PathVariable("answerId") int answerId,
                             ModelMap model) {
        model.addAttribute("question", questionService.read(questionId));
        model.addAttribute("answers", answerService.getAnswersByQuestion(questionId));
        model.addAttribute("answerSelect", answerService.read(answerId));
        return "adminpanel/answer-edit";
    }

    @RequestMapping(value = "/question/{questionId}/answer/create", method = RequestMethod.POST)
    public String createAnswer(@PathVariable("questionId") int questionId,
                               @RequestParam("answerText") String answerText,
                               @RequestParam("answerRight") boolean answerRight) {

        answerService.create(questionId, answerText, answerRight);
        return "redirect:/admin/question/{questionId}/edit";
    }

    @RequestMapping(value = "/question/{questionId}/answer/{answerId}/delete", method = RequestMethod.GET)
    public String deleteAnswer( @PathVariable("questionId") int questionId,
                                @PathVariable("answerId") int answerId,
                                ModelMap model) {
        answerService.delete(answerId);
        model.addAttribute("question", questionService.read(questionId));
        return "redirect:/admin/question/{questionId}/edit";
    }
    //END ANSWER CONTROLLER
    @RequestMapping(value = "/userTestResult", method = RequestMethod.GET)
    public String createCourse(Map<String, Object> model) throws Exception {

        return "adminpanel/userTestResult";

    }

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public String profilePage(@PathVariable("userId")Integer userId, ModelMap model) throws Exception {
        try {
            Course cour = new Course();
            cour.setId(1);
            cour.setName("PHP");

            Course c2 = new Course();
            c2.setId(2);
            c2.setName("Java Script");

            Set<Course> courses = new HashSet<>();
            courses.add(c2);
            courses.add(cour);

            User u = new User();

            u.setBirthDay(new Date());
            u.setId(userId);
            u.setFirstName("Test1");
            u.setEmail("Ivan@mail.ru");
//            u.setIcq("4118377166");
            u.setLastName("Test");
            u.setPatronymic("Test");
            u.setLogin("Ivan123");
            u.setPassword("1234512");
            u.setRegistrationDate(new Date());
//            u.setCourses(courses);
            u.setPhoneNumber("931451514");
//            u.setRoles(Role.ROLE_ADMIN);
            model.addAttribute("user", u);

            return "adminpanel/user-profile";
        }catch (Exception ex) {
            throw new Exception(ex);
        }
    }


    @RequestMapping(value = "/createFeedback/{userid}", method = RequestMethod.GET)
    public String createFeedback(@PathVariable("userid")Integer userid, HttpServletRequest request){
        String feedback = request.getParameter("feedback");
        userService.setFeedback(userid,feedback);
        return "redirect:/admin/users/" + userid + "/edit";
    }

    /*Create and edit classrooms*/

}
