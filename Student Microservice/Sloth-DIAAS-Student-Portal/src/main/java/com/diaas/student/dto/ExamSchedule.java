package com.diaas.student.dto;


import lombok.Data;
@Data

public class ExamSchedule {

	private int id;
	
	private String exam_code;
	private int total;
	private int user_id;
	private int status;


}
