package com.diaas.student.entities.pojo;

import java.util.List;

import lombok.Data;

@Data
public class AnswerBankPojo {
	private int user_id;
	private List<String>exam_code;
	private List<String>answers;
}
