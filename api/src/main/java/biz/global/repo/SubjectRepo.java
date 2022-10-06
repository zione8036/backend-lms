package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.global.model.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Long> {

}
