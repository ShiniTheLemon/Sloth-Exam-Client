package com.diaas.student.dto;

import java.util.ArrayList;
import java.util.List;

import com.diaas.student.entities.AnswerBank;

import lombok.Data;
@Data
public class AnswerBankList {
	private List<AnswerBank> list;
}
