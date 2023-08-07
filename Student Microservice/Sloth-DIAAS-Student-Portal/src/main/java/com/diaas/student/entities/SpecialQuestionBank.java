package com.diaas.student.entities;

import java.util.ArrayList;

import lombok.Data;

@Data
public class SpecialQuestionBank {
	private int id;
	private String questions;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String answer;
	private int points;
	private String exam_code;
	private int user_id;
}
