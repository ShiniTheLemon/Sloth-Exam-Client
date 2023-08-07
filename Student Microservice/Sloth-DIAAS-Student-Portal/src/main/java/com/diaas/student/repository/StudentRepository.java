package com.diaas.student.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.diaas.student.entities.AnswerBank;
import com.diaas.student.entities.Courses;
import com.diaas.student.entities.ExamScores;
import com.diaas.student.entities.Grades;
import com.diaas.student.entities.Sections;
import com.diaas.student.entities.UserInfo;
import com.diaas.student.entities.Users;

@Repository
public interface StudentRepository {
	Courses findCourseById(@Param("id")int id);
	
	int insertIntoAnswerBank(@Param("answer")AnswerBank answerBank);
	

	
	int updateAnswerBankById(@Param("answer")AnswerBank answerBank);
	int updateInfoById(@Param("info")UserInfo info);
	
	
	List<AnswerBank> showAllStudentAnswers();
	List<Grades>findGradesByLastNameAndFirstName(@Param("last_name")String last_name,@Param("first_name")String first_name);
	List<Integer>showIdByUserIdAndExam_code(@Param("user_id") int user_id, @Param("exam_code") String exam_code);
	List<AnswerBank> showAnswersByUserIdAndExam_code(@Param("user_id") int user_id,
			@Param("exam_code") String exam_code);
	
	int insertPointsByid(@Param("id")int id,@Param("points")int points);
	
	//create method to put total in exam scores
	int insertScoreInfo(@Param("scores")ExamScores scores);
	int insertTotal(@Param("scores")ExamScores scores);
	
	List<ExamScores>findByExamCode(@Param("exam")String exam);
	ExamScores findByExamCodeAndUserId(@Param("exam")String exam,@Param("user_id")int user_id);
	UserInfo findByUserId(@Param("user_id")int user_id);
	Sections findSectionByCourseName(@Param("course_name")String course_name);
	Users findUserByUserId(@Param("user_id")int user_id);
	
}
