package com.diaas.student.entities;

import lombok.Data;

@Data
public class RegisterStudent {
	private int id;
	private int role;
	private String first_name;
	private String last_name;
	private String password;
	private int dept_id;
	private String year;
}
