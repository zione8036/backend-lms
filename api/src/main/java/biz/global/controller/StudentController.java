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

import biz.global.Table.tables.records.StudentRecord;
import biz.global.model.Student;
import biz.global.model.Subject;
import biz.global.service.StudentService;

@RestController
@RequestMapping(value = "api/student/")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value = "add")
	public String register(@RequestBody Student student) throws IOException {
		
		studentService.addStudent(student);
		
		return "Student added successfully";
	}
	
	@GetMapping(value = "getallstudents")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping(value = "getstudents")
	public Result<Record> getAllStudents1() {
		return studentService.getStudentsWithSubject();
	}
	
	

}
