package testingClasses;

import java.util.Scanner;

import administration.AdminClass;
import courseFiles.CourseManagement;
import studentFiles.Student;
import studentFiles.StudentManagement;

import static fileHandling.FileHandler.read;
import static fileHandling.FileHandler.write;

public class StudentManagementSystem {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		Selector select = new Selector();
		int choice;
		
		System.out.println("\nSTUDENT MANAGEMENT SYSTEM");
		System.out.println("________________________________________ \n");
		while (true) {
			System.out.print("1. Administratior \n"
							 + "2. Student \n"
							 + "0. Exit \n"
							 + "Choice: ");
			
			choice = input.nextInt();
			switch(choice){
			
			case 1:
				select.Administrator();
				break;

			case 2:
				select.Student();
				break;

			case 0:
				return;

			default:
				System.out.println("Invalid Entry!");
			}

		}

	}
}
