package com.diaas.student.entities;

import lombok.Data;

@Data
public class Grades {
	private int id;
	private String dept_name;
	private String courses;
	private String first_name;
	private String last_name;
	private String year;
	private int credits;
	private String grade;
}
