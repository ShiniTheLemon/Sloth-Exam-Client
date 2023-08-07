package com.diaas.student.entities;

import lombok.Data;

@Data
public class Courses {
	private int id;
	private int dept_id;
	private String name;
	private int credits;
}
