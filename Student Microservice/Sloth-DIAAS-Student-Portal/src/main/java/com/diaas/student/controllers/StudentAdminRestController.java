package com.diaas.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diaas.student.dto.GradesList;
import com.diaas.student.entities.Courses;
import com.diaas.student.entities.Departments;
import com.diaas.student.entities.Grades;
import com.diaas.student.entities.Sections;
import com.diaas.student.repository.AdminRepository;

@RestController
public class StudentAdminRestController {
	@Autowired
	AdminRepository adminRepo;
	
	@RequestMapping("/rest/student/admin/addDept.do")
	public void addDept(@RequestBody Departments dept) {
		System.out.println(dept+" had been recieved by student portal");
		adminRepo.addDepartment(dept);
		
	} 
	@RequestMapping("/rest/student/admin/addCourse.do")
	public void addCourse(@RequestBody Courses course) {
		System.out.println(course+" had been recieved by student portal");
		adminRepo.addCourse(course);
		
	} 
	@RequestMapping("/rest/student/admin/addSection.do")
	public void addSection(@RequestBody Sections section) {
		
		Sections sectionExists = adminRepo.findSectionById(section.getId());
		if(sectionExists!=null) {
			adminRepo.updateSectionStatus(section.getStatus(),section.getDept_id(),section.getId());
		}else {
			adminRepo.addSections(section);
		}
		System.out.println(section+" had been recieved by student portal");
	}
	@RequestMapping("/rest/student/admin/sectionStatus.do")
	public void changeSectionStatus(@RequestBody Sections section) {
		
		adminRepo.updateSectionStatus(section.getStatus(),section.getDept_id(),section.getId());
		System.out.println(section+" had been recieved by student portal");
	}
	@RequestMapping("/rest/student/admin/studentTranscripts.do/{course_name}")
	public GradesList getTranscripts(@PathVariable("course_name")String course_name) {
		GradesList transcripts=new GradesList();
	     List<Grades> data = adminRepo.findGradesByCourseName(course_name);
	     transcripts.setGradeList(data);
	     System.out.println("Transcripts have been retrieved safely :"+transcripts);
		return transcripts;
	}
	
}
