package org.geekhub.controllers;

import org.geekhub.hibernate.entity.Answer;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.AnswerService;
import org.geekhub.service.QuestionService;
import org.geekhub.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.*;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;


    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "adminpanel/index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap model) {
        List<User> users = new ArrayList<>();
        User u = new User();
        u.setBirthDay(new Date());
        u.setId(1);
        u.setFirstName("Test1");
        u.setEmail("Ivan@mail.ru");
        u.setIcq("4118377166");
        u.setLastName("Test");
        u.setPatronymic("Test");
        u.setLogin("Ivan123");
        u.setPassword("1234512");
        u.setRegistrationDate(new Date());
        u.setPhoneNumber("+380(93)145-1514");
        for (int i = 0; i < 5; i++) users.add(u);
        model.addAttribute("users",users);
        return "adminpanel/users";
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
            u.setIcq("4118377166");
            u.setLastName("Test");
            u.setPatronymic("Test");
            u.setLogin("Ivan123");
            u.setPassword("1234512");
            u.setRegistrationDate(new Date());
            u.setCourses(courses);
            u.setPhoneNumber("931451514");

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


    @RequestMapping(value = "/course/list", method = RequestMethod.GET)
    public String coursesList(ModelMap modelMap) {

        Course course = new Course();
        course.setId(1);
        course.setName("PHP");

        Course course1 = new Course();
        course1.setId(2);
        course1.setName("Java for Web");

        Course course2 = new Course();
        course2.setId(3);
        course2.setName("Front-end + CMS");


        List<Course> courses = Arrays.asList(course, course1, course2);
        modelMap.addAttribute("courses", courses);
        return "adminpanel/courses";
    }

    @RequestMapping(value = "/course/create", method = RequestMethod.GET)
    public String createPage(ModelMap model) {
        model.addAttribute("action", "create");
        model.addAttribute("course", new Course());
        return "adminpanel/course-edit";
    }

    @RequestMapping(value = "/course/{courseId}/edit", method = RequestMethod.GET)
    public String editCourses(@PathVariable("courseId") String courseId, ModelMap model) {
        Course course = new Course();
        course.setName("Pony");
        course.setDescription("Sit and ride");
        model.addAttribute("course",course);
        return "course-edit";
    }

    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.POST)
    public String editCourses(@PathVariable("courseId") String courseId,
                              @RequestParam("name") String name, @RequestParam("description") String description) {
        return "redirect:/admin/courses/" + courseId + "/edit";
    }

    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.PUT)
    public String createCourse(@PathVariable("courseId") String courseId,
                               @RequestParam("name") String name, @RequestParam("description") String description) {
        System.out.println("Name " + name + "   Description " + description );
        return "redirect:/admin/courses/" + courseId + "/edit";
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
                                 @RequestParam("questionWeight") byte questionWeight) {
        Question question = new Question();
        question.setQuestionText(questionText);
        question.setQuestionWeight(questionWeight);
        question.setCourseId(1);
        questionService.create(question);
        int questionId = question.getId();
        System.out.println("Question text " + questionText + "   Question Weight " + questionWeight);
        return "redirect:/admin/question/" + questionId + "/edit";
    }

    @RequestMapping(value = "/question/{questionId}/edit", method = RequestMethod.GET)
    public String editQuestion(@PathVariable("questionId") int questionId, ModelMap model) {
        model.addAttribute("question", questionService.read(questionId));
        return "adminpanel/question-edit";
    }


    @RequestMapping(value = "/question/{questionId}", method = RequestMethod.POST)
    public String editQuestion(@PathVariable("questionId") int questionId,
                               @RequestParam("questionText") String questionText,
                               @RequestParam("questionWeight") byte questionWeight) {
        Question question = questionService.read(questionId);
        question.setQuestionText(questionText);
        question.setQuestionWeight(questionWeight);
        questionService.update(question);
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
        model.addAttribute("answer", answerService.read(answerId));
        return "adminpanel/question-edit";
    }

    @RequestMapping(value = "/question/{questionId}/answer/create", method = RequestMethod.POST)
    public String createAnswer(@PathVariable("questionId") int questionId,
                               @RequestParam("answerText") String answerText,
                               @RequestParam("answerRight") boolean answerRight) {
        Answer answer = new Answer();
        answer.setAnswerText(answerText);
        answer.setAnswerRight(answerRight);
        answer.setQuestion(questionService.read(questionId));
        answerService.create(answer);
        return "redirect:/admin/question/{questionId}/edit";
    }
    //END ANSWER CONTROLLER
}
