package biz.global.service;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.global.Table.Tables;
import biz.global.Table.tables.records.SubjectRecord;
import biz.global.model.Subject;

@Service
public class SubjectService {

	@Autowired
	private DSLContext context;
	 public int addSubject(Subject model) {
		 return context.insertInto(Tables.SUBJECT, 
				 				   Tables.SUBJECT.SUBJECT_TITLE, 
				 				   Tables.SUBJECT.SUBJECT_CODE,
				 				   Tables.SUBJECT.UNITS,
				 				   Tables.SUBJECT.PREREQUISITES,
				 				   Tables.SUBJECT.ACTIVE_DEACTIVE,
				 				   Tables.SUBJECT.STUDENT_STUDENT_ID)
				 				   .values(model.getSubject_title(),
				 						   model.getSubject_code(),
				 						   model.getUnits(),
				 						   model.getPrerequisites(),
				 						   model.getActive_deactive(),
				 						   Long.parseLong(model.getStudent().getStudent_no())
				 						   )
				 				   .execute();
	 }
	 public Result<SubjectRecord> getSubjects(Subject subject) {
		 return context.fetch(Tables.SUBJECT);
	 }
}
