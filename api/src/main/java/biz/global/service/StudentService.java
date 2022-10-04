package biz.global.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.ResultQuery;
import org.jooq.TableRecord;
import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.map.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.global.Table.Tables;
import biz.global.Table.tables.records.StudentRecord;
import biz.global.model.Student;
import biz.global.model.Subject;
import org.springframework.http.ResponseEntity;



@Service
public class StudentService {
	@Autowired
	private DSLContext context;
	
//	@Autowired
//	private JdbcMapper<Student> jdbcMapper;
	
	public int addStudent(Student model) {
		return context.insertInto(Tables.STUDENT, 
								  Tables.STUDENT.FIRST_NAME, 
								  Tables.STUDENT.MIDDLE_NAME,
								  Tables.STUDENT.LAST_NAME,
								  Tables.STUDENT.ACADEMIC_YEAR,
								  Tables.STUDENT.SEM,
								  Tables.STUDENT.ACTIVE_DEACTIVE,
								  Tables.STUDENT.STUDENT_NO
								  )
								  .values(model.getFirstName(),
										  model.getMiddleName(),
										  model.getLastName(),
										  model.getAcademicYear(),
										  model.getSem(),
										  model.getActive_deactive(),
										  model.getStudent_no()
										  )
									.execute();
		
	}
	
	public List<Student> getAllStudents() {

		Result<Record> records = context.fetch("select *from Student");
		List<Student> student =  new ArrayList<Student>();
		for(Record record : records) {
			student.add(new Student(
					record.get(Tables.STUDENT.STUDENT_ID),
					record.get(Tables.STUDENT.STUDENT_NO),
					record.get(Tables.STUDENT.FIRST_NAME),
					record.get(Tables.STUDENT.MIDDLE_NAME),
					record.get(Tables.STUDENT.LAST_NAME),
					record.get(Tables.STUDENT.SEM),
					record.get(Tables.STUDENT.ACADEMIC_YEAR),
					record.get(Tables.STUDENT.ACTIVE_DEACTIVE)
					));
		}
		
		return student;
	}
	
	public Result<Record> getStudentsWithSubject() {
		 Result<Record> query =  context.select().from(Tables.STUDENT)
				.leftJoin(Tables.SUBJECT)
				.on(Tables.SUBJECT.STUDENT_STUDENT_ID.eq(Tables.STUDENT.STUDENT_ID))
				.fetch();
		return query;
	}
	
//	private List<Student> transformQueryIntoList(Result<Record> query) {
//            try {
//            	ResultSet rs = query.intoResultSet();
//				return jdbcMapper.stream(rs).collect(Collectors.toList());
//			} catch (MappingException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return null;
//			}
//    }
	
	
}


