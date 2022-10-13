package biz.global.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import biz.global.model.ResponseModel;
import biz.global.model.Schedule;
import biz.global.repo.ScheduleRepo;

public class ScheduleController {

	@Autowired 
	private ScheduleRepo schedulerepo;
	
	
	@GetMapping(value="all")
	List<Schedule> getschedules(){
		return schedulerepo.findAll();
	}
	
	@PostMapping(value="add")
	public ResponseEntity<ResponseModel> addSchedule (@RequestBody Schedule schedule){
		Optional<Schedule> sched = Optional.ofNullable(schedulerepo.findByScheduleCode(schedule.getSchedule_code()));
		if(sched.isPresent()) {
			return ResponseEntity.ok().body(new ResponseModel(0, "schedule code already exist", null,null));
			
		}schedulerepo.save(schedule);
			return ResponseEntity.ok().body(new ResponseModel(0,"schedule code already exist", null,sched.get()));
	}
}
