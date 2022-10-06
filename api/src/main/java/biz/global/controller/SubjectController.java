package biz.global.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import biz.global.model.Professor;
import biz.global.model.Student;
import biz.global.model.Subject;
import biz.global.repo.ProfessorLoadRepo;
import biz.global.repo.ProfessorRepo;
import biz.global.repo.StudentRepo;
import biz.global.repo.SubjectRepo;


@RestController
@RequestMapping("api/subject/")
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {
	
	@Autowired
	private SubjectRepo subjectRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ProfessorLoadRepo professorLoadRepo;
	
	@Autowired
	private ProfessorRepo professorRepo;
	
	@GetMapping(value= "all")
    List<Subject> getSubjects() {
        return subjectRepo.findAll();
    }

    @PostMapping(value="add")
    public String createSubject(@RequestBody Subject subject) {
    	subjectRepo.save(subject);
        return "Subject Successfully Added!";
    }
	
    @PutMapping("/{subjectId}/students/{studentId}")
    Subject addStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ) {
        Subject subject = subjectRepo.findById(subjectId).get();
        Student student = studentRepo.findById(studentId).get();
        subject.getStudent().add(student);
        return subjectRepo.save(subject);
    }
    
    
    @PutMapping("/{subjectId}/professor/{professorId}")
    Subject addProfessorToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long professorId
    ) {
        Subject subject = subjectRepo.findById(subjectId).get();
        Professor professor = professorRepo.findById(professorId).get();
        subject.setProfessor(professor);
        return subjectRepo.save(subject);
    }
	
}
