package biz.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<Student, Long> {

import biz.global.model.AdminModel;

public interface AuthRepo extends JpaRepository<AdminModel, Long> {


}
