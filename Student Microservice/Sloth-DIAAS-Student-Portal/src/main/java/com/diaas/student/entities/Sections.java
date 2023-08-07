package com.diaas.student.entities;


import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class Sections {
	private int id;
	private String Section1;
	private String section2;
	private String section3;
	private int status;
	private Date time;
	private String course_name;
	private int dept_id;
}
