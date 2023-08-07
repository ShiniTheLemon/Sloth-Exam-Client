package com.diaas.student.entities;

import lombok.Data;

@Data
public class UserInfo {
	private int id;
	private int user_id;
	private String first_name;
	private String last_name;
	private String email;
	private int dept_id;
	private int online;
	private String avatar;
	private String year;
}
