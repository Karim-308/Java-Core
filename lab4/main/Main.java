package lab4.main;

import java.util.ArrayList;
import java.util.Scanner;

import lab4.model.Course;
import lab4.model.Student;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        boolean running = true;

        while (running) {

            printMenu();
            System.out.print("Enter choice: ");
            int choice = 0;
            try {
                choice = in.nextInt();
                in.nextLine();
            } catch (Exception E) {
                System.out.println("Invalid input! Please enter a number.");
                in.nextLine();
            }
            switch (choice) {
                case 1:
                    insertStudentPage(in, students);
                    break;
                case 2:
                    insertCoursePage(in, courses);

                    break;
                case 3:
                    registerStudentCoursePage(in, students, courses);
                    break;
                case 4:
                    printFullReport(students, courses);
                    break;
                case 5:
                    running = false;
                    break;

                default:
                    break;
            }
        }

    }

    public static void printMenu() {
        System.out.println("Select one from the following");
        System.out.println("1- Add a student");
        System.out.println("2- Add courses");
        System.out.println("3- Register student in course");
        System.out.println("4- Print full report of the system");
        System.out.println("5- Exit\n");
    }

    public static void insertStudentPage(Scanner in, ArrayList<Student> students) {
        System.out.println("\nEnter Student Name ");
        String name = in.nextLine();
        int id = -1;
        System.out.println("Enter Student ID");

        try {
            id = in.nextInt();
            in.nextLine();
        } catch (Exception E) {
            System.out.println("\nInvalid ID! Please enter a number.\n");
            in.nextLine();
            return;
        }

        for (Student s : students) {
            if (s.getStudentId() == id) {
                System.out.println("\nError: Dublicate ID\n");
                return;
            }
        }

        students.add(new Student(name, id));

        System.out.println("\nStudent " + name + " with ID " + id + " is added\n");
    }

    public static void insertCoursePage(Scanner in, ArrayList<Course> courses) {
        System.out.println("\nEnter Courses to added \n");
        System.out.println("Enter Course name");

        System.out.println("Make sure to match the format: ID,name,creditHours in each line");
        System.out.println("Example: 308,JAVA,3");
        StringBuilder inputList = new StringBuilder();

        while (true) {
            String line = in.nextLine();
            if (line.isEmpty())
                break;
            inputList.append(line).append("\n");
        }

        try {
            ArrayList<Course> newCourses = Course.parseCourses(inputList.toString());

            for (Course nc : newCourses) {
                for (Course existing : courses) {
                    if (existing.getCousreId() == nc.getCousreId()) {
                        System.out.println("Course ID already exists: " + nc.getCousreId());
                        System.out.println("No courses were added.\n");
                        return;
                    }
                }
            }

            courses.addAll(newCourses);
            System.out.println("Courses added successfully!\n");
        } catch (Exception e) {
            System.out.println("Invalid format! Please match: ID,name,creditHours");
            System.out.println("Example: 150,C++,4\n");
        }
    }

    public static void registerStudentCoursePage(Scanner in,
            ArrayList<Student> students,
            ArrayList<Course> courses) {

        if (courses.isEmpty()) {
            System.out.println("No courses available. Add courses first.");
            return;
        }

        System.out.print("\nEnter Student ID: ");
        int sid = -1;
        try {
            sid = in.nextInt();
            in.nextLine();
        } catch (Exception E) {
            System.out.println("\nInvalid ID! Please enter a number.\n");
            in.nextLine();
            return;
        }
        Student selectedStudent = null;
        for (Student s : students) {
            if (s.getStudentId() == sid) {
                selectedStudent = s;
                break;
            }
        }

        if (selectedStudent == null) {
            System.out.println("Student not found!\n");
            return;
        }

        System.out.print("Enter Course ID: ");
        int cid = -1;
        try {
            cid = in.nextInt();
            in.nextLine();
        } catch (Exception E) {
            System.out.println("\nInvalid ID! Please enter a number.\n");
            in.nextLine();
            return;
        }
        Course selectedCourse = null;
        for (Course c : courses) {
            if (c.getCousreId() == cid) {
                selectedCourse = c;
                break;
            }
        }

        if (selectedCourse == null) {
            System.out.println("Course not found!\n");
            return;
        }

        System.out.print("Enter Grade: ");
        Double grade = -1.0;
        try {
            grade = in.nextDouble();
            in.nextLine();
        } catch (Exception E) {
            System.out.println("\nInvalid Grade! Please enter a number.\n");
            in.nextLine();
            return;
        }
        selectedStudent.registerCourse(selectedCourse, grade);

        System.out.println("Registration successful!\n");
    }

    public static void printFullReport(ArrayList<Student> students, ArrayList<Course> courses) {
        System.out.println("\n++++++++FULL SYSTEM REPORT++++++++\n\n");
        for (Student s : students) {
            System.out.println(s.report());
        }

        for (Course c : courses) {
            System.out.println(c.report());
        }
        System.out.println("----------------\n");
    }
}