package biz.global.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import biz.global.model.Attendance;
import biz.global.model.Subject;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
	
	@Query(nativeQuery = true , value="SELECT stu.first_name, stu.middle_name, stu.last_name, stu.student_no, sub.subject_title, sub.subject_code from student as stu\r\n"
			+ "join ( SELECT subject_title, student_subject, subject_code\r\n"
			+ "        FROM subject \r\n"
			+ "		WHERE subject.subject_code like :subjectCode% ) as sub\r\n"
			+ "ON sub.student_subject = stu.student_id")
	List<Attendance> getAllStudentsEnrolledSubject(@Param("subjectCode") String subjectCode);
	

}
