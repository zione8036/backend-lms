package biz.global.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String studentNo;
	
	private String first_name;
	
	private String middle_name;
	
	private String last_name;
	
	private String subject_title;
	
	private String date_modified;
	
	private Boolean isPresent;
	
	

}
