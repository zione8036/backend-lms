package biz.global.model;
import biz.global.enums.YearLevel;
import biz.global.util.Generator;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
public class Student extends Person{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long student_id;
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	 @GenericGenerator(
	            name = "student_seq",
	            strategy = "biz.global.util.Generator",
	            parameters = {
	                    @Parameter(name = Generator.INCREMENT_PARAM, value = "1"),
	                    @Parameter(name = Generator.VALUE_PREFIX_PARAMETER, value = "SN_"),
	                    @Parameter(name = Generator.NUMBER_FORMAT_PARAMETER, value = "%05d")
	            })
	private String student_no;
	private String firstName = super.firstName;
	private String middleName = super.middleName;
	private String lastName = super.lastName;
//	 @NotBlank(message="Program must not be empty")
//	 @OneToMany(mappedBy="student")
//	private Program program;
	 
	
	 @OneToMany(mappedBy = "student")
	private List<Subject> subject;
	 
//	 @ManyToOne()
//	 private Professor professor;
		 @NotBlank(message="Semester must not be empty")
		private String sem;
//		 @NotBlank(message="Year level must not be empty")
//		private YearLevel[] yearLevel = YearLevel.values();
		 @NotBlank(message="Academic Year must not be empty")
		 private String academicYear;
//		 @NotBlank(message="Status must not be empty")
//		private Status status;
	 
	 
	 
	 //Constructors
		 public Student() {
				
			}
		 
	
public Student(Long student_id, String student_no, String firstName, String middleName, String lastName,
		List<Subject> subject, @NotBlank(message = "Semester must not be empty") String sem,
		@NotBlank(message = "Academic Year must not be empty") String academicYear) {
	super();
	this.student_id = student_id;
	this.student_no = student_no;
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.subject = subject;
	this.sem = sem;
	this.academicYear = academicYear;
}


//		public Student(Long student_id, String student_no, String firstName, String lastName,String middleName, String username,String password,String type,
//				List<Subject> subject,
//				String sem,
//				YearLevel[] yearLevel,
//				String academicYear, Boolean active_deactive) {
//			
//			super(firstName, middleName, lastName, username, password, type="student", active_deactive=false);
//			this.student_id = student_id;
//			this.student_no = student_no;
//			this.subject = subject;
//			this.sem = sem;
////			this.yearLevel = yearLevel;
//			this.academicYear = academicYear;		
//		}
		
		
		
		
		//Getters & Setters
			public List<Subject> getSubject() {
			return subject;
			}
			public void setSubject(List<Subject> subject) {
				this.subject = subject;
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
			public void setAcademicYear(String academicYear) {
				this.academicYear = academicYear;
			}
		//	public Status getStatus() {
		//		return status;
		//	}
		//	public void setStatus(Status status) {
		//		this.status = status;
		//	}

	


}
