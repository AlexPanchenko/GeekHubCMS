package org.geekhub.controllers;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Role;
import org.geekhub.hibernate.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


@Controller
@RequestMapping(value = "/dashboard")
public class AdminController {

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

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String courses() {
        return "adminpanel/courses";
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

    public String editUser(@RequestParam("login")String login,
                           @RequestParam("first-name")String firstName,
                           @RequestParam("patronymic")String patronymic,
                           @RequestParam("last-name")String lastName,
                           @RequestParam("email")String email,
                           @RequestParam("skype")String skype,
                           @RequestParam("phone")String phone,
                           @RequestParam("birthday")String birthday,
                           @RequestParam("roles[]")int[] roles,
                           @RequestParam("courses[]")int[] courses,
                           @RequestParam("avatar")MultipartFile avatar,
                           ModelMap model){


        return "adminpanel/user-edit";
    }
}
