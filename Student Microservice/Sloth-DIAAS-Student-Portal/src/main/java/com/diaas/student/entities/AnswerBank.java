package com.diaas.student.entities;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;

@Data
public class AnswerBank {

	private int id;
	private String answers;
	private int points;

	private String exam_code;
	private int user_id;
}
