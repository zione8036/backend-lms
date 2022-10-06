package biz.global.model;
import biz.global.util.Generator;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	 
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
//	 @GenericGenerator(
//	            name = "student_seq",
//	            strategy = "biz.global.util.Generator",
//	            parameters = {
//	                    @Parameter(name = Generator.INCREMENT_PARAM, value = "1"),
//	                    @Parameter(name = Generator.VALUE_PREFIX_PARAMETER, value = "SN_"),
//	                    @Parameter(name = Generator.NUMBER_FORMAT_PARAMETER, value = "%05d")
//	            })

	 private String student_no;
	 


	 private String firstName;
	 


	 private String middleName;
	 


	 private String lastName;
	 
//	 @NotBlank(message="Program must not be empty")
	 
	 @OneToMany(mappedBy="student")
	 @Column(name = "program")
	 private List<Program> program;
	 
	 @JsonIgnore
	 @ManyToMany(mappedBy="student")
	 private Set<Subject> subjects = new HashSet<>();
	 
//	 @ManyToOne()
//	 @JsonRawValue
//	 private Professor professor;
	 
//	 @NotBlank(message="Birthdate must not be empty")

	

	


	public List<Program> getProgram() {
		return program;
	}
	

	public void setProgram(List<Program> program) {
		this.program = program;
	}
	@JsonRawValue
	 private String sem;
//	 @NotBlank(message="Year level must not be empty")
//	private Yearlevel yearLevel;
	 
	 //@NotBlank(message="Academic Year must not be empty")

	 @JsonRawValue
	 private String academicYear;
//	 @NotBlank(message="Status must not be empty")
//	private Status status;
	 @JsonRawValue
	 private Boolean active_deactive=true;
	 
	 
	 
	 
	 
	 
	 
	 public Student() {
		 super();
	 }
	

	 
	public Student(Long student_id, String student_no, String firstName, String middleName,
			String lastName, List<Program> program,
			Set<Subject> subjects, String sem, String academicYear, Boolean active_deactive) {
		super();
		this.student_id = student_id;
		this.student_no = student_no;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.program = program;
		this.subjects = subjects;
		this.sem = sem;
		this.academicYear = academicYear;
		this.active_deactive = active_deactive;
	}


	public Set<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}


	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	public String getStudent_no() {
		return student_no;
	}
	public void setStudent_no(String student_no) {
		this.student_no = student_no;
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
//	public Yearlevel getYearLevel() {
//		return yearLevel;
//	}
//	public void setYearLevel(Yearlevel yearLevel) {
//		this.yearLevel = yearLevel;
//	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academic_year) {
		this.academicYear = academic_year;
	}
//	public Status getStatus() {
//		return status;
//	}
//	public void setStatus(Status status) {
//		this.status = status;
//	}
	public Boolean getActive_deactive() {
		return active_deactive;
	}
	public void setActive_deactive(Boolean active_deactive) {
		this.active_deactive = active_deactive;
	}
	


}
