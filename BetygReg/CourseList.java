package BetygReg;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jaeger on 2016-05-30.
 */
public class CourseList {
    private HashMap<String,Course> courseHash = new HashMap<>();
    private ArrayList<Course> courseList = new ArrayList<>();
    private Course activeCourse = new Course("725G00"); //manuell inmatning av första kurs, ska hätmas ifrån databas
    public CourseList(){
        courseList.add(activeCourse);
    }
    public ArrayList<Course> getCourseList(){
        return courseList;
    }
    public void addCourse(Course name){
        courseList.add(name);
    }
   /* public Course getActiveCourse(){
        courseList.get(
        return activeCourse;
    } */
    public void addHCourse(String nameKey, Course course){
        courseHash.put(nameKey,course);
    }
    public Course getHCourse(String nameKey){
        return courseHash.get(nameKey);
    }
}
