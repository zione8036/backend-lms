package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.global.model.Student;

public interface AuthRepo extends JpaRepository<Student, Long> {

}
