package biz.global.model;

import java.time.LocalDate;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Subject  {
	
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long subject_id;
	 
	private String subjectCode;
	 
	private String subject_title;
	 
	private Integer units;
	 
	private String prerequisites;
	
    private Boolean active_deactive = true;

	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="load_id", referencedColumnName = "load_id")
	private ProfessorLoad professorLoad;
    
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="professor_id", referencedColumnName = "professor_id")
	private Professor professor;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_grade")
    private Grades grades;
    


	public Grades getGrades() {
		return grades;
	}
	public void setGrades(Grades grades) {
		this.grades = grades;
	}
	public Subject() {
		super();
	}
	public Long getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(Long subject_id) {
		this.subject_id = subject_id;
	}


	public String getSubject_code() {
		return subjectCode;
	}


	public void setSubject_code(Long subject_id) {
		this.subjectCode = "SUBJ-"  +  String.format("%03d",subject_id);
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



	public ProfessorLoad getProfessorLoad() {
		return professorLoad;
	}



	public void setProfessorLoad(ProfessorLoad professorLoad) {
		this.professorLoad = professorLoad;
	}



	public Professor getProfessor() {
		return professor;
	}



	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	 
	
}
