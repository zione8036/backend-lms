package biz.global.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Subject  {
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long subject_id;
	 
	private String subject_code;
	 
	private String subject_title;
	 
	private Integer units;
	 
	private String prerequisites;
	
    private Boolean active_deactive = true;
    
//	private Grades grades;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;


	public Student getStudent() {
		return student;
	}


	public void setStudent_no(Student student) {
		this.student = student;
	}

	public Subject() {
		super();
	}
	
	public Subject(Long subject_id,  String subject_code, String subject_title,Integer units, String prerequisites, Boolean active_deactive,Student student) {
	
		this.subject_id = subject_id;
		this.subject_code = subject_code;
		this.subject_title = subject_title;
		this.units = units;
		this.prerequisites = prerequisites;
		this.active_deactive = active_deactive;
	//	this.student = student;
	}


	public Long getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(Long subject_id) {
		this.subject_id = subject_id;
	}


	public String getSubject_code() {
		return subject_code;
	}


	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}


	public String getSubject_title() {
		return subject_title;
	}


	public void setSubject_title(String subject_title) {
		this.subject_title = subject_title;
	}


	public Integer getUnits() {
		return units;
	}


	public void setUnits(Integer units) {
		this.units = units;
	}


	public String getPrerequisites() {
		return prerequisites;
	}


	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}


	public Boolean getActive_deactive() {
		return active_deactive;
	}


	public void setActive_deactive(Boolean active_deactive) {
		this.active_deactive = active_deactive;
	}


//	public Student getStudent() {
//		return student;
//	}
//
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	 
	 
	
}
