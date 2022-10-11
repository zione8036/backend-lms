package biz.global.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global.model.Department;
import biz.global.model.ResponseModel;
import biz.global.model.Subject;
import biz.global.repo.DepartmentRepo;
import biz.global.repo.SubjectRepo;

@RestController
@RequestMapping("api/departments")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Autowired
	private SubjectRepo subjectRepo;
	
	@PostMapping(value = "/add")
	private ResponseEntity<ResponseModel>  addDepartment(@RequestBody Department dep) {
		try {
			departmentRepo.save(dep);
			 return ResponseEntity.ok().body(new ResponseModel(1, "department successfully added", "", dep));
		}
		catch (DataIntegrityViolationException e) {
			return ResponseEntity.ok().body(new ResponseModel(0, "course code already exist", "", null));
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseModel(-1, "", null, null));
		}
	}
	
	@GetMapping(value = "/all")
	private ResponseEntity<ResponseModel> all() {
		List<Department> dep = departmentRepo.findAll();
		return ResponseEntity.ok().body(new ResponseModel(1, "get all departments", "", dep, null));
	}
	
	@GetMapping(value = "/alldepwithsub")
	private ResponseEntity<ResponseModel> allDepartmentWithSubject() {
		List<Department> dep = departmentRepo.findAll();
		List<Subject> subjects = subjectRepo.findAll();
		return ResponseEntity.ok().body(new ResponseModel(1, "get all departments", "", dep, subjects));
	}

}
