package com.diaas.student.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diaas.student.dto.AnswerBankList;
import com.diaas.student.dto.GradedPapers;
import com.diaas.student.dto.StudentInfo;
import com.diaas.student.dto.StudentInfoList;
import com.diaas.student.entities.AnswerBank;
import com.diaas.student.entities.ExamScores;
import com.diaas.student.entities.UserInfo;
import com.diaas.student.repository.StudentRepository;
import com.diaas.student.service.StudentService;

@RestController

public class StudentRestController {
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	StudentService service;
	
	@RequestMapping("/rest/studentInfo.do/{exam_code}")
	public StudentInfoList info(@PathVariable String exam_code) {
		ArrayList<StudentInfo>studentInfo= service.getUserInfo(exam_code);
		System.out.println("student info "+studentInfo);
		
		StudentInfoList info=new StudentInfoList();
		info.setInfo(studentInfo);
		return info;
	}
	
	@RequestMapping("/rest/studentAnswers.do/{user_id}/{exam_code}")
	public AnswerBankList studentAnswers(@PathVariable("user_id") int user_id,@PathVariable("exam_code") String exam_code){
		List<AnswerBank> studentAnswers=studentRepo.showAnswersByUserIdAndExam_code(user_id, exam_code);
		AnswerBankList answers=new AnswerBankList();
		answers.setList(studentAnswers);
		return answers;
	}
	@RequestMapping("/rest/processPapers.do")
	public void processPapers(@RequestBody GradedPapers papers) {
		System.out.println("The data was tranported successfully "+ papers);
		service.gradeProcessor(papers);
	}
}
