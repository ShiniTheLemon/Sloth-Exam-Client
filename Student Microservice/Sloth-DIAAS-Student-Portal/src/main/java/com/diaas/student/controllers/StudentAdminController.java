package com.diaas.student.controllers;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.diaas.student.annotation.RequireLogin;
import com.diaas.student.annotation.RequireRole;
import com.diaas.student.client.request.ClientRequest;
import com.diaas.student.dto.SectionsList;
import com.diaas.student.entities.Departments;
import com.diaas.student.entities.ExamScores;
import com.diaas.student.entities.Grades;
import com.diaas.student.entities.RegisterStudent;
import com.diaas.student.entities.Sections;
import com.diaas.student.entities.UserInfo;
import com.diaas.student.repository.AdminRepository;
import com.diaas.student.service.StudentAdminService;



@Controller
public class StudentAdminController {
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	StudentAdminService service;
	@Autowired
	ClientRequest request;
	
	@RequireLogin
	@RequireRole
	@RequestMapping("/student/admin/index")
	public String mainPage(ModelMap modelMap) {
		SectionsList sections = request.adminExamCalendar();
		modelMap.addAttribute("sections", sections.getSectionsList());
		return "/admin/Index";

	}
	@RequireLogin
	@RequireRole
	@RequestMapping("/student/admin/register/page")
	public String RegisterPage(ModelMap modelMap) {
		
		List<Departments> dept = adminRepo.showAllDepartments();
		modelMap.addAttribute("dept", dept);
		
		return "/admin/Register";
	}
	@RequireLogin
	@RequireRole
	@RequestMapping("/student/admin/registered")
	public String registerStudent(RegisterStudent student,ModelMap modelMap) {
		service.registerStudent(student);
		String msg=student.getFirst_name()+" "+student.getLast_name()+" registered";
		modelMap.addAttribute("msg", msg);
		return "/admin/Index";
	}
	
	@RequireLogin
	@RequireRole
	@RequestMapping("/student/admin/grade/page")
	public String showAllStudents(ModelMap modelMap) {
		List<Integer>ids=adminRepo.ShowAllScores();
		ArrayList<UserInfo>info=new ArrayList();
		for(int i=0;i<ids.size();i++) {
			info.add(adminRepo.findUserInfoByUserId(ids.get(i)));
		}
		modelMap.addAttribute("info", info);
		return "/admin/Grade";
	}
	@RequireLogin
	@RequireRole
	@RequestMapping("/student/admin/calculate")
	public String ShowSingleStudent(@RequestParam("userId")int userId,ModelMap modelMap) {
		
		UserInfo info= adminRepo.findUserInfoByUserId(userId);
		List<ExamScores>studentScores=adminRepo.findScoresByUserId(userId);
		List<Sections>sections= adminRepo.showActiveSections(info.getDept_id());
		
		modelMap.addAttribute("info", info);
		modelMap.addAttribute("studentScores", studentScores);
		modelMap.addAttribute("sections", sections);
		
		System.out.println("info "+info);
		System.out.println("studentScores "+studentScores);
		System.out.println("sections "+sections);
		
		return "/admin/Calculate";
	}
	
	@RequireLogin
	@RequireRole
	@RequestMapping("/student/admin/calculate/scores")
	public String CalculateScores(@RequestParam("user_id") int user_id, @RequestParam("section1") String section1,
			@RequestParam("section2") String section2, @RequestParam("section3") String section3,
			@RequestParam("course_name") String course_name,ModelMap modelMap) {
		
		service.jellyFish(user_id, section1, section2, section3, course_name);
		return showTranscripts(modelMap);
	}
	
	@RequireLogin
	@RequireRole
	@RequestMapping("/student/admin/trascripts")
	public String showTranscripts(ModelMap modelMap) {
		List<Grades>grades= adminRepo.showAllGrades();
		modelMap.addAttribute("grades", grades);
		return "/admin/Transcripts";
	}
	
	@RequireLogin
	@RequireRole
	@RequestMapping("/student/admin/showAllUsers")
	public String showAllUsers(ModelMap modelMap) {
		 
		List<UserInfo> users = adminRepo.ShowAllUsers();
		modelMap.addAttribute("users", users);
		
		return "/admin/users";
	}
	@RequireLogin
	@RequireRole
	@RequestMapping("/student/admin/resetPassword")
	public String resetPassword(@RequestParam("id")int id ,@RequestParam("password")String password,ModelMap modelMap) {
		adminRepo.resetUserPassword(id, password);
		return showAllUsers(modelMap);
	}
}
