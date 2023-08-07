package com.diaas.student.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.diaas.student.annotation.RequireLogin;
import com.diaas.student.annotation.RequireRole;
import com.diaas.student.client.request.ClientRequest;
import com.diaas.student.dto.QuestionBanksList;
import com.diaas.student.dto.SectionsList;
import com.diaas.student.dto.SpecialQuestionList;
import com.diaas.student.entities.Grades;
import com.diaas.student.entities.Photo;
import com.diaas.student.entities.Sections;
import com.diaas.student.entities.UserInfo;
import com.diaas.student.entities.Users;
import com.diaas.student.entities.pojo.AnswerBankPojo;
import com.diaas.student.repository.StudentRepository;
import com.diaas.student.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	ClientRequest request;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	StudentService service;
	
	@RequireLogin
	@RequestMapping("/student/user/showAllSections")
	public String showAllSections(ModelMap modelMap,HttpSession session) {

		int dept_id=(int) session.getAttribute("dept_id");
		SectionsList sections=request.showActiveSections(dept_id);
		
		modelMap.addAttribute("avatar",  (String)session.getAttribute("avatar"));
		modelMap.addAttribute("email", (String)session.getAttribute("email"));
		modelMap.addAttribute("sections", sections.getSectionsList());
		System.out.println("Student department id in show all users method "+ dept_id);
		System.out.println("Session values "+ (String)session.getAttribute("avatar")+" " +(String)session.getAttribute("email"));
		
		return "/student/Sections";
	}
	@RequireLogin
	@RequestMapping("/student/user/selectSections")
	public String selectSections(ModelMap modelMap,@RequestParam("id")int id,HttpSession session) {
		System.out.println("Select section controller method was called");
		session.setAttribute("sectionId", id);
		Sections sections=request.selectSections(id);
		
		modelMap.addAttribute("sections", sections);
		
		return "/student/SelectSection1";
	}
	@RequireLogin
	@RequestMapping("/student/user/showSectionA")
	public String showSectionA(ModelMap modelMap,@RequestParam("exam_code")String exam_code) {
		
		//request questions from faculty microservice
		SpecialQuestionList questions=request.showSectionA(exam_code);
		
		modelMap.addAttribute("questions", questions.getSpecialList());
		
		return "/student/SectionA";
	}
	@RequireLogin
	@RequestMapping("/student/user/showSectionB")
	public String showSectionB(ModelMap modelMap,@RequestParam("exam_code")String exam_code) {
		
		//request questions from faculty microservice
		QuestionBanksList questions=request.showSectionCandB(exam_code);
		
		modelMap.addAttribute("questions", questions.getQuestionBanksLists());
		
		return "/student/SectionB";
	}
	@RequireLogin
	@RequestMapping("/student/user/showSectionC")
	public String showSectionC(ModelMap modelMap,@RequestParam("exam_code")String exam_code) {
		
		//request questions from faculty microservice
		QuestionBanksList questions=request.showSectionCandB(exam_code);
		
		modelMap.addAttribute("questions", questions.getQuestionBanksLists());
		
		return "/student/SectionC";
	}
	
	@RequireLogin
	@RequestMapping("/student/user/submitAnswersA")
	public String submitAnswers(@ModelAttribute("AnswerBankPojo")AnswerBankPojo pojo,ModelMap modelMap,HttpSession session) {
		
		pojo.setUser_id((int) session.getAttribute("user_id"));
		service.insertSingleChoiceAnswers(pojo);
	
		Sections sections=request.selectSections((int) session.getAttribute("sectionId"));
		
		modelMap.addAttribute("sections", sections);
		
		return "/student/SelectSection2";
	}
	@RequireLogin
	@RequestMapping("/student/user/submitAnswersB")
	public String submitAnswersB(@ModelAttribute("AnswerBankPojo")AnswerBankPojo pojo,ModelMap modelMap,HttpSession session) {
		
		pojo.setUser_id((int) session.getAttribute("user_id"));
		service.insertSingleChoiceAnswers(pojo);

		Sections sections=request.selectSections((int) session.getAttribute("sectionId"));
		
		modelMap.addAttribute("sections", sections);
		
		return "/student/SelectSection3";
	}
	@RequireLogin
	@RequestMapping("/student/user/submitAnswersC")
	public String submitAnswersC(@ModelAttribute("AnswerBankPojo")AnswerBankPojo pojo, HttpSession session) {
		
		pojo.setUser_id((int) session.getAttribute("user_id"));
		
		service.insertSingleChoiceAnswers(pojo);
		
		return "/student/Complete";
	}
	
	@RequireLogin
	@RequestMapping("/student/user/completed")
	public String completed() {
		return "/student/Complete";
	}
	@RequestMapping("/403")
	public String forbidden() {
		return "403";
	}
	
	
	@RequestMapping("/student/login")
	public String login(@ModelAttribute("Users")Users user,HttpSession session,ModelMap modelMap) {
		System.out.println("user info "+ user);

	
		String msg = service.login(user,session);
			
			if(msg==null) {
				if((session.getAttribute("role").equals(1))){
					return dashBoard(modelMap,session);
				}else {
					SectionsList sections = request.adminExamCalendar();
					modelMap.addAttribute("sections", sections.getSectionsList());
					return "/admin/Index";
				}
				
			}else {
				modelMap.addAttribute("msg",msg);
				return "/student/Login";
			}
		


	}
	
	@RequestMapping("/")
	public String loginPage() {
		return "/student/Login";
	}
	@RequestMapping("/logout")
	public String loginout(HttpSession session) {
		session.invalidate();
		return "/student/Login";
	}
	@RequireLogin
	@RequestMapping("/student/user/transcripts")
	public String showTranscripts(HttpSession session,ModelMap modelMap) {
		
		int user_id=(int) session.getAttribute("user_id");
		
		UserInfo stuObj= studentRepo.findByUserId(user_id);
		System.out.println("stu object"+ stuObj);
		String first_name=stuObj.getFirst_name();
		String last_name=stuObj.getLast_name();
		List<Grades>grades=studentRepo.findGradesByLastNameAndFirstName(last_name,first_name);
		
		modelMap.addAttribute("avatar",  (String)session.getAttribute("avatar"));
		modelMap.addAttribute("email", (String)session.getAttribute("email"));
		modelMap.addAttribute("grades", grades);
		
		return "/student/Transcripts";
	}
	@RequireLogin
	@RequestMapping("/student/user/info")
	public String ShowUserIfo(HttpSession session,ModelMap modelMap) throws IOException {
		
		UserInfo info=studentRepo.findByUserId((int) session.getAttribute("user_id"));
		
			modelMap.addAttribute("info", info);
			
			return "/student/Info";
		

	}
	
	@RequireLogin
	@RequestMapping("/student/user/info/update")
	public String EditInfo(@ModelAttribute("UserInfo") UserInfo info,
			ModelMap modelMap, HttpSession session) throws IOException {

			studentRepo.updateInfoById(info);
			
			return ShowUserIfo(session, modelMap);
	}
	@RequireLogin
	@RequestMapping("/student/user/info/update/photo")
	public String EditPhoto(@ModelAttribute("UserInfo") UserInfo info, @RequestParam("file") MultipartFile file,
			ModelMap modelMap, HttpSession session) throws IOException {
		
			Photo photo = new Photo();
		    photo.setImage_name(file.getOriginalFilename());
		    
			service.saveImage(file, photo);
			info.setAvatar(photo.getImage_name());
			
			studentRepo.updateInfoById(info);
			return ShowUserIfo(session, modelMap);
	}
	@RequireLogin
	@RequestMapping("/student/user/dashboard")
	public String dashBoard(ModelMap modelMap,HttpSession session) {
		
		int dept_id=(int) session.getAttribute("dept_id");
		System.out.println("Student department id in dashboard method "+ dept_id);
		SectionsList sections=request.showIdleSections(dept_id);
		
		modelMap.addAttribute("avatar",  (String)session.getAttribute("avatar"));
		modelMap.addAttribute("email", (String)session.getAttribute("email"));
		modelMap.addAttribute("sections", sections.getSectionsList());
		
		return "/student/DashBoard";
	}
	
}
