package testingClasses;

import fileHandling.Data;
import static fileHandling.FileHandler.*;
import java.util.ArrayList;
import java.util.Scanner;

import courseFiles.Course;
import studentFiles.Student;

public class Selector {

    Scanner input = new Scanner(System.in);
    Scanner sinput = new Scanner(System.in);
    Data data;

    int choice1;
    int choice2;

    public Selector() {
        data = read();
        if (data == null) {
            data = new Data();
        }
    }

    public void Administrator() {
        System.out.println("########## WELCOME ADMIN ##########");
        System.out.print("Name: ");
        String name = sinput.nextLine();
        System.out.print("Password: ");
        String password = sinput.nextLine();
        if (data.ac.adminLogin(name, password) == true) {

            while (true) {
                System.out.print("1. Display all Students \n"
                        + "2. Display all Courses \n"
                        + "3. Add new Courses \n"
                        + "4. Delete a Course \n"
                        + "5. Delete a Student \n"
                        + "6. Change Admin Name \n"
                        + "7. Change Admin Password \n"
                        + "0. Back \n"
                        + "Choice: ");

                choice1 = input.nextInt();

                switch (choice1) {

                    case 1:
                        System.out.println("PRINT ALL STUDENTS \n");
                        try {
                            ArrayList<Student> listRecieved = data.sm.printAll();
                            for (Student std : listRecieved) {
                                System.out.println(std);
                            }
                            System.out.println();
                        } catch (NullPointerException e) {
                            System.out.println("No Student Found \n");
                        }
                        break;

                    case 2:
                        System.out.println("PRINT ALL COURSES \n");
                        try {
                            ArrayList<Course> listRecieved = data.cm.printAll();
                            listRecieved.forEach((std) -> {
                                System.out.println(std);
                            });
                            System.out.println();
                        } catch (NullPointerException e) {
                            System.out.println("No course Entered yet! \n");
                        }
                        break;

                    case 3:
                        System.out.println("ADD COURSE \n");
                        System.out.print("name: ");
                        String cName = sinput.nextLine();
                        System.out.print("ID: ");
                        String id = sinput.nextLine();
                        if (data.cm.insertCourse(cName, id) == true) {
                            System.out.println("Added Successfully! \n");
                            write(data);
                        } else {
                            System.out.println("Error \n");
                        }
                        break;

                    case 4:
                        System.out.println("DELETE COURSE \n");
                        System.out.print("ID: ");
                        String id2 = sinput.nextLine();
                        if (data.cm.deleteCourse(id2) == true) {
                            System.out.println(id2 + " is Deleted \n");
                            write(data);
                        } else {
                            System.out.println("Error \n");
                        }
                        break;

                    case 5:
                        System.out.println("DELETE STUDENT \n");
                        System.out.print("reg: ");
                        String reg2 = sinput.nextLine();
                        if (data.sm.deleteStudent(reg2) == true) {
                            System.out.println(reg2 + " is Deleted \n");
                            write(data);
                        } else {
                            System.out.println("Error \n");
                        }
                        break;

                    case 6:
                        System.out.println("CHANGE ADMIN NAME");
                        System.out.print("Enter New Name: ");
                        String aName = sinput.nextLine();
                        data.ac.setAdminName(aName);
                        System.out.println("Name Changed, Login Again \n");
                        write(data);
                        return;

                    case 7:
                        System.out.println("CHANGE ADMIN PASSWORD");
                        System.out.print("Enter New Password: ");
                        String aPass = sinput.nextLine();
                        data.ac.setAdminPassword(aPass);
                        System.out.println("Password Changed, Login Again \n");
                        write(data);
                        return;

                    case 0:
                        return;
                    default:
                        System.out.println("Invalid Entry!");
                }
            }
        } else {
            System.out.println("Invalid Admin Name OR Password!");
        }

    }

    public void Student() {
        System.out.println("########## WELCOME STUDENT ##########");
        while (true) {
            System.out.print("1. Sign Up \n"
                    + "2. Log In \n"
                    + "0. Back \n"
                    + "Choice: ");
            choice1 = input.nextInt();

            switch (choice1) {
                case 1:
                    System.out.println("SIGN UP \n");
                    System.out.print("name: ");
                    String name = sinput.nextLine();
                    System.out.print("reg: ");
                    String reg = sinput.nextLine();
                    System.out.print("pass: ");
                    String pass = sinput.nextLine();
                    if (data.sm.studentSignUp(name, reg, pass) == true) {

                        write(data);

                        System.out.println("Signed Up Successfully! \n");
                        if (data.sm.studentLogin(reg, pass) != null) {
                            Student s = data.sm.studentLogin(reg, pass);
                            System.out.println(data.sm.studentLogin(reg, pass));
                            while (true) {
                                System.out.print("1. View My Courses \n"
                                        + "2. Add New Course \n"
                                        + "3. Delete A Course \n"
                                        + "4. Delete All Courses \n"
                                        + "0. Back \n"
                                        + "Choice: ");

                                choice1 = input.nextInt();
                                switch (choice1) {

                                    case 1:
                                        System.out.println("MY COURSES \n");
                                        ArrayList<Course> receivedList = s.getMyCourses();
                                        if (receivedList.isEmpty() == false) {
                                            for (Course c : receivedList) {
                                                System.out.println(c);
                                            }
                                            System.out.println();
                                        } else {
                                            System.out.println("No Courses Registered \n");
                                        }
                                        break;
                                    case 2:				//working
                                        System.out.println("ADD NEW COURSE \n");
                                        System.out.println("(NOTE: You can Register only 6 Courses at a time) \n");
                                        System.out.println("Avaliable Courses: ");
                                        try {
                                            ArrayList<Course> listRecieved = data.cm.printAll();
                                            for (Course std : listRecieved) {
                                                System.out.println(std);
                                            }
                                        } catch (NullPointerException e) {
                                            System.out.println("No course Available yet!");
                                        }

                                        System.out.print("Enter ID of Course to Add: ");
                                        String cID = sinput.nextLine();

                                        if (data.cm.searchCourse(cID) != null) {
                                            Course c = data.cm.searchCourse(cID);		//getting desired course here directly
                                            //and passing to the student class
                                            if (s.setMyCourses(c) == true) {
                                                write(data);
                                                System.out.println("Added Successfully! \n");
                                            } else {
                                                System.out.println("Error \n");
                                            }
                                        } else {
                                            System.out.println("Error \n");
                                        }
                                        break;

                                    case 3:
                                        System.out.print("Enter Course Id to Delete: ");
                                        String cId = sinput.nextLine();
                                        if (s.deleteOneCourse(cId) == true) {
                                            System.out.println(cId + " is Deleted \n");
                                            write(data);
                                        } else {
                                            System.out.println(cId + " not found \n");
                                        }
                                        break;

                                    case 4:
                                        System.out.print("Are you sure to delete all? (1/0)");
                                        int option = input.nextInt();
                                        if (option == 1) {
                                            s.deleteAllCourses();
                                            write(data);
                                            System.out.println("Deleted! \n");
                                        } else {
                                            System.out.println("Not Deleted \n");
                                        }
                                        break;

                                    case 0:
                                        return;
                                    default:
                                        System.out.println("Invalid Entry! \n");

                                }
                            }
                        }

                    } else {
                        System.out.println("Error");
                    }
                    break;
                case 2:
                    System.out.println("LOGIN \n");
                    System.out.print("reg: ");
                    String reg1 = sinput.nextLine();
                    System.out.print("pass: ");
                    String pass1 = sinput.nextLine();
                    if (data.sm.studentLogin(reg1, pass1) != null) {
                        Student s = data.sm.studentLogin(reg1, pass1);
                        System.out.println(data.sm.studentLogin(reg1, pass1));
                        while (true) {
                            System.out.print("1. View My Courses \n"
                                    + "2. Add New Course \n"
                                    + "3. Delete A Course \n"
                                    + "4. Delete All Courses \n"
                                    + "0. Back \n"
                                    + "Choice: ");

                            choice1 = input.nextInt();
                            switch (choice1) {

                                case 1:

                                    System.out.println("MY COURSES \n");
                                    ArrayList<Course> receivedList = s.getMyCourses();
                                    if (receivedList.isEmpty() == false) {
                                        receivedList.forEach((c) -> {
                                            System.out.println(c);
                                        });
                                        System.out.println();
                                    } else {
                                        System.out.println("No Courses Registered yet! \n");
                                    }
                                    break;

                                case 2:
                                    System.out.println("ADD NEW COURSE \n");
                                    System.out.println("(NOTE: You can Register only 6 Courses at a time) \n");
                                    System.out.println("Avaliable Courses: ");
                                    try {
                                        ArrayList<Course> listRecieved = data.cm.printAll();
                                        listRecieved.forEach((std) -> {
                                            System.out.println(std);
                                        });
                                    } catch (NullPointerException e) {
                                        System.out.println("No course Available yet!");;
                                    }

                                    System.out.print("Enter ID of Course to Add: ");
                                    String cID = sinput.nextLine();

                                    if (data.cm.searchCourse(cID) != null) {
                                        Course c = data.cm.searchCourse(cID);		//getting desired course here directly 
                                        //and passing to the student class
                                        if (s.setMyCourses(c) == true) {
                                            write(data);
                                            System.out.println("Added Successfully! \n");
                                        } else {
                                            System.out.println("Error \n");
                                        }
                                    } else {
                                        System.out.println("Error \n");
                                    }
                                    break;

                                case 3:
                                    System.out.print("Enter Course Id to Delete: ");
                                    String cId = sinput.nextLine();
                                    if (s.deleteOneCourse(cId) == true) {
                                        write(data);
                                        System.out.println(cId + " is Deleted \n");
                                    } else {
                                        System.out.println(cId + " not found \n");
                                    }
                                    break;

                                case 4:
                                    System.out.print("Are you sure to delete all? (1/0)");
                                    int option = input.nextInt();
                                    if (option == 1) {
                                        s.deleteAllCourses();
                                        write(data);
                                        System.out.println("Deleted! \n");
                                    } else {
                                        System.out.println("Not Deleted \n");
                                    }
                                    break;
                                case 0:
                                    return;
                                default:
                                    System.out.println("Invalid Entry!");
                            }
                        }
                    } else {
                        System.out.println("Student Not Registered \n");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Entry! \n");
                    break;
            }
        }
    }
}
