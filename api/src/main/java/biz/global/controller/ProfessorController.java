package biz.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.Professor;
import biz.global.model.Subject;
import biz.global.repo.ProfessorRepo;

@RestController
@RequestMapping("api/professor/")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfessorController {
	@Autowired
	private ProfessorRepo professorRepo;
	
	
	
	@GetMapping(value= "all")
    List<Professor> getprofessors() {
        return professorRepo.findAll();
    }

    @PostMapping(value="add")
    public String addProfessor(@RequestBody Professor professor) {
    	professorRepo.save(professor);
        return "Professor Sucessfully Added!";
    }

}
