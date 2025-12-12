package lab4.model;

import java.util.ArrayList;
import java.util.StringTokenizer;

import lab4.interfaces.Reportable;

public class Course  implements Reportable{
    Integer cousreId;
    String courseName;
    Integer creditHours;

    Course(int cousreId, String courseName, int creditHours) {
        this.courseName = courseName;
        this.cousreId = cousreId;
        this.creditHours = creditHours;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCousreId() {
        return cousreId;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCousreId(int cousreId) {
        this.cousreId = cousreId;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String toString() {
        return "Course Name: " + courseName + " ,Course ID: " + cousreId + " ,Credit Hours: " + creditHours + "\n";
    }

    public static ArrayList<Course>  parseCourses(String inputList) {
        ArrayList<Course> courses = new ArrayList<>();

        StringTokenizer tokens = new StringTokenizer(inputList, "\n");

        while (tokens.hasMoreTokens()) {
            String courseData = tokens.nextToken();

            StringTokenizer fields = new StringTokenizer(courseData, ",");

            Integer courseId = Integer.parseInt(fields.nextToken());
            String courseName = fields.nextToken();
            Integer creditHours = Integer.parseInt(fields.nextToken());

            courses.add(new Course(courseId, courseName, creditHours));

        }

        return courses;
    }


    @Override
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("++++++++Course REPORT++++++++\n");
        sb.append(this + "\n");
        sb.append("------------------------------\n");
        return sb.toString();
    }
}
