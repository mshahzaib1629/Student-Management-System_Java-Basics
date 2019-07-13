package studentFiles;

import java.util.ArrayList;

import courseFiles.Course;
import java.io.Serializable;

public class Student implements Serializable{

    String name;
    String registration;
    String password;
    Student next;
    ArrayList<Course> myCourses = new ArrayList<>();

    int courseIndex = 1;

    public Student() {
        this(null, null, null, null);
    }

    public Student(String name, String registration, String password, Student next) {
        super();
        this.name = name;
        this.registration = registration;
        this.password = password;
        this.next = next;
    }

    public boolean setMyCourses(Course c) { // temp

        if (duplicateTest(c) == false) {
            if (courseIndex <= 6) {
                myCourses.add(c);
                courseIndex++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean duplicateTest(Course c) {
        if (myCourses.contains(c)) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList getMyCourses() {
        return myCourses;
    }

    public boolean deleteOneCourse(String id) {
        for (Course c : myCourses) {
            if (c.getId().equals(id)) {
                myCourses.remove(c);
                courseIndex--;
                return true;
            }
        }
        return false;
    }

    public void deleteAllCourses() {

        myCourses.removeAll(myCourses);
        courseIndex = 0;
    }

    @Override
    public String toString() {
        return "Student [registration=" + registration + ", name=" + name + "]";
    }

}
