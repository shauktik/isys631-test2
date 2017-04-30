package com.project.model;


/*UserProfile.java
 * Bean to store retrieved user information from database 
 * in memory for operation*/

public class UserProfile {
	
	private String firstName;
	private String lastName;
	private String dob;
	private String addressline1;
	private String addressline2;
	private String state;
	private int zip;
	private String phoneNumber;
	private String ssn;
	private String jobRole;
	private int hourlyWage;
	private String user_Name;
	
	
	
	
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		final StringBuilder temp = new StringBuilder();
		for(int i=0; i<=temp.length(); i++)
		{
			if (i<3)
				temp.append("*");
			else if (i==3)
				temp.append("-");
			else if (i>3 && i<6)
				temp.append("*");
			else if (i==6)
				temp.append("-");
			else
			{
				temp.append(ssn.substring(7));
				break;
			}
		}
		this.ssn = temp.toString();
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public int getHourlyWage() {
		return hourlyWage;
	}
	public void setHourlyWage(int hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	

}
