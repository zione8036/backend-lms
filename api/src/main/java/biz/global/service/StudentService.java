package biz.global.service;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.global.Table.Tables;
import biz.global.model.Student;
import biz.global.model.Subject;

@Service
public class StudentService {
	@Autowired
	private DSLContext context;
	
	public int addStudent(Student model, Subject subject) {
		return context.insertInto(Tables.STUDENT, 
								  Tables.STUDENT.FIRST_NAME, 
								  Tables.STUDENT.MIDDLE_NAME,
								  Tables.STUDENT.LAST_NAME,
								  Tables.STUDENT.ACADEMIC_YEAR,
								  Tables.STUDENT.SEM,
								  Tables.STUDENT.ACTIVE_DEACTIVE
								  
								  )
								  .values(model.getFirstName(),
										  model.getMiddleName(),
										  model.getLastName(),
										  model.getAcademicYear(),
										  model.getSem(),
										  model.getActive_deactive()
										  
										  )
									.execute();
	}
}
