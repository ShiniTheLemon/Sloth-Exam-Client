package com.diaas.student.dto;

import java.util.List;

import com.diaas.student.entities.SpecialQuestionBank;

import lombok.Data;
@Data
public class SpecialQuestionList {
	List<SpecialQuestionBank>specialList;
}
