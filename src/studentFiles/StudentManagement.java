package studentFiles;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentManagement implements Serializable {

    public Student head;

    public StudentManagement() {
        head = null;
    }

    public boolean studentSignUp(String name, String reg, String pass) {
        try {   

            if (duplicationTest(reg) == true) {
                return false;

            } else {
                Student newStudent = new Student(name, reg, pass, head);

                if (head == null) {
                    newStudent.next = null;
                    head = newStudent;
                    return true;

                } else {
                    head = newStudent;
                }
                return true;
            }
        } catch (java.lang.OutOfMemoryError e) {
            return false;
        }
    }

    public boolean duplicationTest(String reg) {
        try {
            Student current = head;
            while (current.registration.equals(reg) || current.next != null) {

                if (current.registration.equals(reg)) {
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

        ArrayList<Student> list = new ArrayList<>();

        if (head == null) {
            return null;

        } else {
            Student current = head;

            while (current != null) {
                list.add(current);
                current = current.next;
            }
            return list;
        }

    }

    public Student studentLogin(String reg, String pass) {
        try {
            Student current = head;
            while (current.registration.equals(reg) || current.next != null) {

                if (current.registration.equals(reg)) {
                    if (current.password.equals(pass)) {
                        return current;
                    }
                }
                current = current.next;

            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public boolean deleteStudent(String reg) {
        Student current = head;
        Student previous = new Student();

        while (current != null) {

            if (current.registration.equals(reg)) {
                if (current == head) {
                    Student temp = head.next;
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
