
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileHandling;

import administration.AdminClass;
import courseFiles.CourseManagement;
import java.io.Serializable;
import studentFiles.StudentManagement;

public class Data implements Serializable {
	public AdminClass ac = new AdminClass();
	public CourseManagement cm = new CourseManagement();
	public StudentManagement sm = new StudentManagement();
}
