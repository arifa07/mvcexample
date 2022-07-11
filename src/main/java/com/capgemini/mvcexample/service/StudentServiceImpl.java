package com.capgemini.mvcexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.mvcexample.dao.StudentRepository;
import com.capgemini.mvcexample.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repository;	
	
	@Override
	public Student getStudentById(Integer studentId) {
		Optional<Student> optStudent = repository.findById(studentId);
		if(optStudent.isPresent()) {
			return optStudent.get();
		}
		return null;
	}

	@Override
	public List<Student> getStudents() {
		
		return (List<Student>) repository.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		
		return repository.save(student);
	}

	@Override
	public void deleteStudent(Integer studnetId) {
		repository.deleteById(studnetId);
	}

	@Override
	public Student updateStudent(Student student, Integer studentId) {
		Optional<Student> studentData = repository.findById(studentId);
		if (studentData.isPresent()) {
			Student _student = studentData.get();
			_student.setRollNo(student.getRollNo());
			_student.setStudentName(student.getStudentName());
			_student.setCourseEnrolled(student.getCourseEnrolled());
			return repository.save(_student);
		}else {
				return null;
			}
	}

}
