package administration;

import java.io.Serializable;
import java.util.ArrayList;

import courseFiles.CourseManagement;
import studentFiles.StudentManagement;

public class AdminClass implements Serializable{

	String adminName = "admin";
	String adminPassword = "1629";
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	public boolean adminLogin(String name, String password){
		if(this.adminName.equals(name) && this.adminPassword.equals(password))
			return true;
		else
			return false;
	}
	
}
