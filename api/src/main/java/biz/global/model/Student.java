package biz.global.model;
import biz.global.util.Generator;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Student implements  Serializable{
//	private static final long serialVersionUID = 1L;


	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long student_id;
	
	 private String studentNo;

	 private String firstName;
	 
	 private String middleName;
	 
	 private String lastName;
	 
	 private String password;
	 
	 private LocalDate birthDate;
	 
	 public String status;
		
	 public String Course;
	 
	 private String sem;

	 private String academicYear;
	 
	 private Boolean active_deactive = false;
	
	@OneToMany(targetEntity = Program.class, cascade = CascadeType.ALL)
	 @JoinColumn(referencedColumnName = "student_id", name = "student_program")
	 private List<Program> program;
	 
	 @OneToMany(targetEntity = Subject.class, cascade = CascadeType.ALL)
	 @JoinColumn(name = "student_subject", referencedColumnName = "student_id")
	 private List<Subject> subjects;
	 
	 @OneToMany(targetEntity = Grades.class, cascade = CascadeType.ALL)
	 @JoinColumn(name = "student_grades", referencedColumnName = "student_id" )
	 private List<Grades> grades;
	 
	 private String type = "student";
	 
	 
	 
	 public Student() {
		 super();
	 }
	
	public Student(Long student_id, String firstName, String middleName,
			String lastName, List<Program> program,
			List<Subject> subjects, String sem, String academicYear, Boolean active_deactive) {
		super();
	
		this.student_id = student_id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.program = program;
		this.subjects = subjects;
		this.sem = sem;
		this.academicYear = academicYear;
		this.active_deactive = active_deactive;
	}

	 
	 public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<Grades> getGrades() {
		return grades;
	}


	public void setGrades(List<Grades> grades) {
		this.grades = grades;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCourse() {
		return Course;
	}


	public void setCourse(String course) {
		Course = course;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	

	public List<Program> getProgram() {
		return program;
	}
	

	public void setProgram(List<Program> program) {
		this.program = program;
	}
	
	 
	List<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	public Long getStudent_id() {
		return student_id;
	}
	
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	
	public String getStudent_no() {
		return studentNo;
	}
	
	public void setStudent_no(Long student_id) {
		this.studentNo  = "SN-" + Integer.toString(LocalDate.now().getYear()) + "-" +String.format("%04d",student_id);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSem() {
		return sem;
	}
	
	public void setSem(String sem) {
		this.sem = sem;
	}


	public String getAcademicYear() {
		return academicYear;
	}
	
	public void setAcademicYear(String academic_year) {
		this.academicYear = academic_year;
	}

	public Boolean getActive_deactive() {
		return active_deactive;
	}
	
	public void setActive_deactive(Boolean active_deactive) {
		this.active_deactive = active_deactive;
	}
	

}
