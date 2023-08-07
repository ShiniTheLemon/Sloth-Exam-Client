package com.diaas.student.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.diaas.student.entities.Courses;
import com.diaas.student.entities.Departments;
import com.diaas.student.entities.ExamScores;
import com.diaas.student.entities.Grades;
import com.diaas.student.entities.Sections;
import com.diaas.student.entities.UserInfo;
import com.diaas.student.entities.Users;


@Repository
public interface AdminRepository {
	
	int addUser(@Param("users")Users user);
	int addUserInfo(@Param("info")UserInfo info);
	int addCourse(@Param("course")Courses course);
	int addDepartment(@Param("dept")Departments dept);
	int addGrade(@Param("grade")Grades grade);
	int changeScoreStatus(@Param("user_id")int user_id,@Param("exam_code")String exam_code);
	//????????
	int addSections(@Param("section")Sections section);
	

	List<Grades>showAllGrades();
	List<Integer>ShowAllScores();
	List<UserInfo>ShowAllUsers();
	List<Departments>showAllDepartments();
	
	Grades findGradeByGradeObject(@Param("grade")Grades grade);
	Sections findSectionById(@Param("id")int id);
	List<ExamScores>findScoresByUserId(@Param("userId")int userId);
	List<Grades>findGradesByDepartmentName(@Param("dept_name")String dept_name);
	List<Grades>findGradesByCourseName(@Param("course")String course);
	UserInfo findUserInfoByUserId(@Param("userId")int userId);
	List<Sections> showActiveSections(@Param("dept_id")int dept_id);
	int findTotalByUserIdAndExamCode(@Param("user_id")int user_id,@Param("exam_code")String exam_code);
	Courses findCourseByName(@Param("course_name")String course_name);
	Departments findDeptById(@Param("dept_id")int dept_id);

	
	int updateSectionStatus(@Param("status")int status,@Param("dept_id")int dept_id,@Param("id")int id);
	int updateGradeById(@Param("id")int id,@Param("grade")String grade);
	int resetUserPassword(@Param("id")int id,@Param("password")String newPassowrd);

	//create method to change section status once exam is over

	

}
