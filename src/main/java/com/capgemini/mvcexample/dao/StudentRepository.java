package com.capgemini.mvcexample.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.mvcexample.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

}
