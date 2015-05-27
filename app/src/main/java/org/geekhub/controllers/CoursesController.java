package org.geekhub.controllers;

import org.geekhub.service.CourseService;
import org.geekhub.service.RegistrationCoursesService;
import org.geekhub.service.UserService;
import org.geekhub.service.TestAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/student")
public class CoursesController {

    @Autowired
    private RegistrationCoursesService registrationCoursesService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    private TestAssignmentService testAssignmentService;


    @RequestMapping(value = "/registrationCourses", method = RequestMethod.GET)
    public String coursesRegistration(Map<String, Object> model) {
        model.put("listCourses", registrationCoursesService.getListCourseWrappers());
        return "studentPage/registrationCourses";
    }


    @RequestMapping(value = "/registrationCourses", method = RequestMethod.POST)
    public String registrationCourses(@RequestParam(required = false , value = "courseId") List<Integer> id) {
        if(id != null) {
            registrationCoursesService.getRegistrationUserByCourses(id);
        }


        return "redirect:/student/userProfile";
    }

    @RequestMapping(value ="/deleteCourse/{courseId}")
    public ModelAndView deleteCourse(@PathVariable int courseId){
        ModelAndView model = new ModelAndView("redirect:/student/userProfile");
        courseService.unRegisterCourse(courseId);

        return model;
    }

/*    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView showUserOfCourses() {
        ModelAndView model = new ModelAndView("userProfile");
        List<CourseBean> courseBeanList = courseService.getCourseBeenByUser();
        model.addObject("coursesList", courseBeanList);
        return model;
    }*/
}
