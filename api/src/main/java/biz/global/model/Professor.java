package biz.global.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import biz.global.util.Generator;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long professor_id;
	
	private String professor_no;

	private String professor_name;
	
	private String work;
	
	private String gender;
	
	private String status;
	
	private String birthdate;
	
	private String password;
	
	private Boolean active_deactive;
	
	@OneToMany(targetEntity = Grades.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "encode", referencedColumnName = "professor_id" )
	private List<Grades> grades;
	
	@OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "evaluate", referencedColumnName = "professor_id" )
	private List<Student> student;
	
	
	@OneToMany(targetEntity = ProfessorLoad.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_id", referencedColumnName = "professor_id" )
	private List<ProfessorLoad> professorLoad;
	
	@OneToMany(targetEntity = SubjectDetailHistory.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_id", referencedColumnName = "professor_id" )
	private List<SubjectDetailHistory> subjectDetailHistory;
	
	
	public Long getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(Long professor_id) {
		this.professor_id = professor_id;
	}

	public String getProfessor_no() {
		return professor_no;
	}

	public void setProfessor_no(String professor_no) {
		this.professor_no = professor_no;
	}

	public String getProfessor_name() {
		return professor_name;
	}

	public void setProfessor_name(String professor_name) {
		this.professor_name = professor_name;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive_deactive() {
		return active_deactive;
	}

	public void setActive_deactive(Boolean active_deactive) {
		this.active_deactive = active_deactive;
	}

	public List<Grades> getGrades() {
		return grades;
	}

	public void setGrades(List<Grades> grades) {
		this.grades = grades;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	
}
