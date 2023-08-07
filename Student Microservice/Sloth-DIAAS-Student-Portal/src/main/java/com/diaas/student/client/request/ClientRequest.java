package com.diaas.student.client.request;

import org.springframework.stereotype.Component;

import com.diaas.student.dto.ExamSchedule;
import com.diaas.student.dto.QuestionBanksList;
import com.diaas.student.dto.SectionsList;
import com.diaas.student.dto.SpecialQuestionList;
import com.diaas.student.entities.Sections;

@Component
public interface ClientRequest {
	public QuestionBanksList showSectionCandB(String exam_code);
	public SpecialQuestionList showSectionA(String exam_code);
	public SectionsList showAllSections(int dept_id);
	public SectionsList showActiveSections(int dept_id);
	public SectionsList showIdleSections(int dept_id);
	public SectionsList showCompletedSections(int dept_id);
	public Sections selectSections(int id);
	public ExamSchedule total(String exam_code);
	public SectionsList adminExamCalendar();
}
