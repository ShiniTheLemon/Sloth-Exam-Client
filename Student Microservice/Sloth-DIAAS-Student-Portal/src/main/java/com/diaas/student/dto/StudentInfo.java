package com.diaas.student.dto;

import lombok.Data;

@Data
public class StudentInfo {
	private int user_id;
	private String first_name;
	private String last_name;
	private String exam_code;
}
