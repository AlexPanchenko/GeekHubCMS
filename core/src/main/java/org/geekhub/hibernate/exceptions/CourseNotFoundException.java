package org.geekhub.hibernate.exceptions;

/**
 * Created by odahovskiy on 18.05.2015.
 * Exception for {@link org.geekhub.hibernate.entity.Course)} entity
 */
public class CourseNotFoundException extends Exception {

    public CourseNotFoundException(){
        super("You try contact the course that does not exist");
    }

    public CourseNotFoundException(String msg){
        super(msg);
    }
}
