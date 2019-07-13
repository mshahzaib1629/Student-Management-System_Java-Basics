package courseFiles;

import java.io.Serializable;
import java.util.ArrayList;

//MyLinkedList Class
public class CourseManagement implements Serializable {

    public Course head;

    public CourseManagement() {
        head = null;
    }

    public boolean insertCourse(String name, String id) {
        try {
            if (duplicationTest(id) == true) {
                return false;
            } else {
                Course newCourse = new Course(name, id, head);
                if (head == null) {
                    newCourse.next = null;
                    head = newCourse;
                    return true;
                } else {
                    head = newCourse;
                }
                return true;
            }

        } catch (java.lang.OutOfMemoryError e) {
            return false;
        }
    }

    public boolean duplicationTest(String id) {
        try {
            Course current = head;
            while (current.id == id || current.next != null) {

                if (current.id == id) {
                    return true;
                }
                current = current.next;
            }
            return false;

        } catch (NullPointerException e) {
            return false;
        }
    }

    public ArrayList printAll() throws NullPointerException {

        ArrayList<Course> list = new ArrayList<>();

        if (head == null) {
            return null;

        } else {
            Course current = head;

            while (current != null) {
                list.add(current);
                current = current.next;
            }
            return list;
        }
    }

    public Course searchCourse(String id) {
        try {
            Course current = head;
            while (current.id.equals(id) || current.next != null) {

                if (current.id.equals(id)) {
                    return current;
                }
                current = current.next;

            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public boolean deleteCourse(String id) {
        Course current = head;
        Course previous = new Course();

        while (current != null) {

            if (current.id.equals(id)) {
                if (current == head) {
                    Course temp = head.next;
                    head = null;
                    head = temp;
                }
                previous.next = current.next;
                return true;
            }

            previous = current;
            current = current.next;
        }
        // if empty list
        return false;
    }

}// end of Linked list class
