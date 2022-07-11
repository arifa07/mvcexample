package com.capgemini.mvcexample.service;

import java.util.List;

import com.capgemini.mvcexample.entity.Student;

public interface StudentService {
	//Retrieve
	public Student getStudentById(Integer studentId);
	//Retrieve
	public List<Student> getStudents();
	//Create
	public Student addStudent(Student student);
	//Delete
	public void deleteStudent(Integer studnetId);
	//Update
	public Student updateStudent(Student student, Integer studentId);
	
}
