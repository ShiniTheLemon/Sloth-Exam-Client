package com.diaas.student.service;

import org.springframework.stereotype.Service;

import com.diaas.student.entities.RegisterStudent;

@Service
public interface StudentAdminService {
	int registerStudent(RegisterStudent student);
	int jellyFish(int user_id,String section1,String section2,String section3,String course_name);
}
