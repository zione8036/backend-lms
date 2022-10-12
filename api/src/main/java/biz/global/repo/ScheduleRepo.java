package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.global.model.Schedule;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
	Schedule findByScheduleCode(String schedule_code);
	
	
}
