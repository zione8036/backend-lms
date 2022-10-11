package biz.global.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import biz.global.model.ResponseModel;
import biz.global.model.Student;
import biz.global.repo.StudentRepo;
import biz.global.util.JWTUtility;

@RestController
@RequestMapping(value = "api/student/")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	private JWTUtility jwtUtility;
	
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
	@PostMapping(value = "add")
	public ResponseEntity<ResponseModel> register(@RequestBody Student student) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.print(mapper.writeValueAsString(student));
		Optional<Student> stu = Optional.ofNullable(studentRepo.findByStudentNo(student.getStudentNo()));
		if(!stu.isEmpty()) {
			return ResponseEntity.ok().body(new ResponseModel(0, "student number already exist", null, null));
		}
		
		String hashedPassword = bcrypt.encode(student.getStudentNo());
		student.setPassword(hashedPassword);
		studentRepo.save(student);
		return ResponseEntity.ok().body(new ResponseModel(1, "student successfully added", null, student));
	}
	
	@GetMapping("studentlist")
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}
	
	
	@PostMapping("student-login")
	public ResponseEntity<ResponseModel> studentLogin(@RequestBody Student student) {
		Optional<Student> stu = Optional.ofNullable(studentRepo.findByLastName(student.getLastName()));
		if(stu.isPresent() && stu.get().getLastName().equals(student.getLastName()) && bcrypt.matches(student.getStudentNo(), stu.get().getPassword())) {
			stu.get().setPassword("");
			ResponseModel responseModel = new ResponseModel(1, "logged in",jwtUtility.generateToken(student.getLastName()), stu.get() );
			return ResponseEntity.ok().body(responseModel);
		}
		ResponseModel responseModel = new ResponseModel(0, "Invalid lastname or password",null, null );
		return ResponseEntity.ok().body(responseModel);
	}
	
	
	@PatchMapping("update-student-info")
	public ResponseEntity<ResponseModel> updateStudentInfo(@RequestBody Student student) {
		Optional<Student> stud = studentRepo.findById(student.getStudent_id());
		if(stud.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "student does not exist", null, null));
		}
		studentRepo.save(student);
		return ResponseEntity.ok().body(new ResponseModel(1, "updated successfully", null, student));
	}
	
	@DeleteMapping("delete-student")
	public ResponseEntity<ResponseModel> deleteStudent(@RequestBody String student_no) {
		Optional<Student> student = Optional.ofNullable(studentRepo.findByStudentNo(student_no));
		if(student.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(0, "student does not exist", null, null));
		}
		studentRepo.deleteById(student.get().getStudent_id());
		return ResponseEntity.ok().body(new ResponseModel(1, "successfully deleted", null, null));
	}
	
	
	
	

}
