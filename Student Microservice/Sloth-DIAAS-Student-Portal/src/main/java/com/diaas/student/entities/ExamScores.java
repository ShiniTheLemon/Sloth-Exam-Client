package com.diaas.student.entities;

import lombok.Data;

@Data
public class ExamScores {
	private int id;
	private String exam_code;
	private int total;
	private int user_id;
	private int status;
}
