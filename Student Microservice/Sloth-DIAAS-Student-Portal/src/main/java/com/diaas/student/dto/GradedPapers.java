package com.diaas.student.dto;

import java.util.List;

import lombok.Data;

@Data
public class GradedPapers {
	private List<Integer>points;
	private List<String>Answers;
	private String exam_code;
	private int user_id;
	private int maximumPoints;
	private String course_name;
	private String section1;
	private String section2;
	private String section3;
}
