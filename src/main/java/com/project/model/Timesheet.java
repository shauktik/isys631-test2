package com.project.model;

import java.util.List;

/*Timesheet.java
 * Bean class to hold 
 * timesheet entries for submission by a user*/
public class Timesheet {
	
	private List<String> timeEntry;

	public List<String> getTimeEntry() {
		return timeEntry;
	}

	public void setTimeEntry(List<String> timeEntry) {
		this.timeEntry = timeEntry;
	}
		

}
