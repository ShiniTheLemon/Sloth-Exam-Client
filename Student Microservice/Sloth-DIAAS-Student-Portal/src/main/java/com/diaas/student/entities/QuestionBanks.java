package com.diaas.student.entities;

import java.util.List;



import lombok.Data;


@Data
public class QuestionBanks {

	private int id;
	private String questions;
	private Integer points;

	private String exam_code;

	private int user_id;
}
