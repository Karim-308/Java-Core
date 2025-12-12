package lab4.model;

import lab4.interfaces.Registerable;
import lab4.interfaces.Reportable;

import java.util.ArrayList;

public class Student  implements Reportable , Registerable{
    Integer studentId;
    String name;
    ArrayList<CourseRegistration> registrations;

    public Student(String name, int studentId) {
        this.studentId = studentId;
        this.name = name;
        this.registrations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public ArrayList<CourseRegistration> getRegistrations() {
        return registrations;
    }

    @Override
    public void registerCourse(Course course, Double grade) {
        this.registrations.add(new CourseRegistration(course, grade));
    }

    public String toString() {

        StringBuilder studentReport = new StringBuilder();
        studentReport.append("Name: " + this.name + "\t ID: " + this.studentId + "\n");
        studentReport.append("Registered Courses: \n");

        for (CourseRegistration cr : this.registrations) {
            studentReport.append(cr);
        }
        studentReport.append("\n");

        return studentReport.toString();
    }


    @Override
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("++++++++STUDENT REPORT++++++++\n");
        sb.append(this);
        sb.append("------------------------------\n");
        return sb.toString();
    }

    class CourseRegistration {
        private Course course;
        private Double grade;

        CourseRegistration(Course course, Double grade) {
            this.course = course;
            this.grade = grade;

        }

        public Course getCourse() {
            return course;
        }

        public Double getGrade() {
            return grade;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public void setGrade(Double grade) {
            this.grade = grade;
        }

        public String toString() {
            return this.course.toString() + " Grade: " + this.grade +"\n" ; 
        }

    }
}
