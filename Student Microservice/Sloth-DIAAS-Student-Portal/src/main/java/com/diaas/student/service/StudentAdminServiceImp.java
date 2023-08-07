package com.diaas.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diaas.student.client.request.ClientRequest;
import com.diaas.student.entities.Courses;
import com.diaas.student.entities.Departments;
import com.diaas.student.entities.Grades;
import com.diaas.student.entities.RegisterStudent;
import com.diaas.student.entities.UserInfo;
import com.diaas.student.entities.Users;
import com.diaas.student.repository.AdminRepository;

@Service
public class StudentAdminServiceImp implements StudentAdminService {
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	ClientRequest request;
	@Override
	//registers a new student
	public int registerStudent(RegisterStudent student) {
		// TODO Auto-generated method stub
		UserInfo info=new UserInfo();
		Users user=new Users();
		info.setUser_id(student.getId());
		info.setFirst_name(student.getFirst_name());
		info.setLast_name(student.getLast_name());
		info.setDept_id(student.getDept_id());
		info.setYear(student.getYear());
		user.setId(student.getId());
		user.setRole(student.getRole());
		user.setPassword(student.getPassword());
	
		int i=adminRepo.addUser(user);
		adminRepo.addUserInfo(info);

		return i;
	}
	@Override
	//enters the student transcript information after they have been graded
	public int jellyFish(int user_id, String section1, String section2, String section3, String course_name) {
		// TODO Auto-generated method stub
		Grades grade=new Grades();
		UserInfo info=adminRepo.findUserInfoByUserId(user_id);
		Courses course=adminRepo.findCourseByName(course_name);
		Departments dept=adminRepo.findDeptById(info.getDept_id());
		
		//retrieves total score obtained by student for each section
		int Section1Score= adminRepo.findTotalByUserIdAndExamCode(user_id, section1);
		int Section2Score= adminRepo.findTotalByUserIdAndExamCode(user_id, section2);
		int Section3Score= adminRepo.findTotalByUserIdAndExamCode(user_id, section3);
		
		//request for the total for each section for faculty microservice
		int max1= request.total(section1).getTotal();
		int max2=request.total(section2).getTotal();
		int max3=request.total(section3).getTotal();
		
		
		
		System.out.println("student exam scores "+ Section1Score);
		System.out.println("student exam scores "+ Section2Score);
		System.out.println("student exam scores "+Section3Score);
		
		System.out.println("actual exam scores "+max1);
		System.out.println("actual exam scores "+max2);
		System.out.println("actual exam scores "+max3);
		
		//calculates final grade
		String result= Vanillalemonaide(Section1Score,Section2Score,Section3Score,max1,max2,max3);
		
		
		grade.setGrade(result);
		grade.setDept_name(dept.getDept_name());
		grade.setCredits(course.getCredits());
		grade.setCourses(course_name);
		grade.setFirst_name(info.getFirst_name());
		grade.setLast_name(info.getLast_name());
		grade.setYear(info.getYear());
		
		//checks info already exists
		//inserts transcript ino into db
		int i=appleSacue(grade);
	    
		//changes status of paper to graded
		crixCross(i,user_id,section1,section2,section3);
		
		return i;
	}
	
	
	//calculates the percentage and then assigns a grade
	public String Vanillalemonaide(int score1,int score2,int score3,int max1,int max2,int max3) {
		double finalScore=score1+score2+score3;
		System.out.println("final score "+finalScore);
		
		double finalMax=max1+max2+max3;
		System.out.println("final max "+finalMax);
		
		double computedScore=(finalScore/finalMax)*100;
		
		int intScore=(int)computedScore;
		
		System.out.println("computed score "+computedScore);
		
		if(intScore>=95) {
			return "A+";
		}if(intScore>=90) {
			return "A";
		}if(intScore>=85) {
			return "A-";
		}if(intScore>=80) {
			return "B+";
		}if(intScore>=75) {
			return "B";
		}if(intScore>=70) {
			return "B-";
		}if(intScore>=65) {
			return "C+";
		}if(intScore>=60) {
			return "C";
		}if(intScore>=55) {
			return "C-";
		}if(intScore>=50) {
			return "D+";
		}if(intScore>=45) {
			return "D";
		}if(intScore>=40) {
			return "D-";
		}else {
			return "F";
		}
		
		
	}
	
	
	//changes status of students paper to graded
	public void crixCross(int i,int user_id,String section1,String section2,String section3) {
		if(i!=0) {
			adminRepo.changeScoreStatus(user_id, section1);
			adminRepo.changeScoreStatus(user_id, section2);
			adminRepo.changeScoreStatus(user_id, section3);
		}else {
			System.out.println("Error crixCross was unable to execute");
		}
	}
	
	
	//checks if grade info already exists
	//adds or updates grades
	public int appleSacue(Grades grade) {
		int i=0;
		Grades gradesExists = adminRepo.findGradeByGradeObject(grade);
		if(gradesExists==null) {
			i=adminRepo.addGrade(grade);
		}else {
			i=adminRepo.updateGradeById(gradesExists.getId(), grade.getGrade());
		}	
		return i;
	}

}
