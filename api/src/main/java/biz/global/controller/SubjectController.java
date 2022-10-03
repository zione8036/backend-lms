package biz.global.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.Subject;
import biz.global.service.SubjectService;

@RestController
@RequestMapping("api/subject/")
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {
	@Autowired
	private SubjectService service;
	
	@PostMapping(value = "add")
	public String addSubject(@RequestBody Subject subject) throws IOException {
		
				service.addSubject(subject);
				return "Subject added successfully";
	}
}
