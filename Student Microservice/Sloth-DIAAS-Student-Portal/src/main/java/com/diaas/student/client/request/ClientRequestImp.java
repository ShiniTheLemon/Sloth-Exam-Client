package com.diaas.student.client.request;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.diaas.student.dto.ExamSchedule;
import com.diaas.student.dto.QuestionBanksList;
import com.diaas.student.dto.SectionsList;
import com.diaas.student.dto.SpecialQuestionList;
import com.diaas.student.entities.Sections;
@Component
public class ClientRequestImp implements ClientRequest {
	public static final String url="http://localhost:8085/";
	@Override
	public QuestionBanksList showSectionCandB(String exam_code) {
		// TODO Auto-generated method stub
		System.out.println("The request client method is running parameter obtained:" +exam_code);
		RestTemplate temp= new RestTemplate();
		QuestionBanksList questions=temp.getForObject(url+"rest/sectionBandC.do/"+exam_code, QuestionBanksList.class);
		System.out.println("The data obtained for section A and B "+questions);
		return questions;
	}

	@Override
	public SpecialQuestionList showSectionA(String exam_code) {
		// TODO Auto-generated method stub
		System.out.println("The request client method is running parameter obtained:" +exam_code);
		RestTemplate temp= new RestTemplate();
		SpecialQuestionList questions=temp.getForObject(url+"rest/sectionA.do/"+exam_code, SpecialQuestionList.class);
		System.out.println("The data obtained for SectionA "+questions );
		return questions;
	}

	@Override
	public SectionsList showAllSections(int dept_id) {
		// TODO Auto-generated method stub
		System.out.println("The request client method is running parameter obtained:"+dept_id);
		
		RestTemplate temp= new RestTemplate();
		SectionsList questions=temp.getForObject(url+"rest/showAllSections.do/"+dept_id, SectionsList.class);
		System.out.println("The request client result:"+questions);
		return questions;
		
	}

	@Override
	public Sections selectSections(int id) {
		// TODO Auto-generated method stub
		System.out.println("Select section method was called");
		RestTemplate temp= new RestTemplate();
	
		Sections questions=temp.getForObject(url+"rest/selectSections.do/"+id, Sections.class);
		System.out.println("The request client method is running parameter obtained:"+questions);
		return questions;
	}

	@Override
	public ExamSchedule total(String exam_code) {
		// TODO Auto-generated method stub
		System.out.println("The request client method is running parameter obtained:"+exam_code);
		RestTemplate temp= new RestTemplate();
		ExamSchedule total=temp.getForObject(url+"rest/faculty/admin/retrieve.do/"+exam_code, ExamSchedule.class);
		System.out.println("The request client has executed data obtained:"+total);
		return total;
	}

	@Override
	public SectionsList adminExamCalendar() {
		// TODO Auto-generated method stub

		RestTemplate temp= new RestTemplate();
		SectionsList calender=temp.getForObject(url+"rest/faculty/admin/calendar.do", SectionsList.class);
		System.out.println("The request client method is running parameter obtained:"+calender);
		return calender;
	}



	@Override
	public SectionsList showActiveSections(int dept_id) {
		// TODO Auto-generated method stub
		System.out.println("The request client method active is running parameter obtained:"+dept_id);
		
		RestTemplate temp= new RestTemplate();
		SectionsList questions=temp.getForObject(url+"rest/showActiveSections.do/"+dept_id, SectionsList.class);
		System.out.println("The request client result:"+questions);
		return questions;
	}

	@Override
	public SectionsList showIdleSections(int dept_id) {
		// TODO Auto-generated method stub
		System.out.println("The request client method idle sections is running parameter obtained:"+dept_id);
		
		RestTemplate temp= new RestTemplate();
		SectionsList questions=temp.getForObject(url+"rest/showIdleSections.do/"+dept_id, SectionsList.class);
		System.out.println("The request client result:"+questions);
		return questions;
	}

	@Override
	public SectionsList showCompletedSections(int dept_id) {
		// TODO Auto-generated method stub
		System.out.println("The request client method completed sections is running parameter obtained:"+dept_id);
		
		RestTemplate temp= new RestTemplate();
		SectionsList questions=temp.getForObject(url+"rest/showCompletedSections.do/"+dept_id, SectionsList.class);
		System.out.println("The request client result:"+questions);
		return questions;
	}

}
