package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.global.model.Professor;

public interface ProfessorRepo extends JpaRepository<Professor, Long> {
	Professor  findByProfessorNo(String professor_no);
}
