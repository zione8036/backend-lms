package biz.global.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.Student;
import biz.global.model.Subject;
import biz.global.service.StudentService;

@RestController
@RequestMapping("api/student/")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value = "add")
	public String register(@RequestBody Student student, Subject subject) throws IOException {
		
				studentService.addStudent(student, subject);
				return "Student added successfully";
	}
	
	

}
