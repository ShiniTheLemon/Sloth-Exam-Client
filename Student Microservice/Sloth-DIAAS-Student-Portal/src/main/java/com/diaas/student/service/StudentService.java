package com.diaas.student.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;

import com.diaas.student.dto.GradedPapers;
import com.diaas.student.dto.StudentInfo;
import com.diaas.student.entities.AnswerBank;
import com.diaas.student.entities.Photo;
import com.diaas.student.entities.UserInfo;
import com.diaas.student.entities.Users;
import com.diaas.student.entities.pojo.AnswerBankPojo;

@Service
public interface StudentService {
	int insertSingleChoiceAnswers(AnswerBankPojo pojo);
	int InsertMultipleChoiceAnswers(AnswerBankPojo pojo);
	//List<AnswerBank> ShowAnswersByUserIdAndExamCode(HttpSession session);
	//int updateAnswers(AnswerBankPojo pojo);
	ArrayList<StudentInfo> getUserInfo(String exam_code);
	//ArrayList<StudentInfo> getStudentInfo(ArrayList<UserInfo> info,String exam_code);
	int gradeProcessor(GradedPapers paper);
	String login(Users user,HttpSession session);
	
	//deprecated
	String UpdateInfo(UserInfo info,MultipartFile file)throws IOException ;
	//deprecated
	String getAvatar(UserInfo info,HttpServletResponse response)throws  IOException ;
	 public void saveImage(MultipartFile imageFile, Photo photo) throws IOException ;
}
