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
	 @NotBlank(message="Subject code must not be empty")
	private String subject_code;
	 @NotBlank(message="Subject title must not be empty")
	private String subject_title;
	 @NotBlank(message="Units must not be empty")
	private Integer units;
	private String prerequisites;
    private Boolean active_deactive = true;
//	 @NotBlank(message="Subject must not be empty")
//	 @OneToMany(mappedBy="student")
//	private Grades grades;
    
    
    @ManyToOne
    private Student student;


	/**
 * 
 */
public Subject() {
	super();
}


	/**
 * @param subject_id
 * @param subject_code
 * @param subject_title
 * @param units
 * @param prerequisites
 * @param active_deactive
 * @param student
 */
public Subject(Long subject_id, @NotBlank(message = "Subject code must not be empty") String subject_code,
		@NotBlank(message = "Subject title must not be empty") String subject_title,
		@NotBlank(message = "Units must not be empty") Integer units, String prerequisites, Boolean active_deactive,
		Student student) {
	super();
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
