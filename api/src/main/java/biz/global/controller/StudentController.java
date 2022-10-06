package biz.global.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectWhereStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.ObjectMapper;

import biz.global.Table.tables.records.StudentRecord;
import biz.global.model.Student;
import biz.global.model.Subject;
import biz.global.repo.StudentRepo;
import biz.global.repo.SubjectRepo;

@RestController
@RequestMapping(value = "api/student/")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@PostMapping(value = "add")
	public String register(@RequestBody Student student) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		 System.out.print(mapper.writeValueAsString(student));
		studentRepo.save(student);
		
		return "Student added successfully";
	}
	
	

}
